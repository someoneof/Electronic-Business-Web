package myshop.web.actionForm;

import myshop.bean.Department;
import myshop.service.DepartmentService;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class DepartmentForm extends PageViewBase {

	@Autowired
	protected DepartmentService dImpl;
	
	protected Integer did;
	protected String name;
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<Department> getQueryResult()
	{
		return dImpl.getScrollData(Department.class, (getCurrpage()-1)*maxresult, maxresult, getWherehql(), getOrderby("did", "asc"));
	}

	@Override
	public String getWherehql()
	{
		String hql="";
		if(did!=null) hql="where o.did="+did;
		return hql;
	}

	public Integer getDid()
	{
		return did;
	}

	public void setDid(Integer did)
	{
		this.did = did;
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
