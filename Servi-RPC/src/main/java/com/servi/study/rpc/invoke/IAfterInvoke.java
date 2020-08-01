package com.servi.study.rpc.invoke;

import com.servi.study.plugin.chain.IInvokeChain;
import com.servi.study.rpc.invoke.dto.IRequest;
import com.servi.study.rpc.invoke.dto.IResponse;

public interface IAfterInvoke extends IInvokeChain<IRequest, IResponse> {

}
