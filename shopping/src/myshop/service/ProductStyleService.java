package myshop.service;

import myshop.base.Dao;
import myshop.bean.ProductStyle;

public interface ProductStyleService extends Dao<ProductStyle> {

	public void setState(String method,Integer[] ids);
}
