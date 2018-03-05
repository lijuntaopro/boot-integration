package test;

import org.apache.axis.wsdl.WSDL2Java;

public class WsdlGenerate {
	public static void main(String[] args) {
		
		WSDL2Java.main(new String[]{"-o", "H:\\", "http://127.0.0.1:8082/services/TestService?wsdl"});
	}
}
