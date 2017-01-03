package myshop.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import myshop.bean.supportbean.Gender;

@Entity
public class Customer implements Serializable{

	private static final long serialVersionUID = 2311056424965325127L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid;
	
	@Column(nullable=false,length=11,unique=true)
	private String username;
	
	@Column(nullable=false,length=12)
	private String password;
	
	@Column(length=10)
	private String customername;
	
	@Enumerated
	private Gender sex=Gender.MAN;
	
	@Column(length=30,nullable=false)
	private String email;
	
	@Column(length=20,nullable=false)
	private Date registertime;
	
	private Boolean state=true;

	
	
	public Customer()
	{
	}

	public Customer(String username, String password, String email,
			Date registertime)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.registertime = registertime;
	}

	public Integer getCid()
	{
		return cid;
	}

	public void setCid(Integer cid)
	{
		this.cid = cid;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getCustomername()
	{
		return customername;
	}

	public void setCustomername(String customername)
	{
		this.customername = customername;
	}

	public Gender getSex()
	{
		return sex;
	}

	public void setSex(Gender sex)
	{
		this.sex = sex;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getRegistertime()
	{
		return registertime;
	}

	public void setRegistertime(Date registertime)
	{
		this.registertime = registertime;
	}

	public Boolean getState()
	{
		return state;
	}

	public void setState(Boolean state)
	{
		this.state = state;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
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
		Customer other = (Customer) obj;
		if (cid == null)
		{
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Customer [cid=" + cid + ", username=" + username
				+ ", customername=" + customername + "]";
	}
	
	

}
