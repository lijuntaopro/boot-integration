package cn.lijuntao.axis.dao;

import org.springframework.stereotype.Component;

@Component
public class TestDao {
	
	public String sayHello(String name){
		return "Hello " + name;
	}
	
	public String sayGoodbye(String name){
		return "goodbye " + name;
	}
}
