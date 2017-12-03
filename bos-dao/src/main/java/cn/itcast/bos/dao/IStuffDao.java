package cn.itcast.bos.dao;

import cn.itcast.bos.dao.base.IBaseDao;
import cn.itcast.bos.domain.PageBean;
import cn.itcast.bos.domain.TStuff;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/** 
 * @Date 2017/10/10 15:20
 * @Author CycloneKid sk18810356@gmail.com 
 * @PackageName: cn.itcast.bos.dao
 * @ClassName: IStuffDao
 * @Description: 
 *
 */
public interface IStuffDao extends IBaseDao<TStuff>{

    void save(TStuff tStuff);

}
