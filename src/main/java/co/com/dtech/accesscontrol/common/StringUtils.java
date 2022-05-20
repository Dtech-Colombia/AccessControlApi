package co.com.dtech.accesscontrol.common;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class StringUtils {
	
	private static final String EMPTY = "";
	
	public static boolean isNullorEmpty(String str) {
		return str == null || EMPTY.equals(str);
	}
	public static String nvl(String str, String ifNull) {
		return isNullorEmpty(str) ? ifNull : str;
	}
	public static String replaceJsonProperties(String json, String property, String value) {
		try {
			JSONObject obj = new JSONObject(json);
			if (!StringUtils.isNullorEmpty(obj.getString(property))) {
				obj.put(property, value);
			}
			return obj.toString();
		} catch (JSONException e) {
			return json;
		}
	}

}
