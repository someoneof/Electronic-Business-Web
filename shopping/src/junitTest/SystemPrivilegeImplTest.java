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
		privileges.add(new SystemPrivilege("department", "delete", "����ɾ��"));
		privileges.add(new SystemPrivilege("department", "insert", "�������"));
		privileges.add(new SystemPrivilege("department", "update", "�����޸�"));
		privileges.add(new SystemPrivilege("department", "view", "���Ų鿴"));

		privileges.add(new SystemPrivilege("employee", "leave", "Ա����ְ����"));
		privileges.add(new SystemPrivilege("employee", "reg", "Ա��ע��"));
		privileges.add(new SystemPrivilege("employee", "update", "Ա����Ϣ�޸�"));
		privileges.add(new SystemPrivilege("employee", "view", "Ա���鿴"));
		privileges.add(new SystemPrivilege("employee", "privilegeGroupSet","Ա��Ȩ������"));
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
		group.setName("����ɾ��");
		group.add(new SystemPrivilege("department","delete"));
		gImpl.save(group);
		System.out.println(group.getName());
	}
	@Test
	public void test()
	{
	}

}
