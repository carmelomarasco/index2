package it.finanze.entrate.coopint.login.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Wds075 implements Serializable {
	@EmbeddedId
	private Wds075PK pk;

	@Column(name="DESC_CICS")
	private String descCics;

	@Column(name="FLAG_STRADA")
	private BigDecimal flagStrada;

	@Column(name="DATA_STRADA")
	private Date dataStrada;

	@Column(name="DATA_INIZIO_VALIDITA")
	private Date dataInizioValidita;

	private static final long serialVersionUID = 1L;

	public Wds075() {
		super();
	}

	public Wds075PK getPk() {
		return this.pk;
	}

	public void setPk(Wds075PK pk) {
		this.pk = pk;
	}

	public String getDescCics() {
		return this.descCics;
	}

	public void setDescCics(String descCics) {
		this.descCics = descCics;
	}

	public BigDecimal getFlagStrada() {
		return this.flagStrada;
	}

	public void setFlagStrada(BigDecimal flagStrada) {
		this.flagStrada = flagStrada;
	}

	public Date getDataStrada() {
		return this.dataStrada;
	}

	public void setDataStrada(Date dataStrada) {
		this.dataStrada = dataStrada;
	}

	public Date getDataInizioValidita() {
		return this.dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

}
