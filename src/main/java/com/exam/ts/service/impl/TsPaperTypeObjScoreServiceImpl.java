package com.exam.ts.service.impl;

import com.exam.ts.pojo.TsPaperTypeObjScoreDO;
import com.exam.ts.mapper.TsPaperTypeObjScoreMapper;
import com.exam.ts.service.TsPaperTypeObjScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生-试卷-每个题型-客观题得分表（一题一分） 服务实现类
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-21
 */
@Service
public class TsPaperTypeObjScoreServiceImpl extends ServiceImpl<TsPaperTypeObjScoreMapper, TsPaperTypeObjScoreDO> implements TsPaperTypeObjScoreService {

}
