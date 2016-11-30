package co.edu.uniandes.dao;

import java.util.List;

import co.edu.uniandes.entity.TipoPension;
import co.edu.uniandes.entity.TipoPensionado;

/**
 * interfaz del dao de tipo pension
 * @author jorge perea
 */
public interface TipoPensionDAO extends DAOBase<TipoPension>{
	
	/**
	 * encuentra por id
	 * @param id
	 */
	public TipoPension find(Long id);
	
	/**
	 * retorna todos los tipos de pension
	 * @return
	 */
	public List<TipoPension> findAll();

	public List<TipoPension> findByTPagador(Long id);

	public List<TipoPension> findByTPensionado(Long id);

}
