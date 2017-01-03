package myshop.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Brand implements Serializable{
	
	private static final long serialVersionUID = -1447644644022820945L;

	@Id
	@Column(length=100,unique=true)
	@GenericGenerator(name="hibernate-uuid",strategy="uuid")
	@GeneratedValue(generator="hibernate-uuid")
	private String code;
	
	@Column(nullable=true,length=10,unique=true)
	private String name;
	
	private Boolean visible=true;
	
	@Column(length=200)
	private String logopath;

	public Brand(String code, String name)
	{
		this.code = code;
		this.name = name;
	}

	public Brand(String code)
	{
		this.code = code;
	}

	public Brand()
	{
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((logopath == null) ? 0 : logopath.hashCode());
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
		Brand other = (Brand) obj;
		if (code == null)
		{
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (logopath == null)
		{
			if (other.logopath != null)
				return false;
		} else if (!logopath.equals(other.logopath))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Brand [code=" + code + ", name=" + name + ", visible="
				+ visible + ", logopath=" + logopath + "]";
	}

}
