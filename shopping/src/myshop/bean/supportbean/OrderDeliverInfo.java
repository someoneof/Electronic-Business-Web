package myshop.bean.supportbean;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import myshop.bean.Order;

/**
 * 收货人信息
 *
 */
@Entity
public class OrderDeliverInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer delivlerid;
	
	/* 收货人姓名 */
	@Column(nullable=false,length=15)
	private String realname;
	
	/* 配送地址 */
	@Column(length=30)
	private String address;
	
	/* 电子邮箱 */
	@Column(length=20)
	private String email;
	
	/* 邮编 */
	@Column(length=10)
	private String postal;
	
	/* 座机 */
	@Column(length=10)
	private String tel;
	
	/* 手机 */
	@Column(length=11)
	private String phone;
	
	/* 性别 */
	@Enumerated(EnumType.STRING)
	@Column(length=6)
	private Gender sex;
	
	/* 配送方式 */
	@Enumerated(EnumType.STRING) 
	@Column(length=23,nullable=false)
	private DeliverWay deliverWay;
	
	/* 时间要求 */
	@Column(length=20)
	private String daterequirement;
	
	/* 所属订单 */
	@OneToOne(cascade=CascadeType.REFRESH,mappedBy="orderDeliverInfo")
	private Order order;
	


	public Integer getDelivlerid()
	{
		return delivlerid;
	}

	public void setDelivlerid(Integer delivlerid)
	{
		this.delivlerid = delivlerid;
	}

	public String getRealname()
	{
		return realname;
	}

	public void setRealname(String realname)
	{
		this.realname = realname;
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

	public String getPostal()
	{
		return postal;
	}

	public void setPostal(String postal)
	{
		this.postal = postal;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Gender getSex()
	{
		return sex;
	}

	public void setSex(Gender sex)
	{
		this.sex = sex;
	}

	public DeliverWay getDeliverWay()
	{
		return deliverWay;
	}

	public void setDeliverWay(DeliverWay deliverWay)
	{
		this.deliverWay = deliverWay;
	}

	public String getDaterequirement()
	{
		return daterequirement;
	}

	public void setDaterequirement(String daterequirement)
	{
		this.daterequirement = daterequirement;
	}

	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((delivlerid == null) ? 0 : delivlerid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDeliverInfo other = (OrderDeliverInfo) obj;
		if (delivlerid == null)
		{
			if (other.delivlerid != null)
				return false;
		} else if (!delivlerid.equals(other.delivlerid))
			return false;
		return true;
	}
}
