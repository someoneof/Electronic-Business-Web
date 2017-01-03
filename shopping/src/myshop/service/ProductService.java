package myshop.service;

import myshop.base.Dao;
import myshop.bean.Product;

public interface ProductService extends Dao<Product> {
	
	/**上架或下架,是否推荐*/
	public void setState(String methodname,Integer[] ids);
	
}
