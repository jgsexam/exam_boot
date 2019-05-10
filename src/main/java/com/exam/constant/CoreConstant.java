package com.exam.constant;

/**
 * 核心常量类
 * 用来放一些、比较重要的常量
 * @version 1.0
 * @author: 杨德石
 * @date: 2019/4/24 0024 下午 8:05
 */
public class CoreConstant {

    private CoreConstant() {}


    /**
     * 图片上传路径
     */
    public final static String IMG_URL = "D:\\ProjectFile\\exam\\photo\\";

    /**
     * 试卷保存路径
     */
    public final static String PAPER_URL = "D:\\ProjectFile\\exam\\paper\\";

    /**
     * freemarker模板所在的目录
     */
    public static final String TEMPLATE_FOLD = "/static/";

    /**
     * freemarker模板名
     */
    public static final String TEMPLATE_FILE_NAME = "最新模板.ftl";

    /**
     * 服务器文件地址
     */
    public final static String SERVER_FILE_URL = "http://tn20898453.51mypc.cn/file/";

    /**
     * redis过期时间
     */
    public final static Long REDIS_TIMEOUT = 3600000L;

    /**
     * 分页每页默认显示条数
     */
    public final static Integer CURRENT_COUNT = 10;


}
