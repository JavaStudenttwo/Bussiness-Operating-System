package cn.itcast.bos.dao.impl;


import cn.itcast.bos.dao.IStuffDao;
import cn.itcast.bos.dao.base.impl.BaseDaoImpl;
import cn.itcast.bos.domain.PageBean;
import cn.itcast.bos.domain.TStuff;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @Date 2017/10/10 14:57
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.dao.impl
 * @ClassName: StuffDaoImpl
 * @Description: 取派员
 *
 */
@Repository(value = "stuffDao")
public class StuffDaoImpl extends BaseDaoImpl<TStuff> implements IStuffDao {

    @Override
    public void saveStuff(TStuff tStuff) {
        save(tStuff);
    }
}
