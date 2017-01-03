package myshop.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class SystemPrivilege {

	@EmbeddedId
	private SystemPrivilegePK id;
	
	@Column(nullable=false,length=20)
	private String name;
	
	/*由privileges负责中间表的添加删除*/
	@ManyToMany(mappedBy="privileges",cascade=CascadeType.REFRESH)
	private Set<PrivilegeGroup> groups =new HashSet<PrivilegeGroup>();

	
	public SystemPrivilege()
	{
	}

	public SystemPrivilege(SystemPrivilegePK id)
	{
		this.id = id;
	}
	public SystemPrivilege(String moduel,String value)
	{
		this.id = new SystemPrivilegePK(moduel,value);
	}
	public SystemPrivilege(String moduel,String value, String name)
	{
		this.id = new SystemPrivilegePK(moduel,value);
		this.name = name;
	}

	public SystemPrivilege(SystemPrivilegePK id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public Set<PrivilegeGroup> getGroups()
	{
		return groups;
	}

	public void setGroups(Set<PrivilegeGroup> groups)
	{
		this.groups = groups;
	}

	public SystemPrivilegePK getId()
	{
		return id;
	}

	public void setId(SystemPrivilegePK id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SystemPrivilege other = (SystemPrivilege) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "SystemPrivilege [id=" + id + ", name=" + name + "]";
	}
}
