package myshop.serviceImpl;



import org.springframework.stereotype.Service;

import myshop.base.DaoSupport;
import myshop.bean.Department;
import myshop.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends DaoSupport<Department> implements DepartmentService {

	@Override
	public void delete(int id)
	{
		hibernateTemplate.delete(find(id));
	}
	

	@Override
	public Department find(int id)
	{
		String hql="select o from Department o where o.did="+id;
		return (Department) hibernateTemplate.find(hql).get(0);
	}

	
}
