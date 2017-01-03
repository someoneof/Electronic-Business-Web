package myshop.bean.supportbean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import myshop.bean.Order;


@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemid;
	
	/* 产品名称 */
	@Column(length=15,nullable=false)
	private String productName;
	
	/* 产品id */
	@Column(nullable=false)
	private Integer productid;
	
	/* 产品销售价 */
	@Column(nullable=false)
	private Float productPrice = 0f;
	
	/* 购买数量 */
	@Column(nullable=false)
	private Integer amount=1;
	
	/* 产品样式 */
	@Column(length=15)
	private String styleName;	
	
	/* 产品样式ID */
	@Column(nullable=false)
	private Integer styleid;
	
	/* 所属订单 */
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name="orderid")
	private Order order;

	public Integer getItemid()
	{
		return itemid;
	}

	public void setItemid(Integer itemid)
	{
		this.itemid = itemid;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public Integer getProductid()
	{
		return productid;
	}

	public void setProductid(Integer productid)
	{
		this.productid = productid;
	}

	public Float getProductPrice()
	{
		return productPrice;
	}

	public void setProductPrice(Float productPrice)
	{
		this.productPrice = productPrice;
	}

	public Integer getAmount()
	{
		return amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	public String getStyleName()
	{
		return styleName;
	}

	public void setStyleName(String styleName)
	{
		this.styleName = styleName;
	}

	public Integer getStyleid()
	{
		return styleid;
	}

	public void setStyleid(Integer styleid)
	{
		this.styleid = styleid;
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
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (itemid == null)
		{
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		return true;
	}
	
}
