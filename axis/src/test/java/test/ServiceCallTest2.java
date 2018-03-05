package test;

import _1._0._0._127.services.TestService.TestServiceServiceLocator;

public class ServiceCallTest2 {
	public static void main(String[] args) {
		TestServiceServiceLocator locator = new TestServiceServiceLocator();
		try {
			_1._0._0._127.services.TestService.TestService service = locator.getTestService();
			String sayHello = service.sayHello("lijuntao");
			System.out.println(sayHello);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
