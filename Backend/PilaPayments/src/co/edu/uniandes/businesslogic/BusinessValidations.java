package co.edu.uniandes.businesslogic;

import co.edu.uniandes.entity.PilaEntity;

public class BusinessValidations {
	
	private PilaEntity entity;
	
	private ValidacionLogic logic;
	
	public BusinessValidations(PilaEntity entity, ValidacionLogic logic) {
		this.entity = entity;
		this.logic = logic;
	}
	
	public String validations() {

		String errorCondition = "";

		String tipoPension = entity.getTipoPension().toString();
		String tipoPensionado = entity.getTipoPensionado().toString();
		String tipoPagador = entity.getSuperEntidad().getTipoPagador().toString();
		
		String error1 = "";
		String error2 = "";
		String error3 = "";
		
		String header =  "," +
				"\"" + "errorCondition\":" + //Si las validacines no pasan entonces se crea esta seccion
				"[";
		
		String footer = "]";
		
		String retorno = header;
		if(logic.validarPensionPensionado(tipoPension, tipoPensionado) == null) {
			error1 =	"{" +    
								"\"" + "Validacion\":" + "\"Tipo Pension vs Tipo Pensionado inconsistente\"," +
								"\"" + "valor1\":" + "\""+ tipoPension +"\"," +
								"\"" + "valor2\":" + "\""+ tipoPensionado +"\"" +
							"}";
			retorno += "," + error1;
		}
		
		if(logic.validarPensionadoPagador(tipoPensionado, tipoPagador) == null) {
			error2 = "{" + 
					"\"" + "Validacion\":" + "\"Tipo Pensionado vs Tipo Pagador inconsistente\"," +
					"\"" + "valor1\":" + "\"" + tipoPensionado + "\"," +
					"\"" + "valor2\":" + "\"" + tipoPagador + "\"" +
				"}";
			retorno += "," + error2;
		}
		
		if(logic.validarPensionPagador(tipoPension, tipoPagador) == null) {
			error3 = "{" + 
					"\"" + "Validacion\":" + "\"Tipo Pensionado vs Tipo Pagador inconsistente\"," +
					"\"" + "valor1\":" + "\"" + tipoPensionado + "\"," +
					"\"" + "valor2\":" + "\"" + tipoPagador + "\"" +
				"}";
			retorno += "," + error3;
		}
		
		if(retorno.startsWith(",")) {
			retorno = retorno.substring(1);
		}

		return errorCondition;
	}
}
