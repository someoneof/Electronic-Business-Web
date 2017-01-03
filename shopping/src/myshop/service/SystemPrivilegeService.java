package myshop.service;

import java.util.List;

import myshop.base.Dao;
import myshop.bean.SystemPrivilege;

public interface SystemPrivilegeService extends Dao<SystemPrivilege>{

	
	public void saves(List<SystemPrivilege> privileges);
	
/*	public SystemPrivilege find(String moduel,String value);*/
}
