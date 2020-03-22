package com.kvpr.smartpit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class SchedullerConfig {

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("ThreadPoolTaskScheduler-task-");
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setRemoveOnCancelPolicy(true);
        scheduler.setAwaitTerminationSeconds(60);
//        scheduler.setErrorHandler(t -> schedulingLogger.error(
//                "Unknown error occurred while executing task.", t));
//        scheduler.setRejectedExecutionHandler(
//                (r, e) -> schedulingLogger.error(
//                        "Execution of task {} was rejected for unknown reasons.", r
//                )
//        );
        return scheduler;
    }
}
