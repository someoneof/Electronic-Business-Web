package myshop.web.page;

import java.util.List;

public class QueryResult<T> {

	/**ÿһҳ�Ĳ�ѯ�����**/
	private List<T> list;
	
	/**�ܼ�¼��**/
	private long totalRecord;

	public List<T> getList()
	{
		return list;
	}

	public void setList(List<T> list)
	{
		this.list = list;
	}

	public long getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord)
	{
		this.totalRecord = totalRecord;
	}

	@Override
	public String toString()
	{
		return list.toString();
	}
	
	
}
