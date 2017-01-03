package myshop.web.actionForm;

import myshop.bean.BuyCart;
import myshop.service.CartService;
import myshop.service.ProductService;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class CartForm extends PageViewBase {

	protected Integer productid;
	protected Integer styleid;
	protected String buyitemid;

	@Autowired
	protected ProductService productImpl;
	
	@Autowired
	protected CartService cartImpl;
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<BuyCart> getQueryResult()
	{
		return cartImpl.getScrollData(BuyCart.class, (getCurrpage()-1)*maxresult, maxresult, getWherehql());
	}
	
	public void setBuyitemid(String buyitemid)
	{
		this.buyitemid=buyitemid;
		if(this.buyitemid!=null){
			String[] values=this.buyitemid.split("-");
			if(values.length==2){
				this.productid=new Integer(values[0]);
				this.styleid=new Integer(values[1]);
			}
		}
	}

	@Override
	public String getWherehql()
	{
		return null;
	}

	public Integer getProductid()
	{
		return productid;
	}

	public void setProductid(Integer productid)
	{
		this.productid = productid;
	}

	public Integer getStyleid()
	{
		return styleid;
	}

	public void setStyleid(Integer styleid)
	{
		this.styleid = styleid;
	}

	
}
