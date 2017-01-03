package junitTest;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import myshop.bean.UploadFile;
import myshop.service.UploadFileService;
import myshop.web.page.QueryResult;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class uploadSErviceImpl {

	static ApplicationContext ctx;
	static UploadFileService serviceImpl;

	@BeforeClass
	public static void before()
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		serviceImpl = (UploadFileService) ctx.getBean("uploadFileServiceImpl");
	}

	@Test
	public void test()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testfindAll()
	{
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("fileid", "asc");
		QueryResult<UploadFile> qr = serviceImpl.getScrollData(
				UploadFile.class, 1, 5, null, orderby);
		System.out.println(qr.getList().toString());
	}

	@Test
	public void testsave() throws ParseException
	{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd/HH");

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String df1 = df.format(new Date());
		for (int i = 0; i < 10; i++)
		{
			String dateformat = sf.format(new Date());
			Date date = df.parse(df1);
			UploadFile file = new UploadFile();
			file.setFilepath("/file/" + dateformat + "/");
			file.setUploadtime(date);
			serviceImpl.save(file);
		}
	}
}
