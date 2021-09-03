package ec.com.pruebagizlo.ms.usuario.controller.dto;

import java.util.HashMap;
import java.util.Map;

import ec.com.pruebagizlo.ms.usuario.utils.patterns.IParam;

public class GenericStringParam  implements IParam{
	
	private Map<String, String> values = new HashMap<>();

	public Map<String, String> getValues() {
		return values;
	}
	
	public void setValues(Map<String, String> values) {
		this.values = values;
	}
	
	public GenericStringParam addValue(String key, String value){
		this.values.put(key, value);
		return this;
	}
}