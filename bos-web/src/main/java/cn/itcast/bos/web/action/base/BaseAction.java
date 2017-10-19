package cn.itcast.bos.web.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * @Date 2017/10/10 14:33
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.web.action.base
 * @ClassName: BaseAction
 * @Description: 抽取了和模型驱动相关的操作
 *
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	public static final String HOME = "home";
	
	/**模型对象*/
	protected T model;
	public T getModel() {
		return model;
	}

	/**
	 * @Date 2017/10/10 14:33
	 * @Author CycloneKid sk18810356@gmail.com
	 * @MethodName: BaseAction
	 * @Params: []
	 * @ReturnType:
	 * @Description: 构造方法，每个继承该类的的对象都会执行该方法
	 *
	 */
	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		/**获得泛型类*/
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		/**创建泛型类的实例*/
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
