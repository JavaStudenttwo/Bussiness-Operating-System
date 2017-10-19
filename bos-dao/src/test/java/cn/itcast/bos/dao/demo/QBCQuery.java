package cn.itcast.bos.dao.demo;

import cn.itcast.bos.domain.PageBean;
import cn.itcast.bos.domain.TStuff;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.Configuration;
import java.util.List;

@Transactional
public class QBCQuery extends HibernateDaoSupport{


    @Test
    public void basicQuery(){

//        Session session = this.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//
//        Criteria criteria = session.createCriteria(TStuff.class);
//        List<TStuff> list = criteria.list();
//
//        for (TStuff tStuff : list){
//            System.out.println(tStuff);
//        }
//        tx.commit();
//        session.close();

    }

    @Test
    public void conditionQuery(){

        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(TStuff.class);
        criteria.add(Restrictions.eq("id","1"));
        List<TStuff> list = criteria.list();

        for (TStuff tStuff : list){
            System.out.println(tStuff);
        }
        tx.commit();
        session.close();

    }

    @Test
    public void paginationQuery(){

        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(PageBean.class);
        criteria.setFirstResult(5);
        criteria.setMaxResults(5);

        List<PageBean> list = criteria.list();

        for (PageBean pageBean : list){
            System.out.println(pageBean.getRows());
        }
        tx.commit();
        session.close();

    }

    @Test
    public void orderQuery(){

        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(TStuff.class);
        criteria.addOrder(Order.asc("id"));
        List<TStuff> list = criteria.list();

        for (TStuff tStuff : list){
            System.out.println(tStuff);
        }
        tx.commit();
        session.close();

    }

    @Test
    public void totalQuery(){

        Session session = this.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(TStuff.class);
        criteria.setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();

        System.out.println(count);
        tx.commit();
        session.close();

    }
}
