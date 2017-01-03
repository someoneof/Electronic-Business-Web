package myshop.serviceImpl;


import org.springframework.stereotype.Service;

import myshop.base.DaoSupport;
import myshop.bean.Product;
import myshop.service.ProductService;

@Service
public class ProductServiceImpl extends DaoSupport<Product> implements ProductService {

	
	@Override
	public void setState(String method,Integer[] ids)
	{	
		//commend,uncommend,disable,visible
		for(int i=1;i<ids.length;i++)
		{
			Product product=find(Product.class,ids[i]);
			if(method.equals("disable"))
				product.setVisible(false);
			else if(method.equals("visible"))
				product.setVisible(true);
			else if(method.equals("commend"))
				product.setCommend(true);
			else product.setCommend(false);
			update(product);
		}				
	}
}
