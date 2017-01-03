package junitTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class createTable {

	@Test
	public void test()
	{
		Configuration cfg = new AnnotationConfiguration().configure();
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
	}
	@Test
	public void testprint()
	{
		String url="<s:url action="+"\"productTypeAction_findAllType\""+" namespace=\"/control\"/>?parentid=parentid";
		System.out.println(url);
	}
	@Test
	public void testTime()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=df.format(new Date());
		System.out.println(date);
		String str=date.substring(0, 4)+date.substring(5,7)+date.substring(8,10)+date.substring(11,13)+date.substring(14,16)+date.substring(17);
		System.out.println(str);
	}
	

	@Test
	public void testtoString()
	{
		String url="moduel,delete";
		String[] moduel=url.split(",");
		for(int i=0;i<moduel.length;i++)
		System.out.println(moduel[i]);
	}
}
