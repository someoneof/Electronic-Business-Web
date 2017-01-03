package junitTest;

import java.util.LinkedHashMap;

import myshop.bean.ProductType;
import myshop.service.ProductTypeService;
import myshop.web.page.QueryResult;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class productTypeServiceTest {

	static ApplicationContext ctx;
	static ProductTypeService serviceImpl;

	@BeforeClass
	public static void before()
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		serviceImpl = (ProductTypeService) ctx
				.getBean("productTypeServiceImpl");
	}

	@Test
	public void testsave()
	{
		for (int i = 0; i < 10; i++)
		{
			ProductType type = new ProductType();
			type.setName(i + "basket");
			type.setNote("google");
			serviceImpl.save(type);
		}
	}

	@Test
	public void testdelete__()
	{
		int a[] = { 1, 2, 3 };
		serviceImpl.delete(ProductType.class, a);
	}

	@Test
	public void testupdate()
	{
		ProductType type = (ProductType) serviceImpl.find(ProductType.class, 4);
		type.setNote("hahaha");
		serviceImpl.update(type);
	}

	@Test
	public void testgetScrollData()
	{
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("typeid", "desc");
		QueryResult<ProductType> qr = serviceImpl.getScrollData(
				ProductType.class, 0, 12, "where o.visible=1", orderby);
		for (ProductType type : qr.getList())
			System.out.println(type.getName());
	}

	@Test
	public void testgetScrollDataNo()
	{
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("typeid", "desc");
		QueryResult<ProductType> qr = serviceImpl.getScrollData(
				ProductType.class, orderby);
		for (ProductType type : qr.getList())
			System.out.println(type.getName());
	}

	@Test
	public void testgetScroll()
	{	//jphql= select o from ProductType o where o.parent is null and o.visible=1 order by o.productid asc
		//jphql= select o from ProductType o where o.parent is null and o.visible=1 order by o.typeid desc
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("typeid", "desc");
		String hql = "where o.parent is null and o.visible=1";
		QueryResult<ProductType> qr = serviceImpl.getScrollData(ProductType.class, -1, -1, hql, orderby);
		for (ProductType type : qr.getList())
			System.out.println(type.getName());
	}
	
	@Test
	public void testfind()
	{
		ProductType type=serviceImpl.find(ProductType.class, 1);
		System.out.println(type.toString());
	}
}
