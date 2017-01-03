package myshop.web.actionForm;

import myshop.bean.PrivilegeGroup;
import myshop.bean.SystemPrivilege;
import myshop.bean.SystemPrivilegePK;
import myshop.service.PrivilegeGroupService;
import myshop.service.SystemPrivilegeService;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("serial")
public class PrivilegeGroupForm extends PageViewBase {

	@Autowired
	protected SystemPrivilegeService privilegeImpl; 
	
	@Autowired
	protected PrivilegeGroupService groupImpl;
	
	protected String name;
	
	protected String groupid;
	
	protected String[] privileges;
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<PrivilegeGroup> getQueryResult()
	{
		return groupImpl.getScrollData(PrivilegeGroup.class,(getCurrpage()-1)*maxresult,maxresult,getWherehql(),getOrderby("id", "asc"));
	}

	@Override
	public String getWherehql()
	{
		return null;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String[] getPrivileges()
	{
		return privileges;
	}

	public void setPrivileges(String[] privileges)
	{
		this.privileges = privileges;
	}

	public String getGroupid()
	{
		return groupid;
	}

	public void setGroupid(String groupid)
	{
		this.groupid = groupid;
	}

}
