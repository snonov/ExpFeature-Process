package com.snonov.explore.process;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessCommandLauncher {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCommandLauncher.class);

	public void launchCmd(final String... processBuilderArgs) {
		LOGGER.info("launchCmd args {}", Arrays.toString(processBuilderArgs));

		try {
			ProcessBuilder processBuilder = new ProcessBuilder(processBuilderArgs);

			// processBuilder.redirectErrorStream(true); // redirect error stream to output
			// stream
			// processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
			// final Process p = processBuilder.start();

			// Equivalent to previous 3 lines
			LOGGER.info("log into inheritIO");
			final Process process = processBuilder.inheritIO().start();

			ProcessTooling.logProcessPid();

			int waitFor = process.waitFor();
			LOGGER.info("waitFor return [{}]", waitFor);
		} catch (Exception ex) {
			LOGGER.error("Exception", ex);
		}

	}

	public void launchCmdWithLog(String logFolder, final String... processBuilderArgs) {
		LOGGER.info("launchCmdWithLog args {}", Arrays.toString(processBuilderArgs));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		String logFilename = "launchCmdWithLog" + LocalDateTime.now().format(formatter) + ".txt";
		Path pathNamed = Paths.get(logFolder, logFilename);
		File logCmdExec = pathNamed.toFile();

		try {
			ProcessBuilder processBuilder = new ProcessBuilder(processBuilderArgs);

			processBuilder.redirectErrorStream(true); // redirect error stream to output stream
			processBuilder.redirectOutput(logCmdExec);

			LOGGER.info("log into {}", pathNamed.toAbsolutePath());
			final Process process = processBuilder.start();

			ProcessTooling.logProcessPid();

			int waitFor = process.waitFor();
			LOGGER.info("waitFor return [{}]", waitFor);
		} catch (Exception ex) {
			LOGGER.error("Exception", ex);
		}
	}

	public int execJavaMainClass(Class<?> klass) {
		LOGGER.info("execJavaMainClass class {}", klass);
		
		String javaHome = System.getenv("JAVA_HOME");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = klass.getCanonicalName();
		
		int returnValue = -1;
		try {
			ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);

			Process process = builder.inheritIO().start();

			ProcessTooling.logProcessPid();
			
			process.waitFor();
			returnValue = process.exitValue();
		} catch (Exception ex) {
			LOGGER.error("Exception", ex);
		}

		return returnValue;
	}

}
