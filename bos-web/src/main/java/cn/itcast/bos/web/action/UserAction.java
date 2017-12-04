package cn.itcast.bos.web.action;

import cn.itcast.bos.domain.User;
import cn.itcast.bos.service.IUserService;
import cn.itcast.bos.web.action.base.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Date 2017/10/10 14:38
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.web.action
 * @ClassName: UserAction
 * @Description: 处理和用户相关的请求
 *
 */
@Controller(value = "userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	User userFrom = this.getModel();

	/**属性驱动，接收页面输入的验证码*/
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	@Resource(name = "userService")
	private IUserService userService;

	/**
	 * @Date 2017/10/10 14:39
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: login
	 * @Params: []
	 * @ReturnType: java.lang.String
	 * @Description:
	 *
	 */
	public String login() {

		/**获取验证码的答案*/
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		/**校验验证码*/
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
			User user = userService.login(userFrom);
			if(user != null){
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				return HOME;
			}else{
				this.addActionError("用户名或者密码输入错误！");
				return LOGIN;
			}
		}else{
			this.addActionError("输入的验证码错误！");
			return LOGIN;
		}
	}

	/**
	 * @Date 2017/10/10 14:41
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: logout
	 * @Params: []
	 * @ReturnType: java.lang.String
	 * @Description: 用户退出
	 *
	 */
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}

	/**
	 * @Date 2017/10/10 14:41
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: editPsw
	 * @Params: []
	 * @ReturnType: java.lang.String
	 * @Description: 修改密码
	 *
	 */
	public String editPsw() throws IOException {

		String callback = "OK";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");

		user.setPassword(model.getPassword());
		userService.editPsw(user);

		/**更新session中的用户信息*/
		ServletActionContext.getRequest().getSession().setAttribute("loginUser",user);

		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		/**
		 * 没有正确的返回AJAX数据，密码修改完后页面不能显示正常信息！！！
		 *
		 * */
		ServletActionContext.getResponse().getWriter().println(callback);

		return HOME;

	}






























}
