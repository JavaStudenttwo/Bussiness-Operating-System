package cn.itcast.bos.service.impl;

import cn.itcast.bos.dao.IUserDao;
import cn.itcast.bos.domain.User;
import cn.itcast.bos.service.IUserService;
import cn.itcast.bos.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Date 2017/10/10 14:50
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.service.impl
 * @ClassName: UserServiceImpl
 * @Description: 用户相关业务处理
 *
 */
@Service(value = "userService")
@Transactional(readOnly=true)
public class UserServiceImpl implements IUserService {

	@Resource(name = "userDao")
	private IUserDao userDao;

	/**
	 * @Date 2017/10/10 14:51
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: login
	 * @Params: [user]
	 * @ReturnType: cn.itcast.bos.domain.User
	 * @Description: 用户登录
	 *
	 */
	@Override
	public User login(User user) {
		/**使用MD5加密密码*/
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
	}

	/**
	 * @Date 2017/10/10 14:51
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: editPsw
	 * @Params: [id, password]
	 * @ReturnType: void
	 * @Description: 用户密码修改
	 *
	 */
	@Override
	@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=false)
	public void editPsw(User user) {

		user.setPassword(MD5Utils.md5(user.getPassword()));

		userDao.beanUpdate(user);
	}



















}
