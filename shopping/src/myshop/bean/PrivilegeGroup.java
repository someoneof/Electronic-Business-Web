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
	 * Ȩ��---Ȩ����:��Զ�
	 */
	@Id
	@Column(length = 40, unique = true)
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	@GeneratedValue(generator = "hibernate-uuid")
	private String groupid;

	@Column(length = 20, nullable = false)
	public String name;

	/*
	 * ��������,��������Ȩ������Ϊ��ϵά����,��Զ�ͨ���м���Ź�ϵ,���м��psά����ϵ
	 * inverseJoinColumns:�м�����ϵ��ά���˵������Ϣ,�˴���ά������Ȩ��privilege
	 * ����Ȩ�޵�������һ����������,�����м������������ֶ�,����ά�������ӳ�� �м���е�������Ƹ���ά���˵��������ƹ���
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
