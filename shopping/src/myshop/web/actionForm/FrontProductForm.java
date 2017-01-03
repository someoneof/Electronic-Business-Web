package myshop.web.actionForm;

import java.util.LinkedHashMap;

import myshop.bean.Product;
import myshop.service.ProductService;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class FrontProductForm extends PageViewBase {

	@Autowired
	protected ProductService productImpl;
	
	protected Integer productid;
	
	protected String sort;
	protected Integer typeid;
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<Product> getQueryResult()
	{
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		if("selldesc".equals(sort)) orderby.put("sellcount", "desc");
		else if("sellpricedesc".equals(sort)) orderby.put("sellprice", "desc");
		else if("sellpriceasc".equals(sort)) orderby.put("sellprice", "asc");
		else orderby.put("createdate", "desc");
		return productImpl.getScrollData(Product.class, (getCurrpage()-1)*maxresult, getMaxresult(), getWherehql(),orderby);
	}

	@Override
	public String getWherehql()
	{
		StringBuffer jpql=new StringBuffer("where o.visible=1");
		if(typeid!=null) {
			jpql.append(" and o.type.typeid=").append("typeid");
			return jpql.toString();
		}
		return jpql.toString();
	}


	public Integer getProductid()
	{
		return productid;
	}

	public void setProductid(Integer productid)
	{
		this.productid = productid;
	}

	public String getSort()
	{
		return sort;
	}

	public void setSort(String sort)
	{
		this.sort = sort;
	}

	public Integer getTypeid()
	{
		return typeid;
	}

	public void setTypeid(Integer typeid)
	{
		this.typeid = typeid;
	}

}
