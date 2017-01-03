package myshop.bean;

import java.util.ArrayList;
import java.util.List;

import myshop.bean.supportbean.BuyItem;
import myshop.bean.supportbean.OrderContactInfo;
import myshop.bean.supportbean.OrderDeliverInfo;

public class BuyCart {

	/* ������ */
	private List<BuyItem> items = new ArrayList<BuyItem>();

	/** �ջ���������Ϣ */
	private OrderDeliverInfo deliverInfo;

	/** ��������ϵ��Ϣ */
	private OrderContactInfo contactInfo;
	
	/**�ջ��˶������Ƿ���ͬһ����*/
	private Boolean buyerIsreceiver;

	/* ������Ϣ */

	/* ��������ϵ��Ϣ */

	/* ֧����ʽ */

	/* ���������ջ����Ƿ���ͬ */

	/* ���ͷ� */

	/* ���� */

	public void addItem(BuyItem item)
	{
		if (!items.contains(item))
			items.add(item);
		else
		{// �������,���ۻ�������
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
	 * ������Ʒ�����ۼ�
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
	 * ������Ʒ���г���
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
	 * �����ܽ�ʡ���
	 * 
	 * @return
	 */
	public float getTotalSavedPrice()
	{
		return this.getTotalMarketPrice() - this.getTotalSellPrice();
	}

	/**
	 * ������ﳵ
	 */
	public void removeAll()
	{
		items.clear();
	}

	/**
	 * ���ĳһ��
	 */
	public void removeBuyItem(BuyItem item)
	{
		if (items.contains(item))
			items.remove(item);
	}

	/**
	 * �������¹�������
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
