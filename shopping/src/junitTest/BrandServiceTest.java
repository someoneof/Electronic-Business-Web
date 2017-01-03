package junitTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.logging.SimpleFormatter;

import myshop.bean.Brand;
import myshop.bean.ProductType;
import myshop.service.BrandService;
import myshop.web.page.QueryResult;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BrandServiceTest {

	static ApplicationContext ctx;
	static BrandService daoImpl;

	@BeforeClass
	public static void before()
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		daoImpl = (BrandService) ctx.getBean("brandServiceImpl");
	}

	@Test
	public void test()
	{
	}

	@Test
	public void testsave() throws ParseException
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*for (int i = 0; i < 10; i++)
		{*/
			Brand brand = new Brand();
			brand.setName( "adidas");
			Date date = df.parse(df.format(new Date()));
			brand.setLogopath("/shopping/WebRoot/log/" + date + "/test.gif");
			daoImpl.save(brand);
//		}
	}

	@Test
	public void testgetScrollData()
	{
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("code", "asc");
		QueryResult<Brand> qr = daoImpl.getScrollData(Brand.class, 0, 12,
				"where o.visible=1", orderby);
		for (Brand type : qr.getList())
			System.out.println(type.getName());
	}

	@Test
	public void testgetScrollDataNo()
	{
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("code", "asc");
		QueryResult<Brand> qr = daoImpl.getScrollData(Brand.class, orderby);
		for (Brand type : qr.getList())
			System.out.println(type.getName());
	}

	@Test
	public void testfind()
	{
		try
		{
			Brand brand = daoImpl.find("2c40d8325942cacc015942cace570000");
			System.out.println(brand.toString());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
