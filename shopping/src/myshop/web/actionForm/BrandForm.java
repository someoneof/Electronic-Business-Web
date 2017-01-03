package myshop.web.actionForm;

import java.io.File;
import java.util.UUID;

import myshop.bean.Brand;
import myshop.service.BrandService;
import myshop.web.AddImage.AddImage;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Scope("prototype")
public class BrandForm extends PageViewBase implements AddImage {

	protected String name;	//Brand.name
	protected File logofile; //
	protected String logofileFileName; //Í¼Æ¬Ãû
	protected String code;
	protected String query;
	protected String logopath;
	private String logoPathdir = "/images/brand/logo/" + getDatestring() + "/";
	
	protected Integer productid;
	
	@Autowired
	protected BrandService serviceImpl;
	
	
	
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
		return UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(logofile.getName());
	}
	@Override
	public File createLogoFile(String logoRealPath,String logoname)
	{
		return new File(logoRealPath,logoname);
	}
	
	@Override
	public String getLogopathIntable(String filename)
	{
		return "/shopping"+logoPathdir+filename;
	}
	
	
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getQuery()
	{
		return query;
	}
	public void setQuery(String query)
	{
		this.query = query;
	}
	public String getLogopath()
	{
		return logopath;
	}
	public void setLogopath(String logopath)
	{
		this.logopath = logopath;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<Brand> getQueryResult()
	{
		return serviceImpl.getScrollData(Brand.class,(getCurrpage() - 1) * maxresult, maxresult, getWherehql(), getOrderby("code","asc"));
	}
	@Override
	public String getWherehql()
	{
		String wherehql="where o.visible=1";
		String name=request.getParameter("name");
		if(name!=null && !"".equals(name.trim()))
			wherehql+=" and o.name='"+name+"'";
		if("true".equals(query))
			return wherehql;
		return wherehql;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public File getLogofile()
	{
		return logofile;
	}
	public void setLogofile(File logofile)
	{
		this.logofile = logofile;
	}
	public Integer getProductid()
	{
		return productid;
	}
	public void setProductid(Integer productid)
	{
		this.productid = productid;
	}
}
