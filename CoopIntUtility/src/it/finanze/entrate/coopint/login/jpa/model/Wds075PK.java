package it.finanze.entrate.coopint.login.jpa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Wds075PK implements Serializable {
	@Column(name="COD_UFF_DOG")
	private String codUffDog;

	@Column(name="COD_CICS")
	private String codCics;

	private static final long serialVersionUID = 1L;

	public Wds075PK() {
		super();
	}

	public String getCodUffDog() {
		return this.codUffDog;
	}

	public void setCodUffDog(String codUffDog) {
		this.codUffDog = codUffDog;
	}

	public String getCodCics() {
		return this.codCics;
	}

	public void setCodCics(String codCics) {
		this.codCics = codCics;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if ( ! (o instanceof Wds075PK)) {
			return false;
		}
		Wds075PK other = (Wds075PK) o;
		return this.codUffDog.equals(other.codUffDog)
			&& this.codCics.equals(other.codCics);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codUffDog.hashCode();
		hash = hash * prime + this.codCics.hashCode();
		return hash;
	}

}
