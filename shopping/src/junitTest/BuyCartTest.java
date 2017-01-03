package junitTest;

import myshop.bean.Product;
import myshop.bean.ProductStyle;
import myshop.bean.supportbean.BuyItem;

import org.junit.Test;

public class BuyCartTest {

	@Test
	public void test()
	{
		Product product1=new Product(1);
		product1.addProductStyle(new ProductStyle(6));
		BuyItem buyItem=new BuyItem(product1,6);
		
		Product product2=new Product(1);
		product2.addProductStyle(new ProductStyle(56));
		BuyItem buyItem1=new BuyItem(product2,16);
		
		System.out.println(buyItem.equals(buyItem1));
	}

}
