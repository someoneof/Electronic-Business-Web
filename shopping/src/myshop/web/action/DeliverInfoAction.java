package myshop.web.action;

import org.springframework.context.annotation.Scope;

import myshop.bean.BuyCart;
import myshop.bean.supportbean.OrderContactInfo;
import myshop.bean.supportbean.OrderDeliverInfo;
import myshop.web.actionForm.DeliverInfoForm;
import myshop.web.page.QueryResult;
import myshop.web.page.WebUtil;

@Scope("prototype")
public class DeliverInfoAction extends DeliverInfoForm {

	
	private static final long serialVersionUID = 3166428823361236567L;

	/**
	 *保存配送信息 
	 */
	public String saveDeliverInfo()
	{
		BuyCart cart=WebUtil.getBuyCart(request);
		System.out.println(cart.getItems().get(0).getProduct().getName());
		//设置收货人信息
		OrderDeliverInfo deliverInfo=new OrderDeliverInfo();
		deliverInfo.setRealname(receiver);
		deliverInfo.setSex(gender);
		deliverInfo.setAddress(address);
		deliverInfo.setPostal(postalcode);
		deliverInfo.setEmail(email);
		deliverInfo.setTel(tel);
		deliverInfo.setPhone(mobile);
		cart.setDeliverInfo(deliverInfo);
		
		cart.setBuyerIsreceiver(buyerIsrecipients);
		//设置购买者信息
		OrderContactInfo contactinfo=new OrderContactInfo();
		if(!cart.getBuyerIsreceiver()){
			contactinfo.setBuyerName(buyer);
			contactinfo.setGender(buyer_gender);
			contactinfo.setAddress(buyer_address);
			contactinfo.setPostalcode(buyer_postalcode);
			contactinfo.setTel(buyer_tel);
			contactinfo.setEmail(WebUtil.getBuyer(request).getEmail());
			contactinfo.setMobile(buyer_mobile);
		}else{
			contactinfo.setBuyerName(receiver);
			contactinfo.setGender(gender);
			contactinfo.setAddress(address);
			contactinfo.setPostalcode(postalcode);
			contactinfo.setTel(tel);
			contactinfo.setMobile(mobile);
			contactinfo.setEmail(email);
		}
		cart.setContactInfo(contactinfo);
		return "saveDeliverInfo";
	}
	

}
