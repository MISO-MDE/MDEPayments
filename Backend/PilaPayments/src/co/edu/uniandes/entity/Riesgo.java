package co.edu.uniandes.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


/**
 * Clasificacion del riesgo para una entidad
 * @author jorge perea
 */
@Entity
public class Riesgo {
	
	/**
	 * id del riesgo
	 */
	private Long id;
	
	/**
	 * Codigo del riesgo
	 */
	private int claseRiesgo;

	/**
	 * Actividades economicas asociadas al riesgo
	 */
	private List<ActividadEconomica> actividadesEconomicas;
	
	/**
	 * Constructor
	 */
	public Riesgo() {
		
	}
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the claseRiesgo
	 */
	public int getClaseRiesgo() {
		return claseRiesgo;
	}

	/**
	 * @param claseRiesgo the claseRiesgo to set
	 */
	public void setClaseRiesgo(int claseRiesgo) {
		this.claseRiesgo = claseRiesgo;
	}

	/**
	 * @return the actividadesEconomicas
	 */
	 @OneToMany
	 @JoinTable(name = "riesgo_actividad", 
	   joinColumns = @JoinColumn(name = "riesgo_id"), 
	   inverseJoinColumns = @JoinColumn(name = "actividadeconomica_id"))
	public List<ActividadEconomica> getActividadesEconomicas() {
		return actividadesEconomicas;
	}

	/**
	 * @param actividadesEconomicas the actividadesEconomicas to set
	 */
	public void setActividadesEconomicas(List<ActividadEconomica> actividadesEconomicas) {
		this.actividadesEconomicas = actividadesEconomicas;
	}
}
