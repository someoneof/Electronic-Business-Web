package myshop.web.action;

import java.util.List;

import myshop.bean.PrivilegeGroup;
import myshop.bean.SystemPrivilege;
import myshop.web.actionForm.PrivilegeGroupForm;
import myshop.web.page.PageView;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class PrivilegeGroupAction extends PrivilegeGroupForm {

	private static final long serialVersionUID = 1209142442430637592L;
	
	public String add()
	{
		PrivilegeGroup group=new PrivilegeGroup(name);
		for(int i=0;i<privileges.length;i++){
			System.out.println("privileges="+privileges[i]);
			String[] id=privileges[i].split(",");
			group.add(new SystemPrivilege(id[0],id[1]));
			setAttribute("message", "���Ȩ����ɹ�!");
			setAttribute("urladdress", "privilegeGroupAction_addSucc");
		}
		groupImpl.save(group);
		return "add";
	}
	
	public String edit()
	{
		PrivilegeGroup group=groupImpl.find(groupid);
		group.getPrivileges().clear();  //�����ԭ����Ȩ���ٽ������
		group.setName(name);
		for(int i=0;i<privileges.length;i++){
			System.out.println("privileges="+privileges[i]);
			String[] id=privileges[i].split(",");
			group.add(new SystemPrivilege(id[0],id[1]));
			setAttribute("message", "�޸�Ȩ����ɹ�!");
			setAttribute("urladdress", "privilegeGroupAction_addSucc");
		}
		groupImpl.update(group);
		return "edit";
	}
	public String delete()
	{
		groupImpl.delete(groupid);
		setAttribute("message", "ɾ��Ȩ����ɹ�!");
		setAttribute("urladdress", "privilegeGroupAction_addSucc");
		return "delete";
	}
	
	public String editUI()
	{
		PrivilegeGroup group=groupImpl.find(groupid);
		setName(group.getName());
		setAttribute("selectprivileges", group.getPrivileges());
		setAttribute("privileges", getPrivilege());
		return "editUI";
	}
	
	
	
	public String addSucc()
	{
		return "addSucc";
	}
	
	public String findGroup()
	{
		PageView<PrivilegeGroup> pageView =getPageView(getCurrpage(), 12);
		pageView.setQueryResult(getQueryResult());
		setAttribute("pageView", pageView);
		return "findGroup";
	}
	
	public String addUI()
	{
		setAttribute("privileges",getPrivilege() );
		return "addUI";
	}
	
	private List<SystemPrivilege> getPrivilege()
	{
		return privilegeImpl.getScrollData(SystemPrivilege.class,getOrderby("id", "asc")).getList();
	}



}
