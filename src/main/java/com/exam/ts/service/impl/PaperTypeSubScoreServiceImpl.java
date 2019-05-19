package com.exam.ts.service.impl;

import com.exam.ts.pojo.PaperTypeSubScoreDO;
import com.exam.ts.mapper.PaperTypeSubScoreMapper;
import com.exam.ts.service.PaperTypeSubScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生-试卷-每个题型-主观题得分表（一题一分） 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-19
 */
@Service
public class PaperTypeSubScoreServiceImpl extends ServiceImpl<PaperTypeSubScoreMapper, PaperTypeSubScoreDO> implements PaperTypeSubScoreService {

}
