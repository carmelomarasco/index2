package it.finanze.entrate.coopint.login.autorizzazioni.bean;

import java.io.Serializable;

public class ApplicazioneBean implements Serializable, Comparable {

	private static final long serialVersionUID = -8395669503421168578L;
	
	private String nomeEar;
	private String areaAppl;
	private String sottoAreaAppl;
	private String titolo;
	private String gruppoAppl;
	private String url;
	private String superUser;
	private boolean abilitazione;
	private String[] profili;
	private boolean checkRule = false;
	private boolean auth = false;
	
	
	public ApplicazioneBean(String nomeEar, String titolo, String[] profili) {
		super();
		this.nomeEar = nomeEar;
		this.titolo = titolo;
		this.profili = profili;
	}

	public ApplicazioneBean(String nomeEar, String url, String titolo, String[] profili) {
		super();
		this.nomeEar = nomeEar;
		this.url = url;
		this.titolo = titolo;
		this.profili = profili;
	}

	public ApplicazioneBean(String nomeEar, String areaAppl, String sottoAreaAppl, String url, String titolo, String gruppoAppl, String superUser, boolean abilitazione, String[] profili) {
		super();
		this.nomeEar = nomeEar;
		this.areaAppl = areaAppl;
		this.sottoAreaAppl = sottoAreaAppl;
		this.url = url;
		this.titolo = titolo;
		this.gruppoAppl = gruppoAppl;
		this.superUser = superUser;
		this.abilitazione = abilitazione;
		this.profili = profili;
	}

	public ApplicazioneBean(String nomeEar, String url, String titolo, String superUser, boolean abilitazione, String[] profili) {
		super();
		this.nomeEar = nomeEar;
		this.url = url;
		this.titolo = titolo;
		this.superUser = superUser;
		this.abilitazione = abilitazione;
		this.profili = profili;
	}

	public String getNomeEar() {
		return nomeEar;
	}
	public void setNomeEar(String nomeEar) {
		this.nomeEar = nomeEar;
	}
	public String getAreaAppl() {
		return areaAppl;
	}

	public void setAreaAppl(String areaAppl) {
		this.areaAppl = areaAppl;
	}

	public String getSottoAreaAppl() {
		return sottoAreaAppl;
	}

	public void setSottoAreaAppl(String sottoAreaAppl) {
		this.sottoAreaAppl = sottoAreaAppl;
	}

	public String getGruppoAppl() {
		return gruppoAppl;
	}

	public void setGruppoAppl(String gruppoAppl) {
		this.gruppoAppl = gruppoAppl;
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSuperUser() {
		return superUser;
	}

	public void setSuperUser(String superUser) {
		this.superUser = superUser;
	}

	public boolean isAbilitazione() {
		return abilitazione;
	}

	public void setAbilitazione(boolean abilitazione) {
		this.abilitazione = abilitazione;
	}

	public String[] getProfili() {
		return profili;
	}
	public void setProfili(String[] profili) {
		this.profili = profili;
	}
	public boolean isCheckRule() {
		return checkRule;
	}
	public void setCheckRule(boolean checkRule) {
		this.checkRule = checkRule;
	}
	public boolean isAuth() {
		return auth;
	}
	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof ApplicazioneBean))
		      throw new ClassCastException("An ApplicazioneBean expected.");
		    return this.titolo.compareTo(((ApplicazioneBean) o).getTitolo());   
	}
	

}
