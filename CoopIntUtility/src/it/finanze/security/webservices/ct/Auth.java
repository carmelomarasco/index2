/**
 * Auth.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

public interface Auth extends java.rmi.Remote {
    public it.finanze.security.login.webservices.ct.Output login(java.lang.String utente, java.lang.String password) throws java.rmi.RemoteException;
    public it.finanze.security.webservices.ct.Risultato checkAuth(java.lang.String utente, java.lang.String password) throws java.rmi.RemoteException;
    public it.finanze.security.login.webservices.ct.Output getCodiceUfficio(java.lang.String utente) throws java.rmi.RemoteException;
    public it.finanze.security.webservices.ct.Output permission(java.lang.String utente, it.finanze.security.webservices.ct.Richiesta[] listaRichieste) throws java.rmi.RemoteException;
}
