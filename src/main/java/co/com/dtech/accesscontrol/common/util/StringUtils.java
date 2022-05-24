package co.com.dtech.accesscontrol.common.util;

public class StringUtils {

	private static final String EMPTY = "";

	public static boolean isNullorEmpty(String str) {
		return str == null || EMPTY.equals(str);
	}

	public static String nvl(String str, String ifNull) {
		return isNullorEmpty(str) ? ifNull : str;
	}
}
