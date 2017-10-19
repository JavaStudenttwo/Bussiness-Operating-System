package cn.itcast.bos.web.interceptor;

import cn.itcast.bos.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * @Date 2017/10/10 14:42
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.web.interceptor
 * @ClassName: BOSLoginIntercepter
 * @Description: 用户登录拦截，如果用户没有登录，则转到登录页面
 *
 */
public class BOSLoginIntercepter extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if(user == null){
            return "login";
        }
        return actionInvocation.invoke();

    }
}
