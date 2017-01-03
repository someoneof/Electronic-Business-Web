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
 *��������Ϣ 
 *
 */
@Entity
public class OrderContactInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer contactid;
	
	/* ���������� */
	@Column(length=15,nullable=false)
	private String buyerName;
	
	/* ��ϵ��ַ */
	@Column(length=15)
	private String address;
	
	/* �������� */
	@Column(length=15)
	private String email;
	
	/* �ʱ� */
	@Column(length=15)
	private String postalcode;
	
	/* ���� */
	@Column(length=10)
	private String tel;
	
	/* �ֻ� */
	@Column(length=11)
	private String mobile;
	
	/* �Ա� */
	@Enumerated(EnumType.STRING)
	@Column(length=6)
	private Gender gender = Gender.MAN;
	
	/* �������� */
	@OneToOne(cascade=CascadeType.REFRESH,mappedBy="orderContactInfo")
	private Order order;

	public Integer getContactid()
	{
		return contactid;
	}

	public void setContactid(Integer contactid)
	{
		this.contactid = contactid;
	}

	public String getBuyerName()
	{
		return buyerName;
	}

	public void setBuyerName(String buyerName)
	{
		this.buyerName = buyerName;
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

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
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
				+ ((contactid == null) ? 0 : contactid.hashCode());
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
		OrderContactInfo other = (OrderContactInfo) obj;
		if (contactid == null)
		{
			if (other.contactid != null)
				return false;
		} else if (!contactid.equals(other.contactid))
			return false;
		return true;
	}
	
	
}
