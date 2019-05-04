package com.exam.dto;

import lombok.Data;

import java.util.List;

/**
 * 只能组卷的试卷DTO对象
 * @Author: 杨德石
 * @Date: 2019/5/2 0002 下午 8:48
 * @Version 1.0
 */
@Data
public class GaPaperDTO {

    /**
     * 试卷id
     */
    private String paperId;

    /**
     * 用户选择多个配置
     */
    private List<GaConfigDTO> configList;

    @Override
    public String toString() {
        return "GaPaperDTO{" +
                "configList=" + configList +
                '}';
    }
}
