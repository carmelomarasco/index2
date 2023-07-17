/**
 * AuthServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

import javax.xml.namespace.QName;

public class AuthServiceLocator extends com.ibm.ws.webservices.engine.client.Service implements it.finanze.security.webservices.ct.AuthService {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2931882316635706523L;
	// Utilizzo per richiamare una classe proxy per auth
    private final java.lang.String auth_address = "http://gestaccessival.sogei.it:80/WSAuthWeb/services/Auth";

    public java.lang.String getAuthAddress() {
        return auth_address;
    }

    // The WSDD port name defaults to the port name.
    private java.lang.String authWSDDPortName = "Auth";

    public java.lang.String getAuthWSDDPortName() {
        return authWSDDPortName;
    }

    public void setAuthWSDDPortName(java.lang.String name) {
        authWSDDPortName = name;
    }

    public it.finanze.security.webservices.ct.Auth getAuth() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(auth_address);
        }
        catch (java.net.MalformedURLException e) {
            return null; // diversamente da come è stato convalidato lURL in WSDL2Java
        }
        return getAuth(endpoint);
    }

    public it.finanze.security.webservices.ct.Auth getAuth(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            it.finanze.security.webservices.ct.AuthSoapBindingStub _stub = new it.finanze.security.webservices.ct.AuthSoapBindingStub(portAddress, this);
            _stub.setPortName(getAuthWSDDPortName());
            return _stub;
        }
        catch (com.ibm.ws.webservices.engine.WebServicesFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (it.finanze.security.webservices.ct.Auth.class.isAssignableFrom(serviceEndpointInterface)) {
                it.finanze.security.webservices.ct.AuthSoapBindingStub _stub = new it.finanze.security.webservices.ct.AuthSoapBindingStub(new java.net.URL(auth_address), this);
                _stub.setPortName(getAuthWSDDPortName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("WSWS3273E: Errore: Nessuna implementazione stub per linterfaccia:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        String inputPortName = portName.getLocalPart();
        if ("Auth".equals(inputPortName)) {
            return getAuth();
        }
        else  {
            throw new javax.xml.rpc.ServiceException();
        }
    }

    @Override
	public javax.xml.namespace.QName getServiceName() {
        return com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "AuthService");
    }

    private java.util.HashSet<QName> ports = null;

    @Override
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet<QName>();
            ports.add(new javax.xml.namespace.QName("http://ct.webservices.security.finanze.it","Auth"));
        }
        return ports.iterator();
    }

    @Override
	public javax.xml.rpc.Call[] getCalls(javax.xml.namespace.QName portName) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            throw new javax.xml.rpc.ServiceException("WSWS3062E: Errore: Il nome porta non può essere nullo.");
        }
        if  (portName.getLocalPart().equals("Auth")) {
            return new javax.xml.rpc.Call[] {
                createCall(portName, "login"),
                createCall(portName, "checkAuth"),
                createCall(portName, "getCodiceUfficio"),
                createCall(portName, "permission"),
            };
        }
        else {
            throw new javax.xml.rpc.ServiceException("WSWS3062E: Errore: Il nome porta non può essere nullo.");
        }
    }
}
