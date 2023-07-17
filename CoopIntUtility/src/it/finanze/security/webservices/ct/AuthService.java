/**
 * AuthService.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

public interface AuthService extends javax.xml.rpc.Service {
    public java.lang.String getAuthAddress();

    public it.finanze.security.webservices.ct.Auth getAuth() throws javax.xml.rpc.ServiceException;

    public it.finanze.security.webservices.ct.Auth getAuth(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
