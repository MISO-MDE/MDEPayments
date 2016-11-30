package co.edu.uniandes.dao;

import java.util.List;

import co.edu.uniandes.entity.Pais;

/**
 * interfaz de dao de pais
 * @author jorge perea
 */
public interface PaisDAO {

	/**
	 * Retorna todos los paises del sistema
	 * @return lista de paises
	 */
	public List<Pais> findAll();
}
