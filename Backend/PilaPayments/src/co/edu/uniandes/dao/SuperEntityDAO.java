package co.edu.uniandes.dao;

import java.util.List;

import co.edu.uniandes.entity.SuperEntity;

/**
 * Interfaz del dao de super entidad
 * @author jorge perea
 */
public interface SuperEntityDAO extends DAOBase<SuperEntity>{
	
	/**
	 * Retorna un super
	 * @param nit nit de la super entity
	 * @return la super entidad con el nit
	 */
	public SuperEntity findSuperEntity(String nit);
	
	/**
	 * Retorna todas las super entidades
	 * @return lista con las super entidades
	 */
	public List<SuperEntity> findAllSuperEntity();
	
	/**
	 * Retorna la super entidad con el id especificado
	 * @param id de la super entidad
	 * @return super entidad
	 */
	public SuperEntity findSuperEntityById(Long id);
	
}
