package com.exam.core.task;

import com.exam.core.constant.MqConstant;
import com.exam.ex.pojo.StudentDO;
import com.exam.ts.pojo.DTO.StudentDTO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lth
 * @date 2020年05月06日 20:45
 */

@Component
@RabbitListener(queues = MqConstant.SUBMIT_EXAM_QUEUE)
public class aa {

    @RabbitHandler
    public void sca(StudentDO studentDO){
        System.out.println(studentDO.toString());
    }

}
