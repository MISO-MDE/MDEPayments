package co.edu.uniandes.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import co.edu.uniandes.staticmodel.EstadoNovedad;
import co.edu.uniandes.staticmodel.TipoNovedad;

/**
 * Representa una novedad del sistema
 * @author jorge perea
 */
@Entity
public class Novedad {
	
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
	private TipoNovedad tipoNovedad;
	
	/**
	 * estado de novedad
	 */
	private EstadoNovedad estado;
	
	/**
	 * entity al cual se le aplica la novedad
	 */
	private PilaEntity entity;
	
	/**
	 * Super entity que crea la novedad
	 */
	private SuperEntity superEntity;
	
	/**
	 * cantidad de dias habiles para el calculo
	 */
	private int cantidadDiasHabiles;
	
	/**
	 * Constructor
	 */
	public Novedad() {
		
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
	@Type(type="date")
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
	@Type(type="date")
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
	 * @return the tipoNovedad
	 */
	@Enumerated(EnumType.STRING)
	public TipoNovedad getTipoNovedad() {
		return tipoNovedad;
	}

	/**
	 * @param tipoNovedad the tipoNovedad to set
	 */
	public void setTipoNovedad(TipoNovedad tipoNovedad) {
		this.tipoNovedad = tipoNovedad;
	}

	/**
	 * @return the estado
	 */
	public EstadoNovedad getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	@Enumerated(EnumType.STRING)
	public void setEstado(EstadoNovedad estado) {
		this.estado = estado;
	}

	/**
	 * @return the entity
	 */
	@ManyToOne
	@JoinColumn(name="entity_id")
	public PilaEntity getEntity() {
		return entity;
	}

	/**
	 * @param entity the entity to set
	 */
	public void setEntity(PilaEntity entity) {
		this.entity = entity;
	}

	/**
	 * @return the superEntity
	 */
	@ManyToOne
	@JoinColumn(name="pilaSuperEntity_id")
	public SuperEntity getSuperEntity() {
		return superEntity;
	}

	/**
	 * @param superEntity the superEntity to set
	 */
	public void setSuperEntity(SuperEntity superEntity) {
		this.superEntity = superEntity;
	}

	/**
	 * @return the cantidadDiasHabiles
	 */
	public int getCantidadDiasHabiles() {
		return cantidadDiasHabiles;
	}

	/**
	 * @param cantidadDiasHabiles the cantidadDiasHabiles to set
	 */
	public void setCantidadDiasHabiles(int cantidadDiasHabiles) {
		this.cantidadDiasHabiles = cantidadDiasHabiles;
	}
	
	
}
