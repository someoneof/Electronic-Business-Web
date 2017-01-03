package junitTest;

import myshop.bean.Department;
import myshop.service.DepartmentService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DepartmentImplTest extends SuperTest{

	private static DepartmentService daoImpl;
	private static ApplicationContext ct;
	
	@BeforeClass
	public static void before()
	{
		ct = new ClassPathXmlApplicationContext("applicationContext.xml");
		daoImpl=(DepartmentService)ct.getBean("departmentServiceImpl");
	}
	
	@Test
	public void testsave()
	{
		Department dep=new Department();
		dep.setName("Ô±¹¤²¿");
		daoImpl.save(dep);
	}
	
	
	@Test
	public void testdelete()
	{
		daoImpl.delete(1);
	}

	
	@Test
	public void test()
	{
	}

}
