/**
 * Dati.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.login.webservices.ct;

public class Dati  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7117024913985213660L;
	private java.lang.String codiceUfficio;

    public Dati() {
    }

    public java.lang.String getCodiceUfficio() {
        return codiceUfficio;
    }

    public void setCodiceUfficio(java.lang.String codiceUfficio) {
        this.codiceUfficio = codiceUfficio;
    }

    private transient java.lang.ThreadLocal<Object> __history;
    public boolean equals(java.lang.Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false;}
        Dati other = (Dati) obj;
        boolean _equals;
        _equals = true
            && ((this.codiceUfficio==null && other.getCodiceUfficio()==null) || 
             (this.codiceUfficio!=null &&
              this.codiceUfficio.equals(other.getCodiceUfficio())));
        if (!_equals) { return false; }
        if (__history == null) {
            synchronized (this) {
                if (__history == null) {
                    __history = new java.lang.ThreadLocal<Object>();
                }
            }
        }
        Dati history = (Dati) __history.get();
        if (history != null) { return (history == obj); }
        if (this == obj) return true;
        __history.set(obj);
        __history.set(null);
        return true;
    }

    private transient java.lang.ThreadLocal<Dati> __hashHistory;
    public int hashCode() {
        if (__hashHistory == null) {
            synchronized (this) {
                if (__hashHistory == null) {
                    __hashHistory = new java.lang.ThreadLocal<Dati>();
                }
            }
        }
        Dati history = (Dati) __hashHistory.get();
        if (history != null) { return 0; }
        __hashHistory.set(this);
        int _hashCode = 1;
        if (getCodiceUfficio() != null) {
            _hashCode += getCodiceUfficio().hashCode();
        }
        __hashHistory.set(null);
        return _hashCode;
    }

}
