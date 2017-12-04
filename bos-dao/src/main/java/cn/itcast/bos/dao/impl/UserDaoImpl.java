package cn.itcast.bos.dao.impl;

import java.util.List;

import cn.itcast.bos.dao.IUserDao;
import cn.itcast.bos.dao.base.impl.BaseDaoImpl;
import cn.itcast.bos.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Date 2017/10/10 14:58
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.dao.impl
 * @ClassName: UserDaoImpl
 * @Description:
 *
 */
@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	/**
	 * @Date 2017/10/10 14:57
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: findUserByUsernameAndPassword
	 * @Params: [username, password]
	 * @ReturnType: cn.itcast.bos.domain.User
	 * @Description:
	 *
	 */

	public User findUserByUsernameAndPassword(String username, String password) {

		String hql = "FROM User u WHERE u.username = ? AND u.password = ?";

		List<User> list = (List<User>) super.getHibernateTemplate().find(hql, username,password);

		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;

	}

	/**
	 * @Date 2017/10/22 20:14
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: beanUpdate
	 * @Params: [password, id]
	 * @ReturnType: void
	 * @Description: 通过Hibernate的一级缓存更改数据（快照更新）
	 *
	 */
	@Override
	public void beanUpdate(User user) {
		update(user);
	}


}
