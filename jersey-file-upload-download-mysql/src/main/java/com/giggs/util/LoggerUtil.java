package com.giggs.util;

import org.apache.log4j.Logger;

public class LoggerUtil {

	private LoggerUtil() {
	}

	public static void info(String clase, String mensaje) {
		Logger logger = Logger.getLogger(clase);
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		logger.info("[" + lineNumber + "] [" + methodName + "] [" + mensaje + "]");
	}

	// public static void info(String clase, String mensaje) {
	// String fullClassName =
	// Thread.currentThread().getStackTrace()[2].getClassName();
	// String className = fullClassName.substring(fullClassName.lastIndexOf(".")
	// + 1);
	// String methodName =
	// Thread.currentThread().getStackTrace()[2].getMethodName();
	// int lineNumber =
	// Thread.currentThread().getStackTrace()[2].getLineNumber();
	//
	// Logger logger = Logger.getLogger(clase);
	// // logger.info(mensaje);
	//
	// logger.info(className + "." + methodName + "():" + lineNumber + "- " +
	// mensaje);
	// }

}
