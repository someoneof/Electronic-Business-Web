package myshop.web.AddImage;

import java.io.File;

public interface AddImage {
	
	/* 先设置存放图片的路径,再创建一个filename,然后由这个filename创建一个文件,将jsp传过来的logofile写入这个文件.
	 * 
	 * public String getLogoRealPath(){return request.getSession().getServletContext().getRealPath(getLogoPathdir());}
	 * 
	 * createFileInContext(){  File file=new File(getLogoRealPath()); if(!file.exist()) file.mirks();}
	 * 
	 * String filename=createLogoname();
	 * 
	 * setLogo(new File(filename),logofile);
	 * 
	 * */
	
	/**得到图片在项目下的路径*/
	abstract String getLogoPathdir();
	
	/**得到logo在tomcat下的路径*/
	abstract String getLogoRealPath();
	
	/**创建logo的文件名*/
	abstract String createLogoname(); //FilenameUtils.getExtension(logoname)
	
	/**
	 * 创建logo文件
	 * @param logoRealPath  图片在tomcat容器下的路径
	 * @param filename		图片的名称
	 * @return
	 */
	abstract File createLogoFile(String logoRealPath,String logoname);
	
	/**
	 * 图片保存在数据表中的路径
	 * @param filename 文件名
	 * @return
	 */
	abstract String getLogopathIntable(String filename);
	
	
}
