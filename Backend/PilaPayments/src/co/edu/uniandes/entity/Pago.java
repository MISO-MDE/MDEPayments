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

import co.edu.uniandes.staticmodel.EstadoPago;

/**
 * Entity que representa un pago de aportes
 * @author jorge perea
 */
@Entity
public class Pago {
	
	/**
	 * id del pago
	 */
	private Long id;
	
	/**
	 * valor del pago
	 */
	private Long valor;
	
	/**
	 * Concepto del pago
	 */
	private double valor1;
	
	/**
	 * Concepto del pago
	 */
	private double valor2;
	
	/**
	 * Concepto del pago
	 */
	private double valor3;
	
	/**
	 * fecha del pago
	 */
	private Date fecha;
	
	/**
	 * Entidad a la cual se le realizo el pago
	 */
	private PilaEntity pilaEntity;
	
	/**
	 * Super entidad que ha realizado el pago
	 */
	private SuperEntity superEntity;
	
	/**
	 * estado del pago
	 */
	private EstadoPago estado;
	
	/**
	 * Constructor
	 */
	public Pago() {
		
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
	 * @return the pilaEntity
	 */
	@ManyToOne
	@JoinColumn(name="pilaEntity_id")
	public PilaEntity getPilaEntity() {
		return pilaEntity;
	}

	/**
	 * @param pilaEntity the pilaEntity to set
	 */
	public void setPilaEntity(PilaEntity pilaEntity) {
		this.pilaEntity = pilaEntity;
	}

	/**
	 * @return the valor
	 */
	public Long getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Long valor) {
		this.valor = valor;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the estado
	 */
	@Enumerated(EnumType.STRING)
	public EstadoPago getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoPago estado) {
		this.estado = estado;
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
	 * @return the valor1
	 */
	public double getValor1() {
		return valor1;
	}

	/**
	 * @param valor1 the valor1 to set
	 */
	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}

	/**
	 * @return the valor2
	 */
	public double getValor2() {
		return valor2;
	}

	/**
	 * @param valor2 the valor2 to set
	 */
	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}

	/**
	 * @return the valor3
	 */
	public double getValor3() {
		return valor3;
	}

	/**
	 * @param valor3 the valor3 to set
	 */
	public void setValor3(double valor3) {
		this.valor3 = valor3;
	}
	
}
