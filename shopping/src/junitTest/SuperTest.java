package junitTest;

import static org.junit.Assert.*;
import myshop.service.BrandService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SuperTest {

	public static ApplicationContext ct;

	@BeforeClass
	public static void before()
	{
		ct = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void test()
	{
	}

}
