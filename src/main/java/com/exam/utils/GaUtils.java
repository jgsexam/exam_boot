package com.exam.utils;

import com.exam.dto.GaConfigDTO;
import com.exam.ga.GaService;
import com.exam.pojo.PaperConfigDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 遗传算法工具类
 *
 * @Author: 杨德石
 * @Date: 2019/5/3 0003 下午 9:16
 * @Version 1.0
 */
@Component
public class GaUtils {

    private static IdWorker idWorker;
    private static GaService gaService;

    public static void setConfigId(PaperConfigDO paperConfigDO) {
        paperConfigDO.setConfigId(idWorker.nextId() + "");
    }

    public static List getGaList(GaConfigDTO configDTO) {
        return gaService.getGaList(configDTO);
    }

    public static List getMutateList(Object question, PaperConfigDO parent2) {
        return gaService.getMutateList(question, parent2);
    }

    @Autowired(required = true)
    public void setIdWorker(IdWorker idWorker) {
        GaUtils.idWorker = idWorker;
    }

    @Autowired(required = true)
    public void setGaService(GaService gaService) {
        GaUtils.gaService = gaService;
    }
}
