package myshop.web.actionForm;

import myshop.bean.Customer;
import myshop.service.CustomerService;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

public abstract class CustomerForm extends PageViewBase {

	
	private static final long serialVersionUID = 5795168357763373276L;
	
	protected String username;
	protected String password;
	protected String email;
	protected String method;	//禁用或启用 delete or enable
	protected String[] usernames;	//勾选了多个还是一个
	
	@SuppressWarnings("rawtypes")
	@Autowired
	protected CustomerService serviceImpl;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<Customer> getQueryResult()
	{
		return serviceImpl.getScrollData(Customer.class,(getCurrpage()-1)*maxresult,maxresult,getWherehql(),getOrderby("cid", "asc"));
	}

	@Override
	public String getWherehql()
	{
		System.out.println("username="+username);
		if(username!=null)
			return " where o.username='"+username+"'";
		return null;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method.substring(0, method.length()-2);
	}

	public String[] getUsernames()
	{
		return usernames;
	}

	public void setUsernames(String[] usernames)
	{
		this.usernames = usernames;
	}
	
	

}
