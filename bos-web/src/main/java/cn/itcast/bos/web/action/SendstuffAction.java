package cn.itcast.bos.web.action;

import cn.itcast.bos.domain.PageBean;
import cn.itcast.bos.domain.TStuff;
import cn.itcast.bos.service.IStuffService;
import cn.itcast.bos.service.impl.StuffServiceImpl;
import cn.itcast.bos.web.action.base.BaseAction;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Date 2017/10/10 12:26
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.web.action
 * @ClassName: SendstuffAction
 * @Description: 处理和取派员相关的请求
 *
 */
@Controller(value = "sendstuffAction")
@Scope("prototype")
public class SendstuffAction extends BaseAction<TStuff>{


    /**使用属性驱动的方式从页面获取page和rows*/
    int page;
    int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Resource(name = "stuffService")
    IStuffService iStuffService = new StuffServiceImpl();

    /**添加取派员*/
    public String addStuff(){
        iStuffService.addStuff(model);
        return "ADD";
    }

    /**
     * @Date 2017/10/10 12:26
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: list
     * @Params: []
     * @ReturnType: java.lang.String
     * @Description: 查询所有取派员的信息
     *
     */
    public String list() throws IOException {

        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);

        /**使用Criteria的离线查询方式*/
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TStuff.class);
        pageBean.setDetachedCriteria(detachedCriteria);

        pageBean = iStuffService.pageQuery(pageBean);

        /**将查询出的数据转换成json格式返回到前端*/
        Gson gson = new Gson();
        String json = gson.toJson(pageBean.getRows());

        /**返回数据*/
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(json);

        /**
         * 为什么这里返回的是NONE???
         *
         * */
        return NONE;
    }







}
