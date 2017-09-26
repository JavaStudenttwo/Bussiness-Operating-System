package cn.itcast.bos.dao.base;

import cn.itcast.bos.domain.PageBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 持久层通用接口
 * @author zhaoqx
 *
 * @param <T>
 */
public interface IBaseDao<T> {
    public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	public void executeUpdate(String queryName,Object... objects);


	List<T> findCollectionByConditionNoPage(String condition, Object[] params, Map<String, String> orderby);

	public void pageQuery(PageBean pageBean);
}
