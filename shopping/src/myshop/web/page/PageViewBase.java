package myshop.web.page;

import java.util.LinkedHashMap;

import myshop.bean.Brand;
import myshop.bean.BuyCart;
import myshop.bean.ProductType;
import myshop.web.actionForm.MyAction;

@SuppressWarnings("serial")
public abstract class PageViewBase extends MyAction{

	protected int currpage;
	protected int maxresult;
	
	public abstract <T> QueryResult<T> getQueryResult();
	
	public abstract String getWherehql();
	
	
	@SuppressWarnings("unchecked")
	public <T> void setPageView(Class<T> entityClass,int maxresult)
	{
		PageView<T> pageView=getPageView(getCurrpage(), maxresult);
		pageView.setQueryResult((QueryResult<T>) getQueryResult());
		setAttribute("pageView", pageView);
	}
	
	
	public <T> PageView<T> getPageView(int currpage,int maxresult)
	{
		setMaxresult(maxresult);
		return new PageView<T>(currpage,maxresult);
	}
	
	public int getCurrpage()
	{
		return currpage==0?1:currpage;
	}
	
	public LinkedHashMap<String, String> getOrderby(String entityID,String ascOrdesc)
	{
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put(entityID, ascOrdesc);
		return orderby;
	}
	public void setAttribute(String param,Object o)
	{
		request.setAttribute(param, o);
	}
	public void setCurrpage(int currpage)
	{
		this.currpage = currpage;
	}
	public int getMaxresult()
	{
		return maxresult;
	}
	public void setMaxresult(int maxresult)
	{
		this.maxresult = maxresult;
	}
	
}
