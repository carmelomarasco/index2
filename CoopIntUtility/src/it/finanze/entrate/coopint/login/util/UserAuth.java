package it.finanze.entrate.coopint.login.util;


import it.finanze.entrate.coopint.login.autorizzazioni.bean.ApplicazioneBean;
import it.finanze.entrate.coopint.login.autorizzazioni.bean.MappaturaCodUfficioBean;
import it.finanze.entrate.coopint.login.autorizzazioni.bean.UtenteNew;
import it.finanze.entrate.coopint.login.autorizzazioni.exception.CoopintLoginException;
import it.finanze.entrate.coopint.login.jpa.model.CoopintLoginSemaforo;
import it.finanze.entrate.coopint.login.util.CostantiUtil;
import it.finanze.entrate.coopint.login.util.UtilityFunctions;
import it.finanze.entrate.coopint.login.util.UtilityService;
import it.finanze.security.AuthPermission;
import it.finanze.security.UnauthorizedUserException;
import it.finanze.security.login.AuthContext;
import it.finanze.security.webservices.ct.AuthProxy;
import it.finanze.security.webservices.ct.Output;
import it.finanze.security.webservices.ct.Richiesta;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ibm.ws.webservices.engine.WebServicesFault;

public class UserAuth implements Serializable {
	
	private static final long serialVersionUID = -3222160063855883733L;
	
	public static final String JTA_PU_NAME = "CoopIntLoginJPA";

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory(JTA_PU_NAME);
	UtilityService serviceApp = new UtilityService(emf);
	
	protected static Logger log = Logger.getLogger(UserAuth.class);
	String uffici[] = null;

	public void valorizzaInfoUtenteNew(HttpServletRequest request)throws CoopintLoginException {
		UtenteNew utenteNew = new UtenteNew();
		
		boolean wsAttivo = false;
		PropertyConfigurator.configure("/prod/installedApps/coopintLogin/log4j.properties");
		Properties properties = new Properties();
		String propertiesPath = "";
		try  {
			InitialContext initCtx = new InitialContext();
			Context env = (Context)initCtx.lookup("java:comp/env");
			propertiesPath = (String)env.lookup("fileProperties");
			properties.load(new FileInputStream(propertiesPath+"ini.properties"));
			wsAttivo = ((String)properties.get("WS_ATTIVO")).equals("true")?true:false;
		}
		catch(IOException e)  {
			throw new RuntimeException("Unable to load property " + propertiesPath);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
		
		AuthProxy proxy = null;

		if (wsAttivo){
			proxy = new AuthProxy();
			String endpoint = (String)properties.get("ADDRESS_WS_CLEARTRUST");
			proxy.setEndpoint(endpoint);
			log.info("WS_ATTIVO:" + wsAttivo );
			log.info("endpoint:" + endpoint );
		}

		HttpSession session = request.getSession();
		
		byte ind = 0;
		boolean checkAuth = false;
		
		try {
			utenteNew.setAppAbil(new TreeMap <ApplicazioneBean, List<String>>());
			List<CoopintLoginSemaforo> listApp;
			String earName = null;
			String appName = null;
			if (request.getParameter("eN") != null && !request.getParameter("eN").equals("") || (session.getAttribute("eN") != null && !session.getAttribute("eN").equals(""))) {
				earName = (String) (request.getParameter("eN") != null ? request.getParameter("eN") : session.getAttribute("eN"));
				session.setAttribute("eN", earName);
				appName = (String) (request.getParameter("appName") != null ? request.getParameter("appName") : session.getAttribute("appName"));
				session.setAttribute("appName", appName);
			}
			earName = (earName != null ? earName : (String)properties.get("nomeEAR"));
			if (earName != null) {
				if (earName.equals("COOPINT_LOGIN_SEMAFORO")) 
					listApp = serviceApp.getInfoAppJdbc(earName);
				else 
					listApp = serviceApp.getInfoEarJdbc(earName);
//				listApp = serviceApp.getInfoEarJdbc(earName);
				session.setAttribute("eN", earName);
				session.setAttribute("appName", appName);
			}
			else {
				listApp = serviceApp.getInfoApp();
//				listApp = serviceApp.getInfoAppJdbc("COOPINT_LOGIN_SEMAFORO"); // solo in LOCALE
				session.removeAttribute("eN");
				session.removeAttribute("appName");
			}
			for (CoopintLoginSemaforo appSem : listApp){
				ApplicazioneBean applicazione = new ApplicazioneBean(appSem.getNomeEar(), appSem.getAreaApplicazione(), appSem.getSottoAreaApplicazione()!=null?appSem.getSottoAreaApplicazione():null, appSem.getUrl(), appSem.getNomeApplicazione(), appSem.getGruppoApplicazione() != null?appSem.getGruppoApplicazione():null, appSem.getSuperuserCf(), appSem.getAbilitazione().equals("1")?true:false, appSem.getProfili().split("\\s*,\\s*"));
				verificaAutUtente(ind, request, utenteNew, applicazione, wsAttivo, proxy);
				if (utenteNew.getAppAbil().get(applicazione) != null && utenteNew.getAppAbil().get(applicazione).size() > 0)
					if (checkAuth == false) checkAuth = true;
			}
						
			String ufficio = "";
			String codUtente = "";
			log.info("checkAuth -> "+checkAuth);
			System.out.println("checkAuth -> "+checkAuth);
			if(checkAuth) {
				
				//ufficio = AuthContext.getCodiceUfficio(request.getSession());
				ufficio = UtilityFunctions.getCodiceUfficoEntrateODogane(AuthContext.getUffici(request.getSession()));
				codUtente = AuthContext.getUtente(request.getSession());
				if(ufficio != null && ufficio.length()==8) {
					String codUfficio = ufficio.substring(2); 
					MappaturaCodUfficioBean mappaturaCodUfficioBean = getMappaturaCodUff(codUfficio);
					ufficio = mappaturaCodUfficioBean.getCodCics();
				}
				else if(ufficio!=null && ufficio.trim().equals(""))
					throw new Exception("UTENTE NON AUTORIZZATO");
				log.info("ufficio -> "+ufficio);
				if (codUtente != null ) {
//					System.out.println("UTENTE " + codUtente + " UFFICIO " + ufficio + " AUTORIZZATO ALLE SEGUENTI PROCEDURE:" );
					log.info("UTENTE " + codUtente + " UFFICIO " + ufficio + " AUTORIZZATO ALLE SEGUENTI PROCEDURE:" );
				}
			}
			
			utenteNew.setCheckAuth(checkAuth);
			utenteNew.setUfficio(ufficio);
			utenteNew.setCodUtente(codUtente);
			
			setUtenteNew(session, utenteNew);
			log.debug("Sessione postLogin n.: "+session.getId());
			
		}
		catch (UnauthorizedUserException uue){
			throw new CoopintLoginException(uue.getMessage());
		}
		catch (Exception exc){
			exc.printStackTrace();
			String msg = exc.getMessage();
			if(exc instanceof WebServicesFault)
				msg = "Errore in fase di Autorizzazione"; 
			throw new CoopintLoginException(msg); 
		}
	}

	private void verificaAutUtente(byte ind, HttpServletRequest request, UtenteNew utenteNew, ApplicazioneBean applicazione, boolean wsAttivo, AuthProxy proxy){
		List<String> role = new ArrayList<String>();		
		Output out = null;
		
		log.info("COOPINTLIB::GESTIONE PROFILAZIONE "+applicazione.getNomeEar()+":");
		if (!wsAttivo){
			ind = 0;
			while(ind < applicazione.getProfili().length ){
				try {
					applicazione.setCheckRule(AuthPermission.check(request.getSession(), applicazione.getProfili()[ind], "ACCESS"));
				} catch (UnauthorizedUserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Di default l'utente non ha accesso a nessuna funzionalità 				
				if (applicazione.isCheckRule()){
					applicazione.setAuth(true);
					role.add(applicazione.getProfili()[ind]);
				}
				ind++;
			}
		} else  {
			// Costruzione lista richieste 
			Richiesta[] richieste = new Richiesta[applicazione.getProfili().length];
		  	for (int i=0; i < applicazione.getProfili().length ; i++ ){
				Richiesta richiesta = new Richiesta();
				richiesta.setRisorsa( applicazione.getProfili()[i] );
				richiesta.setOperazione("ACCESS");
				richieste[i] = richiesta;
			}
		  	
//		  	for( int k=0; k<applicazione.getProfili().length; k++ ) {
//		  		applicazione.setAuth(true);
//				role.add(applicazione.getProfili()[k]);
//		  	}
			 
		  	try {
				out = proxy.permission( request.getRemoteUser(), richieste );
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	  
			// Verifica codice di ritorno
		  	if (out.getRisultato().getCodice().compareTo("0") == 0) {
		  		boolean[] result = out.getDati().getLista();
		  		if (applicazione.getProfili().length == result.length ) {
			  		for( int k=0; k<result.length; k++ ) {
			  			log.info(applicazione.getNomeEar()+"::ABILITAZIONE-->" + (result[k]? "[x]" : "[ ]" ) + request.getRemoteUser() + " - " + applicazione.getProfili()[k] );
			  			if (result[k]) {
			  				applicazione.setAuth(true);
							role.add(applicazione.getProfili()[k]);
						}
			  		}
		  		}		
				else {
					log.info(applicazione.getNomeEar()+"::ABILITAZIONE--> CONTROLLO DISABILITATO PER NUMERO NON CONGRUO FRA RUOLI E PROFILI");
				}
		  	}
		}
		utenteNew.getAppAbil().put(applicazione, role);

	}
	
	private static MappaturaCodUfficioBean getMappaturaCodUff(String codUffDog)throws CoopintLoginException, Exception {
		UtilityService utilityService = new UtilityService();
		MappaturaCodUfficioBean mappaturaCodUfficioBean = utilityService.getMappaturaCodUff(codUffDog);
		return mappaturaCodUfficioBean;
	}
	
	
	//	Restituisce dalla sessione web il profilo dell'utente	
	public static UtenteNew getUtenteNew(HttpSession session){
		return (UtenteNew)( session.getAttribute(CostantiUtil.UTENTE_NEW) );
	}
	
	//	Restituisce dalla sessione web il profilo dell'utente	
	private static void setUtenteNew(HttpSession session, UtenteNew utente){
		session.setAttribute(CostantiUtil.UTENTE_NEW, utente);
	}
}
