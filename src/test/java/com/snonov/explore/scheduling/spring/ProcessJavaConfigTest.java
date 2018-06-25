package com.snonov.explore.scheduling.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.snonov.explore.scheduling.business.BusinessRunner;

class ProcessJavaConfigTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessJavaConfigTest.class);
	
	private ApplicationContext ctx = null;
	
	@Test
	void test() {
		
		LOGGER.info("Test spring context with scheduled elements");
		
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			ctx = new AnnotationConfigApplicationContext(ProcessJavaConfig.class);
			BusinessRunner bean = ctx.getBean(BusinessRunner.class);
			assertTrue(bean != null);
		});
		
		try {
			Thread.sleep(20*1000);
		} catch (InterruptedException e) {
			LOGGER.error("InterruptedException ", e);
		}
		((AnnotationConfigApplicationContext) ctx).close();
	}

}
