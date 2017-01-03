package myshop.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import myshop.bean.Department;
import myshop.web.actionForm.DepartmentForm;
import myshop.web.page.PageView;

public class DepartmentAction extends DepartmentForm {

	private static final long serialVersionUID = -1382523451946313366L;
	
	public String add()
	{
		dImpl.save(new Department(name));
		setAttribute("message", "添加部门成功!");
		setAttribute("urladdress", "departmentAction_operateResult");
		return "add";
	}
	
	public String add_Employee_UI()
	{
		return "add_Employee_UI";
	}
	
	public String findDepartment()
	{
		PageView<Department> pageView=getPageView(getCurrpage(), 12);
		pageView.setQueryResult(getQueryResult());
		setAttribute("pageView", pageView);
		return "findDepartment";
	}
	
	public String edit()
	{
		Department department=dImpl.find(Department.class, did);
		department.setName(name);
		dImpl.update(department);
		setAttribute("message", "修改部门成功!");
		setAttribute("urladdress", "departmentAction_operateResult?did="+did);
		return "edit";
	}
	
	public String delete()
	{
		dImpl.delete(did);
		setAttribute("message", "修删除部门成功!");
		setAttribute("urladdress", "departmentAction_operateResult");
		return "delete";
	}
	
	public String addUI()
	{
		setAttribute("departmentList", dImpl.getScrollData(Department.class).getList());
		return "addUI";
	}
	
	public String editUI()
	{
		return "editUI";
	}
	
	public String operateResult()
	{
		return "operateResult";
	}

}
