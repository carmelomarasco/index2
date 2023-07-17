package it.finanze.entrate.coopint.login.autorizzazioni.bean;



import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UtenteNew implements Serializable{

	private static final long serialVersionUID = 7926362339256906000L;

	private String codUtente = null;
	private String ufficio = null;
	private String[] uffici = null;
	//private Map <ApplicazioneBean, List<String>> appAbil = new TreeMap <ApplicazioneBean, List<String>>();
	private Map <ApplicazioneBean, List<String>> appAbil = null;
	private HashMap<String, Object> properties = null;
	private boolean checkAuth = false;  // per il controllo finale dell'autorizzazione
	
	//Restituisce false se l'utente non � abilitato su nessuna funzionalit� dell'applicativo	
	public boolean isAuthorized(){
		return checkAuth;
	}
	
	public String getUfficio() {
		return ufficio;
	}
	
	public HashMap<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, Object> properties) {
		this.properties = properties;
	}

	public void setCheckAuth(boolean checkAuth) {
		this.checkAuth = checkAuth;
	}
	
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}

	public void setCodUtente(String codUtente) {
		this.codUtente = codUtente;
	}

	public String getCodUtente() {
		return codUtente;
	}

	public String[] getUffici() {
		return uffici;
	}

	public void setUffici(String[] uffici) {
		this.uffici = uffici;
	}

	public Map<ApplicazioneBean, List<String>> getAppAbil() {
		return appAbil;
	}

	public void setAppAbil(Map<ApplicazioneBean, List<String>> appAbil) {
		this.appAbil = appAbil;
	}

	public boolean isCheckAuth() {
		return checkAuth;
	}
	
	
	
}
