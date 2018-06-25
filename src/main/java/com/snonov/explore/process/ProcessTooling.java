package com.snonov.explore.process;

import java.lang.management.ManagementFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Common tooling methods
 *
 */
public class ProcessTooling {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessTooling.class);
	
	/**
	 * Java 9 : use Process getPid, ProcessHandle.current().pid();, ...
	 */
	public static void logProcessPid() {		
		String nameProcess = ManagementFactory.getRuntimeMXBean().getName();
		LOGGER.info("Process (pid@host) [{}]", nameProcess);
		String pidExtract = nameProcess.substring(0, nameProcess.lastIndexOf("@"));
		LOGGER.info("PID [{}]", pidExtract);
	}
	
}
