package myshop.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myshop.base.DaoSupport;
import myshop.bean.Customer;
import myshop.service.CustomerService;

@Service
public class CustomerServiceImpl extends DaoSupport<Customer> implements
		CustomerService<Customer> {

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void setCustomerState(String model, String username)
	{
		Customer customer = getCustomer(username);
		if (model.equals("delete"))
		{	
			customer.setState(false);
		} else
			customer.setState(true);
		update(customer);
	}

	@Override
	public void delete(Class<Customer> entityClass, int[] id)
	{
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public boolean findByUsername(String username)
	{
		String hql = "select count(o) from Customer o where o.username='"
				+ username + "'";
		return (Long) getSession().createQuery(hql).uniqueResult() > 0;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Boolean login(String username, String password)
	{
		String hql = "select count(o) from Customer o where o.username='"
				+ username + "' and o.password='" + password + "'";
		return (Long) getSession().createQuery(hql).uniqueResult() > 0;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Customer getCustomer(String username)
	{
		String hql = "select o from Customer o where o.username='" + username+ "'";
		System.out.println(hql);
		return (Customer) getSession().createQuery(hql).list().get(0);
	}
}