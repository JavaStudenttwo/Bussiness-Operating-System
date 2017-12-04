package cn.itcast.bos.dao.base.impl;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.annotation.Resource;

import cn.itcast.bos.dao.base.IBaseDao;
import cn.itcast.bos.domain.PageBean;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Date 2017/10/10 14:54
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.dao.base.impl
 * @ClassName: BaseDaoImpl
 * @Description: 抽取了基本的操作数据库的方法
 *
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	/**代表的是某个实体的类型*/
	private Class<T> entityClass;

	/**使用注解则必须将父类HibernateDaoSupport中的SessionFactory注入*/
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * @Date 2017/10/10 14:55
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: BaseDaoImpl
	 * @Params: []
	 * @ReturnType:
	 * @Description: 在父类（BaseDaoImpl）的构造方法中动态获得entityClass
	 *
	 */
	public BaseDaoImpl() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		/**获得父类上声明的泛型数组*/
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}


	/**
	 * @Date 2017/12/3 23:18
	 * @Author CycloneKid sk18810356@gmail.com
	 * @PackageName: cn.itcast.bos.dao.base.impl
	 * @ClassName: BaseDaoImpl
	 * @Description: 查询对应表中所有的数据
	 *
	 */
	@Override
	public List<T> findAll() {
		/**getSimpleName()方法，返回源代码中给出的底层类的简称。如果底层类是匿名的则返回一个空字符串*/
		String hql = "FROM " + entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	/**
	 * @Date 2017/12/3 23:18
	 * @Author CycloneKid sk18810356@gmail.com
	 * @PackageName: cn.itcast.bos.dao.base.impl
	 * @ClassName: BaseDaoImpl
	 * @Description: 修改对应表中数据
	 *
	 */
	@Override
	public void executeUpdate(String queryName, Object... objects) {

		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		int i = 1;
		for (Object object:objects){
			query.setParameter(i++,object);
		}
		query.executeUpdate();
	}


	/**数据库查询方法*/
	@Override
	public List<T> findCollectionByConditionNoPage(String condition,
												   final Object[] params, Map<String, String> orderby) {
		/**
		 * 1.先写出hql语句的基本内容
		 */
		String hql = "from "+entityClass.getSimpleName()+" o where 1=1 ";
		/**
		 * 2.添加查询结果的排序约束
		 * 将Map集合中存放的字段排序，组织成ORDER BY o.textDate ASC,o.textName DESC
		 */
		String orderbyCondition = this.orderbyHql(orderby);
		/**
		 * 3.将各个语句结合拼装成最终的hql语句
		 */
		final String finalHql = hql + condition + orderbyCondition;

		List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(finalHql);
				if(params!=null && params.length>0){
					for(int i=0;i<params.length;i++){
						query.setParameter(i, params[i]);
					}
				}
				return query.list();
			}

		});
		return list;
	}

	/**
	 * @Date 2017/10/10 14:56
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: pageQuery
	 * @Params: [pageBean]
	 * @ReturnType: void
	 * @Description: 分页查询方法
	 *
	 */
	@Override
	public PageBean<T> pageQuery(PageBean pageBean){

		/**获取查询参数*/
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();

		/**查询数据库获取数据总数*/
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);

		Long count = countList.get(0);
		pageBean.setTotal(count.intValue());

		/**组织查询参数*/
		detachedCriteria.setProjection(null);
		int firstResult = (currentPage-1)*pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria,firstResult,maxResults);
		pageBean.setRows(rows);

		return pageBean;

	}

	/**
	 * @Date 2017/12/4 22:15
	 * @Author CycloneKid sk18810356@gmail.com
	 * @PackageName: cn.itcast.bos.dao.base.impl
	 * @ClassName: BaseDaoImpl
	 * @Description: 测试detachedCriteria
	 *
	 */
	@Override
	public PageBean<T> testPageQuery(PageBean pageBean){

		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		pageBean.setRows(rows);

		return pageBean;

	}

	/**
	 * @Date 2017/12/3 23:16
	 * @Author CycloneKid sk18810356@gmail.com
	 * @PackageName: cn.itcast.bos.dao.base.impl
	 * @ClassName: BaseDaoImpl
	 * @Description: 功能方法
	 *
 	 * 将Map集合中存放的字段排序，组织成
	 * ORDER BY o.textDate ASC,o.textName DESC
	 *
	 * map集合orderby内，key值为属性名，例如 o.textDate
	 *                 value值为排序方式，例如 DESC(降序)
	 *                 加起来组成的语句 o.textDate DESC 的含义是按textDate降序
	 *
	 */
	private String orderbyHql(Map<String, String> orderby) {

		StringBuffer buffer = new StringBuffer("");
		if(orderby!=null && orderby.size()>0){
			buffer.append(" ORDER BY ");
			for(Map.Entry<String, String> map:orderby.entrySet()){
				buffer.append(map.getKey()+" "+map.getValue()+",");
			}
			/**在循环后，删除最后一个逗号*/
			buffer.deleteCharAt(buffer.length()-1);
		}
		return buffer.toString();
	}











}
