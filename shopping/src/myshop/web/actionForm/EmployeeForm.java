package myshop.web.actionForm;

import java.io.File;
import java.util.UUID;

import myshop.bean.Employee;
import myshop.bean.supportbean.Gender;
import myshop.service.DepartmentService;
import myshop.service.EmployeeService;
import myshop.service.IDCardService;
import myshop.service.PrivilegeGroupService;
import myshop.web.AddImage.AddImage;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class EmployeeForm extends PageViewBase implements AddImage{

	@Autowired
	protected EmployeeService eImpl;
	
	@Autowired/**�������֤��Ϣ*/
	protected IDCardService idImpl;
	
	@Autowired/**���ݲ���idѰ�Ҳ���*/
	protected DepartmentService dImpl;   
	
	@Autowired/**����Ȩ����idѰ�Ҳ���*/
	protected PrivilegeGroupService groupImpl;
	
	/**��½�˺�*/
	protected String logoname;
	protected String password;
	
	/**Ա������*/
	protected String realname;
	
	/**�Ա�*/
	protected Gender sex;
	
	/**��Ƭ*/
	protected File imagefile ;
	
	/**���֤����*/
	protected String idNo;
	
	/**��������*/
	protected String birthday;
	
	/**���֤��ַ*/
	protected String address;
	
	/**��ϵ�绰*/
	protected String phone;
	
	/**�����ʼ�*/
	protected String email;
	
	/**ѧ��*/
	protected String degree;
	
	/**��ҵԺУ*/
	protected String school;
	
	/**����id*/
	protected Integer did;
	
	/**Ȩ����id*/
	protected String groupid;  			
	
	protected Integer eid;
	
	protected String method;
	
	protected String[] groupids;
	
	private String logoPathdir = "/images/brand/logo/" + getDatestring() + "/";
	


	
	@SuppressWarnings("unchecked")
	@Override
	public QueryResult<Employee> getQueryResult()
	{
		return eImpl.getScrollData(Employee.class, (getCurrpage()-1)*maxresult, maxresult, getWherehql(), getOrderby("eid", "asc"));
	}

	@Override
	public String getWherehql()
	{
		String hql="";
		if(logoname!=null && !"".equals(logoname.trim()))
		{
			hql+="where o.logoname='"+logoname+"'";
			return hql;
		}
		else if(realname!=null && !"".equals(realname.trim()))
		{
			hql+="where o.employeename='"+realname+"'";
			return hql;
		}
		else if(did!=null)
		{
			hql+="where o.department.did="+did;
			return hql;
		}
		return null;
	}

	public String getLogoname()
	{
		return logoname;
	}

	public void setLogoname(String logoname)
	{
		this.logoname = logoname;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRealname()
	{
		return realname;
	}

	public void setRealname(String realname)
	{
		this.realname = realname;
	}

	public Gender getSex()
	{
		return sex;
	}

	public void setSex(Gender sex)
	{
		this.sex = sex;
	}

	public File getImagefile()
	{
		return imagefile;
	}

	public void setImagefile(File imagefile)
	{
		this.imagefile = imagefile;
	}

	public String getIdNo()
	{
		return idNo;
	}

	public void setIdNo(String idNo)
	{
		this.idNo = idNo;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getDegree()
	{
		return degree;
	}

	public void setDegree(String degree)
	{
		this.degree = degree;
	}

	public String getSchool()
	{
		return school;
	}

	public void setSchool(String school)
	{
		this.school = school;
	}

	public Integer getDid()
	{
		return did;
	}

	public void setDid(Integer did)
	{
		this.did = did;
	}

	public String getGroupid()
	{
		return groupid;
	}

	public void setGroupid(String groupid)
	{
		this.groupid = groupid;
	}

	@Override
	public String getLogoPathdir()
	{
		return logoPathdir;
	}
	@Override
	public String getLogoRealPath()
	{
		return session.getServletContext().getRealPath(logoPathdir);
	}
	@Override
	public String createLogoname()
	{
		return UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(imagefile.getName());
	}
	@Override
	public File createLogoFile(String logoRealPath,String logoname)
	{
		return new File(logoRealPath,logoname);
	}
	
	@Override
	public String getLogopathIntable(String filename)
	{
		return "/shopping"+logoPathdir+filename;
	}

	public Integer getEid()
	{
		return eid;
	}

	public void setEid(Integer eid)
	{
		this.eid = eid;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String[] getGroupids()
	{
		return groupids;
	}

	public void setGroupids(String[] groupids)
	{
		this.groupids = groupids;
	}



}
