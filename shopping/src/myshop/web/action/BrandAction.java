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
		createFileInContext(getLogoRealPath());  //����һ���洢��Ƭ�Ļ���
		String logoname=createLogoname();		//����ͼƬ������
		Brand brand=new Brand(code,name);
		if(logofile==null ) 
		{
			brand.setLogopath(logopath);	//���ͼƬΪ��,������ԭ����·��
			serviceImpl.update(brand);
			setAttribute("message", "�޸�Ʒ����Ϣ�ɹ�!");
			setAttribute("urladdress", "brandAction_findAllBrand");
			return "edit";
		}
		setLogo(createLogoFile(getLogoRealPath(),logoname),logofile);  //ͼƬ��Ϊ��,��jsp��ͼƬд�뵽�����Ļ�����
		brand.setLogopath(getLogopathIntable(logoname));		//����Brand��·��
		serviceImpl.update(brand);
		setAttribute("message", "�޸�Ʒ����Ϣ�ɹ�!");
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
		System.out.println("BrandAction��                                          productid="+productid);
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
		//�����ô��ͼƬ��·��,�ٴ���һ��filename,Ȼ�������filename����һ���ļ�,��jsp��������logofileд������ļ�.
		createFileInContext(getLogoRealPath());  //create a file useded to save logo in tomcat
		String logoname=createLogoname();		//create file's filename
		setLogo(createLogoFile(getLogoRealPath(), logoname), logofile);
		serviceImpl.save(new Brand(name,getLogopathIntable(logoname)));
		setAttribute("urladdress", "brandAction_findAllBrand");
		setAttribute("message", "��ӳɹ�");
		return "add";
	}

}
