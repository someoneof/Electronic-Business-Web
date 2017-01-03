package myshop.serviceImpl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myshop.base.DaoSupport;
import myshop.bean.Employee;
import myshop.bean.ProductType;
import myshop.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends DaoSupport<Employee> implements EmployeeService {


	public void delete(int[] id)
	{
		for (int i = 0; i < id.length; i++)
		{
			Employee type = (Employee) find(id[i]);
			if (type.getVisible() == true)
				type.setVisible(false);
			update(type);
		}
	}
	public void delete(int id)
	{
		Employee type = (Employee) find(id);
		if (type.getVisible() == true)
			type.setVisible(false);
		update(type);
	}

	@Override
	@Transactional(readOnly=true, propagation = Propagation.NOT_SUPPORTED)
	public Employee find(int id)
	{
		String hql="select o from Employee o where o.eid="+id;
		return (Employee) hibernateTemplate.find(hql).get(0);
	}
	
}
