package myshop.web.action;

import java.util.ArrayList;
import java.util.List;

import myshop.bean.ProductType;
import myshop.web.actionForm.ProductTypeForm;
import myshop.web.page.PageView;

import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Scope("prototype")
public class ProductTypeAction extends ProductTypeForm {

	public String findAllType()
	{
		PageView<ProductType> pageView = getPageView(getCurrpage(), 12);// 设置每页显示的数量
		pageView.setQueryResult(getQueryResult());
		setAttribute("pageView", pageView);
		return "findAllType_success";
	}
	
	public String addSelectUI()
	{
		
		return "add_selectUI";
	}

	public String select()
	{
		String hql = "where o.parent is null and o.visible=1";
		if (typeid != null && typeid > 0)
		{
			hql = "where o.parent.typeid=" + typeid;
			ProductType type = serviceImpl.find(ProductType.class, typeid);
			ProductType parent = type.getParent();
			List<ProductType> types = new ArrayList<ProductType>();
			types.add(type);
			while(parent!=null){
				types.add(parent);
				parent=parent.getParent();
			}
			setAttribute("menutypes", types);
		}
		setAttribute("types", serviceImpl.getScrollData(ProductType.class, -1,-1, hql, getOrderby("typeid", "asc")).getList());
		return "selectUI";
	}

	public String edit()
	{
		ProductType type = new ProductType(typeid, name, note);
		serviceImpl.update(type);
		return "edit_sucess";
	}

	public String add()
	{
		ProductType type = new ProductType(name, note);
		if (parentid != null && parentid > 0)
			type.setParent(new ProductType(parentid));
		else
			type.setParent(null);
		serviceImpl.save(type);
		setAttribute("message", "添加类别成功!");
		setAttribute("urladdress", "productTypeAction_findAllType");
		return "add_success";
	}

	/** 多个jsp页面间传递参数 */
	public String addUI()
	{
		return "add_UI";
	}

	public String editUI()
	{
		return "editUI";
	}

}
