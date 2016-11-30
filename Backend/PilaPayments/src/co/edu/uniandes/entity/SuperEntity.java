package co.edu.uniandes.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Super entidad que desea realizar pagos a empleados
 * @author jorge perea
 */
@Entity
public class SuperEntity {
	
	/**
	 * id de la super entidad
	 */
	private Long Id;
	
	/**
	 * Nit de la super entidad
	 */
	private String NIT;
	
	/**
	 * nombre de la super entidad
	 */
	private String nombre;
	
	/**
	 * codigo que representa la actividad economica
	 */
	private ActividadEconomica actividad;
	
	/**
	 * entities asociados a la super entidad
	 */
	private List<PilaEntity> entities;
	
	/**
	 * tipo de pagador
	 */
	private TipoPagador tipoPagador;
	
	/**
	 * constructor
	 */
	public SuperEntity() {
		
	}
		
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}

	/**
	 * @return the nIT
	 */
	public String getNIT() {
		return NIT;
	}

	/**
	 * @param nIT the nIT to set
	 */
	public void setNIT(String nIT) {
		NIT = nIT;
	}

	/**
	 * @return the nombre
	 */
	@JsonProperty("name")
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the entities
	 */
	@OneToMany(mappedBy="superEntidad")
	public List<PilaEntity> getEntities() {
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	public void setEntities(List<PilaEntity> entities) {
		this.entities = entities;
	}

	/**
	 * @return the actividad
	 */
	@OneToOne
	@JoinColumn(name = "actividad_economica_id")
	public ActividadEconomica getActividad() {
		return actividad;
	}

	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(ActividadEconomica actividad) {
		this.actividad = actividad;
	}

	/**
	 * @return the tipoPagador
	 */
	@OneToOne
	@JoinColumn(name = "tipo_pagador_id")
	public TipoPagador getTipoPagador() {
		return tipoPagador;
	}

	/**
	 * @param tipoPagador the tipoPagador to set
	 */
	public void setTipoPagador(TipoPagador tipoPagador) {
		this.tipoPagador = tipoPagador;
	}
}
