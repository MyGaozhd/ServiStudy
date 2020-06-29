package com.servi.study.plugin.chain;

import com.servi.study.plugin.PluginsLoader;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author servi
 * @date 2020/6/29
 */
public class InvokeChainManager {

    /**
     * 调用链执行
     *
     * @param invokeChainInterface
     * @param res
     * @param req
     * @param <REQ>
     * @param <RES>
     * @param <P>
     */
    public static <REQ, RES, P extends IInvokeChain<REQ, RES>> void invoke(Class<P> invokeChainInterface, REQ req, RES res) {
        List<P> chains = PluginsLoader.load(invokeChainInterface);
        if (CollectionUtils.isEmpty(chains)) {
            throw new RuntimeException("未找到对应调用链路");
        } else {
            chainBuilder(chains).excute(req, res);
        }
    }

    /**
     * chainBuilder
     *
     * @param chains
     * @param <REQ>
     * @param <RES>
     * @param <P>
     * @return
     */
    private static <REQ, RES, P extends IInvokeChain<REQ, RES>> P chainBuilder(List<P> chains) {
        P pre = chains.get(0);
        P next = null;
        for (int i = 1; i < chains.size(); i++) {
            next = chains.get(i);
            pre.setNext(next);
            next.setPre(pre);
            pre = next;
            next = null;
        }
        return chains.get(0);
    }
}
