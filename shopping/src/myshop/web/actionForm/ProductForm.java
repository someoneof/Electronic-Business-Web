package myshop.web.actionForm;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.UUID;

import myshop.bean.Product;
import myshop.bean.supportbean.Sex;
import myshop.service.BrandService;
import myshop.service.ProductService;
import myshop.service.ProductStyleService;
import myshop.service.ProductTypeService;
import myshop.web.AddImage.AddImage;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class ProductForm extends PageViewBase implements AddImage{

	/**产品名称*/
	protected String name;					//产品名称
	/**底价*/
	protected float baseprice;				//底价
	/**市场价*/
	protected float marketprice;			//市场价
	/**销售价*/
	protected float sellprice;   			//销售价
	/**产品货号货号*/
	protected String productcode; 			//产品货号货号
	/**产品图片*/
	protected File imagefile;				//产品图片
	/**样式名称*/
	protected String stylename;				//样式名称
	/**品牌号*/
	protected String code;					//品牌号
	/**适用性别*/
	protected Sex sex;						//适用性别
	/**型号*/
	protected String model;					//型号
	/**重量*/
	protected Integer weight;				//重量
	/**购买说明*/
	protected String buyexplain;			//购买说明
	/**产品简介*/
	protected String description;			//产品简介
	/**类别id*/
	protected Integer typeid;				//类别id
	/**类别名称*/
	protected String typename;				//类别名称
	
	protected Float startbaseprice;			//底价1
	
	protected Float endbaseprice;			//底价2
	
	protected Float startsellprice;			//销售价1
	
	protected Float endsellprice;			//销售价2
	
	protected String methodname;			//commend,uncommend,disable,visible
	
	protected Integer[] productids;
	
	protected Integer productid;
	
	protected String sort;
	
	
	private String logoPathdir = "/style/logo/" + getDatestring() + "/";
	
	
	@Autowired
	protected ProductService serviceImpl; 
	
	@Autowired
	protected ProductStyleService styleImpl;
	
	@Autowired
	protected ProductTypeService typeImpl;
	
	@Autowired
	protected BrandService brandImpl;
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<Product> getQueryResult()
	{	
		//selldesc sellpricedesc sellpriceasc
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		if(sort!=null &&!"".equals(sort) && sort.equals("selldesc"))
			orderby.put("sellprice", "desc");
		else if(sort!=null &&!"".equals(sort) && sort.equals("sellpricedesc"))
			orderby.put("sellprice", "desc");
		else if(sort!=null &&!"".equals(sort) && sort.equals("sellpriceasc"))
			orderby.put("sellprice", "asc");
		else orderby.put("productid", "asc");
		return serviceImpl.getScrollData(Product.class,(getCurrpage()-1)*maxresult,maxresult,getWherehql(),orderby);
	}

	@Override
	public String getWherehql()
	{
		String hql="where ";
		if(name!=null && !"".equals(name.trim())){
			hql+="o.name='"+name+"'";
			return hql;
		}
		else if(typeid!=null){
			hql+="o.type.typeid="+typeid;
			return hql;
		}
		else if(startbaseprice!=null &&startbaseprice>=0 && endbaseprice!=null &&endbaseprice >=0)
		{
			hql+="o.baseprice between "+startbaseprice+" and "+endbaseprice;
			return hql;
		}
		else if(startbaseprice!=null &&startbaseprice >=0){
			hql+="o.baseprice >="+startbaseprice;
			return hql;
		}
		else if(endbaseprice!=null && endbaseprice >=0){
			hql+="o.baseprice <="+endbaseprice;
			return hql;
		}
		else if(startsellprice!=null && startsellprice>=0 && endsellprice!=null && endsellprice >=0)
		{
			hql+="o.sellprice between "+startsellprice+" and "+endsellprice;
			return hql;
		}
		else if(startsellprice!=null && startsellprice>=0)
		{
			hql+="o.sellprice >="+startsellprice;
			return hql;
		}
		else if(endsellprice!=null && endsellprice>=0)
		{
			hql+="o.sellprice <="+endsellprice;
			return hql;
		}
		else if(productcode!=null && !"".equals(productcode.trim()))
		{
			hql+="o.productcode='"+productcode+"'";
			return hql;
		}
		else if(code!=null && !"".equals(code.trim()))
		{
			hql+="o.brand.code='"+code+"'";
			return hql;
		}
		else if(productid!=null)
		{
			hql+="o.productid="+productid;
			return hql;
		}//selldesc sellpricedesc sellpriceasc
		return null;
	}
	
	
	public Product getProduct()
	{
		return new Product();
	}

	@Override
	public String getLogoPathdir()
	{
		return logoPathdir;
	}

	@Override
	public String getLogoRealPath()
	{
		return session.getServletContext().getRealPath(logoPathdir);
	}

	@Override
	public String createLogoname()
	{
		return UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(imagefile.getName());
	}

	@Override
	public File createLogoFile(String logoRealPath, String logoname)
	{
		return new File(logoRealPath,logoname);
	}

	@Override
	public String getLogopathIntable(String filename)
	{
		return "/shopping"+logoPathdir+filename;
	}

	public void setLogoPathdir(String logoPathdir)
	{
		this.logoPathdir = logoPathdir;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	public String getProductcode()
	{
		return productcode;
	}

	public void setProductcode(String productcode)
	{
		this.productcode = productcode;
	}

	public File getImagefile()
	{
		return imagefile;
	}

	public void setImagefile(File imagefile)
	{
		this.imagefile = imagefile;
	}


	public String getStylename()
	{
		return stylename;
	}

	public void setStylename(String stylename)
	{
		this.stylename = stylename;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public Sex getSex()
	{
		return sex;
	}

	public void setSex(Sex sex)
	{
		this.sex = sex;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public Integer getWeight()
	{
		return weight;
	}

	public void setWeight(Integer weight)
	{
		this.weight = weight;
	}

	public String getBuyexplain()
	{
		return buyexplain;
	}

	public void setBuyexplain(String buyexplain)
	{
		this.buyexplain = buyexplain;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}


	public ProductService getServiceImpl()
	{
		return serviceImpl;
	}

	public void setServiceImpl(ProductService serviceImpl)
	{
		this.serviceImpl = serviceImpl;
	}

	public float getBaseprice()
	{
		return baseprice;
	}

	public void setBaseprice(float baseprice)
	{
		this.baseprice = baseprice;
	}

	public float getMarketprice()
	{
		return marketprice;
	}

	public void setMarketprice(float marketprice)
	{
		this.marketprice = marketprice;
	}

	public float getSellprice()
	{
		return sellprice;
	}

	public void setSellprice(float sellprice)
	{
		this.sellprice = sellprice;
	}

	public Integer getTypeid()
	{
		return typeid;
	}

	public void setTypeid(Integer typeid)
	{
		this.typeid = typeid;
	}

	public String getTypename()
	{
		return typename;
	}

	public void setTypename(String typename)
	{
		this.typename = typename;
	}

	public Float getStartbaseprice()
	{
		return startbaseprice;
	}

	public void setStartbaseprice(Float startbaseprice)
	{
		this.startbaseprice = startbaseprice;
	}

	public Float getEndbaseprice()
	{
		return endbaseprice;
	}

	public void setEndbaseprice(Float endbaseprice)
	{
		this.endbaseprice = endbaseprice;
	}

	public Float getStartsellprice()
	{
		return startsellprice;
	}

	public void setStartsellprice(Float startsellprice)
	{
		this.startsellprice = startsellprice;
	}

	public Float getEndsellprice()
	{
		return endsellprice;
	}

	public void setEndsellprice(Float endsellprice)
	{
		this.endsellprice = endsellprice;
	}

	public String getMethodname()
	{
		return methodname;
	}

	public void setMethodname(String methodname)
	{
		this.methodname = methodname;
	}

	public Integer[] getProductids()
	{
		return productids;
	}

	public void setProductids(Integer[] productids)
	{
		this.productids = productids;
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

}
