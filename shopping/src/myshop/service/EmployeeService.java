package myshop.service;

import myshop.base.Dao;
import myshop.bean.Employee;

public interface EmployeeService extends Dao<Employee> {

	Employee find(int id);
	
	public void delete(int[] eid);
	
	public void delete(int id);
	
	
	
}
