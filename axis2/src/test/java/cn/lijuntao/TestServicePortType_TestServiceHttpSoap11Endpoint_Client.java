
package cn.lijuntao;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.2
 * 2018-03-01T17:40:46.561+08:00
 * Generated source version: 3.2.2
 *
 */
public final class TestServicePortType_TestServiceHttpSoap11Endpoint_Client {

    private static final QName SERVICE_NAME = new QName("http://service.axis2.lijuntao.cn", "TestService");

    private TestServicePortType_TestServiceHttpSoap11Endpoint_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = TestService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        TestService ss = new TestService(wsdlURL, SERVICE_NAME);
        TestServicePortType port = ss.getTestServiceHttpSoap11Endpoint();

        {
        System.out.println("Invoking sayGoodbye...");
        java.lang.String _sayGoodbye_name = "";
        java.lang.String _sayGoodbye__return = port.sayGoodbye(_sayGoodbye_name);
        System.out.println("sayGoodbye.result=" + _sayGoodbye__return);


        }
        {
        System.out.println("Invoking sayHello...");
        java.lang.String _sayHello_name = "";
        java.lang.String _sayHello__return = port.sayHello(_sayHello_name);
        System.out.println("sayHello.result=" + _sayHello__return);


        }

        System.exit(0);
    }

}
