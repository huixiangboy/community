package com.nowcoder.community.service;

import com.nowcoder.community.dao.BetaTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: huixiang0729
 * @Date: 2023-10-30  11:17
 */
@Service
public class BetaTestService {
    @Autowired
    private BetaTestDao betaTestDao;
    public String getDao(){
        return betaTestDao.getInfo();
    }
}
