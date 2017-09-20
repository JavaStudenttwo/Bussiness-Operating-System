package cn.itcast.bos.service.impl;

import cn.itcast.bos.dao.IUserDao;
import cn.itcast.bos.domain.User;
import cn.itcast.bos.service.IUserService;
import cn.itcast.bos.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	/***
	 * 用户登录
	 */
	public User login(User user) {
		//使用MD5加密密码
//		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
	}

	@Override
	public void editPassword(String id, String password) {
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}




















}
