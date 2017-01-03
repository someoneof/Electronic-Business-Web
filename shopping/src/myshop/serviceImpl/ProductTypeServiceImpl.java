package myshop.serviceImpl;

import myshop.base.DaoSupport;
import myshop.bean.ProductType;
import myshop.service.ProductTypeService;

import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl extends DaoSupport<ProductType> implements ProductTypeService {

	@Override
	public void delete(Class<ProductType> entityClass, int[] id)
	{
		for (int i = 0; i < id.length; i++)
		{
			ProductType type = (ProductType) find(ProductType.class, id[i]);
			if (type.getVisible() == true)
				type.setVisible(false);
			update(type);
		}
	}
	
}
