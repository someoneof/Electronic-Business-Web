package junitTest;

import myshop.bean.IDCard;
import myshop.service.IDCardService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IDCardServiceImplTest extends SuperTest {

	static IDCardService cardImpl;
	static ApplicationContext ct;
	
	@BeforeClass
	public static void before()
	{
		ct = new ClassPathXmlApplicationContext("applicationContext.xml");
		cardImpl =(IDCardService)ct.getBean("iDCardServiceImpl");
		
	}
	
	@Test
	public void testsave()
	{
		IDCard card=new IDCard();
		card.setAddress("ÖÐ¹ú");
		card.setBirthday("100232");
		card.setIdNo("23948349");
		cardImpl.save(card);
		
	}

	
	
	@Test
	public void test()
	{
	}

}
