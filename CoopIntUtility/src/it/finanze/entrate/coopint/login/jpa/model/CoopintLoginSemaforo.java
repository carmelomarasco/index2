package it.finanze.entrate.coopint.login.jpa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COOPINT_LOGIN_SEMAFORO")
//@Table(name="COOPINT_TEST_EAR")
public class CoopintLoginSemaforo implements Serializable {
	@Id
	@Column(name="ID_SEMAFORO")
	private long idSemaforo;

	@Column(name="NOME_EAR")
	private String nomeEar;

	@Column(name="AREA")
	private String areaApplicazione;

	@Column(name="SOTTO_AREA")
	private String sottoAreaApplicazione;

	@Column(name="NOME_APPL")
	private String nomeApplicazione;

	@Column(name="GRUPPO")
	private String gruppoApplicazione;

	@Column(name="SUPERUSER_CF")
	private String superuserCf;
	
	@Column(name="NOTE")
	private String note;

	@Column(name="ABILITAZIONE")
	private String abilitazione;

	@Column(name="URL")
	private String url;

	@Column(name="PROFILI")
	private String profili;

	private static final long serialVersionUID = 1L;

	public CoopintLoginSemaforo() {
		super();
	}

	public long getIdSemaforo() {
		return this.idSemaforo;
	}

	public void setIdSemaforo(long idSemaforo) {
		this.idSemaforo = idSemaforo;
	}

	public String getNomeEar() {
		return this.nomeEar;
	}

	public void setNomeEar(String nomeEar) {
		this.nomeEar = nomeEar;
	}

	public String getAreaApplicazione() {
		return areaApplicazione;
	}

	public void setAreaApplicazione(String areaApplicazione) {
		this.areaApplicazione = areaApplicazione;
	}

	public String getSottoAreaApplicazione() {
		return sottoAreaApplicazione;
	}

	public void setSottoAreaApplicazione(String sottoAreaApplicazione) {
		this.sottoAreaApplicazione = sottoAreaApplicazione;
	}

	public String getGruppoApplicazione() {
		return gruppoApplicazione;
	}

	public void setGruppoApplicazione(String gruppoApplicazione) {
		this.gruppoApplicazione = gruppoApplicazione;
	}

	public String getNomeApplicazione() {
		return this.nomeApplicazione;
	}

	public void setNomeApplicazione(String nomeApplicazione) {
		this.nomeApplicazione = nomeApplicazione;
	}

	public String getSuperuserCf() {
		return this.superuserCf;
	}

	public void setSuperuserCf(String superuserCf) {
		this.superuserCf = superuserCf;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAbilitazione() {
		return this.abilitazione;
	}

	public void setAbilitazione(String abilitazione) {
		this.abilitazione = abilitazione;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProfili() {
		return this.profili;
	}

	public void setProfili(String profili) {
		this.profili = profili;
	}

}
