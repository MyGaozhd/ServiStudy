package com.servi.study.javabase.serviceloader;

import com.servi.study.plugin.IPlugin;
import com.servi.study.plugin.chain.IInvokeChain;

/**
 * @author servi
 * @date 2020/6/23
 */
public interface ITestService extends IInvokeChain<String, String> {
    @Override
    default void excute(String req, String res) {
        System.out.println(this.getClass().getName() + ":req->" + req);
        System.out.println(this.getClass().getName() + ":res->" + res);
        if (next() != null) {
            next().excute(req, res);
        }
    }
}
