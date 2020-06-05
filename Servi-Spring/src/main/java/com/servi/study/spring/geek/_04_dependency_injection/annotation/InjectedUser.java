package com.servi.study.spring.geek._04_dependency_injection.annotation;

import java.lang.annotation.*;

/**
 * 自定义依赖注入注解
 *
 * @author servi
 * @since
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectedUser {
}
