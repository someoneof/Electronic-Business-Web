package myshop.web.actionForm;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myshop.web.AddImage.BaseImage;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport implements BaseImage,ServletRequestAware, ServletResponseAware, ServletContextAware{

	private static final long serialVersionUID = 9106924720226686858L;

	protected HttpServletRequest request; // �������
	protected HttpServletResponse response; // ��Ӧ����
	protected HttpSession session; // �Ự����
	protected ServletContext application; // ȫ�ֶ���
	
	protected SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/HH");
	
	public void setLogo(File fileInContext,File logofile) throws IOException 
	{
		byte[] buffer = new byte[1024];
		int length = 0;
		OutputStream os=null;
		InputStream is=null;
		try{
			os = new FileOutputStream(fileInContext);   //tomcat�±�д����Ϣ���ļ�
			is = new FileInputStream(logofile);   //jspҳ�洫�������ļ�
			while ((length = is.read(buffer)) > 0)
				{
					os.write(buffer, 0, length);
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			os.close();
			is.close();
		}
	}

	@Override
	public void createFileInContext(String logoRealPath)
	{
		File file=new File(logoRealPath);
		if(!file.exists())
			file.mkdirs();
	}
	
	
	/**�õ���ʽ������ַ�������**/
	public String getDatestring()
	{ 
		return df.format(new Date());
	}
	/**�õ���ʽ���������**/
	public Date getFormatDate() 
	{
		try
		{
			return df.parse(df.format(new Date()));
		} catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void setServletContext(ServletContext application)
	{
		this.application = application;
	}

	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
		this.session = this.request.getSession();
	}
}
