package myshop.web.action;

import java.io.IOException;

import myshop.bean.Brand;
import myshop.bean.Product;
import myshop.bean.ProductStyle;
import myshop.web.actionForm.ProductStyleForm;
import myshop.web.page.PageView;

import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Scope("prototype")
public class ProductStyleAction extends ProductStyleForm {
	
	
	public String findStyle()
	{
		PageView<ProductStyle> pageView =getPageView(getCurrpage(), 5);
		pageView.setQueryResult(getQueryResult());
		if(productid!=null) setAttribute("productid", productid);
		setAttribute("pageView", pageView);
		return "findOk";
	}
	
	public String setVisible()
	{
		try{
		serviceImpl.setState(method, styleids);
		setAttribute("message", "设置成功!");
		setAttribute("urladdress", "productStyleAction_findStyle?productid="+productid);
		return "setState";
		}catch(Exception e)
		{
			setAttribute("message", "设置失败!");
			setAttribute("urladdress", "productStyleAction_findStyle?productid="+productid);
			return "setState";
		}
	}
	
	public String add()
	{
		try{
		ProductStyle style = setStylelogo();
		Product product=duImpl.find(Product.class, productid);
		style.setProductinfo(product);
		serviceImpl.save(style);
		setAttribute("message", "添加样式成功!");
		setAttribute("urladdress", "productStyleAction_findStyle?productid="+productid);
		return "add";
		}catch(Exception e)
		{
			setAttribute("message", "添加样式失败!");
			setAttribute("urladdress", "productStyleAction_findStyle?productid="+productid);
			return "add";
		}
	}
	
	public ProductStyle setStylelogo()
	{
		ProductStyle style;
		if(styleid!=null) style=serviceImpl.find(ProductStyle.class, styleid);
		else style=new ProductStyle();
		createFileInContext(getLogoRealPath()); // create a file useded to save   / logo in tomcat
		style.setName(stylename);
		if(imagefile==null) return style;
		String logoname = createLogoname(); // create file's filename
		String logoRealPath = getLogoRealPath();
		try
		{
			style.setLogopath(getLogopathIntable(logoname));
			setLogo(createLogoFile(logoRealPath, logoname), imagefile);
			return style;
		} catch (IOException e)
		{
			return null;
		}
	}

	
	public String edit()
	{
		try{
		ProductStyle style=setStylelogo();
		serviceImpl.update(style);
		setAttribute("message", "修改样式成功!");
		setAttribute("urladdress", "productStyleAction_findStyle?productid="+productid);
		return "edit";
		}
		catch(Exception e)
		{
			setAttribute("message", "修改样式失败!");
			setAttribute("urladdress", "productStyleAction_findStyle?productid="+productid);
			return "edit";
		}
	}
	
	public String editUI()
	{
		setAttribute("productid", productid);
		return "editUI";
	}
	
	public String addlogo()
	{
		return "addlogo";
	}
	
	public String addUI()
	{
		setAttribute("productid", productid);
		return "addUI";
	}


}
