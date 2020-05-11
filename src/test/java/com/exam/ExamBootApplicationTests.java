package com.exam;

import com.exam.ex.mapper.ChoiceMapper;
import com.exam.ex.pojo.ChoiceAnswerDO;
import com.exam.ex.pojo.ChoiceDO;
import com.exam.ts.mapper.StudentAnswerMapper;
import com.exam.ts.pojo.StudentAnswerDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamBootApplicationTests {

    @Autowired
    private StudentAnswerMapper studentAnswerMapper;

    @Autowired
    private ChoiceMapper choiceMapper;
//
//    @Test
//    public void test(){
//        StudentAnswerDO studentAnswerDO = new StudentAnswerDO();
//        studentAnswerDO.setAnswerStudent("1114880900740530176");
//        studentAnswerDO.setAnswerPaper("1240840105852170240");
//        List<StudentAnswerDO> studentAnswerDOS = studentAnswerMapper.selectcofigList(studentAnswerDO);
//        studentAnswerDOS.forEach(s-> System.out.println(s));
//
//    }

    @Test
    public void test2(){
        System.out.println("e....");
        Object[]  objects = new Object[2];
        objects[0] = "1120209794326650880";
        List<ChoiceDO> listByIds =
                choiceMapper.getListByIds(objects);
        for (ChoiceDO listById : listByIds) {
            System.out.println(listById.getChoiceTrue());
        }
    }
}