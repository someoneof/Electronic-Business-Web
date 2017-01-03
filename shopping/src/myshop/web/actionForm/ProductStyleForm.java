package myshop.web.actionForm;

import java.io.File;
import java.util.UUID;

import myshop.bean.ProductStyle;
import myshop.service.ProductService;
import myshop.service.ProductStyleService;
import myshop.web.AddImage.AddImage;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductStyleForm extends PageViewBase implements AddImage{

	private static final long serialVersionUID = 8787262830632901966L;
	
	protected File imagefile;
	protected String stylename;
	protected Integer productid;
	protected Boolean visible;
	protected String logopath;
	protected Integer styleid;
	protected String method;
	protected Integer[] styleids;
	
	@Autowired
	protected ProductStyleService serviceImpl;
	
	@Autowired
	protected ProductService duImpl;
	
	private String logoPathdir = "/style/logo/" + getDatestring() + "/";
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<ProductStyle> getQueryResult()
	{
		return serviceImpl.getScrollData(ProductStyle.class,(getCurrpage() - 1) * maxresult, maxresult, getWherehql(), getOrderby("styleid","asc"));
	}

	@Override
	public String getWherehql()
	{	//select o from ProductType o 
		String hql="where o.visible=1";
		if(productid!=null)
			hql+=" and o.productinfo.productid="+productid;
		return hql;
	}



	public Integer getProductid()
	{
		return productid;
	}

	public void setProductid(Integer productid)
	{
		this.productid = productid;
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

	public Boolean getVisible()
	{
		return visible;
	}

	public String getLogopath()
	{
		return logopath;
	}

	public void setLogopath(String logopath)
	{
		this.logopath = logopath;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public void setVisible(Boolean visible)
	{
		this.visible = visible;
	}

	public Integer getStyleid()
	{
		return styleid;
	}

	public void setStyleid(Integer styleid)
	{
		this.styleid = styleid;
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

	public Integer[] getStyleids()
	{
		return styleids;
	}

	public void setStyleids(Integer[] styleids)
	{
		this.styleids = styleids;
	}
	
	
}
