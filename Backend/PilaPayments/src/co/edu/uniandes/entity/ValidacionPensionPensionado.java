package co.edu.uniandes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ValidacionPensionPensionado {
	
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
	private TipoPensionado tipoPensionado;
	
	/**
	 * Constructor
	 */
	public ValidacionPensionPensionado() {
		
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
	 * @return the tipoPensionado
	 */
	@OneToOne
	@JoinColumn(name="pensionado_id")
	public TipoPensionado getTipoPensionado() {
		return tipoPensionado;
	}

	/**
	 * @param tipoPensionado the tipoPensionado to set
	 */
	public void setTipoPensionado(TipoPensionado tipoPensionado) {
		this.tipoPensionado = tipoPensionado;
	}
}
