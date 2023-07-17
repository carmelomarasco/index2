/**
 * Richiesta.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

public class Richiesta  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1427467984318114527L;
	private java.lang.String risorsa;
    private java.lang.String operazione;

    public Richiesta() {
    }

    public java.lang.String getRisorsa() {
        return risorsa;
    }

    public void setRisorsa(java.lang.String risorsa) {
        this.risorsa = risorsa;
    }

    public java.lang.String getOperazione() {
        return operazione;
    }

    public void setOperazione(java.lang.String operazione) {
        this.operazione = operazione;
    }

    private transient java.lang.ThreadLocal<Object> __history;
    @Override
	public boolean equals(java.lang.Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false;}
        Richiesta other = (Richiesta) obj;
        boolean _equals;
        _equals = true
            && ((this.risorsa==null && other.getRisorsa()==null) || 
             (this.risorsa!=null &&
              this.risorsa.equals(other.getRisorsa())))
            && ((this.operazione==null && other.getOperazione()==null) || 
             (this.operazione!=null &&
              this.operazione.equals(other.getOperazione())));
        if (!_equals) { return false; }
        if (__history == null) {
            synchronized (this) {
                if (__history == null) {
                    __history = new java.lang.ThreadLocal<Object>();
                }
            }
        }
        Richiesta history = (Richiesta) __history.get();
        if (history != null) { return (history == obj); }
        if (this == obj) return true;
        __history.set(obj);
        __history.set(null);
        return true;
    }

    private transient java.lang.ThreadLocal<Richiesta> __hashHistory;
    @Override
	public int hashCode() {
        if (__hashHistory == null) {
            synchronized (this) {
                if (__hashHistory == null) {
                    __hashHistory = new java.lang.ThreadLocal<Richiesta>();
                }
            }
        }
        Richiesta history = (Richiesta) __hashHistory.get();
        if (history != null) { return 0; }
        __hashHistory.set(this);
        int _hashCode = 1;
        if (getRisorsa() != null) {
            _hashCode += getRisorsa().hashCode();
        }
        if (getOperazione() != null) {
            _hashCode += getOperazione().hashCode();
        }
        __hashHistory.set(null);
        return _hashCode;
    }

}
