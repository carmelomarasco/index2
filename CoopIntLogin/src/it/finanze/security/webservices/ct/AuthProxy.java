package it.finanze.security.webservices.ct;

import org.apache.log4j.Logger;

public class AuthProxy implements it.finanze.security.webservices.ct.Auth {
  //private boolean _useJNDI = true;
  private boolean _useJNDI = false;
  private String _endpoint = null;
  private it.finanze.security.webservices.ct.Auth auth = null;
  
  protected static Logger log = Logger.getLogger(AuthProxy.class);
  
  public AuthProxy() {
    _initAuthProxy();
  }
  
  private void _initAuthProxy() {
  
  if (_useJNDI) {
    try{
      javax.naming.InitialContext ctx = new javax.naming.InitialContext();
      auth = ((it.finanze.security.webservices.ct.AuthService)ctx.lookup("java:comp/env/service/AuthService")).getAuth();
      }
    catch (javax.naming.NamingException namingException) {}
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  if (auth == null) {
	log.info("_useJNDI --> FALSE");
    try{
      auth = (new it.finanze.security.webservices.ct.AuthServiceLocator()).getAuth();
      }
    catch (javax.xml.rpc.ServiceException serviceException) {
    	log.error("_initAuthProxy()::[ERROR]AuthServiceLocator()"); 
    	
    }
  }
  
  if (auth != null) {  	
  	
    if (_endpoint != null)
      ((javax.xml.rpc.Stub)auth)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    else
      _endpoint = (String)((javax.xml.rpc.Stub)auth)._getProperty("javax.xml.rpc.service.endpoint.address");
  }
  
}


public void useJNDI(boolean useJNDI) {
  _useJNDI = useJNDI;
  auth = null;
  
}

public String getEndpoint() {
  return _endpoint;
}

public void setEndpoint(String endpoint) {
  _endpoint = endpoint;
  if (auth != null)
    ((javax.xml.rpc.Stub)auth)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
  
}

public it.finanze.security.webservices.ct.Auth getAuth() {
  if (auth == null)
    _initAuthProxy();
  return auth;
}

public it.finanze.security.login.webservices.ct.Output login(java.lang.String utente, java.lang.String password) throws java.rmi.RemoteException{
  if (auth == null)
    _initAuthProxy();
  return auth.login(utente, password);
}

public it.finanze.security.webservices.ct.Risultato checkAuth(java.lang.String utente, java.lang.String password) throws java.rmi.RemoteException{
  if (auth == null)
    _initAuthProxy();
  return auth.checkAuth(utente, password);
}

public it.finanze.security.login.webservices.ct.Output getCodiceUfficio(java.lang.String utente) throws java.rmi.RemoteException{
  if (auth == null)
    _initAuthProxy();
  return auth.getCodiceUfficio(utente);
}

public it.finanze.security.webservices.ct.Output permission(java.lang.String utente, it.finanze.security.webservices.ct.Richiesta[] listaRichieste) throws java.rmi.RemoteException{
  if (auth == null)
    _initAuthProxy();
  return auth.permission(utente, listaRichieste);
}


}