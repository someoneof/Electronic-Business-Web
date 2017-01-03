package myshop.web.actionForm;

import myshop.bean.UploadFile;
import myshop.service.UploadFileService;
import myshop.web.page.PageViewBase;
import myshop.web.page.QueryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class UploadFileForm extends PageViewBase {

	private static final long serialVersionUID = -320775858582547291L;
	
	protected Integer[] ids;
	@Autowired
	private UploadFileService serviceImpl;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public  QueryResult<UploadFile> getQueryResult()
	{
		
		return serviceImpl.getScrollData(UploadFile.class,(getCurrpage() - 1) * maxresult, maxresult,null,getOrderby("fileid","asc"));
	}

	@Override
	public String getWherehql()
	{
		return null;
	}

	public UploadFileService getServiceImpl()
	{
		return serviceImpl;
	}

	public void setServiceImpl(UploadFileService serviceImpl)
	{
		this.serviceImpl = serviceImpl;
	}

}
