package com.servi.study.rpc.invoke;

import com.servi.study.plugin.chain.IInvokeChain;
import com.servi.study.rpc.dto.IRequest;
import com.servi.study.rpc.dto.IResponse;

/**
 * @author servi
 * @date 2020/6/29
 */
public abstract class AbstractInvokeChain {

    private IInvokeChain<IRequest, IResponse> pre = null;
    private IInvokeChain<IRequest, IResponse> next = null;

    public <I extends IInvokeChain<IRequest, IResponse>> boolean setPre(I pre) {
        this.pre = pre;
        return true;
    }

    public <E extends IInvokeChain<IRequest, IResponse>> E pre() {
        return (E) this.pre;
    }

    public <I extends IInvokeChain<IRequest, IResponse>> boolean setNext(I next) {
        this.next = next;
        return false;
    }

    public <E extends IInvokeChain<IRequest, IResponse>> E next() {
        return (E) this.next;
    }
}
