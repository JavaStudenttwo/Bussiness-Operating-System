package cn.itcast.bos.service.impl;

import cn.itcast.bos.dao.StuffDao;
import cn.itcast.bos.dao.impl.StuffDaoImpl;
import cn.itcast.bos.domain.PageBean;
import cn.itcast.bos.domain.TStuff;
import cn.itcast.bos.service.IStuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Date 2017/10/10 14:49
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.service.impl
 * @ClassName: StuffServiceImpl
 * @Description: 取派员相关业务处理
 *
 */
@Service
@Transactional(readOnly=true)
public class StuffServiceImpl implements IStuffService {

    @Autowired
    StuffDao stuffDao = new StuffDaoImpl();

    /**
     * @Date 2017/10/10 14:49
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: addStuff
     * @Params: [model]
     * @ReturnType: void
     * @Description: 取派员添加
     *
     */
    @Override
    @Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=false)
    public void addStuff(TStuff model) {
//        stuffDao.save(model);
    }

    /**
     * @Date 2017/10/10 14:50
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: pageQuery
     * @Params: [pageBean]
     * @ReturnType: void
     * @Description: 分页查询取派员
     *
     */
    @Override
    public void pageQuery(PageBean pageBean) {

//        stuffDao.pageQuery(pageBean);
    }


}
