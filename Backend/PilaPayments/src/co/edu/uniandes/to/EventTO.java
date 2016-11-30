package co.edu.uniandes.to;

import java.util.Date;

/**
 * To para la novedad
 * @author Rafa
 */

public class EventTO {
	
	/**
	 * id de la novedad
	 */
	private Long id;
	
	/**
	 * Fecha de creacion de la novedad
	 */
	private Date fechaCreacion;
	
	/**
	 * Fecha de inicio de la novedad
	 */
	private Date fechaInicio;
	
	/**
	 * Fecha de fin de la novedad
	 */
	private Date fechaFin;
	
	/**
	 * tipo de novedad
	 */
	private String tipoNovedad;
	
	/**
	 * estado de novedad
	 */
	private String estado;
	
	/**
	 * entity al cual se le aplica la novedad
	 */
	private String cedulaEntity;
	
	/**
	 * dias habiles de la novedad
	 */
	private String diasHabiles;
	
	/**
	 * Constructor
	 */
	public EventTO() {
		
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * @return the id
	 */
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
	 * @return the tipoNovedad
	 */
	public String getTipoNovedad() {
		return tipoNovedad;
	}

	/**
	 * @param tipoNovedad the tipoNovedad to set
	 */
	public void setTipoNovedad(String tipoNovedad) {
		this.tipoNovedad = tipoNovedad;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cedulaEntity
	 */
	public String getCedulaEntity() {
		return cedulaEntity;
	}

	/**
	 * @param cedulaEntity the cedulaEntity to set
	 */
	public void setCedulaEntity(String cedulaEntity) {
		this.cedulaEntity = cedulaEntity;
	}

	/**
	 * @return the diasHabiles
	 */
	public String getDiasHabiles() {
		return diasHabiles;
	}

	/**
	 * @param diasHabiles the diasHabiles to set
	 */
	public void setDiasHabiles(String diasHabiles) {
		this.diasHabiles = diasHabiles;
	}
}
