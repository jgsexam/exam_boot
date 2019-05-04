package com.exam.ga;

import com.exam.dto.GaConfigDTO;
import com.exam.exception.ExamException;
import com.exam.pojo.PaperConfigDO;
import com.exam.utils.GaUtils;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 遗传算法种群（多个试卷配置组成一个种群）
 *
 * @Author: 杨德石
 * @Date: 2019/5/3 0003 下午 3:27
 * @Version 1.0
 */
@Data
public class Population {

    /**
     * 个体数组
     */
    private PaperConfigDO[] configs = new PaperConfigDO[0];

    /**
     * 初始化种群
     */
    public void initPopulation(int populationSize) {
        if (populationSize == 0) {
            populationSize = 1;
        }
        this.configs = new PaperConfigDO[populationSize];
        PaperConfigDO config;
        for (int i = 0; i < populationSize; i++) {
            config = new PaperConfigDO();
            GaUtils.setConfigId(config);
            configs[i] = config;
        }
    }

    /**
     * 初始化种群
     */
    public void initPopulation(int populationSize, GaConfigDTO configDTO) throws ExamException {
        configs = new PaperConfigDO[populationSize];
        PaperConfigDO config;
        for (int i = 0; i < populationSize; i++) {
            config = new PaperConfigDO();
            GaUtils.setConfigId(config);
            config.initPaperConfig(configDTO);
            while (config.getScoreGa() != configDTO.getTotalScore().doubleValue()) {
                // 分值不对，重新组卷
                config.getQuestionDetailList().clear();
                // 抽题
                generateQuestion(configDTO, config);
            }
            // 计算配置知识点覆盖率
            config.setKpCoverageGa(configDTO);
            // 计算配置适应度
            config.setAdaptationDegreeGa(configDTO);
            configs[i] = config;
        }
    }

    public Population() {
    }

    /**
     * 从数据库中根据DTO抽取试题放到config中
     *
     * @param configDTO
     * @param config
     */
    private void generateQuestion(GaConfigDTO configDTO, PaperConfigDO config) throws ExamException {
        Random random = new Random();

        // 题目列表
        List list = GaUtils.getGaList(configDTO);

        if (list.size() < configDTO.getQuestionNum()) {
            // 题库中总题目小于所需题目
            throw new ExamException("题库中题目数不够，组卷失败！");
        }

        Object templateQuestion;
        for (Integer i = 0; i < configDTO.getQuestionNum(); i++) {
            int index = random.nextInt(list.size() - i);
            // 将题目放入到config中
            config.getQuestionDetailList().add(list.get(index));

            // 保证不会重复添加试题，将试题放到最后面
            templateQuestion = list.get(list.size() - i - 1);
            list.set(list.size() - i - 1, list.get(index));
            list.set(index, templateQuestion);

        }

    }

    /**
     * 排序后获得指定索引的个体
     *
     * @param offset
     * @return
     */
    public PaperConfigDO getFitness(int offset) {
        Arrays.sort(this.configs, (o1, o2) -> {
            if (o1.getAdaptationDegree() > o2.getAdaptationDegree()) {
                return -1;
            } else if (o1.getAdaptationDegree() < o2.getAdaptationDegree()) {
                return 1;
            }
            return 0;
        });
        return this.configs[offset];
    }

    /**
     * 获取个体的数量
     *
     * @return
     */
    public Integer getConfigSize() {
        return this.configs.length;
    }

    /**
     * 根据下标获取个体
     *
     * @param index
     * @return
     */
    public PaperConfigDO getConfig(int index) {
        return configs[index];
    }

    /**
     * 根据下标设置个体
     *
     * @param index
     * @param config
     */
    public void setConfig(Integer index, PaperConfigDO config) {
        this.configs[index] = config;
    }
}
