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

@Entity
public class Department implements Serializable{

	private static final long serialVersionUID = -7432146718559885286L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer did;
	
	@Column(nullable=false,length=12)
	private String name;
	
	@OneToMany(cascade={CascadeType.REFRESH},mappedBy="department", fetch=FetchType.EAGER)//由少的一方维护,减少工作量
	private Set<Employee> employees=new HashSet<Employee>();

	
	
	public Department()
	{
	}

	public Department(String name)
	{
		this.name = name;
	}

	public Integer getDid()
	{
		return did;
	}

	public void setDid(Integer did)
	{
		this.did = did;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Employee> getEmployees()
	{
		return employees;
	}

	public void setEmployees(Set<Employee> employees)
	{
		this.employees = employees;
	}
	
	
}
