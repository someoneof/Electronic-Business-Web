package myshop.serviceImpl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import myshop.base.DaoSupport;
import myshop.bean.Brand;
import myshop.service.BrandService;

@Service
public class BrandServiceImpl<UploadFile> extends DaoSupport<Brand> implements BrandService {

	@Override
	public void save(Object o)
	{
		((Brand)o).setCode(UUID.randomUUID().toString());
		super.save(o);
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Brand find(String code)
	{
		//from Users au where au.username =? and au.password =?",username,pass);
		String hql="select o from Brand o where o.code='"+code+"'";
		return (Brand) getSession().createQuery(hql).list().get(0);
	}
	
	
}
