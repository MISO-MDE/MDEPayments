package co.edu.uniandes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ValidacionPensionPagador {
		
	/**
	 * id
	 */
	private Long id;
	
	/**
	 * tipo de pension
	 */
	private TipoPension tipoPension;
	
	/**
	 * tipo pensionado
	 */
	private TipoPagador tipoPagador;
	
	/**
	 * Constructor
	 */
	public ValidacionPensionPagador() {
		
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	 * @return the tipoPension
	 */
	@OneToOne
	@JoinColumn(name="pension_id")
	public TipoPension getTipoPension() {
		return tipoPension;
	}

	/**
	 * @param tipoPension the tipoPension to set
	 */
	public void setTipoPension(TipoPension tipoPension) {
		this.tipoPension = tipoPension;
	}

	/**
	 * @return the tipoPagador
	 */
	@OneToOne
	@JoinColumn(name="pagador_id")
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
