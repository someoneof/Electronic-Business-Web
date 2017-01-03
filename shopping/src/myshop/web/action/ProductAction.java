package myshop.web.action;

import java.io.IOException;

import myshop.bean.Product;
import myshop.bean.ProductStyle;
import myshop.bean.ProductType;
import myshop.web.actionForm.ProductForm;
import myshop.web.page.PageView;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class ProductAction extends ProductForm {

	private static final long serialVersionUID = -1296936153358051943L;

	public String add()
	{
		try
		{
			Product product = getProduct();
			setProductInfo(product);
			ProductStyle style = new ProductStyle();
			setStylelogo(style);
			product.addProductStyle(style);
			serviceImpl.save(product);
			setAttribute("message", "添加成功!");
			setAttribute("urladdress", "productAction_findAllProduct");
			return "add";
		} catch (Exception e)
		{
			setAttribute("message", "添加失败!");
			setAttribute("urladdress", "productAction_findAllProduct");
			return "add";
		}
	}
	public String editProduct()
	{
		/*try{*/
		Product product = serviceImpl.find(Product.class, productid);
		setProductInfo(product);
		ProductStyle style = new ProductStyle();
		setStylelogo(style);
		product.addProductStyle(style);
		serviceImpl.update(product);
		setAttribute("message", "修改成功!");
		setAttribute("urladdress", "productAction_findAllProduct");
	/*	}catch(Exception e)
		{
			setAttribute("message", "修改失败!");
			setAttribute("urladdress", "productAction_findAllProduct");
			return "editresult";
		}*/
		return "editProduct";
	}

	public String editUI()
	{
		return "editUI";
	}

	public String setState()
	{
		try
		{
			serviceImpl.setState(methodname, productids);
			setAttribute("message", "设置成功!");
			setAttribute("urladdress", "productAction_setSucc");
			return "setState";
		} catch (Exception e)
		{
			setAttribute("message", "设置信息失败!");
			setAttribute("urladdress", "productAction_setFail");
			return "setState";
		}
	}

	public String findAllProduct()
	{
		try
		{
			PageView<Product> pageView =getPageView(getCurrpage(), 12);
			pageView.setQueryResult(getQueryResult());
			setAttribute("pageView", pageView);
			return "find";
		} catch (Exception e)
		{
			setAttribute("message", "抱歉,没有您要查找的商品!");
			setAttribute("urladdress", "productAction_findFailUI");
			return "find_fail";
		}
	}
	
	public String sort()
	{	
		//selldesc sellpricedesc sellpriceasc
		setPageView(Product.class, 5);
		return "sort";
	}
	
	public String view()
	{
		setAttribute("product", serviceImpl.find(Product.class, productid));;
		return "view";
	}
	

	public ProductStyle setStylelogo(ProductStyle style)
	{
		createFileInContext(getLogoRealPath()); // create a file useded to save
												// logo in tomcat
		String logoname = createLogoname(); // create file's filename
		String logoRealPath = getLogoRealPath();
		style.setLogopath(getLogopathIntable(logoname));
		if(stylename!=null)
		style.setName(stylename);
		try
		{
			if(imagefile!=null)
			setLogo(createLogoFile(logoRealPath, logoname), imagefile);
			return style;
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void setProductInfo(Product product)
	{
		if (productcode != null && !"".equals(productcode))
			product.setProductcode(productcode);
		if (marketprice >= 0 && !"".equals(marketprice))
			product.setMarketprice(marketprice);
		if (name != null && !"".equals(name))
			product.setName(name);
		if (baseprice >= 0 && !"".equals(baseprice))
			product.setBaseprice(baseprice);
		if (description != null && !"".equals(description))
			product.setDescription(description);
		if (sellprice >= 0 && !"".equals(sellprice))
			product.setSellprice(sellprice);
		if (buyexplain != null && !"".equals(buyexplain))
			product.setBuyerplain(buyexplain);
		if (weight != null && !"".equals(weight))
			product.setWeight(weight);
		if (code != null && !"".equals(code))
			product.setBrand(brandImpl.find(code));
		if (typeid != null && !"".equals(typeid))
			product.setType(typeImpl.find(ProductType.class, typeid));
		if (model != null && !"".equals(model))
			product.setModel(model);
		if (sex != null && !"".equals(sex))
			product.setSexrequest(sex);
		product.setCreatedate(getFormatDate());
	}

	public String setSucc()
	{
		return "setSucc";
	}

	public String setFail()
	{
		return "setFail";
	}

	public String findFailUI()
	{
		return "findfailUI";
	}

	public String addlogo()
	{

		return "addlogo";
	}

	public String addUI()
	{
		return "addUI";
	}
}
