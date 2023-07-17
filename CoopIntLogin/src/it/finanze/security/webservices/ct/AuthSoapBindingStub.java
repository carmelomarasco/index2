/**
 * AuthSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

public class AuthSoapBindingStub extends com.ibm.ws.webservices.engine.client.Stub implements it.finanze.security.webservices.ct.Auth {
    public AuthSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws com.ibm.ws.webservices.engine.WebServicesFault {
        if (service == null) {
            super.service = new com.ibm.ws.webservices.engine.client.Service();
        }
        else {
            super.service = service;
        }
        super.engine = ((com.ibm.ws.webservices.engine.client.Service) super.service).getEngine();
        initTypeMapping();
        super.cachedEndpoint = endpointURL;
        super.connection = ((com.ibm.ws.webservices.engine.client.Service) super.service).getConnection(endpointURL);
        super.messageContexts = new com.ibm.ws.webservices.engine.MessageContext[4];
    }

    private void initTypeMapping() {
        javax.xml.rpc.encoding.TypeMapping tm = super.getTypeMapping(com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
        java.lang.Class javaType = null;
        javax.xml.namespace.QName xmlType = null;
        com.ibm.ws.webservices.engine.encoding.SerializerFactory sf = null;
        com.ibm.ws.webservices.engine.encoding.DeserializerFactory df = null;
        javaType = it.finanze.security.login.webservices.ct.Dati.class;
        xmlType = com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.login.security.finanze.it", "Dati");
        sf = com.ibm.ws.webservices.engine.encoding.ser.BaseSerializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanSerializerFactory.class, javaType, xmlType);
        df = com.ibm.ws.webservices.engine.encoding.ser.BaseDeserializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializerFactory.class, javaType, xmlType);
        if (sf != null || df != null) {
            tm.register(javaType, xmlType, sf, df);
        }

        javaType = it.finanze.security.login.webservices.ct.Output.class;
        xmlType = com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.login.security.finanze.it", "Output");
        sf = com.ibm.ws.webservices.engine.encoding.ser.BaseSerializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanSerializerFactory.class, javaType, xmlType);
        df = com.ibm.ws.webservices.engine.encoding.ser.BaseDeserializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializerFactory.class, javaType, xmlType);
        if (sf != null || df != null) {
            tm.register(javaType, xmlType, sf, df);
        }

        javaType = it.finanze.security.webservices.ct.Dati.class;
        xmlType = com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "Dati");
        sf = com.ibm.ws.webservices.engine.encoding.ser.BaseSerializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanSerializerFactory.class, javaType, xmlType);
        df = com.ibm.ws.webservices.engine.encoding.ser.BaseDeserializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializerFactory.class, javaType, xmlType);
        if (sf != null || df != null) {
            tm.register(javaType, xmlType, sf, df);
        }

        javaType = it.finanze.security.webservices.ct.Risultato.class;
        xmlType = com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "Risultato");
        sf = com.ibm.ws.webservices.engine.encoding.ser.BaseSerializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanSerializerFactory.class, javaType, xmlType);
        df = com.ibm.ws.webservices.engine.encoding.ser.BaseDeserializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializerFactory.class, javaType, xmlType);
        if (sf != null || df != null) {
            tm.register(javaType, xmlType, sf, df);
        }

        javaType = it.finanze.security.webservices.ct.Richiesta.class;
        xmlType = com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "Richiesta");
        sf = com.ibm.ws.webservices.engine.encoding.ser.BaseSerializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanSerializerFactory.class, javaType, xmlType);
        df = com.ibm.ws.webservices.engine.encoding.ser.BaseDeserializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializerFactory.class, javaType, xmlType);
        if (sf != null || df != null) {
            tm.register(javaType, xmlType, sf, df);
        }

        javaType = it.finanze.security.webservices.ct.Output.class;
        xmlType = com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "Output");
        sf = com.ibm.ws.webservices.engine.encoding.ser.BaseSerializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanSerializerFactory.class, javaType, xmlType);
        df = com.ibm.ws.webservices.engine.encoding.ser.BaseDeserializerFactory.createFactory(com.ibm.ws.webservices.engine.encoding.ser.BeanDeserializerFactory.class, javaType, xmlType);
        if (sf != null || df != null) {
            tm.register(javaType, xmlType, sf, df);
        }

    }

    private com.ibm.ws.webservices.engine.description.OperationDesc _loginOperation0 = null;
    private com.ibm.ws.webservices.engine.description.OperationDesc _getloginOperation0() {
        if (_loginOperation0 == null) {
            com.ibm.ws.webservices.engine.description.ParameterDesc[] _params = new com.ibm.ws.webservices.engine.description.ParameterDesc[] {
                new com.ibm.ws.webservices.engine.description.ParameterDesc(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "utente"), com.ibm.ws.webservices.engine.description.ParameterDesc.IN, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
                new com.ibm.ws.webservices.engine.description.ParameterDesc(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "password"), com.ibm.ws.webservices.engine.description.ParameterDesc.IN, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            };
            _loginOperation0 = new com.ibm.ws.webservices.engine.description.OperationDesc("login", _params, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "loginReturn"));
            _loginOperation0.setReturnType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.login.security.finanze.it", "Output"));
            _loginOperation0.setElementQName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "login"));
            _loginOperation0.setSoapAction("login");
            com.ibm.ws.webservices.engine.description.FaultDesc _fault = null;
        }
        return _loginOperation0;
    }

    private int _loginIndex0 = 0;
    private synchronized com.ibm.ws.webservices.engine.client.Stub.Invoke _getloginInvoke0(Object[] parameters) throws com.ibm.ws.webservices.engine.WebServicesFault  {
        com.ibm.ws.webservices.engine.MessageContext mc = super.messageContexts[_loginIndex0];
        if (mc == null) {
            mc = new com.ibm.ws.webservices.engine.MessageContext(super.engine);
            mc.setOperation(_getloginOperation0());
            mc.setUseSOAPAction(true);
            mc.setSOAPActionURI("login");
            mc.setOperationStyle("wrapped");
            mc.setOperationUse("literal");
            mc.setEncodingStyle(com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
            mc.setProperty(com.ibm.ws.webservices.engine.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
            mc.setProperty(com.ibm.ws.webservices.engine.WebServicesEngine.PROP_DOMULTIREFS, Boolean.FALSE);
            super.primeMessageContext(mc);
            super.messageContexts[_loginIndex0] = mc;
        }
        try {
            mc = (com.ibm.ws.webservices.engine.MessageContext) mc.clone();
        }
        catch (CloneNotSupportedException cnse) {
            throw com.ibm.ws.webservices.engine.WebServicesFault.makeFault(cnse);
        }
        return new com.ibm.ws.webservices.engine.client.Stub.Invoke(connection, mc, parameters);
    }

    public it.finanze.security.login.webservices.ct.Output login(java.lang.String utente, java.lang.String password) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new com.ibm.ws.webservices.engine.NoEndPointException();
        }
        java.util.Vector _resp = null;
        try {
            _resp = _getloginInvoke0(new java.lang.Object[] {utente, password}).invoke();

        } catch (com.ibm.ws.webservices.engine.WebServicesFault wsf) {
            throw wsf;
        } 
        try {
            return (it.finanze.security.login.webservices.ct.Output) ((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue();
        } catch (java.lang.Exception _exception) {
            return (it.finanze.security.login.webservices.ct.Output) com.ibm.ws.webservices.engine.utils.JavaUtils.convert(((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue(), it.finanze.security.login.webservices.ct.Output.class);
        }
    }

    private com.ibm.ws.webservices.engine.description.OperationDesc _checkAuthOperation1 = null;
    private com.ibm.ws.webservices.engine.description.OperationDesc _getcheckAuthOperation1() {
        if (_checkAuthOperation1 == null) {
            com.ibm.ws.webservices.engine.description.ParameterDesc[] _params = new com.ibm.ws.webservices.engine.description.ParameterDesc[] {
                new com.ibm.ws.webservices.engine.description.ParameterDesc(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "utente"), com.ibm.ws.webservices.engine.description.ParameterDesc.IN, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
                new com.ibm.ws.webservices.engine.description.ParameterDesc(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "password"), com.ibm.ws.webservices.engine.description.ParameterDesc.IN, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            };
            _checkAuthOperation1 = new com.ibm.ws.webservices.engine.description.OperationDesc("checkAuth", _params, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "checkAuthReturn"));
            _checkAuthOperation1.setReturnType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "Risultato"));
            _checkAuthOperation1.setElementQName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "checkAuth"));
            _checkAuthOperation1.setSoapAction("checkAuth");
            com.ibm.ws.webservices.engine.description.FaultDesc _fault = null;
        }
        return _checkAuthOperation1;
    }

    private int _checkAuthIndex1 = 1;
    private synchronized com.ibm.ws.webservices.engine.client.Stub.Invoke _getcheckAuthInvoke1(Object[] parameters) throws com.ibm.ws.webservices.engine.WebServicesFault  {
        com.ibm.ws.webservices.engine.MessageContext mc = super.messageContexts[_checkAuthIndex1];
        if (mc == null) {
            mc = new com.ibm.ws.webservices.engine.MessageContext(super.engine);
            mc.setOperation(_getcheckAuthOperation1());
            mc.setUseSOAPAction(true);
            mc.setSOAPActionURI("checkAuth");
            mc.setOperationStyle("wrapped");
            mc.setOperationUse("literal");
            mc.setEncodingStyle(com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
            mc.setProperty(com.ibm.ws.webservices.engine.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
            mc.setProperty(com.ibm.ws.webservices.engine.WebServicesEngine.PROP_DOMULTIREFS, Boolean.FALSE);
            super.primeMessageContext(mc);
            super.messageContexts[_checkAuthIndex1] = mc;
        }
        try {
            mc = (com.ibm.ws.webservices.engine.MessageContext) mc.clone();
        }
        catch (CloneNotSupportedException cnse) {
            throw com.ibm.ws.webservices.engine.WebServicesFault.makeFault(cnse);
        }
        return new com.ibm.ws.webservices.engine.client.Stub.Invoke(connection, mc, parameters);
    }

    public it.finanze.security.webservices.ct.Risultato checkAuth(java.lang.String utente, java.lang.String password) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new com.ibm.ws.webservices.engine.NoEndPointException();
        }
        java.util.Vector _resp = null;
        try {
            _resp = _getcheckAuthInvoke1(new java.lang.Object[] {utente, password}).invoke();

        } catch (com.ibm.ws.webservices.engine.WebServicesFault wsf) {
            throw wsf;
        } 
        try {
            return (it.finanze.security.webservices.ct.Risultato) ((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue();
        } catch (java.lang.Exception _exception) {
            return (it.finanze.security.webservices.ct.Risultato) com.ibm.ws.webservices.engine.utils.JavaUtils.convert(((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue(), it.finanze.security.webservices.ct.Risultato.class);
        }
    }

    private com.ibm.ws.webservices.engine.description.OperationDesc _getCodiceUfficioOperation2 = null;
    private com.ibm.ws.webservices.engine.description.OperationDesc _getgetCodiceUfficioOperation2() {
        if (_getCodiceUfficioOperation2 == null) {
            com.ibm.ws.webservices.engine.description.ParameterDesc[] _params = new com.ibm.ws.webservices.engine.description.ParameterDesc[] {
                new com.ibm.ws.webservices.engine.description.ParameterDesc(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "utente"), com.ibm.ws.webservices.engine.description.ParameterDesc.IN, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            };
            _getCodiceUfficioOperation2 = new com.ibm.ws.webservices.engine.description.OperationDesc("getCodiceUfficio", _params, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "getCodiceUfficioReturn"));
            _getCodiceUfficioOperation2.setReturnType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.login.security.finanze.it", "Output"));
            _getCodiceUfficioOperation2.setElementQName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "getCodiceUfficio"));
            _getCodiceUfficioOperation2.setSoapAction("getCodiceUfficio");
            com.ibm.ws.webservices.engine.description.FaultDesc _fault = null;
        }
        return _getCodiceUfficioOperation2;
    }

    private int _getCodiceUfficioIndex2 = 2;
    private synchronized com.ibm.ws.webservices.engine.client.Stub.Invoke _getgetCodiceUfficioInvoke2(Object[] parameters) throws com.ibm.ws.webservices.engine.WebServicesFault  {
        com.ibm.ws.webservices.engine.MessageContext mc = super.messageContexts[_getCodiceUfficioIndex2];
        if (mc == null) {
            mc = new com.ibm.ws.webservices.engine.MessageContext(super.engine);
            mc.setOperation(_getgetCodiceUfficioOperation2());
            mc.setUseSOAPAction(true);
            mc.setSOAPActionURI("getCodiceUfficio");
            mc.setOperationStyle("wrapped");
            mc.setOperationUse("literal");
            mc.setEncodingStyle(com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
            mc.setProperty(com.ibm.ws.webservices.engine.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
            mc.setProperty(com.ibm.ws.webservices.engine.WebServicesEngine.PROP_DOMULTIREFS, Boolean.FALSE);
            super.primeMessageContext(mc);
            super.messageContexts[_getCodiceUfficioIndex2] = mc;
        }
        try {
            mc = (com.ibm.ws.webservices.engine.MessageContext) mc.clone();
        }
        catch (CloneNotSupportedException cnse) {
            throw com.ibm.ws.webservices.engine.WebServicesFault.makeFault(cnse);
        }
        return new com.ibm.ws.webservices.engine.client.Stub.Invoke(connection, mc, parameters);
    }

    public it.finanze.security.login.webservices.ct.Output getCodiceUfficio(java.lang.String utente) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new com.ibm.ws.webservices.engine.NoEndPointException();
        }
        java.util.Vector _resp = null;
        try {
            _resp = _getgetCodiceUfficioInvoke2(new java.lang.Object[] {utente}).invoke();

        } catch (com.ibm.ws.webservices.engine.WebServicesFault wsf) {
            throw wsf;
        } 
        try {
            return (it.finanze.security.login.webservices.ct.Output) ((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue();
        } catch (java.lang.Exception _exception) {
            return (it.finanze.security.login.webservices.ct.Output) com.ibm.ws.webservices.engine.utils.JavaUtils.convert(((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue(), it.finanze.security.login.webservices.ct.Output.class);
        }
    }

    private com.ibm.ws.webservices.engine.description.OperationDesc _permissionOperation3 = null;
    private com.ibm.ws.webservices.engine.description.OperationDesc _getpermissionOperation3() {
        if (_permissionOperation3 == null) {
            com.ibm.ws.webservices.engine.description.ParameterDesc[] _params = new com.ibm.ws.webservices.engine.description.ParameterDesc[] {
                new com.ibm.ws.webservices.engine.description.ParameterDesc(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "utente"), com.ibm.ws.webservices.engine.description.ParameterDesc.IN, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
                new com.ibm.ws.webservices.engine.description.ParameterDesc(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "listaRichieste"), com.ibm.ws.webservices.engine.description.ParameterDesc.IN, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "Richiesta"), it.finanze.security.webservices.ct.Richiesta[].class, false, false), 
            };
            _permissionOperation3 = new com.ibm.ws.webservices.engine.description.OperationDesc("permission", _params, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "permissionReturn"));
            _permissionOperation3.setReturnType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "Output"));
            _permissionOperation3.setElementQName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "permission"));
            _permissionOperation3.setSoapAction("permission");
            com.ibm.ws.webservices.engine.description.FaultDesc _fault = null;
        }
        return _permissionOperation3;
    }

    private int _permissionIndex3 = 3;
    private synchronized com.ibm.ws.webservices.engine.client.Stub.Invoke _getpermissionInvoke3(Object[] parameters) throws com.ibm.ws.webservices.engine.WebServicesFault  {
        com.ibm.ws.webservices.engine.MessageContext mc = super.messageContexts[_permissionIndex3];
        if (mc == null) {
            mc = new com.ibm.ws.webservices.engine.MessageContext(super.engine);
            mc.setOperation(_getpermissionOperation3());
            mc.setUseSOAPAction(true);
            mc.setSOAPActionURI("permission");
            mc.setOperationStyle("wrapped");
            mc.setOperationUse("literal");
            mc.setEncodingStyle(com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
            mc.setProperty(com.ibm.ws.webservices.engine.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
            mc.setProperty(com.ibm.ws.webservices.engine.WebServicesEngine.PROP_DOMULTIREFS, Boolean.FALSE);
            java.util.HashSet _set = new java.util.HashSet();
            _set.add(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "listaRichieste"));
            mc.setProperty(com.ibm.ws.webservices.engine.MessageContext.PARAM_MINOCCURS_0, _set);
            java.util.HashSet _set2 = new java.util.HashSet();
            _set2.add(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "listaRichieste"));
            mc.setProperty(com.ibm.ws.webservices.engine.MessageContext.PARAM_MAXOCCURS_NOT1, _set2);
            super.primeMessageContext(mc);
            super.messageContexts[_permissionIndex3] = mc;
        }
        try {
            mc = (com.ibm.ws.webservices.engine.MessageContext) mc.clone();
        }
        catch (CloneNotSupportedException cnse) {
            throw com.ibm.ws.webservices.engine.WebServicesFault.makeFault(cnse);
        }
        return new com.ibm.ws.webservices.engine.client.Stub.Invoke(connection, mc, parameters);
    }

    public it.finanze.security.webservices.ct.Output permission(java.lang.String utente, it.finanze.security.webservices.ct.Richiesta[] listaRichieste) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new com.ibm.ws.webservices.engine.NoEndPointException();
        }
        java.util.Vector _resp = null;
        try {
            _resp = _getpermissionInvoke3(new java.lang.Object[] {utente, listaRichieste}).invoke();

        } catch (com.ibm.ws.webservices.engine.WebServicesFault wsf) {
            throw wsf;
        } 
        try {
            return (it.finanze.security.webservices.ct.Output) ((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue();
        } catch (java.lang.Exception _exception) {
            return (it.finanze.security.webservices.ct.Output) com.ibm.ws.webservices.engine.utils.JavaUtils.convert(((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue(), it.finanze.security.webservices.ct.Output.class);
        }
    }

}
