//VERSIONE NON ESTERNALIZZATA
package it.finanze.entrate.index.login.actions;

import it.finanze.entrate.coopint.login.autorizzazioni.bean.UtenteNew;
import it.finanze.entrate.coopint.login.autorizzazioni.exception.CoopintLoginException;
import it.finanze.entrate.coopint.login.util.UtilityFunctions;
import it.finanze.entrate.coopint.login.util.UserAuth;
import it.finanze.security.UnauthenticatedUserException;
import it.finanze.security.login.AuthContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AutorizzazioneAction extends Action {
	
//	ottengo instanza del log
	//static Logger log = Logger.getLogger(AutorizzazioneAction.class) ;
	protected Logger log = Logger.getLogger(this.getClass().getName());
//	se OFFLINE = false il sw non è "bloccato" quindi entrano tutti gli utenti censiti su LDAP e che abbiano i permessi per accedere ad alemeno una funzionalit� dell'applicativo
//	se OFFLINE = true e l'ufficio non è Sogei forzo il redirect sulla pagina di "Web-site in costruzione"	
	private final boolean OFFLINE = false; 

	 
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception { 
		
		//Leggo le informazioni dalla property
		PropertyConfigurator.configure("/prod/installedApps/coopintLogin/log4j.properties");
		Properties properties = new Properties();
		String propertiesPath = "";

		try {
			InitialContext initCtx = new InitialContext();
			Context env = (Context)initCtx.lookup("java:comp/env");
			propertiesPath = (String)env.lookup("fileProperties");
			properties.load(new FileInputStream(propertiesPath+"ini.properties"));
		 }
		 catch(IOException e) {
		   throw new RuntimeException("Unable to load property " + propertiesPath);
		 } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		try {
			//	prevents caching at the proxy server
			response.setDateHeader("Header",System.currentTimeMillis());
			response.setDateHeader("Expires", -1); 

			// Faccio il logout dell'utente			
			if ( request.getParameter("logout")!=null ){
				request.getRequestDispatcher("ibm_security_logout?logoutExitPage=/home.jsp").forward(request,response);
				return null;
			}
									
			if (!AuthContext.isSessionInitialized(request) ){
				AuthContext.sessionInit(request, response);
				//log.debug("COOPINT::Ufficio: " + AuthContext.getCodiceUfficio(request.getSession()));
				log.debug("COOPINT::Ufficio: " + UtilityFunctions.getCodiceUfficoEntrateODogane(AuthContext.getUffici(request.getSession())));
			}

			if (OFFLINE){
				//utente SO.GE.I. - accesso consentito
				//if( (AuthContext.getCodiceUfficio(request.getSession()) == null) || AuthContext.getCodiceUfficio(request.getSession()).equalsIgnoreCase("000") )
				if( (UtilityFunctions.getCodiceUfficoEntrateODogane(AuthContext.getUffici(request.getSession())) == null) || UtilityFunctions.getCodiceUfficoEntrateODogane(AuthContext.getUffici(request.getSession())).equalsIgnoreCase("000") )
					log.debug("COOPINT::Versione OFFLINE::Utente SO.GE.I. " + request.getRemoteUser() +": Accesso Consentito");
				//utente Agenzia - accesso bloccato	
				else{
					//log.debug("COOPINT::Versione OFFLINE::Utente Agenzia "  + request.getRemoteUser() +": Accesso Bloccato per ufficio " + AuthContext.getCodiceUfficio(request.getSession()) );
					log.debug("COOPINT::Versione OFFLINE::Utente Agenzia "  + request.getRemoteUser() +": Accesso Bloccato per ufficio " + UtilityFunctions.getCodiceUfficoEntrateODogane(AuthContext.getUffici(request.getSession())) );
					return mapping.findForward("failureAppAccess");
				}
			}
			else log.debug("COOPINT::Versione ONLINE");
			
			boolean checkAuth = isAutorizzatoNew(request, response);
			
			if (!checkAuth) {
				forward = mapping.findForward("failureAuth");
				return (forward);
			}
			
		} catch (UnauthenticatedUserException e) {
			forward = new ActionForward("login.jsp");
			return (forward);
		}
		catch (Exception e) {
			log.error("Errore AutorizzazioneAction: " + e.getMessage(), e);
			errors.add("name", new ActionMessage("coopint.exception",e.getMessage()));
			saveErrors(request, errors);
			forward = mapping.findForward("genericError");
			return (forward);
		}
		
		
		forward = mapping.findForward("success");
		return (forward);
		
	}
	
	/**
	 * Restituisce true se l'utente ha accesso a qualche funzionalità di almeno uno dei moduli di CoopInt
	 * @param req
	 * @param res
	 * @return
	 * @throws COOPINTLoginException
	 */	
//	public static boolean isAutorizzato(HttpServletRequest req, HttpServletResponse res) throws COOPINTLoginException{
//		UtenteBean utente = new UtenteBean();
//		try{
//			UserAuth.valorizzaInfoUtente(req);
//			utente = UserAuth.getUtente(req.getSession());
//		 }
//		 catch (Exception e) {
//			throw new COOPINTLoginException(e.getMessage());
//		 }
//		 
//		 return utente.isAuthorized();
//	 }
	
	/**
	 * Restituisce true se l'utente ha accesso a qualche funzionalità di almeno uno dei moduli di CoopInt
	 * @param req
	 * @param res
	 * @return
	 * @throws COOPINTLoginException
	 */	
	public boolean isAutorizzatoNew(HttpServletRequest req, HttpServletResponse res) throws CoopintLoginException{
		UtenteNew utenteNew = new UtenteNew();
		UserAuth usAuth = new UserAuth();
		try {
//			usAuth.valorizzaInfoUtente(req);
//			utente = UserAuth.getUtente(req.getSession());
			usAuth.valorizzaInfoUtenteNew(req);
			utenteNew = UserAuth.getUtenteNew(req.getSession());
		 }
		 catch (Exception e) {
			throw new CoopintLoginException(e.getMessage());
		 }
		 
		 return utenteNew.isAuthorized();
	 }
}