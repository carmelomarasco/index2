package it.finanze.entrate.index.login.actions;

import it.finanze.entrate.coopint.login.autorizzazioni.bean.ApplicazioneBean;
import it.finanze.entrate.coopint.login.autorizzazioni.bean.UtenteNew;
import it.finanze.entrate.coopint.login.util.Menu;
import it.finanze.entrate.coopint.login.util.VoceMenu;
import it.finanze.entrate.coopint.login.util.UserAuth;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SideMenuAction extends Action {

	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = new ActionForward();

		try {
			//	prevents caching at the proxy server
			response.setDateHeader("Header",System.currentTimeMillis());
			response.setDateHeader("Expires", -1); 
		} 
		catch (Exception e) {
			// Report the error using the appropriate name and ID.
			errors.add("name", new ActionMessage("id"));
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
		} else {
			String func = request.getParameter("head")!= null ? request.getParameter("head"): "home";
			String area = request.getParameter("a")!= null ? request.getParameter("a"): "";
			log.debug("COOPINT::CARICAMENTO SEMAFORO");			
			
			UtenteNew utenteNew = UserAuth.getUtenteNew(request.getSession());
			Map <ApplicazioneBean, List<String>> appAbil = utenteNew.getAppAbil();
			Menu menuOrizzontale = null;
			Menu menuVerticale = null;
			VoceMenu voce = null;
		
			if ( func.equals("home") ) {
				//menu orizzontale
				System.out.println("Applicazioni autorizzate: "+utenteNew.getAppAbil().entrySet().size());	
				menuOrizzontale = new Menu();
				for (Entry<ApplicazioneBean, List<String>> appl : appAbil.entrySet()){
					
					voce = new VoceMenu(appl.getKey().getAreaAppl());
					menuOrizzontale.getElenco().add(voce);
						
					for (VoceMenu sottoVoce : menuOrizzontale.getElenco()){
						if (appl.getKey().getSottoAreaAppl()!=null && sottoVoce.getTitolo().equals(appl.getKey().getAreaAppl()))
							sottoVoce.getSubVoci().put(appl.getKey().getSottoAreaAppl(), null);
					}
					
				}
				request.getSession().setAttribute("menuOrizzontale", menuOrizzontale);
				forward = mapping.findForward("success");
				
				//visualizzazione automatica del menu verticale nel caso di unica voce del menu orizzontale
				if (menuOrizzontale.getElenco().size() == 1)
					for (VoceMenu a: menuOrizzontale.getElenco())
						if (a.getSubVoci().size() == 0)
							area = a.getTitolo();
						else if (a.getSubVoci().size() == 1)
							for (Entry<String, String> v : a.getSubVoci().entrySet())
								area = v.getKey();
				
				
				//menu verticale
				if (!area.isEmpty()) {
					
					menuVerticale = new Menu();
					menuVerticale.setTitolo(area);
					int countGruppoAppl = 0;
					for (Entry<ApplicazioneBean, List<String>> appl : appAbil.entrySet()){
						
						if (area.equals(appl.getKey().getAreaAppl()) || (appl.getKey().getSottoAreaAppl() != null && area.equals(appl.getKey().getSottoAreaAppl())) ){
							
							if (appl.getKey().getGruppoAppl() == null){
								if (appl.getKey().isAbilitazione() ||
										//superuser
										(!appl.getKey().isAbilitazione() && appl.getKey().getSuperUser().contains(utenteNew.getCodUtente()))  ){
									voce = new VoceMenu(appl.getKey().getTitolo(), appl.getKey().getUrl());
								//in manutenzione
								} else if (!appl.getKey().isAbilitazione() && !appl.getKey().getSuperUser().contains(utenteNew.getCodUtente())){
									voce = new VoceMenu(appl.getKey().getTitolo(), "/CoopIntLoginWeb/SideMenu.do?id=5-01-00-00&openMenu=1&compatta=ok&head=Man&a="+area);
								}
								menuVerticale.getElenco().add(voce);
							} else {
								voce = new VoceMenu(appl.getKey().getGruppoAppl(), String.valueOf(countGruppoAppl++));
								menuVerticale.getElenco().add(voce);
							}
								

							for (VoceMenu sottoVoce : menuVerticale.getElenco()){
								if (appl.getKey().getGruppoAppl()!=null && (sottoVoce.getTitolo().equals(appl.getKey().getGruppoAppl())) ){
									if (appl.getKey().isAbilitazione() ||
											//superuser
											(!appl.getKey().isAbilitazione() && appl.getKey().getSuperUser().contains(utenteNew.getCodUtente()))  ){
										sottoVoce.getSubVoci().put(appl.getKey().getTitolo(), appl.getKey().getUrl());
									//in manutenzione
									} else if (!appl.getKey().isAbilitazione() && !appl.getKey().getSuperUser().contains(utenteNew.getCodUtente())){
										sottoVoce.getSubVoci().put(appl.getKey().getTitolo(), "/CoopIntLoginWeb/SideMenu.do?id=5-01-00-00&openMenu=1&compatta=ok&head=Man&a="+area);
									}

								}
							}

						
						}						
							
					}
					
//					System.out.println("Numero voci menu verticale: "+menuVerticale.getElenco().size());
//					for (VoceMenu voci : menuVerticale.getElenco()){
//						System.out.println("Area - "+voci.getTitolo());
//						for (Entry<String, String> voceMenu : voci.getSubVoci().entrySet()){
//							System.out.println("Sub area - "+voceMenu.getKey());
//							
//						}
//					}
					request.getSession().setAttribute("titoloMenu", area);
					request.getSession().setAttribute("menuVerticale", menuVerticale);
					forward = mapping.findForward("success2");
				}				
				
			}
			else if ( func.equals("News") ) {

			}	
			else if ( func.equals("Help") )
				forward = mapping.findForward("HelpSuccess");	
			else
				forward = mapping.findForward("manutenzione");	

		}
		//request.getSession().removeAttribute(CostantiUtil.UTENTE);
		// Finish with
		return (forward);

	}	
	
}
