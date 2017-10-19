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

    @Autowired
    IStuffService IStuffService = new StuffServiceImpl();

    /**添加取派员*/
    public String addStuff(){
        IStuffService.addStuff(model);
        return "ADD";
    }

    /**
     * @Date 2017/10/10 12:26
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: list
     * @Params: []
     * @ReturnType: java.lang.String
     * @Description:13718
     *
     */
    public String list() throws IOException {

        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TStuff.class);
        pageBean.setDetachedCriteria(detachedCriteria);
        IStuffService.pageQuery(pageBean);

        Gson gson = new Gson();
        String json = gson.toJson(pageBean.getRows());

        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(json);

        return "LIST";
    }







}
