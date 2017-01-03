package myshop.serviceImpl;


import java.util.List;

import myshop.base.DaoSupport;
import myshop.bean.SystemPrivilege;
import myshop.service.SystemPrivilegeService;

import org.springframework.stereotype.Service;

@Service
public class SystemPrivilegeServiceImpl extends DaoSupport<SystemPrivilege>
		implements SystemPrivilegeService {
	
	public void saves(List<SystemPrivilege> privileges)
	{
		for(SystemPrivilege p:privileges)
			super.save(p);
	}
	
	/*public SystemPrivilege find(String moduel,String value)
	{
		String hql="select o from SystemPrivilege o where o.moduel='"+moduel+"' and o.value='"+value+"'";
		return (SystemPrivilege) hibernateTemplate.find(hql).get(0);
	}
*/
}
