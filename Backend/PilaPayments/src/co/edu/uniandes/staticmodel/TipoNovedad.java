package co.edu.uniandes.staticmodel;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Tipo de novedades
 * @author jorge perea
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoNovedad {
	
	TRASLADO(1,"Traslado"),
	VARIACION_TRANSITORIA_SALARIO(2, "Variación transitoria del salario"),
	SLN(3,"Suspension temporal, licencia no remunerada o comosión de servicios"),
	INCAPACIDAD_ENFERMEDAD(4,"Incapacidad temporal por enfermedad"),
	LICENCIA_MATERNIDAD_PATERNIDAD(5, "Licencia de maternidad o paternidad"),
	VACACIONES(6, "Vacaciones"),
	LICENCIA_REMUNERADA(7, "Licencia remunerada"),
	APORTE_VOLUNTARIO(8, "Aporte voluntario a pensiones"),
	SUSPENSION(9, "Suspension");
	
	private final String text;
	
	private final int codigo;

    /**
     * @param text
     */
    TipoNovedad(final int codigo, final String text) {
        this.codigo = codigo;
    	this.text = text;
    }

    /**
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
    
    public int getCodigo() {
    	return this.codigo;
    }
    
  //devuelve el texto del enum
    public String getName() {
    	return this.text;
    }
    
    static public TipoNovedad getTipoByCodigo(int codigo)
    {
        for(TipoNovedad act : TipoNovedad.values())
        {
            if(act.getCodigo() == codigo) {
            	return act;
            }
        }
        return null;
    }
    
}
