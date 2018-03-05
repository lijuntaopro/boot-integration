
package cn.lijuntao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.lijuntao package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHelloName_QNAME = new QName("http://service.axis2.lijuntao.cn", "name");
    private final static QName _SayHelloResponseReturn_QNAME = new QName("http://service.axis2.lijuntao.cn", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.lijuntao
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link SayGoodbye }
     * 
     */
    public SayGoodbye createSayGoodbye() {
        return new SayGoodbye();
    }

    /**
     * Create an instance of {@link SayGoodbyeResponse }
     * 
     */
    public SayGoodbyeResponse createSayGoodbyeResponse() {
        return new SayGoodbyeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.axis2.lijuntao.cn", name = "name", scope = SayHello.class)
    public JAXBElement<String> createSayHelloName(String value) {
        return new JAXBElement<String>(_SayHelloName_QNAME, String.class, SayHello.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.axis2.lijuntao.cn", name = "return", scope = SayHelloResponse.class)
    public JAXBElement<String> createSayHelloResponseReturn(String value) {
        return new JAXBElement<String>(_SayHelloResponseReturn_QNAME, String.class, SayHelloResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.axis2.lijuntao.cn", name = "name", scope = SayGoodbye.class)
    public JAXBElement<String> createSayGoodbyeName(String value) {
        return new JAXBElement<String>(_SayHelloName_QNAME, String.class, SayGoodbye.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.axis2.lijuntao.cn", name = "return", scope = SayGoodbyeResponse.class)
    public JAXBElement<String> createSayGoodbyeResponseReturn(String value) {
        return new JAXBElement<String>(_SayHelloResponseReturn_QNAME, String.class, SayGoodbyeResponse.class, value);
    }

}
