package com.exam.core.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.exam.core.constant.ExamEnum;
import com.exam.core.constant.RedisConstant;
import com.exam.ts.mapper.ExamMapper;
import com.exam.ts.mapper.StudentPaperMapper;
import com.exam.ts.pojo.ExamDO;
import com.exam.ts.pojo.StudentPaperDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lth
 */

@Component
@Slf4j
public class PaperTask {

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 每分钟检查一次
     */
    @Scheduled(cron = "0 * * * * ?")
    public void scan(){
        // 当前时间
        Date date = new Date();
        // 查询库里是否有即将开始的考试
        QueryWrapper<ExamDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("exam_date",date.toString());
        queryWrapper.lt("exam_date",DateUtils.addMinutes(date,1));

        List<ExamDO> examDOS = examMapper.selectList(queryWrapper);
        if(examDOS.size() == 0){
        // 没有则返回
         log.info("exam list scan : size = 0");
            return;
        }
        log.info("exam list scan :{}",examDOS.size());

        // 有则入redis
        examDOS.forEach(exam -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date startDate = sdf.parse(exam.getExamDate());
                Date endDate = DateUtils.addMinutes(startDate, exam.getExamTime());
                long end = endDate.getTime();
                long expire = (end - date.getTime())/ 1000;
                // redis中有则说明还没结束，没有则结束了
                redisTemplate.opsForValue().set(RedisConstant.EXAM_INFO + exam.getExamId(),1,expire, TimeUnit.SECONDS);
                exam.setExamState(ExamEnum.STARTED.getCode());
                examMapper.updateById(exam);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

}
