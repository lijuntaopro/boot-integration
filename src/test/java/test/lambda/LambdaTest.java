package test.lambda;

import org.junit.Test;

public class LambdaTest {
	@Test
	public void ytest(){
		Runnable r = () -> {System.out.println("nihao");};
		new Thread(r).start();;
	}
}
