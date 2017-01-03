package myshop.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.metamodel.SetAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import myshop.bean.PrivilegeGroup;
import myshop.bean.SystemPrivilege;
import myshop.web.actionForm.SystemPrivilegeForm;

@Scope("prototype")
public class SystemPrivilegeAction extends SystemPrivilegeForm{

	private static final long serialVersionUID = -7595897685193927948L;

	public String initPrivilege()
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
		privilegeImpl.saves(privileges);
		setAttribute("message", "初始化成功");
		setAttribute("urladdress","systemPrivilegeAction_initUI");
		return "intit";
	}
	
	public String initUI()
	{
		return "initUI";
	}
}
