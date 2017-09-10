package cn.itcast.bos.service.impl;

import cn.itcast.bos.dao.StuffDao;
import cn.itcast.bos.dao.impl.StuffDaoImpl;
import cn.itcast.bos.domain.TStuff;
import cn.itcast.bos.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 13718 on 2017/9/10.
 */

@Service
@Transactional
public class StuffServiceImpl implements StuffService {

    @Autowired
    StuffDao stuffDao = new StuffDaoImpl();

    /**
     * 取派员添加
     * @param model
     */
    @Override
    public void addStuff(TStuff model) {
        stuffDao.save(model);
    }
}
