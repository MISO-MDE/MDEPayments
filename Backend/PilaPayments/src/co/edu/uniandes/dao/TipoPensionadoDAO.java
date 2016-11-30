package co.edu.uniandes.dao;

import java.util.List;

import co.edu.uniandes.entity.TipoPensionado;

/**
 * interfaz del tipo pensionado
 * @author jorge perea
 */
public interface TipoPensionadoDAO {

	public TipoPensionado find(Long id);
	
	public List<TipoPensionado> findAll();

	public List<TipoPensionado> findByTPagador(Long id);

	public List<TipoPensionado> findByTPension(Long id);

}
