package myshop.web.action;

import java.text.ParseException;
import java.util.Map;

import myshop.bean.Customer;
import myshop.web.actionForm.CustomerForm;
import myshop.web.page.PageView;
import myshop.web.page.WebUtil;

import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Scope("prototype")
public class CustomerAction extends CustomerForm {

	public String findAllCustomer()
	{
		PageView<Customer> pageView = getPageView(getCurrpage(), 12);
		pageView.setQueryResult(getQueryResult());
		setAttribute("pageView", pageView);
		return "find";
	}

	public String setCustomerState()
	{
		for (int i = 1; i <usernames.length; i++)
			serviceImpl.setCustomerState(getMethod(), usernames[i]);
		return "setState";
	}

	public String register() throws ParseException
	{
		if (serviceImpl.findByUsername(username))
		{
			setAttribute("message", "该用户名已存在,请重新注册!");
			setAttribute("urladdress", "customerAction_registerUI_Fail");
			return "register";
		}
		Customer customer = new Customer(username, password, email,
				getFormatDate());
		serviceImpl.save(customer);
		setAttribute("message", "恭喜,注册成功!");
		setAttribute("urladdress", "customerAction_registerUI_Succ");
		return "register";
	}

	public String login()
	{
		if (serviceImpl.login(username, password))
		{
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			session.put("user", serviceImpl.getCustomer(username));
			session.put("username", username);
//			WebUtil.addCookie(response, "username", username, request.getSession().getMaxInactiveInterval());
			setAttribute("message", "登陆成功!");
			setAttribute("urladdress", "customerAction_loginUI_succ");
			return "login";
		} else
		{
			setAttribute("message", "登陆失败!");
			setAttribute("urladdress", "customerAction_loginUI_fail");
			return "login";
		}
	}
	
	public String settleAccounts()
	{
		return "settleAccounts";
	}
	
	public String query()
	{
		return "query";
	}

	public String checkUsername()
	{
		if (serviceImpl.findByUsername(username))
			setAttribute("exsit", true);
		else
			setAttribute("exsit", false);
		return "check";
	}

	public String loginUI_succ()
	{
		return "loginsucc";
	}

	public String loginUI_fail()
	{
		return "loginfail";
	}

	public String registerUI_Succ()
	{
		return "register_succ";
	}

	public String registerUI_Fail()
	{
		return "register_fail";
	}

}
