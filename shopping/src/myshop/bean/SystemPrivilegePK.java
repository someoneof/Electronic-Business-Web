package myshop.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SystemPrivilegePK implements Serializable{

	private static final long serialVersionUID = -2844799386324974482L;

	@Column(length=20,nullable=false,name="moduel")
	private String moduel;
	
	@Column(length=20,nullable=false,name="value")
	private String value;
	
	

	public SystemPrivilegePK(String moduel, String value)
	{
		this.moduel = moduel;
		this.value = value;
	}

	public SystemPrivilegePK()
	{
	}

	public String getModuel()
	{
		return moduel;
	}

	public void setModuel(String moduel)
	{
		this.moduel = moduel;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moduel == null) ? 0 : moduel.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		SystemPrivilegePK other = (SystemPrivilegePK) obj;
		if (moduel == null)
		{
			if (other.moduel != null)
				return false;
		} else if (!moduel.equals(other.moduel))
			return false;
		if (value == null)
		{
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
}
