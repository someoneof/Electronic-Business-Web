package junitTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import myshop.bean.Product;
import myshop.bean.ProductStyle;
import myshop.bean.ProductType;
import myshop.service.BrandService;
import myshop.service.ProductService;
import myshop.service.ProductStyleService;
import myshop.service.ProductTypeService;
import myshop.web.page.QueryResult;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductServiceTest {

	static ApplicationContext ct;
	static ProductService daoImpl;
	static SimpleDateFormat df;
	static BrandService brandImpl;
	static ProductTypeService  typeImpl;
	static ProductStyleService styleImpl;
	@BeforeClass
	public static void before()
	{
		df = new SimpleDateFormat("yyyy/MM/dd/HH");
		ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		daoImpl=(ProductService) ct.getBean("productServiceImpl");
		brandImpl=(BrandService)ct.getBean("brandServiceImpl");
		typeImpl=(ProductTypeService)ct.getBean("productTypeServiceImpl");
		styleImpl=(ProductStyleService)ct.getBean("productStyleServiceImpl");
	}
	@Test
	public void test()
	{
	}
	
	@Test
	public void testsave() throws ParseException
	{
		Product product=new Product("v2122", 12, "basket", 12, "haha", 12, "haodongxi", 12);
		product.setCreatedate(df.parse(df.format((new Date()))));
		product.setModel("big");
		try{
		product.setBrand(brandImpl.find("2c40d8325942cacc015942cace570000"));
		product.setType(typeImpl.find(ProductType.class, 1));
		product.addProductStyle(new ProductStyle("style","/shopping/style/logo/2016/12/27/15/style.tmp"));
//		product.addProductStyle(styleImpl.find(ProductStyle.class, 1));
		daoImpl.save(product);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void testBetweenAnd()
	{
		LinkedHashMap<String , String> orderby=new LinkedHashMap<String, String>();
		orderby.put("productid", "asc");
//		QueryResult<Product> qr=daoImpl.getScrollData(Product.class, -1, -1, " where o.baseprice >=0", orderby);
		QueryResult<Product> qr=daoImpl.getScrollData(Product.class, -1, -1, " where o.baseprice <=20", orderby);
		for(Product pro:qr.getList())
			System.out.println(pro.toString());
	}
	
	@Test
	public void testfind()
	{
		Product product=daoImpl.find(Product.class, 1);
		System.out.println(product.getName());
	}

}
