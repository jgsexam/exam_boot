package com.exam.ts.mapper;

import com.exam.ts.pojo.PO.LogPO;
import com.exam.ts.pojo.StudentPaperDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 学生试卷表 Mapper 接口
 * </p>
 *
 * @author 杨德石
 * @since 2019-05-24
 */
public interface StudentPaperMapper extends BaseMapper<StudentPaperDO> {

    /**
     * 根据考试Id查询学生
     * @param
     */
    List<String> selectStuByexamId(String examId);

    /**
     * 根据考试Id 和学生id 查询学生试卷
     * @param
     */
    StudentPaperDO getQuestion(@Param("examId") String stExam,@Param("stuId") String stStu);

    /**
     * 根据试卷id查询试卷
     * @param
     */
    StudentPaperDO getQuestionById(String paperId);


    /**
     * 得到考试学生数量及及格率
     */
    LogPO countOfPaper(String examId);
}
