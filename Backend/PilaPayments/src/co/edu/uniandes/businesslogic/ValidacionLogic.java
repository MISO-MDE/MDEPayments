package co.edu.uniandes.businesslogic;

import co.edu.uniandes.dao.ValidacionDAO;
import co.edu.uniandes.dao.ValidacionDAOImpl;
import co.edu.uniandes.entity.ValidacionPensionPagador;
import co.edu.uniandes.entity.ValidacionPensionPensionado;
import co.edu.uniandes.entity.ValidacionPensionadoPagador;

public class ValidacionLogic {
	
	/**
	 * dao de validacion
	 */
	private ValidacionDAO validacionDAO;
	
	/**
	 * Constructor
	 * @param validacionDAO
	 */
	public ValidacionLogic(ValidacionDAO validacionDAO) {
		this.validacionDAO = validacionDAO;
	}
	
	/**
	 * Ejecuta validacion tipo pension vs tipo pensionado
	 * @param idPension
	 * @param idPensionado
	 * @return
	 */
	public ValidacionPensionPensionado validarPensionPensionado(String idPension, String idPensionado) {
		return validacionDAO.validarPensionPensionado(idPension, idPensionado);
	}
	
	/**
	 * ejecuta validacion tipo pension vs pagador
	 * @param idPension
	 * @param idPagador
	 * @return
	 */
	public ValidacionPensionPagador validarPensionPagador(String idPension, String idPagador) {
		return validacionDAO.validarPensionPagador(idPension, idPagador);
	}
	
	/**
	 * ejecuta validacion tipo pensionado vs pagador
	 * @param idPension
	 * @param idPagador
	 * @return
	 */
	public ValidacionPensionadoPagador validarPensionadoPagador(String idPensionado, String idPagador) {
		return validacionDAO.validarPensionadoPagador(idPensionado, idPagador);
	}
	
	/**
	 * metodo auxiliar para obtener la logica del super entity
	 * @return
	 */
	public static ValidacionLogic getValidacionLogic() {
		
		return new ValidacionLogic(new ValidacionDAOImpl());					
	}
}

