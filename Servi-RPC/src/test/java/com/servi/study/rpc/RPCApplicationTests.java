package com.servi.study.rpc;

import com.servi.study.plugin.chain.InvokeChainManager;
import com.servi.study.rpc.dto.IRequest;
import com.servi.study.rpc.dto.IResponse;
import com.servi.study.rpc.invoke.IRPCInvoke;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RPCApplicationTests {

    @Test
    void contextLoads() {

        InvokeChainManager.invoke(IRPCInvoke.class, new IRequest() {
        }, new IResponse() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
    }
}
