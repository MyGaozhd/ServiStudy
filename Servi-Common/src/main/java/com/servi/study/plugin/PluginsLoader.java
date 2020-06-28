package com.servi.study.plugin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author servi
 * @date 2020/6/28
 */
public class PluginsLoader {

    public static <P extends IPlugin> List<P> load(Class<P> pluginInterface) {

        return load(pluginInterface, pluginInterface.getClassLoader(), new IPluginsLoader() {
            @Override
            public <P extends IPlugin> List<P> loader(Class<P> pluginInterface, ClassLoader classLoader) {
                ServiceLoader<P> services = ServiceLoader.load(pluginInterface, classLoader);
                List<P> plugins = new ArrayList<>();
                services.forEach(plugin -> {
                    plugins.add(plugin);
                });

                plugins.sort(new Comparator<P>() {
                    @Override
                    public int compare(P p1, P p2) {
                        return p1.order() - p2.order();
                    }
                });

                return plugins;
            }
        });
    }

    public static <P extends IPlugin> List<P> load(Class<P> pluginInterface, ClassLoader classLoader, IPluginsLoader pluginsLoader) {

        if (pluginsLoader == null) {
            throw new NullPointerException(" 插件加载器不能为空 ");
        }

        return pluginsLoader.loader(pluginInterface, classLoader);
    }

    @FunctionalInterface
    public interface IPluginsLoader {
        <P extends IPlugin> List<P> loader(Class<P> pluginInterface, ClassLoader classLoader);
    }
}
