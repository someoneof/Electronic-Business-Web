package junitTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import myshop.bean.PrivilegeGroup;
import myshop.bean.SystemPrivilege;
import myshop.service.PrivilegeGroupService;
import myshop.service.SystemPrivilegeService;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SystemPrivilegeImplTest {

	static SystemPrivilegeService daoImpl;
	static PrivilegeGroupService gImpl;
	static ApplicationContext ct;
	@BeforeClass
	public static void before()
	{
		ct=new ClassPathXmlApplicationContext("applicationContext.xml");
		daoImpl=(SystemPrivilegeService)ct.getBean("systemPrivilegeServiceImpl");
		gImpl=(PrivilegeGroupService)ct.getBean("privilegeGroupServiceImpl");
	}
	
	@Test
	public void testsave()
	{
		List<SystemPrivilege> privileges = new ArrayList<SystemPrivilege>();
		privileges.add(new SystemPrivilege("department", "delete", "部门删除"));
		privileges.add(new SystemPrivilege("department", "insert", "部门添加"));
		privileges.add(new SystemPrivilege("department", "update", "部门修改"));
		privileges.add(new SystemPrivilege("department", "view", "部门查看"));

		privileges.add(new SystemPrivilege("employee", "leave", "员工离职设置"));
		privileges.add(new SystemPrivilege("employee", "reg", "员工注册"));
		privileges.add(new SystemPrivilege("employee", "update", "员工信息修改"));
		privileges.add(new SystemPrivilege("employee", "view", "员工查看"));
		privileges.add(new SystemPrivilege("employee", "privilegeGroupSet","员工权限设置"));
		daoImpl.saves(privileges);
	}
	
	
	
	@Test
	public void testfindAll()
	{
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("id", "asc");
		List<SystemPrivilege> qr=daoImpl.getScrollData(SystemPrivilege.class,orderby).getList() ;
		for(SystemPrivilege sy:qr)
			System.out.println(sy.getName());
	}
	
	
	@Test
	public void testfind()
	{
//		SystemPrivilege sp=daoImpl.find("department", "delete");
		PrivilegeGroup group=new PrivilegeGroup();
		group.setName("部门删除");
		group.add(new SystemPrivilege("department","delete"));
		gImpl.save(group);
		System.out.println(group.getName());
	}
	@Test
	public void test()
	{
	}

}
