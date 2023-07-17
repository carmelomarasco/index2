package it.finanze.entrate.index.login.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.tiles.TilesRequestProcessor;

public class SessionRequestProcessor extends TilesRequestProcessor {
	
		protected boolean processPreprocess (
			HttpServletRequest request,
			HttpServletResponse response) 
		{
           
         ////per il LogOff
         String LogOff = (String)request.getParameter("Off")==null? "" : (String)request.getParameter("Off");
         if (LogOff.equals("Esci")){
         	return true;
         }
		 HttpSession session = request.getSession(false);
		 String test = (String)session.getAttribute("AutByLDAP")== null? "" : (String)session.getAttribute("AutByLDAP");
		 if( session != null  && (test).equals("OK"))		 
			 return true;
		 else{
			 try{
				 //If no redirect user to login Page
					
				session.setAttribute("AutByLDAP", "OK");
				if ( request.getParameter("login")!=null && request.getParameter("login").equals("ok") ) 
					return true;

				response.sendRedirect("/CoopIntLoginWeb/Aut.do?login=ok");	
				
			 }catch(Exception ex){
			 	ex.printStackTrace();
			 }
		 }
		 return false;
 }

    
}