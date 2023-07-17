/**
 * Output.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.login.webservices.ct;

public class Output  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5881144745673710364L;
	private it.finanze.security.webservices.ct.Risultato risultato;
    private it.finanze.security.login.webservices.ct.Dati dati;

    public Output() {
    }

    public it.finanze.security.webservices.ct.Risultato getRisultato() {
        return risultato;
    }

    public void setRisultato(it.finanze.security.webservices.ct.Risultato risultato) {
        this.risultato = risultato;
    }

    public it.finanze.security.login.webservices.ct.Dati getDati() {
        return dati;
    }

    public void setDati(it.finanze.security.login.webservices.ct.Dati dati) {
        this.dati = dati;
    }

    private transient java.lang.ThreadLocal<Object> __history;
    public boolean equals(java.lang.Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false;}
        if (__history == null) {
            synchronized (this) {
                if (__history == null) {
                    __history = new java.lang.ThreadLocal<Object>();
                }
            }
        }
        Output history = (Output) __history.get();
        if (history != null) { return (history == obj); }
        if (this == obj) return true;
        __history.set(obj);
        Output other = (Output) obj;
        boolean _equals;
        _equals = true
            && ((this.risultato==null && other.getRisultato()==null) || 
             (this.risultato!=null &&
              this.risultato.equals(other.getRisultato())))
            && ((this.dati==null && other.getDati()==null) || 
             (this.dati!=null &&
              this.dati.equals(other.getDati())));
        if (!_equals) {
            __history.set(null);
            return false;
        };
        __history.set(null);
        return true;
    }

    private transient java.lang.ThreadLocal<Output> __hashHistory;
    public int hashCode() {
        if (__hashHistory == null) {
            synchronized (this) {
                if (__hashHistory == null) {
                    __hashHistory = new java.lang.ThreadLocal<Output>();
                }
            }
        }
        Output history = (Output) __hashHistory.get();
        if (history != null) { return 0; }
        __hashHistory.set(this);
        int _hashCode = 1;
        if (getRisultato() != null) {
            _hashCode += getRisultato().hashCode();
        }
        if (getDati() != null) {
            _hashCode += getDati().hashCode();
        }
        __hashHistory.set(null);
        return _hashCode;
    }

}
