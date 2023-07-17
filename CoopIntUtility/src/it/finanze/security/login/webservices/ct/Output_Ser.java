/**
 * Output_Ser.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.login.webservices.ct;

public class Output_Ser extends com.ibm.ws.webservices.engine.encoding.ser.BeanSerializer {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8372855104188091438L;
	/**
     * Constructor
     */
    public Output_Ser(
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType, 
           com.ibm.ws.webservices.engine.description.TypeDesc _typeDesc) {
        super(_javaType, _xmlType, _typeDesc);
    }
    public void serialize(
        javax.xml.namespace.QName name,
        org.xml.sax.Attributes attributes,
        java.lang.Object value,
        com.ibm.ws.webservices.engine.encoding.SerializationContext context)
        throws java.io.IOException
    {
        context.startElement(name, addAttributes(attributes,value,context));
        addElements(value,context);
        context.endElement();
    }
    protected org.xml.sax.Attributes addAttributes(
        org.xml.sax.Attributes attributes,
        java.lang.Object value,
        com.ibm.ws.webservices.engine.encoding.SerializationContext context)
        throws java.io.IOException
    {
        return attributes;
    }
    protected void addElements(
        java.lang.Object value,
        com.ibm.ws.webservices.engine.encoding.SerializationContext context)
        throws java.io.IOException
    {
        Output bean = (Output) value;
        java.lang.Object propValue;
        javax.xml.namespace.QName propQName;
        {
          propQName = QName_2_3;
          propValue = bean.getRisultato();
          context.serialize(propQName, null, 
              propValue, 
              QName_0_5,
              true,null);
          propQName = QName_2_4;
          propValue = bean.getDati();
          context.serialize(propQName, null, 
              propValue, 
              QName_2_6,
              true,null);
        }
    }
        public final static javax.xml.namespace.QName QName_2_3 = 
               com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                      "http://ct.webservices.login.security.finanze.it",
                      "risultato");
        public final static javax.xml.namespace.QName QName_2_4 = 
               com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                      "http://ct.webservices.login.security.finanze.it",
                      "dati");
        public final static javax.xml.namespace.QName QName_2_6 = 
               com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                      "http://ct.webservices.login.security.finanze.it",
                      "Dati");
        public final static javax.xml.namespace.QName QName_0_5 = 
               com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                      "http://ct.webservices.security.finanze.it",
                      "Risultato");
}
