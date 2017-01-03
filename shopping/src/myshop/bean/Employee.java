package myshop.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import myshop.bean.supportbean.Gender;
import myshop.bean.supportbean.IDCard;


@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 9027495844659837128L;

	/** 用户名 */
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer eid;
	
	/** 用户权限 */
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name="employee_group",
			   joinColumns=@JoinColumn(name="logoname"),
			   inverseJoinColumns=@JoinColumn(name="groupid"))
	private Set<PrivilegeGroup> groups=new HashSet<PrivilegeGroup>();
	
	/** 员工姓名 */
	@Column(name="employeename",length=15)
	private String employeename;
	
	/**登录账号**/
	@Column(name="logoname",length=15,nullable=false)
	private String logoname;
	
	/**登录密码*/
	@Column(length=15,nullable=false)
	private String password;
	
	/**员工照片*/
	@Column(length=100)
	private String photopath;
	
	/**身份证号码*/
	@OneToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="carid")
	private IDCard idCard; 
	
	/**联系电话*/
	@Column(length=11)
	private String phone;
	
	/**电子邮件*/
	@Column(length=18)
	private String email;
	
	/**毕业院校*/
	@Column(length=20)
	private String school;
	
	@Column(length=10)
	private String degree;
	/** 性别 */
	@Enumerated
	@Column(length=5)
	private Gender sex;
	
	private Boolean visible=true;

	/** 所属部门 */
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="did")
	private Department department;

	
	public Employee()
	{
	}


	/**
	 * 添加权限组
	 * @param group
	 */
	public void addPrivilegeGroup(PrivilegeGroup group){
		this.groups.add(group);
	}
	
	
	public Integer getEid()
	{
		return eid;
	}

	public void setEid(Integer eid)
	{
		this.eid = eid;
	}

	public Set<PrivilegeGroup> getGroups()
	{
		return groups;
	}

	public void setGroups(Set<PrivilegeGroup> groups)
	{
		this.groups = groups;
	}

	public String getEmployeename()
	{
		return employeename;
	}

	public void setEmployeename(String employeename)
	{
		this.employeename = employeename;
	}

	public String getLogoname()
	{
		return logoname;
	}

	public void setLogoname(String logoname)
	{
		this.logoname = logoname;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPhotopath()
	{
		return photopath;
	}

	public void setPhotopath(String photopath)
	{
		this.photopath = photopath;
	}

	public IDCard getIdCard()
	{
		return idCard;
	}

	public void setIdCard(IDCard idCard)
	{
		this.idCard = idCard;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSchool()
	{
		return school;
	}

	public void setSchool(String school)
	{
		this.school = school;
	}

	public Gender getSex()
	{
		return sex;
	}

	public void setSex(Gender sex)
	{
		this.sex = sex;
	}

	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}


	public Boolean getVisible()
	{
		return visible;
	}


	public void setVisible(Boolean visible)
	{
		this.visible = visible;
	}


	public String getDegree()
	{
		return degree;
	}


	public void setDegree(String degree)
	{
		this.degree = degree;
	}
	
	
}
