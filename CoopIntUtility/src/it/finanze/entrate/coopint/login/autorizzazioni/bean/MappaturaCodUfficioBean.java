package it.finanze.entrate.coopint.login.autorizzazioni.bean;

import java.io.Serializable;
import java.util.Date;


public class MappaturaCodUfficioBean implements Serializable {
	
	private static final long serialVersionUID = 6560910553825063768L;
	
	private String codUffDog = "";
	private String codCics = "";
	private String descCics = "";
	private Integer flagStrada = null;
	private Date dataStrada = null;
	private Date dataInizioValidita = null;
	
	public String getCodCics() {
		return codCics;
	}
	public void setCodCics(String codCics) {
		this.codCics = codCics;
	}
	public String getCodUffDog() {
		return codUffDog;
	}
	public void setCodUffDog(String codUffDog) {
		this.codUffDog = codUffDog;
	}
	public Date getDataInizioValidita() {
		return dataInizioValidita;
	}
	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}
	public Date getDataStrada() {
		return dataStrada;
	}
	public void setDataStrada(Date dataStrada) {
		this.dataStrada = dataStrada;
	}
	public String getDescCics() {
		return descCics;
	}
	public void setDescCics(String descCics) {
		this.descCics = descCics;
	}
	public Integer getFlagStrada() {
		return flagStrada;
	}
	public void setFlagStrada(Integer flagStrada) {
		this.flagStrada = flagStrada;
	}
}
