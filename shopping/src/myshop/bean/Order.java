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
	
	/* 所属用户 */
	@ManyToOne(cascade=CascadeType.REFRESH,optional=false)
	@JoinColumn(name="logoname")
	private Customer customer;
	
	/* 订单创建时间 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date createdate;
	
	/* 订单状态 */
	@Enumerated(EnumType.STRING)
	@Column(length=16,nullable=false)
	private OrderState orderstate;
	
	/* 商品总金额 */
	@Column(nullable=false)
	private Float producttotalprice=0f;
	
	/* 配送费 */
	@Column(nullable=false)
	private Float deliverFee=0f;
	
	/* 订单总金额 */
	@Column(nullable=false)
	private Float totalprice;
	
	/* 应付款(实际需要支付的费用) */
	@Column(nullable=false)
	private Float payablefee;
	
	/* 顾客附言 */
	@Column(length=100)
	private String note;
	
	/* 支付方式 */
	@Enumerated(EnumType.STRING)
	@Column(length=20,nullable=false)
	private PayWay payway;
	
	/* 支付状态 */
	private Boolean ispayment=false;
	
	/* 订单配送信息,订单作为关系维护端,加入外键
	 * persist 当页面上点击订单确认之后,除了要保存订单的基本信息之外,还要保存订单的配送信息,所以要级联保存
	 * merge   当要对订单的信息进行修改的时候,也要修改订单的配送信息
	 * refresh 当从数据库中获取订单的最新信息的时候,也要获取到订单配送信息的最新信息
	 * remove  当将订单删除的时候,订单的配送信息也没必要存在了.
	 * optional 订单必须要有该项属性,数字产品不需要配送,所以允许为空
	 * */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="delivlerid")
	private OrderContactInfo orderDeliverInfo;
	
	/* 订单购买者联系信息 ,订单作为关系维护端*/
	@OneToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="contactid")
	private OrderContactInfo orderContactInfo;
	
	/*订单项*/
	@OneToMany(cascade=CascadeType.ALL,mappedBy="order")
	private Set<OrderItem> orderitems=new HashSet<OrderItem>();
	
	/* 员工留言 */
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
