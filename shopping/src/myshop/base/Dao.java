package myshop.base;

import java.util.LinkedHashMap;

import myshop.web.page.QueryResult;

public interface Dao<T> {

	void save(Object o);

	void update(Object o);

	void delete(Class<T> entityClass, int id);

	void delete(Class<T> entityClass, int[] id);

	T find(Class<T> entityClass, int id);

	QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex,int pagecount, String wherehql,LinkedHashMap<String, String> orderby);

	QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex,int pagecount, String wherehql);

	QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex,int pagecount);

	QueryResult<T> getScrollData(Class<T> entityClass,LinkedHashMap<String, String> orderby);

	QueryResult<T> getScrollData(Class<T> entityClass);

}
