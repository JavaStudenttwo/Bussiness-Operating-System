package cn.itcast.bos.dao;


import cn.itcast.bos.dao.base.IBaseDao;
import cn.itcast.bos.domain.User;

/**
 * @Date 2017/10/10 14:58
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.dao
 * @ClassName: IUserDao
 * @Description:
 *
 */
public interface IUserDao extends IBaseDao<User> {

	public User findUserByUsernameAndPassword(String username, String password);

    void beanUpdate(User user);
}
