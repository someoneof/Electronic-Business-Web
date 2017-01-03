package myshop.web.page;

import java.util.List;

/**
 * ÿһҳ��ϢӦ�ð���������:PageIndex(jspҳ����ʾ����βҳ),QueryResult(ÿһҳ�Ľ����,�ܼ�¼��)
 * 					 ÿһҳ�ļ�¼����maxresult,��ҳ��totalPage
 * @author ����
 *
 * @param <T>
 */
public class PageView<T> {

	/**ÿһҳ�Ľ����**/
	private List<T> record;
	/**��ǰҳ**/
	private int currpage;
	/**��ҳ��**/
	private long totalPage;
	/**��βҳ*/
	private PageIndex pageIndex;
	/**�ܼ�¼��*/
	private long totalRecord;
	/**ÿһҳ��¼��*/
	private int maxresult=12;
	
	public PageView(int currpage, int maxresult)
	{
		this.currpage = currpage;
		this.maxresult = maxresult;
	}
	
	public void setQueryResult(QueryResult<T> qr)
	{
		setTotalRecord(qr.getTotalRecord());
		setRecord(qr.getList());
		System.out.println(qr.getList().toString());
	}
	
	public List<T> getRecord()
	{
		return record;
	}

	public void setRecord(List<T> records)
	{
		this.record = records;
	}

	public void setPageIndex(PageIndex pageIndex)
	{
		this.pageIndex = pageIndex;
	}

	public int getCurrpage()
	{
		return currpage;
	}
	public void setCurrpage(int currpage)
	{
		this.currpage = currpage;
	}
	public long getTotalPage()
	{
		return totalPage;
	}
	public void setTotalPage(long totalPage)
	{	
		this.totalPage = totalPage;
		this.pageIndex=WebTool.getPageIndex(maxresult, currpage, totalPage);
	}
	public PageIndex getPageIndex()
	{
		return pageIndex;
	}
	public long getTotalRecord()
	{
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord)
	{	
		this.totalRecord = totalRecord;
		setTotalPage(this.totalRecord%maxresult==0?this.totalRecord/maxresult:this.totalRecord/maxresult+1);
	}
	public int getMaxresult()
	{
		return maxresult;
	}
	public void setMaxresult(int maxresult)
	{
		this.maxresult = maxresult;
	}

}
