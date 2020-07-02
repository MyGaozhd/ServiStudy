package com.servi.study.rpc;

import com.servi.study.plugin.IPlugin;
import com.servi.study.plugin.PluginsLoader;
import com.servi.study.plugin.chain.InvokeChainManager;
import com.servi.study.rpc.dto.IRequest;
import com.servi.study.rpc.dto.IResponse;
import com.servi.study.rpc.invoke.IBeforeInvoke;
import com.servi.study.rpc.invoke.IRPCInvoke;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.List;

@SpringBootTest
class RPCApplicationTests {

    @Autowired
    private List<IBeforeInvoke> beforeInvokes;

    @Test
    void contextLoads() {

        InvokeChainManager.invoke(IRPCInvoke.class, new IRequest() {
        }, new IResponse() {
        });
    }

    @Test
    void testLoader() {

        InvokeChainManager.invoke(IRPCInvoke.class, new IRequest() {
        }, new IResponse() {
        }, new PluginsLoader.IPluginsLoader() {
            @Override
            public <P extends IPlugin> List<P> loader(Class<P> pluginInterface, ClassLoader classLoader) {
                return (List<P>) beforeInvokes;
            }
        });
    }
}
