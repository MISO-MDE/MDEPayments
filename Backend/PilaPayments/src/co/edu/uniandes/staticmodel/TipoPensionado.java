package co.edu.uniandes.staticmodel;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Enum con los valores para el tipo de pensionado
 * @author jorge perea
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoPensionado {
	REGIMEN_PRIMA_MEDIA("Pensionado de régimen de prima media. Tope máximo de pensión 25 smlmv"),
	REGIMEN_PRIMA_MEDIA_SIN_TOPE("Pensionado de régimen de prima media. Sin tope máximo de pensión"),
	REGIMEN_AHORRO_INDIVIDUAL("Pensionado de régimen de ahorro individual. No aplica tope máximo de pensión"),
	RIESGOS_LABORALES("Pensionado de riesgos laborales. Tope máximo de 25 smlmv"),
	PENSIONADO_EMPLEADOR("Pensionado de régimen de ahorro individual. No aplica tope máximo de pensión"),
	ENTIDADES_REGIMEN_ESPECIAL("Pensionado de entidades de los regimenes especial y de excepción, con tope máximo de pensión de "
			+ "25 smlmv"),
	ENTIDADES_REGIMEN_ESPECIAL_SIN_TOPE("Pensionado de entidades de los regimenes especial y de excepción, "
			+ " sin tope máximo de pensión"),
	BENEFICIARIO_UPC_ADICIONAL("Beneficiario UPC adicional");
	
	private final String text;

    /**
     * @param text
     */
    TipoPensionado(final String text) {
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
    
    static public TipoPensionado getEnumbyDesc(String desc)
    {
        for(TipoPensionado act : TipoPensionado.values())
        {
            if(act.getName().equals(desc)) {
            	return act;
            }
        }
        return null;
    }
}
