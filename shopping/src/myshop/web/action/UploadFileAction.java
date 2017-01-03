package myshop.web.action;

import myshop.bean.UploadFile;
import myshop.web.actionForm.UploadFileForm;
import myshop.web.page.PageView;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class UploadFileAction extends UploadFileForm {

	private static final long serialVersionUID = 6193505790844356770L;

	public String findAllfile()
	{
		PageView<UploadFile> pageView = getPageView(getCurrpage(), 12);//设置每页显示的数量
		pageView.setQueryResult(getQueryResult());
		setAttribute("pageView", pageView);
		return "find";
	}

}
