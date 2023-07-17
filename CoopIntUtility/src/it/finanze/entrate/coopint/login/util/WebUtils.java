package it.finanze.entrate.coopint.login.util;

import it.finanze.entrate.coopint.login.autorizzazioni.bean.ApplicazioneBean;
import it.finanze.entrate.coopint.login.autorizzazioni.bean.UtenteNew;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;

public class WebUtils {
	
	private static boolean isLoggerActive = false;
	public static void activeLogger(){

		if(!isLoggerActive) {

			String log4jPath = "";

			try {

				InitialContext initCtx = new InitialContext();
				Context env = (Context)initCtx.lookup("java:comp/env");

				log4jPath = (String)env.lookup("log4jPath");

				PropertyConfigurator.configure(log4jPath);

				isLoggerActive = true;

			} catch (NamingException e) {
				// Blocco catch generato automaticamente
				e.printStackTrace();
			}
		}
	}
	
	public static void sideMenu(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String func = request.getParameter("head")!= null ? request.getParameter("head"): "home";
		String area = request.getParameter("a")!= null ? request.getParameter("a"): "";
//		log.debug("COOPINT::CARICAMENTO SEMAFORO");			
		
		UtenteNew utenteNew = UserAuth.getUtenteNew(request.getSession());
		Map <ApplicazioneBean, List<String>> appAbil = utenteNew.getAppAbil();
		Menu menuOrizzontale = null;
		Menu menuVerticale = null;
		VoceMenu voce = null;
	
		if ( func.equals("home") ) {
			//menu orizzontale
//			System.out.println("Applicazioni autorizzate: "+utenteNew.getAppAbil().entrySet().size());	
			menuOrizzontale = new Menu();
			for (Entry<ApplicazioneBean, List<String>> appl : appAbil.entrySet()){
				if (!appl.getKey().getUrl().equals("#"))
					voce = new VoceMenu(appl.getKey().getAreaAppl(), appl.getKey().getUrl());
				else 
					voce = new VoceMenu(appl.getKey().getAreaAppl());
				menuOrizzontale.getElenco().add(voce);
					
				for (VoceMenu sottoVoce : menuOrizzontale.getElenco()){
					if (appl.getKey().getSottoAreaAppl()!=null && sottoVoce.getTitolo().equals(appl.getKey().getAreaAppl()))
						sottoVoce.getSubVoci().put(appl.getKey().getSottoAreaAppl(), null);
				}
				
			}
			request.getSession().setAttribute(CostantiUtil.MENU_ORIZZONTALE, menuOrizzontale);
//			forward = mapping.findForward("success");
			
			//visualizzazione automatica del menu verticale nel caso di unica voce del menu orizzontale
			if (menuOrizzontale.getElenco().size() == 1) {
				for (VoceMenu a: menuOrizzontale.getElenco()) {
					if (a.getSubVoci().size() == 0)
						area = a.getTitolo();
					else if (a.getSubVoci().size() == 1)
						for (Entry<String, String> v : a.getSubVoci().entrySet())
							area = v.getKey();
				}
			}
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
				
				request.getSession().setAttribute(CostantiUtil.TITOLO_MENU, area);
				request.getSession().setAttribute(CostantiUtil.MENU_VERTICALE, menuVerticale);
			}
		}
	
	}
}
