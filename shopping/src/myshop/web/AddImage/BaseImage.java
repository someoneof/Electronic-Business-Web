package myshop.web.AddImage;

import java.io.File;
import java.io.IOException;

public interface BaseImage {

	
	/**
	 * 在tomcat下创建一个文件,此时文件内容为空
	 * @param logoRealPath logo在容器下的全路径
	 */
	abstract void createFileInContext(String logoRealPath);
	
	/**
	 * jsp页面传过来的图片信息写入到tomcat下以filename为文件名的文件
	 * @param fileInContext  待写入的文件
	 * @param jspfile		 jsp传过来的图片
	 * @throws IOException
	 */
	abstract void setLogo(File fileInContext,File jspfile) throws IOException;
	
}
