package com.exam.core.task;

import com.exam.core.constant.MqConstant;
import com.exam.ex.pojo.StudentDO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lth
 * @date 2020年05月06日 20:42
 */

@Component
public class Mesg {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 每分钟检查一次
     */
    @Scheduled(cron = "0 * * * * ?")
    public void scan(){
        StudentDO studentDO = new StudentDO();
        studentDO.setStuAge(26);
        rabbitTemplate.convertAndSend(MqConstant.SUBMIT_EXAM_QUEUE,studentDO);
    }
}
