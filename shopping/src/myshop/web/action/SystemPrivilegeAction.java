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
		privileges.add(new SystemPrivilege("department", "delete", "����ɾ��"));
		privileges.add(new SystemPrivilege("department", "insert", "�������"));
		privileges.add(new SystemPrivilege("department", "update", "�����޸�"));
		privileges.add(new SystemPrivilege("department", "view", "���Ų鿴"));

		privileges.add(new SystemPrivilege("employee", "leave", "Ա����ְ����"));
		privileges.add(new SystemPrivilege("employee", "reg", "Ա��ע��"));
		privileges.add(new SystemPrivilege("employee", "update", "Ա����Ϣ�޸�"));
		privileges.add(new SystemPrivilege("employee", "view", "Ա���鿴"));
		privileges.add(new SystemPrivilege("employee", "privilegeGroupSet","Ա��Ȩ������"));
		privilegeImpl.saves(privileges);
		setAttribute("message", "��ʼ���ɹ�");
		setAttribute("urladdress","systemPrivilegeAction_initUI");
		return "intit";
	}
	
	public String initUI()
	{
		return "initUI";
	}
}
