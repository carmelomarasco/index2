/**
 * Dati_Ser.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

public class Dati_Ser extends com.ibm.ws.webservices.engine.encoding.ser.BeanSerializer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5802959544782716487L;
	/**
     * Constructor
     */
    public Dati_Ser(
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
        Dati bean = (Dati) value;
        java.lang.Object propValue;
        javax.xml.namespace.QName propQName;
        {
          propQName = QName_0_9;
          {
            propValue = bean.getLista();
            if (propValue != null) {
              for (int i=0; i<java.lang.reflect.Array.getLength(propValue); i++) {
                context.serialize(propQName, null, 
                    java.lang.reflect.Array.get(propValue, i), 
                    QName_1_10,
                    true,null);
              }
            }
          }
        }
    }
        public final static javax.xml.namespace.QName QName_1_10 = 
               com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                      "http://www.w3.org/2001/XMLSchema",
                      "boolean");
        public final static javax.xml.namespace.QName QName_0_9 = 
               com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                      "http://ct.webservices.security.finanze.it",
                      "lista");
}
