package co.edu.uniandes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ValidacionPensionadoPagador {
	
	/**
	 * id
	 */
	private Long id;
	
	/**
	 * tipo de pension
	 */
	private TipoPensionado tipoPensionado;
	
	/**
	 * tipo pensionado
	 */
	private TipoPagador tipoPagador;
	
	/**
	 * Constructor
	 */
	public ValidacionPensionadoPagador() {
		
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
