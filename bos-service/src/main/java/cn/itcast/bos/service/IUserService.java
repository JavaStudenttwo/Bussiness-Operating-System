package cn.itcast.bos.service;


import cn.itcast.bos.domain.User;

/**
 * @Date 2017/10/10 14:53
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.service
 * @ClassName: IUserService
 * @Description: 用户业务接口
 *
 */
public interface IUserService {

	public User login(User model);

    void editPsw(User user);

}
