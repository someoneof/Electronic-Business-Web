package myshop.web.actionForm;

import myshop.bean.supportbean.DeliverWay;
import myshop.bean.supportbean.Gender;
import myshop.bean.supportbean.OrderDeliverInfo;
import myshop.bean.supportbean.PayWay;
import myshop.service.OrderDeliverInfoService;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class DeliverInfoForm extends PageViewBase {

	/**接受人信息*/
	protected String receiver;
	protected Gender gender;
	protected String address;
	protected String email;
	protected String postalcode;
	/**座机*/
	protected String tel;  
	/**手机*/
	protected String mobile;
	protected Boolean buyerIsrecipients;
	/**购买人信息*/
	protected String buyer;
	protected Gender buyer_gender;
	protected String buyer_address;
	protected String buyer_postalcode;
	protected String buyer_mobile;
	protected String buyer_tel;
	
	protected DeliverWay deliverway;
	protected PayWay paymentway;
	protected String delivernote;
	protected String requirement;
	
	protected String directUrl;	
	protected String note;	
	
	@Autowired
	protected OrderDeliverInfoService deliverImpl;
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<OrderDeliverInfo> getQueryResult()
	{
		return deliverImpl.getScrollData(OrderDeliverInfo.class, (getCurrpage()-1)*maxresult, maxresult);
	}

	@Override
	public String getWherehql()
	{
		return null;
	}


	public String getReceiver()
	{
		return receiver;
	}

	public void setReceiver(String receiver)
	{
		this.receiver = receiver;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPostalcode()
	{
		return postalcode;
	}

	public void setPostalcode(String postalcode)
	{
		this.postalcode = postalcode;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public Boolean getBuyerIsrecipients()
	{
		return buyerIsrecipients;
	}

	public void setBuyerIsrecipients(Boolean buyerIsrecipients)
	{
		this.buyerIsrecipients = buyerIsrecipients;
	}

	public String getBuyer()
	{
		return buyer;
	}

	public void setBuyer(String buyer)
	{
		this.buyer = buyer;
	}

	public Gender getBuyer_gender()
	{
		return buyer_gender;
	}

	public void setBuyer_gender(Gender buyer_gender)
	{
		this.buyer_gender = buyer_gender;
	}

	public String getBuyer_address()
	{
		return buyer_address;
	}

	public void setBuyer_address(String buyer_address)
	{
		this.buyer_address = buyer_address;
	}

	public String getBuyer_postalcode()
	{
		return buyer_postalcode;
	}

	public void setBuyer_postalcode(String buyer_postalcode)
	{
		this.buyer_postalcode = buyer_postalcode;
	}

	public String getBuyer_mobile()
	{
		return buyer_mobile;
	}

	public void setBuyer_mobile(String buyer_mobile)
	{
		this.buyer_mobile = buyer_mobile;
	}

	public String getBuyer_tel()
	{
		return buyer_tel;
	}

	public void setBuyer_tel(String buyer_tel)
	{
		this.buyer_tel = buyer_tel;
	}

	public DeliverWay getDeliverway()
	{
		return deliverway;
	}

	public void setDeliverway(DeliverWay deliverway)
	{
		this.deliverway = deliverway;
	}

	public PayWay getPaymentway()
	{
		return paymentway;
	}

	public void setPaymentway(PayWay paymentway)
	{
		this.paymentway = paymentway;
	}

	public String getDelivernote()
	{
		return delivernote;
	}

	public void setDelivernote(String delivernote)
	{
		this.delivernote = delivernote;
	}

	public String getRequirement()
	{
		return requirement;
	}

	public void setRequirement(String requirement)
	{
		this.requirement = requirement;
	}

	public String getDirectUrl()
	{
		return directUrl;
	}

	public void setDirectUrl(String directUrl)
	{
		this.directUrl = directUrl;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}
	
}
