package junitTest;

import myshop.bean.ProductStyle;
import myshop.service.ProductService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductStyleServiceTest {
	
	static ApplicationContext ct;
	static ProductService daoImpl;
	@BeforeClass
	public static void before()
	{
		ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		daoImpl=(ProductService)ct.getBean("productServiceImpl");
	}

	@Test
	public void test()
	{
		
	}
	@Test
	public void testsave()
	{
		ProductStyle style1=new ProductStyle("style", "/shopping/style/logo/2016/12/27/15/style.tmp");
		ProductStyle style2=new ProductStyle("style", "/shopping/style/logo/2016/12/27/15/style.tmp");
		daoImpl.save(style1); 
		daoImpl.save(style2); 
		
	}

}
