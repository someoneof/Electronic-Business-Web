package myshop.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="producttype")
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@TableGenerator(initialValue=1,allocationSize=1, name ="typeid")
	private Integer typeid;
	
	@Column(name="name",nullable=false,length=20,unique=true)
	private String name;
	
	@Column(name="visible")
	private Boolean visible=true;
	
	@Column(nullable=false,length=100)
	private String note;
	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="parentid")
	private ProductType parent;
	
	@OneToMany(cascade={CascadeType.REFRESH,CascadeType.REMOVE},mappedBy="parent", fetch=FetchType.EAGER)//由少的一方维护,减少工作量
	private Set<ProductType> childtypes=new HashSet<ProductType>();

	
	

	public ProductType(Integer typeid, String name)
	{
		this.typeid = typeid;
		this.name = name;
	}


	public ProductType()
	{
	}
	

	public ProductType(Integer typeid)
	{
		this.typeid = typeid;
	}


	public ProductType(Integer typeid, String name, String note)
	{
		this.typeid = typeid;
		this.name = name;
		this.note = note;
	}


	public ProductType(String name, String note)
	{
		this.name = name;
		this.note = note;
	}


	public Integer getTypeid()
	{
		return typeid;
	}

	public void setTypeid(Integer typeid)
	{
		this.typeid = typeid;
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

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public ProductType getParent()
	{
		return parent;
	}

	public void setParent(ProductType parent)
	{
		this.parent = parent;
	}

	public Set<ProductType> getChildtypes()
	{
		return childtypes;
	}

	public void setChildtypes(Set<ProductType> childtypes)
	{
		this.childtypes = childtypes;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + typeid;
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
		ProductType other = (ProductType) obj;
		if (typeid != other.typeid)
			return false;
		return true;
	}


	@Override
	public String toString()
	{
		return "ProductType [typeid=" + typeid + ", name=" + name + "]";
	}

	
	
}
