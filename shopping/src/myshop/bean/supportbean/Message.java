package myshop.bean.supportbean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import myshop.bean.Order;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer messageid;
	
	@Column(length=100)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime = new Date();
	
	@Column(length=15,nullable=false)
	private String username;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="orderid")
	private Order order;


	public Integer getMessageid()
	{
		return messageid;
	}

	public void setMessageid(Integer messageid)
	{
		this.messageid = messageid;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((messageid == null) ? 0 : messageid.hashCode());
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
		Message other = (Message) obj;
		if (messageid == null)
		{
			if (other.messageid != null)
				return false;
		} else if (!messageid.equals(other.messageid))
			return false;
		return true;
	}
	
	
}
