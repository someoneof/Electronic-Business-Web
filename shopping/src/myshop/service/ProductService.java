package myshop.service;

import myshop.base.Dao;
import myshop.bean.Product;

public interface ProductService extends Dao<Product> {
	
	/**�ϼܻ��¼�,�Ƿ��Ƽ�*/
	public void setState(String methodname,Integer[] ids);
	
}
