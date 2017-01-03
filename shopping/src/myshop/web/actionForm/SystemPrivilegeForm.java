package myshop.web.actionForm;

import myshop.bean.SystemPrivilege;
import myshop.service.SystemPrivilegeService;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class SystemPrivilegeForm extends PageViewBase {

	@Autowired
	protected SystemPrivilegeService privilegeImpl;
	
	private String[] privileges;
	private String name;

	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<SystemPrivilege> getQueryResult()
	{
		return privilegeImpl.getScrollData(SystemPrivilege.class,(getCurrpage() - 1) * maxresult, maxresult, getWherehql(), getOrderby("id","asc"));
	}

	@Override
	public String getWherehql()
	{
		return null;
	}

	public String[] getPrivileges()
	{
		return privileges;
	}

	public void setPrivileges(String[] privileges)
	{
		this.privileges = privileges;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
