package it.finanze.entrate.coopint.login.util;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Menu implements Serializable{
	private static final long serialVersionUID = 4894917409235380358L;
	
	private String titolo;
	private Set<VoceMenu> elenco = new TreeSet<VoceMenu>();
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Set<VoceMenu> getElenco() {
		return elenco;
	}
	public void setElenco(Set<VoceMenu> elenco) {
		this.elenco = elenco;
	}

	
	
}
