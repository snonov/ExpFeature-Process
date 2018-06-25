package com.snonov.explore.subprocess;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SubProcessTestingTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubProcessTestingTest.class);
	
	@Test
	void testMain() {
		LOGGER.info("Test main SubProcessTesting");
		SubProcessTesting.main(null);
		
	}

}
