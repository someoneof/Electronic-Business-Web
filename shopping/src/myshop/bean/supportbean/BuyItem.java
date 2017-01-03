package myshop.bean.supportbean;

import myshop.bean.Product;
import myshop.bean.ProductStyle;


public class BuyItem {
	
	/**���������Ʒ*/
	private Product product;
	
	/**���������*/
	private Integer amount = 1;
	
	
	

	
	
	public BuyItem(Product product)
	{
		this.product = product;
	}

	public BuyItem()
	{
	}

	public BuyItem(Product product, Integer amount)
	{
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public Integer getAmount()
	{
		return amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	@Override
	public int hashCode()
	{	//�жϹ��ﳵ�еĲ�Ʒ�Ƿ���ͬһ����Ʒ,���ݲ�Ʒid����ʽid���ж�
		String buyitemid = product.hashCode()+"-";
		if(product.getStyles().size()>0) buyitemid +=product.getStyles().iterator().next().getStyleid();
		return buyitemid.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final BuyItem other = (BuyItem) obj; 
		if (product == null)
		{
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if(product.getStyles().size()!=other.product.getStyles().size()) return false;
		
		if (product.getStyles().size() > 0){
			ProductStyle style = product.getStyles().iterator().next();
			ProductStyle otherstyle = other.product.getStyles().iterator().next();
			if (!style.equals(otherstyle)) return false;
		}
		return true;
	}
	
}
