package co.com.dtech.accesscontrol.common.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AppLogger {

	private static final Logger eLog = LogManager.getLogger("error");
	private static final Logger iLog = LogManager.getLogger("info");
	
	public static void logInfo(String message) {
		iLog.info(message);
	}
	
	public static void logError(String message) {
		eLog.error(message);
	}

}
