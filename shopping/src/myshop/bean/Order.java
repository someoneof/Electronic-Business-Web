package myshop.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import myshop.bean.supportbean.Message;
import myshop.bean.supportbean.OrderContactInfo;
import myshop.bean.supportbean.OrderItem;
import myshop.bean.supportbean.OrderState;
import myshop.bean.supportbean.PayWay;

@Entity
@Table(name="t_order")
public class Order {

	@Id
	@Column(length=16)
	private String orderid;
	
	/* �����û� */
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="logoname")
	private Customer customer;
	
	/* ��������ʱ�� */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date createdate;
	
	/* ����״̬ */
	@Enumerated(EnumType.STRING)
	@Column(length=16,nullable=false)
	private OrderState orderstate;
	
	/* ��Ʒ�ܽ�� */
	@Column(nullable=false)
	private Float producttotalprice=0f;
	
	/* ���ͷ� */
	@Column(nullable=false)
	private Float deliverFee=0f;
	
	/* �����ܽ�� */
	@Column(nullable=false)
	private Float totalprice;
	
	/* Ӧ����(ʵ����Ҫ֧���ķ���) */
	@Column(nullable=false)
	private Float payablefee;
	
	/* �˿͸��� */
	@Column(length=100)
	private String note;
	
	/* ֧����ʽ */
	@Enumerated(EnumType.STRING)
	@Column(length=20,nullable=false)
	private PayWay payway;
	
	/* ֧��״̬ */
	private Boolean ispayment=false;
	
	/* ����������Ϣ,������Ϊ��ϵά����,�������
	 * persist ��ҳ���ϵ������ȷ��֮��,����Ҫ���涩���Ļ�����Ϣ֮��,��Ҫ���涩����������Ϣ,����Ҫ��������
	 * merge   ��Ҫ�Զ�������Ϣ�����޸ĵ�ʱ��,ҲҪ�޸Ķ�����������Ϣ
	 * refresh �������ݿ��л�ȡ������������Ϣ��ʱ��,ҲҪ��ȡ������������Ϣ��������Ϣ
	 * remove  ��������ɾ����ʱ��,������������ϢҲû��Ҫ������.
	 * optional ��������Ҫ�и�������,���ֲ�Ʒ����Ҫ����,��������Ϊ��
	 * */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="delivlerid")
	private OrderContactInfo orderDeliverInfo;
	
	/* ������������ϵ��Ϣ ,������Ϊ��ϵά����*/
	@OneToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="contactid")
	private OrderContactInfo orderContactInfo;
	
	/*������*/
	@OneToMany(cascade=CascadeType.ALL,mappedBy="order")
	private Set<OrderItem> orderitems=new HashSet<OrderItem>();
	
	/* Ա������ */
	@OneToMany(cascade=CascadeType.REFRESH,mappedBy="order")
	private Set<Message> messages=new HashSet<Message>();

	public Order()
	{
	}
	
	public void addOrderitem(OrderItem item)
	{
		this.orderitems.add(item);
		item.setOrder(this);
	}

	public String getOrderid()
	{
		return orderid;
	}

	public void setOrderid(String orderid)
	{
		this.orderid = orderid;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Date getCreatedate()
	{
		return createdate;
	}

	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}

	public OrderState getOrderstate()
	{
		return orderstate;
	}

	public void setOrderstate(OrderState orderstate)
	{
		this.orderstate = orderstate;
	}

	public Float getProducttotalprice()
	{
		return producttotalprice;
	}

	public void setProducttotalprice(Float producttotalprice)
	{
		this.producttotalprice = producttotalprice;
	}

	public Float getDeliverFee()
	{
		return deliverFee;
	}

	public void setDeliverFee(Float deliverFee)
	{
		this.deliverFee = deliverFee;
	}

	public Float getTotalprice()
	{
		return totalprice;
	}

	public void setTotalprice(Float totalprice)
	{
		this.totalprice = totalprice;
	}

	public Float getPayablefee()
	{
		return payablefee;
	}

	public void setPayablefee(Float payablefee)
	{
		this.payablefee = payablefee;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public PayWay getPayway()
	{
		return payway;
	}

	public void setPayway(PayWay payway)
	{
		this.payway = payway;
	}

	public Boolean getIspayment()
	{
		return ispayment;
	}

	public void setIspayment(Boolean ispayment)
	{
		this.ispayment = ispayment;
	}

	public OrderContactInfo getOrderDeliverInfo()
	{
		return orderDeliverInfo;
	}

	public void setOrderDeliverInfo(OrderContactInfo orderDeliverInfo)
	{
		this.orderDeliverInfo = orderDeliverInfo;
	}

	public OrderContactInfo getOrderContactInfo()
	{
		return orderDeliverInfo;
	}

	public void setOrderContactInfo(OrderContactInfo orderContactInfo)
	{
		this.orderDeliverInfo = orderContactInfo;
	}

	public Set<OrderItem> getOrderitems()
	{
		return orderitems;
	}

	public void setOrderitems(Set<OrderItem> orderitems)
	{
		this.orderitems = orderitems;
	}

	public Set<Message> getMessages()
	{
		return messages;
	}

	public void setMessages(Set<Message> messages)
	{
		this.messages = messages;
	}
	
}
