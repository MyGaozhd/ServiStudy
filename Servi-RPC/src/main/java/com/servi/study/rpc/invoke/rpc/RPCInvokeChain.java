package com.servi.study.rpc.invoke.rpc;

import com.servi.study.plugin.chain.InvokeChainManager;
import com.servi.study.rpc.invoke.dto.IRequest;
import com.servi.study.rpc.invoke.dto.IResponse;
import com.servi.study.rpc.invoke.AbstractInvokeChain;
import com.servi.study.rpc.invoke.IAfterInvoke;
import com.servi.study.rpc.invoke.IBeforeInvoke;
import com.servi.study.rpc.invoke.IRPCInvoke;
import org.springframework.stereotype.Component;

/**
 * @author servi
 * @date 2020/6/29
 */
@Component
public class RPCInvokeChain extends AbstractInvokeChain implements IRPCInvoke {

    @Override
    public void excute(IRequest req, IResponse res) {
        System.out.println("**********************before begin**********************");
        InvokeChainManager.invoke(IBeforeInvoke.class, req, res);
        System.out.println("**********************before end**********************");

        System.out.println(RPCInvokeChain.class.getName() + "->" + req.getClass().toString());
        System.out.println(RPCInvokeChain.class.getName() + "->" + res.getClass().toString());

        System.out.println("**********************after begin**********************");
        InvokeChainManager.invoke(IAfterInvoke.class, req, res);
        System.out.println("**********************after end**********************");

        if (next() != null) {
            next().excute(req, res);
        }
    }
}
