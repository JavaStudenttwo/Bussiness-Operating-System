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

	/**通用保存方法*/
	void save(T entity);
	/**通用删除方法*/
	void delete(T entity);
	/**通用更改方法*/
	void update(T entity);
	/**通用查询方法，根据id查询*/
	T findById(Serializable id);
	/**通用查询方法，查询所有*/
	List<T> findAll();
	/**通用修改方法，适用于有多个参数时*/
	void executeUpdate(String queryName, Object... objects);
	/**不分页地查询一组数据*/
	List<T> findCollectionByConditionNoPage(String condition,
											Object[] params, Map<String, String> orderby);
	/**分页查询*/
	PageBean<T> pageQuery(PageBean pageBean);

	PageBean<T> testPageQuery(PageBean pageBean);
}
