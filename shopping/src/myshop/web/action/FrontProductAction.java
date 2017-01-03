package myshop.web.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import myshop.bean.Product;
import myshop.bean.ProductStyle;
import myshop.bean.ProductType;
import myshop.web.actionForm.FrontProductForm;
import myshop.web.page.PageView;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class FrontProductAction extends FrontProductForm {

	private static final long serialVersionUID = -4564269818640609349L;

	public String findProduct()
	{
		PageView<Product> pageView=getPageView(getCurrpage(), 9);
		pageView.setQueryResult(getQueryResult());
		for(Product product:pageView.getRecord()){
			Set<ProductStyle> styles=new HashSet<ProductStyle>();
			for(ProductStyle style:product.getStyles()){
				if(style.getVisible()){
					styles.add(style);
					break;
				}
			}
			product.setStyles(styles);	
		}
		setAttribute("pageView", pageView);
		return "findProduct";
	}
	
	
	public String view()
	{
		Product product=productImpl.find(Product.class, productid);
		if(product==null){
			setAttribute("message", "获取不到你需要浏览的产品!");
			setAttribute("urladdress", "frontProductAction_findProduct");
			return "view";
		}
		List<ProductType> types=new ArrayList<ProductType>();
		ProductType parent=product.getType();
		while(parent!=null){
			types.add(parent);
			parent=parent.getParent();
		}
		setAttribute("product", product);
		setAttribute("stypes", types);
		return "view";
	}

}
