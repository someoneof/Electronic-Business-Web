package myshop.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductStyle implements Serializable{

	private static final long serialVersionUID = 852090372933250861L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer styleid;
	
	/**样式名称,如一个产品可能有不同的颜色*/
	@Column(nullable=false,length=10)
	private String name;
	/**在售状态*/
	private Boolean visible=true;
	
	/**产品图片*/
	@Column(length=100)
	private String logopath;
	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="productid")
	private Product productinfo;

	
	
	
	public ProductStyle()
	{
	}

	public ProductStyle(Integer styleid)
	{
		this.styleid = styleid;
	}


	public ProductStyle(String name, String logopath)
	{
		this.name = name;
		this.logopath = logopath;
	}

	public Integer getStyleid()
	{
		return styleid;
	}

	public void setStyleid(Integer styleid)
	{
		this.styleid = styleid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Boolean getVisible()
	{
		return visible;
	}

	public void setVisible(Boolean visible)
	{
		this.visible = visible;
	}

	public String getLogopath()
	{
		return logopath;
	}

	public void setLogopath(String logopath)
	{
		this.logopath = logopath;
	}

	public Product getProductinfo()
	{
		return productinfo;
	}

	public void setProductinfo(Product productinfo)
	{
		this.productinfo = productinfo;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((styleid == null) ? 0 : styleid.hashCode());
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
		ProductStyle other = (ProductStyle) obj;
		if (styleid == null)
		{
			if (other.styleid != null)
				return false;
		} else if (!styleid.equals(other.styleid))
			return false;
		return true;
	}

	
}
