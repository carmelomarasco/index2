package it.finanze.entrate.coopint.login.autorizzazioni.filter;

import it.finanze.entrate.coopint.login.autorizzazioni.bean.MappaturaCodUfficioBean;
import it.finanze.entrate.coopint.login.autorizzazioni.bean.UtenteNew;
import it.finanze.entrate.coopint.login.autorizzazioni.exception.CoopintLoginException;
import it.finanze.entrate.coopint.login.util.CostantiUtil;
import it.finanze.entrate.coopint.login.util.UserAuth;
import it.finanze.entrate.coopint.login.util.UtilityService;
import it.finanze.entrate.coopint.login.util.WebUtils;
import it.finanze.security.UnauthenticatedUserException;
import it.finanze.security.login.AuthContext;
import it.finanze.security.login.LoginException;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class CheckAuthFilter implements Filter {
	
	protected Logger logger 			= Logger.getLogger(this.getClass());
	protected Logger loggerFileTrace 	= Logger.getLogger("indexmoss.trace");

	UtilityService serviceApp = new UtilityService();

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public CheckAuthFilter() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.Filter#init(FilterConfig arg0)
	 */
	public void init(FilterConfig arg0) throws ServletException {
	}

	/* (non-Java-doc)
	 * @see javax.servlet.Filter#doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if ( request instanceof HttpServletRequest && response instanceof HttpServletResponse ) {
			this.doFilter( (HttpServletRequest)request, (HttpServletResponse)response, chain );
		} else {
			chain.doFilter( request, response );
		}
	}

	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		WebUtils.activeLogger();
		
		boolean errore = false;
		boolean primoAccesso = false;
		boolean altraApplicazione = false;
		boolean sessioneScaduta = false;
		
		HttpSession session = request.getSession(); 
		logger.debug("Sessione n.: "+session.getId());
		UtenteNew utente = null;
		String qS = request.getQueryString();
		logger.debug("FromLogin: "+qS);
		String contextPath = request.getContextPath();
		if(contextPath.indexOf("CoopIntLoginWeb")>-1 )
			if (qS==null || qS.indexOf("fromLogin") == -1)
				utente = (UtenteNew)(session.getAttribute(CostantiUtil.UTENTE_NEW));
			else
				primoAccesso = true;
		else
			altraApplicazione = true;
		
		
//		if(qS!=null && qS.indexOf("fromLogin") > -1)
//			primoAccesso = true;
		
		try {
//			if (!(AuthContext.isSessionInitialized(request)))
				AuthContext.sessionInit(request, response);
		} catch (LoginException e1) {
			logger.error("entro in LoginException:");
			e1.printStackTrace();
			session.removeAttribute(CostantiUtil.UTENTE_NEW);
			errore = true;
			response.sendRedirect( request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/common/redirect.jsp" );
		} catch (UnauthenticatedUserException e1) {
			logger.error("entro in UnauthenticatedUserException:");
			e1.printStackTrace();
			session.removeAttribute(CostantiUtil.UTENTE_NEW);
			errore = true;
			response.sendRedirect( request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/common/redirect.jsp" );
		}
		
		if((primoAccesso || altraApplicazione) && !errore) {
			try {
				UserAuth userAuth = new UserAuth();
				userAuth.valorizzaInfoUtenteNew(request);
			} catch (CoopintLoginException e) {
				logger.error("entro in CoopIntLoginException:");
			}
		}
		
//		if(!primoAccesso) {
//			if(session.getAttribute(CostantiUtil.APPLICAZIONE)==null) {
//				sessioneScaduta = true;
//				response.sendRedirect( request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/common/expiredExternal.jsp" );
//			}
//		}
		
		if(!errore && !sessioneScaduta){
			WebUtils.sideMenu(request, response);
			chain.doFilter( request , response );
		}
		
		
		//*********** INIZIO UTENTE TEST DA ELIMINARE *****/
		/*UtenteNew utenteNew = new UtenteNew();
		utenteNew.setCheckAuth(true);
		utenteNew.setUfficio("123");
		utenteNew.setCodUtente("GLNLRD72C25H501");
		session.setAttribute(CostantiUtil.UTENTE_NEW,utenteNew );*/
		//*********** FINE UTENTE TEST DA ELIMINARE *****/
		
	}

	/* (non-Java-doc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}
	
	
//	public void valorizzaInfoUtenteNew(HttpServletRequest request)throws CoopintLoginException {
//		UtenteNew utenteNew = new UtenteNew();
//		
//		boolean wsAttivo = false;
//
//		Properties properties = new Properties();
//		String propertiesPath = "";
//		try  {
//			InitialContext initCtx = new InitialContext();
//			Context env = (Context)initCtx.lookup("java:comp/env");
//			propertiesPath = (String)env.lookup("fileProperties");
//			properties.load(new FileInputStream(propertiesPath+"ini.properties"));
//			wsAttivo = ((String)properties.get("WS_ATTIVO")).equals("true")?true:false;
//		}
//		catch(IOException e)  {
//			throw new RuntimeException("Unable to load property " + propertiesPath);
//		} 
//		catch (NamingException e) {
//			e.printStackTrace();
//		}
//		
//		AuthProxy proxy = null;
//
//		if (wsAttivo){
//			proxy = new AuthProxy();
//			String endpoint = (String)properties.get("ADDRESS_WS_CLEARTRUST");
//			proxy.setEndpoint(endpoint);
//			logger.info("WS_ATTIVO:" + wsAttivo );
//			logger.info("endpoint:" + endpoint );
//		}
//
//		HttpSession session = request.getSession();
//		
//		byte ind = 0;
//		boolean checkAuth = false;
//
//		String nomeEAR = (String)properties.get("nomeEAR");
//		
//		try {
//			utenteNew.setAppAbil(new TreeMap <ApplicazioneBean, List<String>>());
//			List<CoopintLoginSemaforo> listApp = serviceApp.getInfoEarJdbc(nomeEAR);
//					//getInfoAppJdbc(CostantiUtil.TAB_COOPINT_LOGIN_SEMAFORO, nomeEAR);
//			logger.debug("listApp().size():"+listApp.size());
//			for (CoopintLoginSemaforo appSem : listApp){
////				if (appSem.getNomeEar().equals(nomeEAR)){
//					ApplicazioneBean applicazione = new ApplicazioneBean(appSem.getNomeEar(), appSem.getUrl(), appSem.getNomeApplicazione(), appSem.getSuperuserCf(), appSem.getAbilitazione().equals("1")?true:false, appSem.getProfili().split(","));
//					applicazione.setAreaAppl(appSem.getAreaApplicazione());
//					verificaAutUtente(ind, request, utenteNew, applicazione, wsAttivo, proxy);
//					if (utenteNew.getAppAbil().get(applicazione) != null && utenteNew.getAppAbil().get(applicazione).size() > 0)
//						if (checkAuth == false) checkAuth = true;
////				}
//			}
//						
//			String ufficio = "";
//			String codUtente = "";
//			logger.info("checkAuth -> "+checkAuth);
//			logger.debug("checkAuth -> "+checkAuth);
//			if(checkAuth) {
//				//ufficio = AuthContext.getCodiceUfficio(request.getSession());
//				ufficio = UtilityFunctions.getCodiceUfficoEntrateODogane(AuthContext.getUffici(request.getSession()));
//				codUtente = AuthContext.getUtente(request.getSession());
//				if(ufficio != null && ufficio.length()==8) {
//					String codUfficio = ufficio.substring(2); 
//					MappaturaCodUfficioBean mappaturaCodUfficioBean = getMappaturaCodUff(codUfficio);
//					ufficio = mappaturaCodUfficioBean.getCodCics();
//				}
//				else if(ufficio!=null && ufficio.trim().equals(""))
//					throw new Exception("UTENTE NON AUTORIZZATO");
//				logger.info("ufficio -> "+ufficio);
//				if (codUtente != null ) {
//					logger.debug("UTENTE " + codUtente + " UFFICIO " + ufficio + " AUTORIZZATO ALLE SEGUENTI PROCEDURE:" );
//					logger.info("UTENTE " + codUtente + " UFFICIO " + ufficio + " AUTORIZZATO ALLE SEGUENTI PROCEDURE:" );
//				}
//			}
//			
//			utenteNew.setCheckAuth(checkAuth);
//			utenteNew.setUfficio(ufficio);
//			utenteNew.setCodUtente(codUtente);
//			
//			setUtenteNew(session, utenteNew);
//			logger.debug("Sessione postLogin n.: "+session.getId());
//			
//		}
//		catch (UnauthorizedUserException uue){
//			throw new CoopintLoginException(uue.getMessage());
//		}
//		catch (Exception exc){
//			String msg = exc.getMessage();
//			if(exc instanceof WebServicesFault)
//				msg = "Errore in fase di Autorizzazione"; 
//			throw new CoopintLoginException(msg); 
//		}
//	}
//
//	
//	
//	private void verificaAutUtente(byte ind, HttpServletRequest request, UtenteNew utenteNew, ApplicazioneBean applicazione, boolean wsAttivo, AuthProxy proxy){
//		List<String> role = new ArrayList<String>();		
//		Output out = null;
//		logger.info("CHEKAUTH::GESTIONE PROFILAZIONE "+applicazione.getNomeEar()+":");
//		if (!wsAttivo){
//			ind = 0;
//			while(ind < applicazione.getProfili().length ){
//				try {
//					applicazione.setCheckRule(AuthPermission.check(request.getSession(), applicazione.getProfili()[ind], "ACCESS"));
//				} catch (UnauthorizedUserException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				applicazione.setCheckRule(true); // FRANCESCA
//				//Di default l'utente non ha accesso a nessuna funzionalit� 				
//				if (applicazione.isCheckRule()){
//					applicazione.setAuth(true);
//					role.add(applicazione.getProfili()[ind]);
//				}
//				ind++;
//			}
//		} else  {
//			// Costruzione lista richieste 
//			Richiesta[] richieste = new Richiesta[applicazione.getProfili().length];
//		  	for (int i=0; i < applicazione.getProfili().length ; i++ ){
//				Richiesta richiesta = new Richiesta();
//				richiesta.setRisorsa( applicazione.getProfili()[i] );
//				richiesta.setOperazione("ACCESS");
//				richieste[i] = richiesta;
//			}
//			 
//		  	try {
//				out = proxy.permission( request.getRemoteUser(), richieste );
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	  
//			// Verifica codice di ritorno
//		  	if (out.getRisultato().getCodice().compareTo("0") == 0) {
//		  		boolean[] result = out.getDati().getLista();
//		  		if (applicazione.getProfili().length == result.length ) {
//			  		for( int k=0; k<result.length; k++ ) {
//			  			logger.info(applicazione.getNomeEar()+"::ABILITAZIONE-->" + (result[k]? "[x]" : "[ ]" ) + request.getRemoteUser() + " - " + applicazione.getProfili()[k] );
//			  			if (result[k]) {
//			  				applicazione.setAuth(true);
//							role.add(applicazione.getProfili()[k]);
//						}
//			  		}
//		  		}		
//				else {
//					logger.info(applicazione.getNomeEar()+"::ABILITAZIONE--> CONTROLLO DISABILITATO PER NUMERO NON CONGRUO FRA RUOLI E PROFILI");
//				}
//		  	}
//		}
//		utenteNew.getAppAbil().put(applicazione, role);
//	}

	
	
	private static MappaturaCodUfficioBean getMappaturaCodUff(String codUffDog)throws CoopintLoginException, Exception {
		UtilityService utilityService = new UtilityService();
		MappaturaCodUfficioBean mappaturaCodUfficioBean = utilityService.getMappaturaCodUff(codUffDog);
		return mappaturaCodUfficioBean;
	}
	
	//	Restituisce dalla sessione web il profilo dell'utente	
	private static void setUtenteNew(HttpSession session, UtenteNew utenteNew){
		//session.setAttribute(CostantiUtil.UTENTE_NEW, utenteNew);
		session.removeAttribute(CostantiUtil.UTENTE_NEW);
		session.setAttribute(CostantiUtil.UTENTE_NEW, utenteNew);
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}	
}