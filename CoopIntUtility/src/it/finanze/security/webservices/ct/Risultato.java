/**
 * Risultato.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

public class Risultato  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2748982649914128487L;
	private java.lang.String codice;
    private java.lang.String messaggio;

    public Risultato() {
    }

    public java.lang.String getCodice() {
        return codice;
    }

    public void setCodice(java.lang.String codice) {
        this.codice = codice;
    }

    public java.lang.String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(java.lang.String messaggio) {
        this.messaggio = messaggio;
    }

    private transient java.lang.ThreadLocal<Object> __history;
    @Override
	public boolean equals(java.lang.Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false;}
        Risultato other = (Risultato) obj;
        boolean _equals;
        _equals = true
            && ((this.codice==null && other.getCodice()==null) || 
             (this.codice!=null &&
              this.codice.equals(other.getCodice())))
            && ((this.messaggio==null && other.getMessaggio()==null) || 
             (this.messaggio!=null &&
              this.messaggio.equals(other.getMessaggio())));
        if (!_equals) { return false; }
        if (__history == null) {
            synchronized (this) {
                if (__history == null) {
                    __history = new java.lang.ThreadLocal<Object>();
                }
            }
        }
        Risultato history = (Risultato) __history.get();
        if (history != null) { return (history == obj); }
        if (this == obj) return true;
        __history.set(obj);
        __history.set(null);
        return true;
    }

    private transient java.lang.ThreadLocal<Risultato> __hashHistory;
    @Override
	public int hashCode() {
        if (__hashHistory == null) {
            synchronized (this) {
                if (__hashHistory == null) {
                    __hashHistory = new java.lang.ThreadLocal<Risultato>();
                }
            }
        }
        Risultato history = (Risultato) __hashHistory.get();
        if (history != null) { return 0; }
        __hashHistory.set(this);
        int _hashCode = 1;
        if (getCodice() != null) {
            _hashCode += getCodice().hashCode();
        }
        if (getMessaggio() != null) {
            _hashCode += getMessaggio().hashCode();
        }
        __hashHistory.set(null);
        return _hashCode;
    }

}
