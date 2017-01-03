package junitTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import myshop.bean.PrivilegeGroup;
import myshop.bean.SystemPrivilege;
import myshop.service.PrivilegeGroupService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrivilegeGroupServiceImplTest {

	static PrivilegeGroupService gImpl;
	static ApplicationContext ct;
	@BeforeClass
	public static void before()
	{
		ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		gImpl=(PrivilegeGroupService)ct.getBean("privilegeGroupServiceImpl");
	}
	
	@Test
	public void testdelete()
	{
		gImpl.delete("2c40d832594ad4ae01594ad4f4e30000");
	}

	
	@Test
	public void testsave()
	{
		Set<SystemPrivilege> privileges = new HashSet<SystemPrivilege>();
		privileges.add(new SystemPrivilege("department", "delete", "部门删除"));
		privileges.add(new SystemPrivilege("department", "insert", "部门添加"));
		privileges.add(new SystemPrivilege("department", "update", "部门修改"));
		privileges.add(new SystemPrivilege("department", "view", "部门查看"));
		PrivilegeGroup group=new PrivilegeGroup();
		group.setName("员工部");
		group.setPrivileges(privileges);
		gImpl.save(group);
	}

}
