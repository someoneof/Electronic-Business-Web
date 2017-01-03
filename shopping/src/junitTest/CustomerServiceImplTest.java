package junitTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import myshop.bean.Customer;
import myshop.bean.Gender;
import myshop.service.CustomerService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class CustomerServiceImplTest {

	static ApplicationContext cx;
	static CustomerService daoImpl;

	@BeforeClass
	public static void before()
	{
		cx = new ClassPathXmlApplicationContext("applicationContext.xml");
		daoImpl = (CustomerService) cx.getBean("customerServiceImpl");
	}

	@Test
	public void test()
	{
	}

	@Test
	public void testsave() throws ParseException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/HH");
		for (int i = 0; i < 10; i++)
		{
			Customer cu = new Customer();
			cu.setCustomername("xiaoming");
			cu.setUsername(i + "zuotian");
			cu.setPassword("zmhs");
			cu.setEmail("123456677@qq.com");
			cu.setSex(Gender.MAN);
			cu.setRegistertime(df.parse(df.format(new Date())));
			cu.setState(true);
			daoImpl.save(cu);
			System.out.println(cu.toString());
		}

	}
	@Test
	public void testfindByUsername()
	{
		System.out.println(daoImpl.findByUsername("5zuotian"));
	}
	@Test
	public void testlogin()
	{
		System.out.println(daoImpl.login("zuotian","1111111"));
	}
	
	@Test
	public void testgetCustomer()
	{
		System.out.println(daoImpl.getCustomer("1zuotian").toString());
	}
	@Test
	public void testSetCustomerState()
	{
		daoImpl.setCustomerState("delete","0zuotian");
	}
	@Test
	public void testsubString()
	{
		String user="method,";
//		user=user.substring(0, user.length()-1);
		System.out.println(user.substring(0, user.length()-1));
	}
	
	
}
