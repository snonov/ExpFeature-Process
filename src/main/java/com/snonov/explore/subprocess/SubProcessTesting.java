package com.snonov.explore.subprocess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.snonov.explore.process.ProcessTooling;

/**
 * 
 * Simple Java main to be launch as sub process
 *
 */
public class SubProcessTesting {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubProcessTesting.class);
	
	public static void main(String[] args) {

		
		LOGGER.info("Running SubProcessTesting");
		ProcessTooling.logProcessPid();
		//Do things taking some times and output if you want to
		try {
			Thread.sleep(1000 * 3);
		} catch (InterruptedException e) {
			LOGGER.error("InterruptedException ", e);
		}
		LOGGER.info("End SubProcessTesting");
		
	}

}
