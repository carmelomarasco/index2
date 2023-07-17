package it.finanze.entrate.coopint.login.jpa.controller;

//import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import com.ibm.jpa.web.NamedQueryTarget;
//import com.ibm.jpa.web.Action;

import it.finanze.entrate.coopint.login.jpa.model.Wds075;
import it.finanze.entrate.coopint.login.jpa.model.Wds075PK;

import java.util.List;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
//@JPAManager(targetEntity = it.finanze.entrate.coopint.login.jpa.model.Wds075.class)
public class Wds075Manager {

	protected static final class NamedQueries {

		protected static final String getWds075 = "SELECT w FROM Wds075 w WHERE w.pk.codUffDog = :codUffDog";}

	private EntityManagerFactory emf;

	public Wds075Manager() {
	
	}

	public Wds075Manager(EntityManagerFactory emf) {
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
	public String createWds075(Wds075 wds075) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(wds075);
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
	public String deleteWds075(Wds075 wds075) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			wds075 = em.merge(wds075);
			em.remove(wds075);
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
	public String updateWds075(Wds075 wds075) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			wds075 = em.merge(wds075);
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
	public Wds075 findWds075ByPrimaryKey(String codUffDog, String codCics) {
		Wds075 wds075 = null;
		EntityManager em = getEntityManager();
		Wds075PK pk = new Wds075PK();
		pk.setCodUffDog(codUffDog);
		pk.setCodCics(codCics);
		try {
			wds075 = (Wds075) em.find(Wds075.class, pk);
		} finally {
			em.close();
		}
		return wds075;
	}

	//@Action(Action.ACTION_TYPE.NEW)
	public Wds075 getNewWds075() {
	
		Wds075 wds075 = new Wds075();
	
		Wds075PK pk = new Wds075PK();
		wds075.setPk(pk);
	
		return wds075;
	}

	//@NamedQueryTarget("getWds075")
	public List<Wds075> getWds075(String codUffDog) {
		EntityManager em = getEntityManager();
		List<Wds075> results = null;
		try {
			Query query = em.createQuery(NamedQueries.getWds075);
			query.setParameter("codUffDog", codUffDog);
			results = (List<Wds075>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}