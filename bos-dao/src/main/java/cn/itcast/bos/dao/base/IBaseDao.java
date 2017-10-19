package cn.itcast.bos.dao.base;

import cn.itcast.bos.domain.PageBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Date 2017/10/10 14:56
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.dao.base
 * @ClassName: IBaseDao
 * @Description:
 *
 */
public interface IBaseDao<T> {

    /*public void save(T entity);

	public void delete(T entity);

	public void update(T entity);

	public T findById(Serializable id);

	public List<T> findAll();

	public void executeUpdate(String queryName,Object... objects);

	List<T> findCollectionByConditionNoPage(String condition, Object[] params, Map<String, String> orderby);

	public void pageQuery(PageBean pageBean);*/
}
