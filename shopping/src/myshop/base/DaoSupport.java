package myshop.base;

import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.persistence.Entity;

import myshop.bean.SystemPrivilege;
import myshop.web.page.QueryResult;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class DaoSupport<T> implements Dao<T> {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Autowired
	protected HibernateTemplate hibernateTemplate; 
	
	@Resource
	public void setSessionfactory(SessionFactory sessionfactory)
	{
		this.sessionfactory = sessionfactory;
	}

	@Override
	public void save(Object o)
	{
		hibernateTemplate.save(o);
	}

	@Override
	public void delete(Class<T> entityClass, int id)
	{
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void delete(Class<T> entityClass, int[] id)
	{
		for(int i=0;i<id.length;i++)
			hibernateTemplate.delete(find(entityClass,id[i]));
	}

	@Override
	public void update(Object o)
	{
		hibernateTemplate.update(o);
	}

	@Override
	public T find(Class<T> entityClass, int id)
	{
		return hibernateTemplate.get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass,int firstIndex, int pagecount, String wherehql,LinkedHashMap<String, String> orderby)
	{	
		QueryResult<T> qr=new QueryResult<T>();
		String hql=(wherehql==null?"":wherehql);
		Session session=getSession();
		Query query=createQuery(session,getWherehql(entityClass, wherehql==null?"":wherehql, orderby));
		setQuery(query,firstIndex,pagecount);
		qr.setList(query.list()); 
		String clazzhql="select count(o) from "+getTableName(entityClass)+" o "+hql;
		//类类型是否属于另外一个类类型
		if(entityClass.equals(SystemPrivilege.class)) clazzhql="select count(o.name) from "+getTableName(entityClass)+" o "+hql;
		Long totalRecord=(Long)createQuery(session,clazzhql).uniqueResult();
		qr.setTotalRecord(totalRecord);
		return qr;
	}
	
	public void setQuery(Query query,int firstIndex, int pagecount)
	{
		if(firstIndex>-1 && pagecount>-1)
			query.setFirstResult(firstIndex).setMaxResults(pagecount);
	}
	// select count(o) from ProductType o where o.visible=1
	public Query createQuery(Session session,String hql)
	{
		return session.createQuery(hql);
	}
	
	public Session getSession()
	{
		return hibernateTemplate.getSessionFactory().getCurrentSession();
	}
	
	public String getWherehql(Class<T> entityClass,String hql,LinkedHashMap<String, String> orderby)
	{
		//select o from ProductType o where o.visible=1 order by typeid asc
		StringBuffer buffer=new StringBuffer();
		String build=buildOrderBy(orderby);
		buffer.append("select o from ").append(getTableName(entityClass)).append(" o ").append(hql).append(build==null?"":build);
		System.out.println("jphql= "+buffer.toString());
		return buffer.toString();
	}
	private String buildOrderBy(LinkedHashMap<String, String> orderby)
	{	//order by o.typeid desc
		StringBuffer buffer=new StringBuffer();
		buffer.append(" order by ");
		if(orderby!=null && orderby.size()>0)
		{
			for(String key:orderby.keySet())
				buffer.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
		buffer.deleteCharAt(buffer.length()-1);
		return buffer.toString();
		}
		else return null;
	}

	public <T> String getTableName(Class<T> entityClass)
	{
		String entityName=entityClass.getSimpleName();
		Entity entity=entityClass.getAnnotation(Entity.class);
		if(entity.name()!=null && !"".equals(entity.name()))
			entityName=entity.name();
		return entityName;
	}
	
	@Transactional(readOnly=true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public  QueryResult<T> getScrollData(Class<T> entityClass,
			int firstIndex, int pagecount, String wherehql)
	{
		return getScrollData(entityClass,firstIndex,pagecount,wherehql,null);
	}
	
	@Transactional(readOnly=true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass,
			int firstIndex, int pagecount)
	{
		return getScrollData(entityClass,firstIndex,pagecount,null);
	}
	
	@Transactional(readOnly=true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass,LinkedHashMap<String, String> orderby)
	{
		return getScrollData(entityClass,-1,-1,null,orderby);
	}
	
	@Transactional(readOnly=true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass)
	{
		return getScrollData(entityClass,-1,-1,null);
	}
}
