package cn.itcast.bos.service;

import cn.itcast.bos.domain.PageBean;
import cn.itcast.bos.domain.TStuff;

/**
 * Created by 13718 on 2017/9/10.
 */
public interface StuffService {

    public static final String SERVICE_NAEM = "cn.itcast.bos.service.impl.StuffServiceImpl";

    void addStuff(TStuff model);

    void pageQuery(PageBean pageBean);
}
