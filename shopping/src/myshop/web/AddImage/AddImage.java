package myshop.web.AddImage;

import java.io.File;

public interface AddImage {
	
	/* �����ô��ͼƬ��·��,�ٴ���һ��filename,Ȼ�������filename����һ���ļ�,��jsp��������logofileд������ļ�.
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
	
	/**�õ�ͼƬ����Ŀ�µ�·��*/
	abstract String getLogoPathdir();
	
	/**�õ�logo��tomcat�µ�·��*/
	abstract String getLogoRealPath();
	
	/**����logo���ļ���*/
	abstract String createLogoname(); //FilenameUtils.getExtension(logoname)
	
	/**
	 * ����logo�ļ�
	 * @param logoRealPath  ͼƬ��tomcat�����µ�·��
	 * @param filename		ͼƬ������
	 * @return
	 */
	abstract File createLogoFile(String logoRealPath,String logoname);
	
	/**
	 * ͼƬ���������ݱ��е�·��
	 * @param filename �ļ���
	 * @return
	 */
	abstract String getLogopathIntable(String filename);
	
	
}
