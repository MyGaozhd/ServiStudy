package com.servi.study.plugin;

/**
 * 插件标志接口
 */
public interface IPlugin {

    //默认排序顺序
    public static final int default_sort_order = Integer.MIN_VALUE;

    /**
     * @return 排序位置
     */
    public default int order() {
        return default_sort_order;
    }
}
