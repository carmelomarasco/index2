package it.finanze.entrate.coopint.login.util;

import it.finanze.entrate.coopint.login.autorizzazioni.bean.MappaturaCodUfficioBean;
import it.finanze.entrate.coopint.login.autorizzazioni.exception.CoopintLoginException;
import it.finanze.entrate.coopint.login.jpa.controller.CoopintLoginSemaforoManager;
import it.finanze.entrate.coopint.login.jpa.controller.JDBCCoopintLoginSemaforoManager;
import it.finanze.entrate.coopint.login.jpa.controller.Wds075Manager;
import it.finanze.entrate.coopint.login.jpa.model.CoopintLoginSemaforo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;

public class UtilityService{
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private EntityManagerFactory emf;
	
	public UtilityService() {

	}

	public UtilityService(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void destroy() {

	}
	
	public List<CoopintLoginSemaforo> getInfoApp()throws CoopintLoginException {
		CoopintLoginSemaforoManager semaforoMan = new CoopintLoginSemaforoManager();
		semaforoMan.setEntityManagerFactory(emf);
		
		List<CoopintLoginSemaforo> listApp = semaforoMan.getCoopintLoginSemaforo();

		return listApp;		
	}
	
	public List<CoopintLoginSemaforo> getInfoAppJdbc(String tableName)throws Exception {
		JDBCCoopintLoginSemaforoManager semaforoMan = new JDBCCoopintLoginSemaforoManager();
		
		List<CoopintLoginSemaforo> listApp = semaforoMan.getCoopintLoginSemaforo(tableName);

		return listApp;		
	}
	
	public List<CoopintLoginSemaforo> getInfoAppJdbc(String tableName, String earName)throws Exception {
//		JDBCCoopintLoginSemaforoManager semaforoMan = new JDBCCoopintLoginSemaforoManager();
		
		List<CoopintLoginSemaforo> listApp = JDBCCoopintLoginSemaforoManager.getCoopintLoginSemaforo(tableName, earName);

		return listApp;		
	}

	public List<CoopintLoginSemaforo> getInfoEarJdbc(String earName)throws Exception {
		JDBCCoopintLoginSemaforoManager semaforoMan = new JDBCCoopintLoginSemaforoManager();
		
		List<CoopintLoginSemaforo> listApp = semaforoMan.getCoopintEar(earName);

		return listApp;		
	}
	
	
	
	public MappaturaCodUfficioBean getMappaturaCodUff(String codUffDog)throws CoopintLoginException {		
		Wds075Manager uffDogMan = new Wds075Manager();
		uffDogMan.setEntityManagerFactory(emf);
		MappaturaCodUfficioBean mappaturaCodUfficioBean = null;
		 
		try {
			uffDogMan.getWds075(codUffDog);
			//mappaturaCodUfficioBean = (MappaturaCodUfficioBean)indexLoginDAO.getMappaturaCodUff(finder);
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "=>ERRORE UtilityService.getMappaturaCodUff() : " + e.getMessage());
			throw new CoopintLoginException(e.getMessage());
		}

		return mappaturaCodUfficioBean;		
	}
	
}
