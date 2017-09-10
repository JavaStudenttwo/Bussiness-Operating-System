package cn.itcast.bos.utils;

import cn.itcast.bos.domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by 13718 on 2017/9/10.
 */
public class BOSUtils {
    public static HttpSession getSession(){
        return ServletActionContext.getRequest().getSession();
    }

    public static User getLoginUser(){
        return (User)getSession().getAttribute("loginUser");
    }




















}
