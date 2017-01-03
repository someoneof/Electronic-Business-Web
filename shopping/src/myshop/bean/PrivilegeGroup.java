package myshop.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PrivilegeGroup {

	/*
	 * 权限---权限组:多对多
	 */
	@Id
	@Column(length = 40, unique = true)
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	@GeneratedValue(generator = "hibernate-uuid")
	private String groupid;

	@Column(length = 20, nullable = false)
	public String name;

	/*
	 * 立即加载,级联更新权限组作为关系维护端,多对多通过中间表存放关系,由中间表ps维护关系
	 * inverseJoinColumns:中间表跟关系被维护端的外键信息,此处被维护端是权限privilege
	 * 由于权限的主键是一个联合主键,所以中间表有两个外键字段,跟被维护表进行映射 中间表中的外键名称跟被维护端的主键名称关联
	 */
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "ps", inverseJoinColumns = {
			@JoinColumn(name = "moduel", referencedColumnName = "moduel"),
			@JoinColumn(name = "value", referencedColumnName = "value") },
			joinColumns = @JoinColumn(name = "group_id"))
	private Set<SystemPrivilege> privileges = new HashSet<SystemPrivilege>();
	
	@ManyToMany(mappedBy="groups",cascade=CascadeType.REFRESH)
	private Set<Employee> employees=new HashSet<Employee>();

	public PrivilegeGroup()
	{
	}

	public PrivilegeGroup(String name)
	{
		this.name = name;
	}

	public void add(SystemPrivilege privilege)
	{
		this.privileges.add(privilege);
	}

	public String getGroupid()
	{
		return groupid;
	}

	public void setGroupid(String groupid)
	{
		this.groupid = groupid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<SystemPrivilege> getPrivileges()
	{
		return privileges;
	}

	public void setPrivileges(Set<SystemPrivilege> privileges)
	{
		this.privileges = privileges;
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
