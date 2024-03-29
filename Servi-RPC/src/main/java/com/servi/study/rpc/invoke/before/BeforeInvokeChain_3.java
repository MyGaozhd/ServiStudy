package com.servi.study.rpc.invoke.before;

import com.servi.study.rpc.invoke.dto.IRequest;
import com.servi.study.rpc.invoke.dto.IResponse;
import com.servi.study.rpc.invoke.AbstractInvokeChain;
import com.servi.study.rpc.invoke.IBeforeInvoke;
import org.springframework.stereotype.Component;

/**
 * @author servi
 * @date 2020/6/29
 */
@Component
public class BeforeInvokeChain_3 extends AbstractInvokeChain implements IBeforeInvoke {

    @Override
    public void excute(IRequest req, IResponse res) {
        System.out.println(BeforeInvokeChain_3.class.getName() + "->" + order() + "->" + req.getClass().toString());
        System.out.println(BeforeInvokeChain_3.class.getName() + "->" + order() + "->" + res.getClass().toString());
        if (next() != null) {
            next().excute(req, res);
        }
    }

    @Override
    public int order() {
        return 1;
    }
}
