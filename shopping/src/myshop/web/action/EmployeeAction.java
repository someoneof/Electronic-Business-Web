package myshop.web.action;

import java.io.IOException;

import myshop.bean.Department;
import myshop.bean.Employee;
import myshop.bean.PrivilegeGroup;
import myshop.bean.supportbean.IDCard;
import myshop.web.actionForm.EmployeeForm;
import myshop.web.page.PageView;


public class EmployeeAction extends EmployeeForm {

	private static final long serialVersionUID = 158217898867445113L;
	
	public String findemployee()
	{
		PageView<Employee> pageView =getPageView(getCurrpage(), 6);
		pageView.setQueryResult(getQueryResult());
		setAttribute("pageView", pageView);
		return "findemployee";
	}
	
	public String query()
	{
		PageView<Employee> pageView =getPageView(getCurrpage(), 12);
		pageView.setQueryResult(getQueryResult());
		setAttribute("pageView", pageView);
		return "query";
	}
	
	public String add()
	{
		try{
		Employee employee=setEmployeePicture();
		IDCard card=new IDCard();
		setEmployeeInfo(card, employee);
		employee.setDepartment(dImpl.find(did));
		employee.addPrivilegeGroup(groupImpl.find(groupid));
		card.setEmployee(employee);
		employee.setIdCard(card);
		System.out.println("edit="+method);
		idImpl.save(card);
		eImpl.save(employee);
		setAttribute("message", "添加员工成功!");
		setAttribute("urladdress", "employeeAction_operatorResult");
		return "add";
		}catch(Exception e)
		{
			setAttribute("message", "添加员工失败!");
			setAttribute("urladdress", "employeeAction_operatorResult");
			e.printStackTrace();
			return "add";
		}
	}
	
	public String set()
	{
		Employee em=eImpl.find(eid);
		em.getGroups().clear();
		for(int i=0;i<groupids.length;i++)
		{
			em.addPrivilegeGroup(groupImpl.find(groupids[i]));
		}
		eImpl.update(em);
		setAttribute("message", "设置员工权限成功!");
		setAttribute("urladdress", "employeeAction_operatorResult");
		return "set";
	}
	
	public String edit()
	{
		try{
			Employee employee=setEmployeePicture();
			IDCard card=employee.getIdCard();
			setEmployeeInfo(card, employee);
			employee.setDepartment(dImpl.find(did));
			eImpl.update(employee);
			setAttribute("message", "修改员工信息成功!");
			setAttribute("urladdress", "employeeAction_operatorResult");
			return "editResult";
			}catch(Exception e)
			{
				setAttribute("message", "修改员工信息失败!");
				setAttribute("urladdress", "employeeAction_operatorResult");
				e.printStackTrace();
				return "editResult";
			}
	}
	
	public String delete()
	{
		try{
		eImpl.delete(eid);
		setAttribute("message", "标记员工离职成功!");
		setAttribute("urladdress", "employeeAction_operatorResult");
		return "delete";
		}catch(Exception e)
		{
			setAttribute("message", "标记员工离职失败!");
			setAttribute("urladdress", "employeeAction_operatorResult");
			e.printStackTrace();
			return "delete";
		}
	}
	
	public String addUI()
	{
		setAttribute("privilegegroups", groupImpl.getScrollData(PrivilegeGroup.class).getList());
		setAttribute("departmentList", dImpl.getScrollData(Department.class).getList());
		return "addUI";
	}
	
	private void setEmployeeInfo(IDCard card,Employee employee)
	{
		card.setAddress(address);
		card.setBirthday(birthday);
		card.setIdNo(idNo);
		if(logoname!=null)
		employee.setLogoname(logoname);
		if(password!=null)
		employee.setPassword(password);
		if(realname!=null)
		employee.setEmployeename(realname);
		employee.setSex(sex);
		employee.setPhone(phone);
		employee.setEmail(email);
		employee.setDegree(degree);
		employee.setSchool(school);
	}
	
	public Employee setEmployeePicture()
	{
		Employee employee;
		String logoname;
		if(eid!=null) employee=eImpl.find(eid);
		else employee=new Employee();
		createFileInContext(getLogoRealPath()); // create a file useded to save   / logo in tomcat
		if(imagefile==null) return employee;
		logoname = createLogoname(); // create file's filename
		try
		{
			employee.setPhotopath(getLogopathIntable(logoname));
			setLogo(createLogoFile(getLogoRealPath(), logoname), imagefile);
			return employee;
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public String SetUI()
	{
		setAttribute("groups", groupImpl.getScrollData(PrivilegeGroup.class).getList());
		setAttribute("usergroups", eImpl.find(eid).getGroups());
		return "SetUI";
	}
	
	public String operatorResult()
	{
		return "operatorResult";
	}
	
	public String editUI()
	{
		Employee employee= eImpl.find(eid);
		IDCard card=employee.getIdCard();
		setAttribute("realname", employee.getEmployeename());
		setAttribute("sex", employee.getSex());
		setAttribute("photopath", employee.getPhotopath());
		setAttribute("idNo", card.getIdNo());
		setAttribute("birthday", card.getBirthday());
		setAttribute("address", card.getAddress());
		setAttribute("phone",employee.getPhone());
		setAttribute("email", employee.getEmail());
		setAttribute("degree", employee.getDegree());
		setAttribute("school", employee.getSchool());
		setAttribute("departments", dImpl.getScrollData(Department.class).getList());
		setAttribute("selectdepartmentid", employee.getDepartment().getDid());
		return "editUI";
	}
}
