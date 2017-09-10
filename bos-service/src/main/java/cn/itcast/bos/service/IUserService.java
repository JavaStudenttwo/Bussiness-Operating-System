package cn.itcast.bos.service;


import cn.itcast.bos.domain.User;

public interface IUserService {

	public User login(User model);

    void editPassword(String id, String password);
}
