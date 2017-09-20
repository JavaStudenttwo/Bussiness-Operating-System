package cn.itcast.bos.web.interceptor;

import cn.itcast.bos.domain.User;
import cn.itcast.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;

public class BOSLoginIntercepter extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //从session中获取用户对象
//        User user = BOSUtils.getLoginUser();
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if(user == null){
            //没有登录，跳转到登录页面
            return "login";
        }
        //放行
        return actionInvocation.invoke();

    }
}
