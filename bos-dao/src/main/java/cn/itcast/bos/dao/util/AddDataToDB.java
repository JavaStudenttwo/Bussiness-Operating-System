package cn.itcast.bos.dao.util;

import cn.itcast.bos.dao.StuffDao;
import cn.itcast.bos.dao.impl.StuffDaoImpl;
import cn.itcast.bos.data.JsonTransform;
import cn.itcast.bos.domain.TStuff;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import javax.net.ssl.SSLEngineResult;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class AddDataToDB {

    /**加载配置文件*/
    org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure();
    /**创建一个SessionFactory类型的对象*/
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    @Test
    public void doAdd() throws InvocationTargetException, IllegalAccessException {

        /**使用sessionFactory对象创建session对象*/
        Session session = sessionFactory.openSession();
        /**开启事务*/
        Transaction transaction = session.beginTransaction();

//        StuffDao stuffDao = new StuffDaoImpl();

        JsonTransform<Map<String,String>> jsonTransform = new JsonTransform<Map<String,String>>();
        String json = "[\n" +
                "\t\t{\"name\":\"李大\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小红\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小明\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"王五\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"hshi\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小红\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小明\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"王五\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"hshi\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小红\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小明\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"王五\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"hshi\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小红\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小明\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"王五\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"hshi\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小红\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小明\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"王五\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"hshi\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小红\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小明\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"王五\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"hshi\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小红\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"小明\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"王五\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"hshi\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"},\n" +
                "\t\t{\"name\":\"李二\",\"telephone\":\"13912345678\",\"haspda\":\"1\",\"deltag\":\"0\",\"standard\":\"10-20公斤\",\"station\":\"杭州分部\"}\n" +
                "\t]";
        List<Map<String,String>> list = jsonTransform.transformForList(json);


        for (Map<String,String> map: list ){

            TStuff tStuff = new TStuff();
            BeanUtils.populate(tStuff,map);
            session.save(tStuff);

        }

        /*Map<String,Object> map  = new HashMap<String,Object>();

        String string = new String("李达");

        Integer integer = new Integer("1231213");

        map.put("name",string);
        map.put("telephone",integer);


        TStuff tStuff = new TStuff();
        BeanUtils.populate(tStuff,map);

        session.save(tStuff);
*/

        transaction.commit();
        session.close();

    }


}
