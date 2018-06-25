package com.snonov.explore.process;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.snonov.explore.subprocess.SubProcessTesting;

class ProcessCommandLauncherTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCommandLauncherTest.class);
	private File pathTestResource = new File(".");
	
	@Test
	void testLaunchCmd() {
		String cmdToEx = pathTestResource.getAbsolutePath() + "\\src\\test\\resources\\testprocess\\echo.cmd";
		String cmdArg = "Test argument";
		
		ProcessCommandLauncher launcher = new ProcessCommandLauncher();
		LOGGER.info("Testing launchCmd with command [{}] and args [{}]", cmdToEx, cmdArg);
		launcher.launchCmd(cmdToEx, cmdArg);
	}
	
	@Test
	void testLaunchCmdWithLog() {
		String cmdToEx = pathTestResource.getAbsolutePath() + "\\src\\test\\resources\\testprocess\\echo.cmd";
		String cmdArg = "Test argument";
		
		String logFolder = pathTestResource.getAbsolutePath() + "\\src\\test\\resources\\testprocess\\";
		
		ProcessCommandLauncher launcher = new ProcessCommandLauncher();
		LOGGER.info("Testing launchCmdWithLog with command [{}] and args [{}] and log output [{}]", cmdToEx, cmdArg, logFolder);
		launcher.launchCmdWithLog(logFolder, cmdToEx, cmdArg);
	}
	
	@Test
	void testLaunchCmdWithJavaMain() {
		
		ProcessCommandLauncher launcher = new ProcessCommandLauncher();
		Class<?> klass = SubProcessTesting.class;
		LOGGER.info("Testing execJavaMainClass with class [{}]", klass);
		launcher.execJavaMainClass(klass);
	}

}
