package co.edu.uniandes.staticmodel;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Actividad economica
 * @author jorge perea
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ActividadEconomica {
	
	ESTABLECIMIENTO_EDUCACION_MEDIA("8022","Establecimientos de educación media"),
	EMPRESA_ODONTOLOGIA("8513","Empresas dedicadas a practicas de odontologia"),
	EMPRESA_FRUTAS_BEBESTIBLES("0117","Empresas dedicadas a la producción especializada de frutas "
			+ ", nueces, plantas bebestibles, y especias. Incluye el tostado y beneficio del cacao"),
	EMPRESA_PRODUCTOS_ALMIDON_ANIMALES("1541","Empresa dedicada a la elaboracion de productos de molineria, de almidones, "
			+ "productos derivados del almidon y alimentos preparados para animales. Incluye el tostado de semillas y granos"),
	EMPRESA_BEBIDA_FERMENTADA("1592","Empresa dedicada a la elaboracion de bebidas fermentadas no destiladas"),
	EMPRESA_CUERDAS("1743","Empresa dedicada a la fabricación de cuerdas, cordeles, cables, bramantes y redes"),
	EMPRESA_PAPEL("2101", "Empresa dedicada a la fabricación de papel, carton, y productos de papel y carton"),
	EMPRESA_DERIVADOS_PETROLEO("2322", "Empresa dedicada a la fabricación de productos derivados del petroleo, fuera de"
			+ " refineria como asfalto"),
	EMPRESA_ESMERALDAS("1431", "Extraccion de esmeraldas"),
	EMPRESA_PETROLEO_REFINERIA("2321","Fabricacion de productos de la refinación del petroleo, elaborados en refineria");
	
	/**
	 * codigo ciu de la actividad economica
	 */
	private final String id;
	
	/**
	 * descripcion de la actividad
	 */
	private final String name;
    
	/**
     * @param text
     */
    ActividadEconomica(String ciu, String descripcion) {
        this.id = ciu;
        this.name= descripcion;
    }
    
    /**
     * Retorna la actividad económica que tiene el codigo ciiu correspondiente
     * @param ciiu codigo ciiiu
     * @return actividad economica
     */
    static public ActividadEconomica getActividadByCIIU(String ciiu)
    {
        for(ActividadEconomica act : ActividadEconomica.values())
        {
            if(act.getId().equals(ciiu)) {
            	return act;
            }
        }
        return null;
    }
    
    /**
     * Retorna el ciu
     * @return
     */
    public String getId() {
    	return id;
    }
    
    /**
     * Retorna el ciu
     * @return
     */
    public String getName() {
    	return name;
    }
    
    /**
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return id + " - " + name;
    }
    
}
