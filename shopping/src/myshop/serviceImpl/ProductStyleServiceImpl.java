package myshop.serviceImpl;


import myshop.base.DaoSupport;
import myshop.bean.Product;
import myshop.bean.ProductStyle;
import myshop.service.ProductStyleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductStyleServiceImpl extends DaoSupport<ProductStyle> implements ProductStyleService {

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void delete(Class<ProductStyle> entityClass, int[] id)
	{
		for(int i=0;i<id.length;i++)
		{
			ProductStyle style=find(entityClass, id[i]);
			style.setVisible(false);
			update(style);
		}
	}

	@Override
	public void setState(String method,Integer[] ids)
	{	
		//disable,visible
		for(int i=1;i<ids.length;i++)
		{
			ProductStyle style=find(ProductStyle.class,ids[i]);
			if(method.equals("visible"))
				style.setVisible(true);
			else style.setVisible(false);
			update(style);
		}				
	}
}
