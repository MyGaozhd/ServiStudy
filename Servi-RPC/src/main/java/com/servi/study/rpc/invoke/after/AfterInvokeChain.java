package com.servi.study.rpc.invoke.after;

import com.servi.study.rpc.dto.IRequest;
import com.servi.study.rpc.dto.IResponse;
import com.servi.study.rpc.invoke.AbstractInvokeChain;
import com.servi.study.rpc.invoke.IAfterInvoke;
import org.springframework.stereotype.Component;

/**
 * @author servi
 * @date 2020/6/29
 */
@Component
public class AfterInvokeChain extends AbstractInvokeChain implements IAfterInvoke {

    @Override
    public void excute(IRequest req, IResponse res) {
        System.out.println(AfterInvokeChain.class.getName() + "->" + req.getClass().toString());
        System.out.println(AfterInvokeChain.class.getName() + "->" + res.getClass().toString());
        if (next() != null) {
            next().excute(req, res);
        }
    }
}
