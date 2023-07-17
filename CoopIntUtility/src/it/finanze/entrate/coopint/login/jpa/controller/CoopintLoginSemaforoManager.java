package it.finanze.entrate.coopint.login.jpa.controller;

import it.finanze.entrate.coopint.login.jpa.model.CoopintLoginSemaforo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

//import com.ibm.jpa.web.Action;
//import com.ibm.jpa.web.JPAManager;
//import com.ibm.jpa.web.NamedQueryTarget;

@SuppressWarnings("unchecked")
//@JPAManager(targetEntity = it.finanze.entrate.coopint.login.jpa.model.CoopintLoginSemaforo.class)
public class CoopintLoginSemaforoManager {

	protected static final class NamedQueries {

		protected static String getCoopintLoginSemaforoAll = "SELECT m FROM CoopintLoginSemaforo m";
		protected static String getCoopintLoginSemaforo = "SELECT m FROM CoopintLoginSemaforo m WHERE m.areaApplicazione is not null";
		protected static String getCoopintLoginSemaforoAttive = "SELECT m FROM CoopintLoginSemaforo m WHERE m.abilitazione = :1";}

	
	private EntityManagerFactory emf;

	public CoopintLoginSemaforoManager() {
	
	}

	public CoopintLoginSemaforoManager(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private EntityManager getEntityManager() {
		if (emf == null) {
			throw new RuntimeException(
					"The EntityManagerFactory is null.  This must be passed in to the constructor or set using the setEntityManagerFactory() method.");
		}
		return emf.createEntityManager();
	}

	//@Action(Action.ACTION_TYPE.CREATE)
	public String createCoopintLoginSemaforo(CoopintLoginSemaforo coopintLoginSemaforo)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(coopintLoginSemaforo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	//@Action(Action.ACTION_TYPE.DELETE)
	public String deleteCoopintLoginSemaforo(CoopintLoginSemaforo coopintLoginSemaforo)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			coopintLoginSemaforo = em.merge(coopintLoginSemaforo);
			em.remove(coopintLoginSemaforo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	//@Action(Action.ACTION_TYPE.UPDATE)
	public String updateCoopintLoginSemaforo(CoopintLoginSemaforo coopintLoginSemaforo)
			throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			coopintLoginSemaforo = em.merge(coopintLoginSemaforo);
			em.getTransaction().commit();
		} catch (Exception ex) {
			try {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} catch (Exception e) {
				ex.printStackTrace();
				throw e;
			}
			throw ex;
		} finally {
			em.close();
		}
		return "";
	}

	//@Action(Action.ACTION_TYPE.FIND)
	public CoopintLoginSemaforo findCoopintLoginSemaforoByIdSemaforo(long idSemaforo) {
		CoopintLoginSemaforo coopintLoginSemaforo = null;
		EntityManager em = getEntityManager();
		try {
			coopintLoginSemaforo = (CoopintLoginSemaforo) em.find(
					CoopintLoginSemaforo.class, idSemaforo);
		} finally {
			em.close();
		}
		return coopintLoginSemaforo;
	}

	//@Action(Action.ACTION_TYPE.NEW)
	public CoopintLoginSemaforo getNewCoopintLoginSemaforo() {
	
		CoopintLoginSemaforo coopintLoginSemaforo = new CoopintLoginSemaforo();
	
		return coopintLoginSemaforo;
	}

	//@NamedQueryTarget("getCoopintLoginSemaforo")
	public List<CoopintLoginSemaforo> getCoopintLoginSemaforo() {
		EntityManager em = getEntityManager();
		List<CoopintLoginSemaforo> results = null;
		try {
			Query query = em.createQuery(NamedQueries.getCoopintLoginSemaforo);
			results = (List<CoopintLoginSemaforo>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	//@NamedQueryTarget("getCoopintLoginSemaforoAttive")
	public List<CoopintLoginSemaforo> getCoopintLoginSemaforoAttive() {
		EntityManager em = getEntityManager();
		List<CoopintLoginSemaforo> results = null;
		try {
			Query query = em
					.createQuery(NamedQueries.getCoopintLoginSemaforoAttive);
			results = (List<CoopintLoginSemaforo>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}