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
@Repository
public class StuffDaoImpl extends BaseDaoImpl<TStuff> implements IStuffDao {

    /**
     * @Date 2017/10/19 16:13
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: pageQuery
     * @Params: [pageBean]
     * @ReturnType: void
     * @Description:
     *
     */
    @Override
    public PageBean pageQuery(PageBean<TStuff> pageBean) {

        int currentPage = pageBean.getCurrentPage();
        int pageSize =  pageBean.getPageSize();
        DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();

        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);

        Long count = countList.get(0);
        pageBean.setTotal(count.intValue());

        detachedCriteria.setProjection(null);
        int firstResult = (currentPage-1)*pageSize;
        int maxResults = pageSize;
        List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria,firstResult,maxResults);
        pageBean.setRows(rows);

        return pageBean;
    }

    @Override
    public void save(TStuff tStuff) {

        this.getHibernateTemplate().save(tStuff);

    }
}
