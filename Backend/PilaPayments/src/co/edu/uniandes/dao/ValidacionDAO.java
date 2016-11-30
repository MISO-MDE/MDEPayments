package co.edu.uniandes.dao;

import co.edu.uniandes.entity.ValidacionPensionPagador;
import co.edu.uniandes.entity.ValidacionPensionPensionado;
import co.edu.uniandes.entity.ValidacionPensionadoPagador;

/**
 * Interfaz del dao de validacion
 * @author jorge perea
 */
public interface ValidacionDAO {
	
	/**
	 * Valida que corresponda el tipo de pension con el pensionado
	 * @param idPension
	 * @param idPensionado
	 * @return
	 */
	public ValidacionPensionPensionado validarPensionPensionado(String idPension, String idPensionado);
	
	/**
	 * Valida que corresponda el tipo de pension con el pagador
	 * @param idPension
	 * @param idPensionado
	 * @return
	 */
	public ValidacionPensionPagador validarPensionPagador(String idPension, String idPagador);
	
	/**
	 * Valida que correspondan el tipo de pensionado con el tipo de pagador
	 * @param idPension
	 * @param idPensionado
	 * @return
	 */
	public ValidacionPensionadoPagador validarPensionadoPagador(String idPensionado, String idPagador);
}
