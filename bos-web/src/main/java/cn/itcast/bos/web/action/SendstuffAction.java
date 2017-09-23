package cn.itcast.bos.web.action;

import cn.itcast.bos.domain.PageBean;
import cn.itcast.bos.domain.TStuff;
import cn.itcast.bos.service.StuffService;
import cn.itcast.bos.service.impl.StuffServiceImpl;
import cn.itcast.bos.web.action.base.BaseAction;
import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.Servlet;
import java.io.IOException;

/**
 * Created by 13718 on 2017/9/10.
 */

@Controller(value = "sendstuffAction")
@Scope("prototype")
public class SendstuffAction extends BaseAction<TStuff>{


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
    StuffService stuffService = new StuffServiceImpl();

//    添加取派员
    public String addStuff(){
        stuffService.addStuff(model);
        return "ADD";
    }

    public String list() throws IOException {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TStuff.class);
        pageBean.setDetachedCriteria(detachedCriteria);
        stuffService.pageQuery(pageBean);

        Gson gson = new Gson();
        String json = gson.toJson(pageBean);
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(json);
        return "LIST";
    }

























}
