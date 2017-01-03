package myshop.bean;

import java.util.ArrayList;
import java.util.List;

import myshop.bean.supportbean.BuyItem;
import myshop.bean.supportbean.OrderContactInfo;
import myshop.bean.supportbean.OrderDeliverInfo;

public class BuyCart {

	/* 购物项 */
	private List<BuyItem> items = new ArrayList<BuyItem>();

	/** 收货人配送信息 */
	private OrderDeliverInfo deliverInfo;

	/** 订购者联系信息 */
	private OrderContactInfo contactInfo;
	
	/**收货人订购者是否是同一个人*/
	private Boolean buyerIsreceiver;

	/* 配送信息 */

	/* 购买者联系信息 */

	/* 支付方式 */

	/* 购买者与收货人是否相同 */

	/* 配送费 */

	/* 附言 */

	public void addItem(BuyItem item)
	{
		if (!items.contains(item))
			items.add(item);
		else
		{// 如果存在,则累积购物项
			for (BuyItem it : items)
				if (it.equals(item))
				{
					it.setAmount(it.getAmount() + 1);
					break;
				}
		}
	}

	public List<BuyItem> getItems()
	{
		return items;
	}

	public void setItems(List<BuyItem> items)
	{
		this.items = items;
	}

	/**
	 * 计算商品总销售价
	 * 
	 * @return
	 */
	public float getTotalSellPrice()
	{
		float totalprice = 0F;
		for (BuyItem item : this.items)
		{
			totalprice += item.getProduct().getSellprice() * item.getAmount();
		}
		return totalprice;
	}

	/**
	 * 计算商品总市场价
	 * 
	 * @return
	 */
	public float getTotalMarketPrice()
	{
		float totalprice = 0F;
		for (BuyItem item : this.items)
		{
			totalprice += item.getProduct().getMarketprice() * item.getAmount();
		}
		return totalprice;
	}

	/**
	 * 计算总节省金额
	 * 
	 * @return
	 */
	public float getTotalSavedPrice()
	{
		return this.getTotalMarketPrice() - this.getTotalSellPrice();
	}

	/**
	 * 清除购物车
	 */
	public void removeAll()
	{
		items.clear();
	}

	/**
	 * 清除某一项
	 */
	public void removeBuyItem(BuyItem item)
	{
		if (items.contains(item))
			items.remove(item);
	}

	/**
	 * 批量更新购买数量
	 */
	public void updateAmount(BuyItem[] items)
	{
		for (BuyItem bi : this.items)
			for (BuyItem item : items)
			{
				if (bi.equals(item))
				{
					bi.setAmount(item.getAmount());
					break;
				}
			}
	}

	public OrderDeliverInfo getDeliverInfo()
	{
		return deliverInfo;
	}

	public void setDeliverInfo(OrderDeliverInfo deliverInfo)
	{
		this.deliverInfo = deliverInfo;
	}

	public OrderContactInfo getContactInfo()
	{
		return contactInfo;
	}

	public void setContactInfo(OrderContactInfo contactInfo)
	{
		this.contactInfo = contactInfo;
	}

	public Boolean getBuyerIsreceiver()
	{
		return buyerIsreceiver;
	}

	public void setBuyerIsreceiver(Boolean buyerIsreceiver)
	{
		this.buyerIsreceiver = buyerIsreceiver;
	}
	
	
}
