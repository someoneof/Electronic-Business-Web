package myshop.serviceImpl;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myshop.base.DaoSupport;
import myshop.bean.PrivilegeGroup;
import myshop.service.PrivilegeGroupService;

@Service
public class PrivilegeGroupServiceImpl extends DaoSupport<PrivilegeGroup> implements
		PrivilegeGroupService {


	@Override
	public void delete(String groupid)
	{
		hibernateTemplate.delete(find(groupid));;
	}

	@Override
	@Transactional(readOnly=true,propagation = Propagation.NOT_SUPPORTED)
	public PrivilegeGroup find(String groupid)
	{
		String hql="select o from PrivilegeGroup o where o.groupid='"+groupid+"'";
		return (PrivilegeGroup) hibernateTemplate.find(hql).get(0);
	}
	
	
}
