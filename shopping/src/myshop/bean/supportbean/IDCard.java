package myshop.bean.supportbean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import myshop.bean.Employee;


@Entity
public class IDCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cardid;
	
	@Column(length=20)
	private String idNo;
	
	@Column(length=50)
	private String address;
	
	@Column(length=15)
	private String birthday;
	
	@OneToOne(cascade=CascadeType.REFRESH,mappedBy="idCard")
	private Employee employee;

	
	

	public Integer getCardid()
	{
		return cardid;
	}

	public void setCardid(Integer cardid)
	{
		this.cardid = cardid;
	}

	public String getIdNo()
	{
		return idNo;
	}

	public void setIdNo(String idNo)
	{
		this.idNo = idNo;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public Employee getEmployee()
	{
		return employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	
	
	
}
