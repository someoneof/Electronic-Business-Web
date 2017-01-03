package myshop.service;

import myshop.base.Dao;
import myshop.bean.Department;

public interface DepartmentService extends Dao<Department>{

	void delete(int id);
	
	Department find(int id);
}
