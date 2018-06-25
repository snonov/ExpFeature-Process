package com.snonov.explore.scheduling.business;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import com.snonov.explore.process.ProcessCommandLauncher;

public class BusinessRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCommandLauncher.class);
	
	private File pathTestResource = new File(".");
	
	@Scheduled(cron = "*/10 * * * * ?")
	public void firstRunner() {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LOGGER.info("Cron Task :: Execution Time - {}", formatter.format(LocalDateTime.now()));
		
		String cmdToEx = pathTestResource.getAbsolutePath() + "\\src\\test\\resources\\testprocess\\echo.cmd";
		String cmdArg = "Test argument";
		
		ProcessCommandLauncher processCommandLauncher = new ProcessCommandLauncher();
		processCommandLauncher.launchCmd(cmdToEx, cmdArg);
	}
	
}
