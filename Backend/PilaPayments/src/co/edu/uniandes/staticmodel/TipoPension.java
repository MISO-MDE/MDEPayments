package co.edu.uniandes.staticmodel;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Tipo de pension
 * @author jorge perea
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoPension {

	VEJEZ("Vejez"), 
	SOBREVIVENCIA_VITALICIA_RIESGO_COMUN("Sobrevivencia vitalicia riesgo comun"),
	SOBREVIVENCIA_TEMPORAL_RIESGO_COMUN("Sobrevivencia temporal riesgo comun"),
	SOBREVIVENCIA_TEMPORAL_RIESGO_COMUN_CONYUGUE("Sobrevivencia temporal riesgo comun, Conyugue o compañera(o) menor de 30 "
			+ "años sin hijos"),
	SOBREVIVENCIA_VITALICIA_RIESGO_LABORAL("Sobrevivencia vitalicia por riesgo laboral"),
	SOBREVIVENCIA_TEMPORAL_RIESGO_LABORAL("Sobrevivencia temporal por riesgo laboral"),
	SOBREVIVENCIA_TEMPORAL_RIESGO_LABORAL_CONYUGUE("Sobrevivencia temporal por riesgo laboral, Conyugue o compañera(o) menor de 30 "
			+ "años sin hijos"),
	INVALIDEZ_RIESGO_COMUN("Invalidez riesgo común"),
	INVALIDEZ_RIESGO_LABORAL("Invalidez resgo laboral"),
	JUBILACION("Jubilacion"),
	JUBILACION_COMPARTIR("Jubilacion para compartir"),
	SANCION("Sanción"),
	CONVENCIONAL("Convencional"),
	CONVENCIONAL_COMPARTIR("Convencional para compartir"),
	GRACIA("Gracia"),
	CONVENIO_INTERNACIONAL("Por convenio internacional"),
	SENTENCIA_JUDICIAL("Sentencia Judicial"),
	CONCILIACIONES("Conciliaciones");
	
	private final String text;

    /**
     * @param text
     */
    TipoPension(String text) {
        this.text = text;
    }
   
    //devuelve el texto del enum
    public String getName() {
    	return this.text;
    }

    /**
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
    
    static public TipoPension getEnumbyDesc(String desc)
    {
        for(TipoPension act : TipoPension.values())
        {
            if(act.getName().equals(desc)) {
            	return act;
            }
        }
        return null;
    }
}
