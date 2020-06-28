package com.servi.study.plugin;

/**
 * 顶层插件接口 无具体实现类
 */
public interface IPlugin {

    //默认排序顺序
    public static final int default_sort_order = Integer.MIN_VALUE;

    /**
     * 排序
     *
     * @return
     */
    public default int order() {
        return default_sort_order;
    }
}
