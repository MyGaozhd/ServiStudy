package com.servi.study.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
public class ServiSpringApplicationRunListener implements SpringApplicationRunListener {

    private final SpringApplication application;

    private final String[] args;

    public ServiSpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }

    /**
     * Called immediately when the run method has first started. Can be used for very
     * early initialization.
     */
    public void starting() {
        log.info("ServiSpringApplicationRunListener...->starting");
    }

    /**
     * Called once the environment has been prepared, but before the
     * {@link ApplicationContext} has been created.
     *
     * @param environment the environment
     */
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info("ServiSpringApplicationRunListener...->environmentPrepared");
    }

    /**
     * Called once the {@link ApplicationContext} has been created and prepared, but
     * before sources have been loaded.
     *
     * @param context the application context
     */
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("ServiSpringApplicationRunListener...->contextPrepared");
    }

    /**
     * Called once the application context has been loaded but before it has been
     * refreshed.
     *
     * @param context the application context
     */
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("ServiSpringApplicationRunListener...->contextLoaded");
    }

    /**
     * The context has been refreshed and the application has started but
     * {@link CommandLineRunner CommandLineRunners} and {@link ApplicationRunner
     * ApplicationRunners} have not been called.
     *
     * @param context the application context.
     * @since 2.0.0
     */
    public void started(ConfigurableApplicationContext context) {
        log.info("ServiSpringApplicationRunListener...->started");

    }

    /**
     * Called immediately before the run method finishes, when the application context has
     * been refreshed and all {@link CommandLineRunner CommandLineRunners} and
     * {@link ApplicationRunner ApplicationRunners} have been called.
     *
     * @param context the application context.
     * @since 2.0.0
     */
    public void running(ConfigurableApplicationContext context) {
        log.info("ServiSpringApplicationRunListener...->running");
    }

    /**
     * Called when a failure occurs when running the application.
     *
     * @param context   the application context or {@code null} if a failure occurred before
     *                  the context was created
     * @param exception the failure
     * @since 2.0.0
     */
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("ServiSpringApplicationRunListener...->failed");
    }
}
