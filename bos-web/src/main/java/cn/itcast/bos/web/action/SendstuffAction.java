package cn.itcast.bos.web.action;

import cn.itcast.bos.domain.TStuff;
import cn.itcast.bos.service.StuffService;
import cn.itcast.bos.service.impl.StuffServiceImpl;
import cn.itcast.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by 13718 on 2017/9/10.
 */

@Controller
@Scope("prototype")
public class SendstuffAction extends BaseAction<TStuff>{

    @Autowired
    StuffService stuffService = new StuffServiceImpl();

//    添加取派员
    public String addStuff(){
//        stuffService.addStuff(model);
        return "ADD";
    }

}
