package myshop.web.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import myshop.bean.BuyCart;
import myshop.bean.Product;
import myshop.bean.ProductStyle;
import myshop.bean.supportbean.BuyItem;
import myshop.web.actionForm.CartForm;
import myshop.web.filter.SiteSessionListener;
import myshop.web.page.WebUtil;

public class CartAction extends CartForm {

	private static final long serialVersionUID = 7954434330198328372L;
	
	public String findAllItem()
	{
//		BuyCart buyCart=
//		setAttribute("buyCart", pageView.getRecord());
		return "findAllItem";
	}

	public String addItem()
	{
		BuyCart buyCart=(BuyCart)request.getSession().getAttribute("buycart");//从当前会话获取session
		if(buyCart==null){//购物车对象为空,如果用户在新窗口打开一个页面,假如用户原来已经购买了一个商品,然后又打开了一个新窗口,在新窗口buyCart是不存在的
			//但是前一次已经购买了一个商品,也就是说前一次和这一次的sessionid值是不一样的,所以取不到session值,所以必须先从用户当前的会话去取得购物车对象.
			//如果没取到,再看看原来有没有购物车对象,所以从cookie中取得购物车对象.
			String sid=WebUtil.getCookieByName(request, "buyCartID");
			if(sid!=null){//如果不为空,取得session对象,也即从以前的session取得购物车
				HttpSession session=SiteSessionListener.getSession(sid);  //从以前的会话获取session
				if(session!=null){
					buyCart=(BuyCart)session.getAttribute("buycart");
					if(buyCart!=null){  //从以前的cookies中获取购物车
						SiteSessionListener.remove(sid);
						setAttribute("buyCart", buyCart);
						WebUtil.addCookie(response, "buyCartID", request.getSession().getId(),request.getSession().getMaxInactiveInterval());
					}
				}//如果当前会话不存在,就把以前会话的购物车放在当前会话中,以后只要通过当前会话就可以访问购物车,而不用再得到以前的session
				
			}
		}
		//如果从当前和以前的会话都获取不到购物车,则新建一个购物车
		if(buyCart==null){  //如果从当前session取得的购物车为空,也就是说当前没有session,就new一个购物车,将其放入当前session中
			buyCart=new BuyCart();
			request.getSession().setAttribute("buycart", buyCart);//将session加入到cookie中去,session的名称作为key,session的id作为value
			WebUtil.addCookie(response, "buyCartID", request.getSession().getId(), request.getSession().getMaxInactiveInterval());
		}
		
		if(productid!=null && productid>0){
			Product product=productImpl.find(Product.class, productid);
			if(product!=null){
				ProductStyle currentStyle=null;
				for(ProductStyle style:product.getStyles()){//找到对应id的样式
					if(style.getVisible() && style.getStyleid().equals(styleid)){
						currentStyle=style;
						break;
					}
				}//为了保证假如到购物车的样式只有一个种类
				product.getStyles().clear();//清楚样式,然后放入被选样式
				//往产品里面+样式,样式是维护端,则往被维护端加样式,不会更新到数据库
				if(currentStyle!=null) product.addProductStyle(currentStyle);
				buyCart.addItem(new BuyItem(product,1));//把商品放入购物车
			}
		}
		//将购物车放入到请求范围中去
		setAttribute("buyCart", buyCart);
		return "addItem";
	}
	
	/**
	 * 删除指定购买项
	 */
	public String delete()
	{
		BuyCart buyCart=getBuyCart(request);
		if(buyCart!=null){
			Product product=new Product(productid);
			product.addProductStyle(new ProductStyle(styleid));
			buyCart.removeBuyItem(new BuyItem(product));
		}
		return "delete";
	}
	
	/**
	 * 删除所有购买项
	 */
	public String deleteAll()
	{
		BuyCart buyCart=getBuyCart(request);
		if(buyCart!=null) buyCart.removeAll();
		return "deleteAll";
	}
	
	/**
	 * 更新所有购买项的数量
	 * @param request
	 * @return
	 */
	public String updateAll()
	{
		BuyCart buyCart=getBuyCart(request);
		if(buyCart!=null){
			for(BuyItem item:buyCart.getItems()){
				StringBuffer key=new StringBuffer("amount_");
				key.append(item.getProduct().getProductid()).append('_');
				if(item.getProduct().getStyles().size()>0)
					key.append(item.getProduct().getStyles().iterator().next().getStyleid());
				String amountStr=request.getParameter(key.toString());
				if(amountStr!=null && !"".equals(amountStr)){
					try{
						int amount=Integer.parseInt(amountStr);
						System.out.println(key.toString());
						if(amount>0) item.setAmount(amount);
					}catch(Exception e){}
				}
			}
		}
		return "updateAll";
	}
	
	public BuyCart getBuyCart(HttpServletRequest request){
		return (BuyCart)request.getSession().getAttribute("buycart");
	}
	

}
