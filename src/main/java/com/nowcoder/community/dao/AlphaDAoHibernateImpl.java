package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: huixiang0729
 * @Date: 2023-10-29  21:25
 */
@Repository("hibert")
public class AlphaDAoHibernateImpl implements AlphaDao{

    @Override
    public String select() {
        return "AlphaDAoHibernateImpl";
    }
}
