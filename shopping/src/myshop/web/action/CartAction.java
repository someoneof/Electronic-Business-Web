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
		BuyCart buyCart=(BuyCart)request.getSession().getAttribute("buycart");//�ӵ�ǰ�Ự��ȡsession
		if(buyCart==null){//���ﳵ����Ϊ��,����û����´��ڴ�һ��ҳ��,�����û�ԭ���Ѿ�������һ����Ʒ,Ȼ���ִ���һ���´���,���´���buyCart�ǲ����ڵ�
			//����ǰһ���Ѿ�������һ����Ʒ,Ҳ����˵ǰһ�κ���һ�ε�sessionidֵ�ǲ�һ����,����ȡ����sessionֵ,���Ա����ȴ��û���ǰ�ĻỰȥȡ�ù��ﳵ����.
			//���ûȡ��,�ٿ���ԭ����û�й��ﳵ����,���Դ�cookie��ȡ�ù��ﳵ����.
			String sid=WebUtil.getCookieByName(request, "buyCartID");
			if(sid!=null){//�����Ϊ��,ȡ��session����,Ҳ������ǰ��sessionȡ�ù��ﳵ
				HttpSession session=SiteSessionListener.getSession(sid);  //����ǰ�ĻỰ��ȡsession
				if(session!=null){
					buyCart=(BuyCart)session.getAttribute("buycart");
					if(buyCart!=null){  //����ǰ��cookies�л�ȡ���ﳵ
						SiteSessionListener.remove(sid);
						setAttribute("buyCart", buyCart);
						WebUtil.addCookie(response, "buyCartID", request.getSession().getId(),request.getSession().getMaxInactiveInterval());
					}
				}//�����ǰ�Ự������,�Ͱ���ǰ�Ự�Ĺ��ﳵ���ڵ�ǰ�Ự��,�Ժ�ֻҪͨ����ǰ�Ự�Ϳ��Է��ʹ��ﳵ,�������ٵõ���ǰ��session
				
			}
		}
		//����ӵ�ǰ����ǰ�ĻỰ����ȡ�������ﳵ,���½�һ�����ﳵ
		if(buyCart==null){  //����ӵ�ǰsessionȡ�õĹ��ﳵΪ��,Ҳ����˵��ǰû��session,��newһ�����ﳵ,������뵱ǰsession��
			buyCart=new BuyCart();
			request.getSession().setAttribute("buycart", buyCart);//��session���뵽cookie��ȥ,session��������Ϊkey,session��id��Ϊvalue
			WebUtil.addCookie(response, "buyCartID", request.getSession().getId(), request.getSession().getMaxInactiveInterval());
		}
		
		if(productid!=null && productid>0){
			Product product=productImpl.find(Product.class, productid);
			if(product!=null){
				ProductStyle currentStyle=null;
				for(ProductStyle style:product.getStyles()){//�ҵ���Ӧid����ʽ
					if(style.getVisible() && style.getStyleid().equals(styleid)){
						currentStyle=style;
						break;
					}
				}//Ϊ�˱�֤���絽���ﳵ����ʽֻ��һ������
				product.getStyles().clear();//�����ʽ,Ȼ����뱻ѡ��ʽ
				//����Ʒ����+��ʽ,��ʽ��ά����,������ά���˼���ʽ,������µ����ݿ�
				if(currentStyle!=null) product.addProductStyle(currentStyle);
				buyCart.addItem(new BuyItem(product,1));//����Ʒ���빺�ﳵ
			}
		}
		//�����ﳵ���뵽����Χ��ȥ
		setAttribute("buyCart", buyCart);
		return "addItem";
	}
	
	/**
	 * ɾ��ָ��������
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
	 * ɾ�����й�����
	 */
	public String deleteAll()
	{
		BuyCart buyCart=getBuyCart(request);
		if(buyCart!=null) buyCart.removeAll();
		return "deleteAll";
	}
	
	/**
	 * �������й����������
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
