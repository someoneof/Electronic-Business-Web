package myshop.service;

import myshop.base.Dao;
import myshop.bean.PrivilegeGroup;

public interface PrivilegeGroupService extends Dao<PrivilegeGroup> {

	void delete(String id);
	
	public PrivilegeGroup find(String groupid);

}
