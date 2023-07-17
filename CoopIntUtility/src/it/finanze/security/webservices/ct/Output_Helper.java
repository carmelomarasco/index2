/**
 * Output_Helper.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * cf10402.01 v11604170016
 */

package it.finanze.security.webservices.ct;

public class Output_Helper {
    // Type metadata
    private static com.ibm.ws.webservices.engine.description.TypeDesc typeDesc =
        new com.ibm.ws.webservices.engine.description.TypeDesc(Output.class);

    static {
        com.ibm.ws.webservices.engine.description.FieldDesc field = new com.ibm.ws.webservices.engine.description.ElementDesc();
        field.setFieldName("risultato");
        field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "risultato"));
        field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "Risultato"));
        typeDesc.addFieldDesc(field);
        field = new com.ibm.ws.webservices.engine.description.ElementDesc();
        field.setFieldName("dati");
        field.setXmlName(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "dati"));
        field.setXmlType(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://ct.webservices.security.finanze.it", "Dati"));
        typeDesc.addFieldDesc(field);
    };

    /**
     * Return type metadata object
     */
    public static com.ibm.ws.webservices.engine.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static com.ibm.ws.webservices.engine.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class javaType,  
           javax.xml.namespace.QName xmlType) {
        return 
          new Output_Ser(
            javaType, xmlType, typeDesc);
    };

    /**
     * Get Custom Deserializer
     */
    public static com.ibm.ws.webservices.engine.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class javaType,  
           javax.xml.namespace.QName xmlType) {
        return 
          new Output_Deser(
            javaType, xmlType, typeDesc);
    };

}
