package myshop.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.bean.Customer;
import myshop.web.page.WebUtil;

public class BuyerLogonValidateFilter implements Filter{

	@Override
	public void destroy()
	{
		
	}

	/**
	 * 用户的每一个请求都会经过doFilter
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException
	{
		System.out.println("执行检测用户是否登陆的过滤器");
		HttpServletRequest request=(HttpServletRequest)req;
		Customer customer=WebUtil.getBuyer(request);
		if(customer==null){
			HttpServletResponse response=(HttpServletResponse)res;
			response.sendRedirect("/shopping/page/user/logon.jsp");
		}
		else chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		
	}


}
