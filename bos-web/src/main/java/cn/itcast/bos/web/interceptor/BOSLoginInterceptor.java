package cn.itcast.bos.web.interceptor;

import cn.itcast.bos.domain.User;
import cn.itcast.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by 13718 on 2017/9/10.
 */
public class BOSLoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        User user = BOSUtils.getLoginUser();
        if ( user == null){
            return "login";
        }

        return actionInvocation.invoke();
    }














}
