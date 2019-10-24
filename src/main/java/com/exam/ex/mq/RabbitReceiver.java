package com.exam.ex.mq;

import com.exam.core.constant.MqConstant;
import com.exam.core.constant.PaperEnum;
import com.exam.core.constant.SubmitEnum;
import com.exam.core.exception.ExamException;
import com.exam.ts.pojo.StudentAnswerDO;
import com.exam.ts.pojo.StudentPaperDO;
import com.exam.ts.service.StudentAnswerService;
import com.exam.ts.service.StudentPaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * rabbit消费者
 * @author lth
 * @version 1.0.0
 * @date
 */
@Slf4j
@Service
public class RabbitReceiver {

    @Autowired
    private StudentPaperService studentPaperService;
    @Autowired
    private StudentAnswerService studentAnswerService;


    @RabbitListener(queues = MqConstant.SUBMIT_EXAM_QUEUE)
    public void handlerExam(StudentAnswerDO studentAnswerDO) throws ExamException {
            // 处理考试逻辑
        log.debug("处理学生答题 学生ID:{}",studentAnswerDO.getAnswerStudent());
        StudentPaperDO studentPaperDO = studentPaperService.getById(studentAnswerDO.getAnswerPaper());
        if(SubmitEnum.NOT_SUBMIT.getCode().equals(studentPaperDO.getPaperFlag())){
            throw new ExamException("试卷未提交");
        }
        if(PaperEnum.LOADING.getCode().equals(studentPaperDO.getPaperFlag())){
            throw new ExamException("试卷处理中");
        }
        // 更改状态
        studentPaperDO.setPaperFlag(PaperEnum.LOADING.getCode());
        boolean isSuccess = studentPaperService.updateById(studentPaperDO);
        // 更改成功则开始
        if(isSuccess){
            studentAnswerService.asyncHandler(studentAnswerDO);
        }

    }

}
