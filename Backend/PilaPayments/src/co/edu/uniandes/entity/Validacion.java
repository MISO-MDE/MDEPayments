package co.edu.uniandes.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validacion {
	private Map<String,Map<String,List<?>>> values;

	public Validacion() {
		super();
		this.values = new HashMap<String,Map<String,List<?>>>();
	}

	public Map<String, Map<String, List<?>>> getValues() {
		return values;
	}

	public void setValues(Map<String, Map<String, List<?>>> values) {
		this.values = values;
	}

	
}
