package co.edu.uniandes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * representa una entidad asociada a una super entidad de PILA
 * @author jorge perea
 */
@Entity
public class PilaEntity {
	
	/**
	 * id de la entidad
	 */
	private Long id;
	
	/**
	 * cedula del entity
	 */
	private long cedula;
	
	/**
	 * nombre
	 */
	private String nombre;
	
	/**
	 * apellido
	 */
	private String apellido;
	
	/**
	 * salario
	 */
	private double salario;
	
	/**
	 * tipo pension
	 */
	private TipoPension tipoPension;
	
	/**
	 * tipo pensionado
	 */
	private TipoPensionado tipoPensionado;
	
	/**
	 * Pais en el que reside
	 */
	private Long pais;
	
	/**
	 * pais del grup familiar
	 */
	private Long paisGrupoFamiliar;
	
	/**
	 * super entidad a la que pertenece
	 */
	@JsonIgnore
	private SuperEntity superEntidad;
	
	/**
	 * profesion del entity
	 */
	private String profesion;
	
	/**
	 * Constructor
	 */
	public PilaEntity() {
		
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
	 * @return the cedula
	 */
	public long getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombre
	 */	
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
	 * @return the apellido
	 */	
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the salario
	 */	
	public double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * @return el tipo de pension
	 */	
	@OneToOne
	@JoinColumn(name="tipo_pension_id")
	public TipoPension getTipoPension(){
		return tipoPension;
	}
	
	/**
	 * @param tipoPension the tipoPension to set
	 */
	public void setTipoPension(TipoPension tipoPension){
		this.tipoPension = tipoPension;
	}
	
	/**
	 * @return el tipo de pensionado
	 */	
	@OneToOne
	@JoinColumn(name="tipo_pensionado_id")
	public TipoPensionado getTipoPensionado(){
		return tipoPensionado;
	}
	
	/**
	 * @param tipoPensionado the tipoPensionado to set
	 */
	public void setTipoPensionado(TipoPensionado tipoPensionado){
		this.tipoPensionado = tipoPensionado;
	}


	/**
	 * @return the superEntidad
	 */	
	@ManyToOne
	@JoinColumn(name="superEntity_id")
	public SuperEntity getSuperEntidad() {
		return superEntidad;
	}

	/**
	 * @param superEntidad the superEntidad to set
	 */
	public void setSuperEntidad(SuperEntity superEntidad) {
		this.superEntidad = superEntidad;
	}

	/**
	 * @return the pais
	 */	
	public Long getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(Long pais) {
		this.pais = pais;
	}

	/**
	 * @return the paisGrupoFamiliar
	 */	
	public Long getPaisGrupoFamiliar() {
		return paisGrupoFamiliar;
	}

	/**
	 * @param paisGrupoFamiliar the paisGrupoFamiliar to set
	 */
	public void setPaisGrupoFamiliar(Long paisGrupoFamiliar) {
		this.paisGrupoFamiliar = paisGrupoFamiliar;
	}

	/**
	 * @return the profesion
	 */
	public String getProfesion() {
		return profesion;
	}

	/**
	 * @param profesion the profesion to set
	 */
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
}
