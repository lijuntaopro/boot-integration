package cn.lijuntao.axis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lijuntao.axis.dao.TestDao;
import cn.lijuntao.axis.service.interfaces.ITestService;

@Service
public class TestService implements ITestService{

	public String sayHello(String name){
		System.out.println(name);
		return testDao.sayHello(name);
	}
	
	public String sayGoodbye(String name){
		System.out.println(name);
		return testDao.sayGoodbye(name);
	}
	
	@Autowired
	private TestDao testDao;

}
