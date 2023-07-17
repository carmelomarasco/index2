/**
 * Risultato_Ser.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

public class Risultato_Ser extends com.ibm.ws.webservices.engine.encoding.ser.BeanSerializer {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2660852719135596099L;
	/**
     * Constructor
     */
    public Risultato_Ser(
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType, 
           com.ibm.ws.webservices.engine.description.TypeDesc _typeDesc) {
        super(_javaType, _xmlType, _typeDesc);
    }
    @Override
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
        Risultato bean = (Risultato) value;
        java.lang.Object propValue;
        javax.xml.namespace.QName propQName;
        {
          propQName = QName_0_0;
          propValue = bean.getCodice();
          if (propValue != null && !context.shouldSendXSIType()) {
            context.simpleElement(propQName, null, propValue.toString()); 
          } else {
            context.serialize(propQName, null, 
              propValue, 
              QName_1_2,
              true,null);
          }
          propQName = QName_0_1;
          propValue = bean.getMessaggio();
          if (propValue != null && !context.shouldSendXSIType()) {
            context.simpleElement(propQName, null, propValue.toString()); 
          } else {
            context.serialize(propQName, null, 
              propValue, 
              QName_1_2,
              true,null);
          }
        }
    }
        public final static javax.xml.namespace.QName QName_0_0 = 
               com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                      "http://ct.webservices.security.finanze.it",
                      "codice");
        public final static javax.xml.namespace.QName QName_0_1 = 
               com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                      "http://ct.webservices.security.finanze.it",
                      "messaggio");
        public final static javax.xml.namespace.QName QName_1_2 = 
               com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                      "http://www.w3.org/2001/XMLSchema",
                      "string");
}
