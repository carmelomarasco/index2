package it.finanze.entrate.index.login.actions;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
/**
 * @version 	1.0
 * @author
 */
public class LogoffAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();
		// return value

		try {
			Enumeration attributes = request.getSession().getAttributeNames();
			if (attributes != null){
				while( attributes.hasMoreElements() ){
					request.getSession().removeAttribute( (String)attributes.nextElement() );
				}
//Logout da CT							
  				request.getSession().invalidate();
				response.sendRedirect("ibm_security_logout?logoutExitPage=/login.jsp");
			}
		} catch (Exception e) {

			// Report the error using the appropriate name and ID.
			errors.add("name", new ActionMessage("id"));

		}

		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.

//	prevents caching at the proxy server
		response.setDateHeader("Header",System.currentTimeMillis());
		response.setDateHeader("Expires", -1); 

		
		if (!errors.isEmpty()) {
			saveErrors(request, errors);

			// Forward control to the appropriate 'failure' URI (change name as desired)
			//	forward = mapping.findForward("failure");

		} else {

			// Forward control to the appropriate 'success' URI (change name as desired)
			// forward = mapping.findForward("success");

		}

		// Finish with
		return (null);

	}
}
