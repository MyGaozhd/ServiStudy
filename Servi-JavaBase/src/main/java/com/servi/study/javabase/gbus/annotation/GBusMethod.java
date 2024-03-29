package com.servi.study.javabase.gbus.annotation;

import com.servi.study.javabase.gbus.IRequestAdapter;
import com.servi.study.javabase.gbus.IResponseAdapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GBusMethod {

    /**
     * 需要调用的远程接口
     *
     * @return
     */
    public Class<?> clazz() default void.class;

    /**
     * 需要调用的远程接口方法名称
     * 如果不配置方法名称，默认走接口定义的方法名称
     *
     * @return
     */
    public String method() default "";

    /**
     * 如果设置自动翻译参数类型，取接口定义的方法的参数类型
     *
     * @return
     */
    public boolean autoParameterType() default true;

    /**
     * 需要调用的远程接口方法对应的参数类型
     * 如果不走自动翻译，使用此参数作为参数类型
     *
     * @return
     */
    public Class<?>[] parameterTypes() default {};

    /**
     * 请求参数的转换器
     *
     * @return
     */
    public Class<? extends IRequestAdapter> requestAdapter() default IRequestAdapter.DefaultRequestAdapter.class;

    /**
     * 返回值的转换器
     *
     * @return
     */
    public Class<? extends IResponseAdapter> responseAdapter() default IResponseAdapter.DefaultResponseAdapter.class;
}
