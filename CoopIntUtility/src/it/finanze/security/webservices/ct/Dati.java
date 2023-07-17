/**
 * Dati.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

public class Dati  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -713137333351481193L;
	private boolean[] lista;

    public Dati() {
    }

    public boolean[] getLista() {
        return lista;
    }

    public void setLista(boolean[] lista) {
        this.lista = lista;
    }

    public boolean getLista(int i) {
        return lista[i];
    }

    public void setLista(int i, boolean value) {
        this.lista[i] = value;
    }

    private transient java.lang.ThreadLocal<Object> __history;
    @Override
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
        Dati history = (Dati) __history.get();
        if (history != null) { return (history == obj); }
        if (this == obj) return true;
        __history.set(obj);
        Dati other = (Dati) obj;
        boolean _equals;
        _equals = true
            && ((this.lista==null && other.getLista()==null) || 
             (this.lista!=null &&
              java.util.Arrays.equals(this.lista, other.getLista())));
        if (!_equals) {
            __history.set(null);
            return false;
        };
        __history.set(null);
        return true;
    }

    private transient java.lang.ThreadLocal<Dati> __hashHistory;
    @Override
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
        if (getLista() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLista());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLista(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashHistory.set(null);
        return _hashCode;
    }

}
