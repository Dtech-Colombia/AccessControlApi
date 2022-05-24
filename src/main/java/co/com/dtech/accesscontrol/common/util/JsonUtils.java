package co.com.dtech.accesscontrol.common.util;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	private static ObjectMapper objectMapper;

	public JsonUtils() {
		super();
	}

	/**
	 * Get ObjectMapper, usa un patron de doble confirmaci para prevenir varias
	 * instancias de la clase
	 * 
	 * @return
	 */
	private static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapperlocal = objectMapper;
		if (objectMapperlocal == null) {
			synchronized (JsonUtils.class) {
				objectMapperlocal = objectMapper;
				if (objectMapperlocal == null) {
					try {
						objectMapper = new ObjectMapper();
						objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // fallo al
																											// encontrar
																											// una
																											// propiedad
																											// desconocida
						objectMapper
								.configure(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS
										.mappedFeature(), true); // incluir caracteres inferiores aal ASCII con código
																	// 32
						objectMapper
								.configure(com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES
										.mappedFeature(), true); // permitir nombres de atributos sin comillas
						objectMapper.configure(
								com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_SINGLE_QUOTES.mappedFeature(),
								true); // permitir comillas simples
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
				}

			}
		}
		return objectMapper;
	}

	/**
	 * @param <T>
	 * @param jsonData
	 * @param classToParse
	 * @return un objeto de una clase en específico a partir de un json
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static <T> T getObjectFromJson(String jsonData, Class<T> classToParse)
			throws JsonMappingException, JsonProcessingException {
		return getObjectMapper().readValue(jsonData, classToParse);
	}

	/**
	 * 
	 * @param obj
	 * @return String en forma json de cualquier objeto
	 * @throws JsonProcessingException
	 */
	public static String getJsonFromObject(Object object) throws JsonProcessingException {
		return getObjectMapper().writer().writeValueAsString(object);
	}

	/**
	 * 
	 * @param json
	 * @param property
	 * @param value
	 * @return Json con la propiedad remplezada
	 */
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
