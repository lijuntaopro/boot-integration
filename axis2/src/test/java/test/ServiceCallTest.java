package test;

import cn.lijuntao.TestService;
import cn.lijuntao.TestServicePortType;

public class ServiceCallTest {
	public static void main(String[] args) {
		TestService service = new TestService();
		TestServicePortType port = service.getTestServiceHttpSoap11Endpoint();
		String sayHello = port.sayHello("lijuntao");
		System.out.println(sayHello);
	}
}
