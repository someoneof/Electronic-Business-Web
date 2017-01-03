package myshop.web.actionForm;

import java.util.ArrayList;
import java.util.List;

import myshop.bean.ProductType;
import myshop.service.ProductTypeService;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Scope("prototype")
public class ProductTypeForm extends PageViewBase {
	
	
	/*��ҳ�����ת����ҳ����action����ת��ʱ��,���ݲ�����ʱ��,action���в����ı�ʶ��������Ӧ��getter��setter������ʱ��,action��
	 * �Զ���ֵװ��,�ڶ��jspҳ�����ת��ʱ��,������<s:url action="" />�����ݲ���.
	 * */
	
	protected Integer parentid;
	protected String name;
	protected String note;
	protected String query;
	protected Integer typeid;
	protected List<ProductType> types=new ArrayList<ProductType>();
	
	@Autowired
	protected ProductTypeService serviceImpl;
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<ProductType> getQueryResult()
	{
		return serviceImpl.getScrollData(ProductType.class,(getCurrpage() - 1) * maxresult, maxresult, getWherehql(), getOrderby("typeid","asc"));
	}
	@Override
	public String getWherehql()
	{
		String wherehql="where o.visible=1";
		if("true".equals(query))
			return wherehql+=" and o.name='"+name+"'";
		else if (typeid!=null) return wherehql+=" and o.typeid="+typeid;
		return wherehql+" and o.parent.typeid="+parentid;
	}
	
	public List<ProductType> getTypes()
	{
		return types;
	}
	public void setTypes(List<ProductType> types)
	{
		this.types = types;
	}
	public Integer getParentid()
	{
		return parentid;
	}
	public void setParentid(Integer parentid)
	{
		this.parentid = parentid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getNote()
	{
		return note;
	}
	public void setNote(String note)
	{
		this.note = note;
	}
	public String getQuery()
	{
		return query;
	}
	public void setQuery(String query)
	{
		this.query = query;
	}
	public Integer getTypeid()
	{
		return typeid;
	}
	public void setTypeid(Integer typeid)
	{
		this.typeid = typeid;
	}
	public ProductTypeService getServiceImpl()
	{
		return serviceImpl;
	}
	public void setServiceImpl(ProductTypeService serviceImpl)
	{
		this.serviceImpl = serviceImpl;
	}
	

}
