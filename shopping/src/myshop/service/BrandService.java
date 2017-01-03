package myshop.service;

import myshop.base.Dao;
import myshop.bean.Brand;

public interface BrandService extends Dao<Brand> {
	
	public Brand find(String code);

}
