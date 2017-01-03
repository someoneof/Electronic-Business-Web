package myshop.web.AddImage;

import java.io.File;
import java.io.IOException;

public interface BaseImage {

	
	/**
	 * ��tomcat�´���һ���ļ�,��ʱ�ļ�����Ϊ��
	 * @param logoRealPath logo�������µ�ȫ·��
	 */
	abstract void createFileInContext(String logoRealPath);
	
	/**
	 * jspҳ�洫������ͼƬ��Ϣд�뵽tomcat����filenameΪ�ļ������ļ�
	 * @param fileInContext  ��д����ļ�
	 * @param jspfile		 jsp��������ͼƬ
	 * @throws IOException
	 */
	abstract void setLogo(File fileInContext,File jspfile) throws IOException;
	
}
