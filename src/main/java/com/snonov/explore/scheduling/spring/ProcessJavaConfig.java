package com.snonov.explore.scheduling.spring;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import com.snonov.explore.scheduling.business.BusinessRunner;

@Configuration
@EnableScheduling
public class ProcessJavaConfig {

    @Bean
    public TaskScheduler taskExecutor () {
        return new ConcurrentTaskScheduler(Executors.newScheduledThreadPool(3));
    }
    
	@Bean
	public BusinessRunner businessRunner() {
		BusinessRunner businessRunner = new BusinessRunner();
		return businessRunner;
	}
	
}
