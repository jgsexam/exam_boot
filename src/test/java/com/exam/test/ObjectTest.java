package com.exam.test;

import com.exam.pojo.ChoiceDO;
import com.exam.pojo.QuestionDO;
import org.junit.Test;

/**
 * @Author: 杨德石
 * @Date: 2019/5/3 0003 下午 5:01
 * @Version 1.0
 */
public class ObjectTest {

    @Test
    public void testInstanceof() {
        QuestionDO questionDO = new QuestionDO();
        Object o = questionDO;
        System.out.println(o instanceof QuestionDO);
        System.out.println(o instanceof ChoiceDO);
    }

}
