package myshop.web.action;

import java.io.IOException;
import java.util.List;

import myshop.bean.Brand;
import myshop.web.actionForm.BrandForm;
import myshop.web.page.PageView;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class BrandAction extends BrandForm {

	private static final long serialVersionUID = 7472448978503937164L;

	public String findAllBrand()
	{
		PageView<Brand> pageView = getPageView(getCurrpage(),5);
		pageView.setQueryResult(getQueryResult());
		setAttribute("pageView", pageView);
		return "findBrand";
	}
	public String edit() throws IOException
	{	
		createFileInContext(getLogoRealPath());  //创建一个存储照片的环境
		String logoname=createLogoname();		//设置图片的名字
		Brand brand=new Brand(code,name);
		if(logofile==null ) 
		{
			brand.setLogopath(logopath);	//如果图片为空,就设置原本的路径
			serviceImpl.update(brand);
			setAttribute("message", "修改品牌信息成功!");
			setAttribute("urladdress", "brandAction_findAllBrand");
			return "edit";
		}
		setLogo(createLogoFile(getLogoRealPath(),logoname),logofile);  //图片不为空,则将jsp的图片写入到创建的环境下
		brand.setLogopath(getLogopathIntable(logoname));		//设置Brand的路径
		serviceImpl.update(brand);
		setAttribute("message", "修改品牌信息成功!");
		setAttribute("urladdress", "brandAction_findAllBrand");
		return "edit";
	}
	
	public String addUI()
	{
		List<Brand> brandList=serviceImpl.getScrollData(Brand.class,-1,-1,getWherehql(),getOrderby("code", "asc")).getList();
		setAttribute("brandList", brandList);
		return "addUI";
	}
	public String addUI_Product()
	{
		List<Brand> brandList=serviceImpl.getScrollData(Brand.class,-1,-1,getWherehql(),getOrderby("code", "asc")).getList();
		setAttribute("brandList", brandList);
		return "addUI_Product";
	}
	public String addUI_edit()
	{
		System.out.println("BrandAction中                                          productid="+productid);
		setAttribute("productid", productid);
		List<Brand> brandList=serviceImpl.getScrollData(Brand.class,-1,-1,getWherehql(),getOrderby("code", "asc")).getList();
		setAttribute("brandList", brandList);
		return "addUI_edit";
	}
	
	public String editUI()
	{
		return "editUI";
	}
	
	public String add() throws IOException
	{
		//先设置存放图片的路径,再创建一个filename,然后由这个filename创建一个文件,将jsp传过来的logofile写入这个文件.
		createFileInContext(getLogoRealPath());  //create a file useded to save logo in tomcat
		String logoname=createLogoname();		//create file's filename
		setLogo(createLogoFile(getLogoRealPath(), logoname), logofile);
		serviceImpl.save(new Brand(name,getLogopathIntable(logoname)));
		setAttribute("urladdress", "brandAction_findAllBrand");
		setAttribute("message", "添加成功");
		return "add";
	}

}
