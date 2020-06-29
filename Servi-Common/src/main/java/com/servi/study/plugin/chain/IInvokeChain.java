package com.servi.study.plugin.chain;

import com.servi.study.plugin.IPlugin;

/**
 * 调用链接口 每个调用链，需重新定义接口
 *
 * @param <REQ> request
 * @param <RES> response
 */
public interface IInvokeChain<REQ, RES> extends IPlugin {

    /**
     * @return 设置上一个 null 表示是第一个
     */
    default <I extends IInvokeChain<REQ, RES>> boolean setPre(I i) {
        throw new RuntimeException("不支持此设置");
    }

    /**
     * @return 上一个 null 表示是第一个
     */
    default <E extends IInvokeChain<REQ, RES>> E pre() {
        return null;
    }

    /**
     * @return 设置下一个 null 表示最后一个
     */
    default <I extends IInvokeChain<REQ, RES>> boolean setNext(I i) {
        throw new RuntimeException("不支持此设置");
    }

    /**
     * @return 下一个 null 表示最后一个
     */
    default <E extends IInvokeChain<REQ, RES>> E next() {
        return null;
    }

    /**
     * @param req 请求参数
     * @param res 返回值
     * @return true 继续next请求 false 结束请求
     */
    boolean excute(REQ req, RES res);
}
