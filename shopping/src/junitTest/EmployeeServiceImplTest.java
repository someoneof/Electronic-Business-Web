package junitTest;

import java.util.Set;

import myshop.bean.Employee;
import myshop.bean.IDCard;
import myshop.bean.PrivilegeGroup;
import myshop.service.EmployeeService;
import myshop.service.IDCardService;
import myshop.service.PrivilegeGroupService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeServiceImplTest {
	
	static ApplicationContext ct;
	static EmployeeService eImpl;
	static PrivilegeGroupService gImpl;
	static IDCardService cardImpl;
	@BeforeClass
	public static void before()
	{
		ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		eImpl=(EmployeeService)ct.getBean("employeeServiceImpl");
		gImpl=(PrivilegeGroupService)ct.getBean("privilegeGroupServiceImpl");
		cardImpl =(IDCardService)ct.getBean("iDCardServiceImpl");
	}
	
	@Test
	public void testsave()
	{
		Employee em=new Employee();
		em.setLogoname("表表");
		em.setPassword("h込込");
		em.setPhotopath("/shopping/skjsf");
		em.addPrivilegeGroup(gImpl.find("40283f81594fa5f601594fa5f9280000"));
		em.setIdCard(cardImpl.find(IDCard.class, 1));
		eImpl.save(em);
	}
	
	
	@Test
	public void testfind()
	{
		Employee em=eImpl.find(3);
		Set<PrivilegeGroup>groups=em.getGroups();
		for(PrivilegeGroup gr:groups)
			System.out.println(gr.getName());
//		em.setEmployeename("haha");
//		eImpl.update(em);
//		System.out.println(em.getEmployeename());
	}
	
	@Test
	public void testdelete()
	{
		int a[]={2};
		eImpl.delete(a);
	}

	
	@Test
	public void test()
	{
	}

}
