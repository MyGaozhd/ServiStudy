package com.servi.study.rpc.invoke;

import com.servi.study.plugin.IPlugin;
import com.servi.study.plugin.chain.IInvokeChain;
import com.servi.study.rpc.dto.IRequest;
import com.servi.study.rpc.dto.IResponse;

public interface IBeforeInvoke extends IInvokeChain<IRequest, IResponse> {

}
