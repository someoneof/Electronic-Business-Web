package myshop.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import myshop.bean.supportbean.Sex;


@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = -4192924253865280061L;
	// 产品id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productid;
	// 产品货号
	@Column(length = 50)
	private String productcode;
	// 产品名称
	@Column(length = 50, nullable = false)
	private String name;

	// 产品品牌 一个品牌有好多产品 多对一 通过产品可以得到品牌 当项关联
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "brandid")
	private Brand brand;
	// 型号

	@Column(length = 30)
	private String model;
	// 产品底价

	@Column(nullable = false)
	private float baseprice = 999999999;
	// 产品市场价

	@Column(nullable = false)
	private float marketprice = 999999999;
	// 产品销售价

	@Column(nullable = false)
	private float sellprice = 999999999;
	// 产品重量

	@Column(length = 30)
	private int weight;

	// 产品描述
	@Column(nullable = false, length = 100)
	private String description;

	// 购买说明
	@Column(length = 30)
	private String buyerplain;

	// 是否上架
	private Boolean visible = true;

	// 产品类别 多对一 一个类别对多个产品
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "typeid")
	private ProductType type;

	// 创建时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate = new Date();

	// 点击量
	@Column
	private int clickcount = 1;

	// 销售量
	@Column(nullable = false)
	private int sellcount = 0;

	// 是否推荐
	@Column
	private Boolean commend = true;

	// 产品适用性别
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Sex sexrequest = Sex.NONE;

	// 产品样式 一对多 由产品样式维护主键
	@OneToMany(cascade =CascadeType.ALL,
			mappedBy = "productinfo", fetch = FetchType.EAGER)
	@OrderBy("visible desc, styleid asc") 
	private Set<ProductStyle> styles = new HashSet<ProductStyle>();

	// 专家模式 product通过自己添加productstyle
	public void addProductStyle(ProductStyle productStyle)
	{
		if (!this.styles.contains(productStyle))
		{
			this.styles.add(productStyle);
			productStyle.setProductinfo(this);
		}
	}
	/**
	 * 从样式集合中删除指定样式
	 * @param style
	 */
	public void removeProductStyle(ProductStyle style){
		if(this.styles.contains(style)){
			this.styles.remove(style);
			style.setProductinfo(null);
		}
	}	
	

	public Product()
	{
	}



	public Product(Integer productid)
	{
		this.productid = productid;
	}
	public Product(String productcode, float baseprice,String name,
			float marketprice,String description, float sellprice, String buyerplain,int weight)
	{
		this.productcode = productcode;
		this.baseprice = baseprice;
		this.name = name;
		this.marketprice = marketprice;
		this.description = description;
		this.sellprice = sellprice;
		this.buyerplain = buyerplain;
		this.weight = weight;
	}


	public Integer getProductid()
	{
		return productid;
	}

	public void setProductid(Integer productid)
	{
		this.productid = productid;
	}

	public String getProductcode()
	{
		return productcode;
	}

	public void setProductcode(String productcode)
	{
		this.productcode = productcode;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Brand getBrand()
	{
		return brand;
	}

	public void setBrand(Brand brand)
	{
		this.brand = brand;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public float getBaseprice()
	{
		return baseprice;
	}

	public void setBaseprice(float baseprice)
	{
		this.baseprice = baseprice;
	}

	public float getMarketprice()
	{
		return marketprice;
	}

	public void setMarketprice(float marketprice)
	{
		this.marketprice = marketprice;
	}

	public float getSellprice()
	{
		return sellprice;
	}

	public void setSellprice(float sellprice)
	{
		this.sellprice = sellprice;
	}

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getBuyerplain()
	{
		return buyerplain;
	}

	public void setBuyerplain(String buyerplain)
	{
		this.buyerplain = buyerplain;
	}

	public Boolean getVisible()
	{
		return visible;
	}

	public void setVisible(Boolean visible)
	{
		this.visible = visible;
	}

	public ProductType getType()
	{
		return type;
	}

	public void setType(ProductType type)
	{
		this.type = type;
	}

	public Date getCreatedate()
	{
		return createdate;
	}

	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}

	public int getClickcount()
	{
		return clickcount;
	}

	public void setClickcount(int clickcount)
	{
		this.clickcount = clickcount;
	}

	public int getSellcount()
	{
		return sellcount;
	}

	public void setSellcount(int sellcount)
	{
		this.sellcount = sellcount;
	}

	public Boolean getCommend()
	{
		return commend;
	}

	public void setCommend(Boolean commend)
	{
		this.commend = commend;
	}

	public Sex getSexrequest()
	{
		return sexrequest;
	}

	public void setSexrequest(Sex sexrequest)
	{
		this.sexrequest = sexrequest;
	}

	public Set<ProductStyle> getStyles()
	{
		return styles;
	}

	public void setStyles(Set<ProductStyle> styles)
	{
		this.styles = styles;
	}
	
	public Float getSavedPrice()
	{
		return marketprice-baseprice;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productid == null) ? 0 : productid.hashCode());
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
		Product other = (Product) obj;
		if (productid == null)
		{
			if (other.productid != null)
				return false;
		} else if (!productid.equals(other.productid))
			return false;
		return true;
	}

}
