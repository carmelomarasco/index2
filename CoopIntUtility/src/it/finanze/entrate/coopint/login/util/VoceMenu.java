package it.finanze.entrate.coopint.login.util;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class VoceMenu implements Serializable, Comparable<VoceMenu>{
	
	private static final long serialVersionUID = -6877813311926476820L;
	private String titolo;
	private String url;
	//Nome, url
	private Map<String, String> subVoci = new TreeMap<String, String>();
	
	public VoceMenu(String titolo) {
		super();
		this.titolo = titolo;
	}
	public VoceMenu(String titolo, String url) {
		super();
		this.titolo = titolo;
		this.url = url;
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
	public Map<String, String> getSubVoci() {
		return subVoci;
	}
	public void setSubVoci(Map<String, String> voci) {
		this.subVoci = voci;
	}

	@Override
	public int compareTo(VoceMenu o) {
//		int result = -1;
//		if (this.titolo.compareTo(o.getTitolo()) == 0 && this.getVoci().size() == 0 && o.getVoci().size() == 0)
//			result = 0;
//		else if (this.titolo.compareTo(o.getTitolo()) == 0 && this.getVoci().size() != 0 && o.getVoci().size() != 0 && this.getVoci().size() == o.getVoci().size()){
//			if (this.voci.containsAll(o.getVoci()))
//				result = 0;
//		}
		return this.titolo.compareTo(o.getTitolo());
//		return result;
	}

	
	
}
