package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @Author: huixiang0729
 * @Date: 2023-10-29  21:28
 */
@Repository
@Primary
public class AlphaDaoMybatis implements AlphaDao{
    @Override
    public String select() {
        return "AlphaDaoMybatis";
    }
}
