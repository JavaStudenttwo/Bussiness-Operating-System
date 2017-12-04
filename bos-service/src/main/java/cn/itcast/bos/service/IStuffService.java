package cn.itcast.bos.service;

import cn.itcast.bos.domain.PageBean;
import cn.itcast.bos.domain.TStuff;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @Date 2017/10/10 14:52
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: cn.itcast.bos.service
 * @ClassName: IStuffService
 * @Description: 取派员业务接口
 *
 */
public interface IStuffService {

    void addStuff(TStuff model);

    PageBean<TStuff> pageQuery(PageBean pageBean);

    PageBean<TStuff> testPageQuery(PageBean pageBean);
}
