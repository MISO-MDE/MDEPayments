package co.edu.uniandes.dao;

import java.util.List;

import co.edu.uniandes.entity.PilaEntity;
import co.edu.uniandes.entity.SuperEntity;

/**
 * Dao para la entidad
 * @author jorge perea
 */
public interface EntityDAO extends DAOBase<PilaEntity> {

	/**
	 * encuentra el entity por cedula
	 * @param cedula
	 * @return
	 */
	public PilaEntity find(long cedula);
	
	/**
	 * Encuentra el enity por id
	 * @param id
	 * @return
	 */
	public PilaEntity findEntityById(Long id);
	
	/**
	 * Retorna todas las entidades
	 * @return lista con las entidades
	 */
	public List<PilaEntity> findAll();
	
	/**
	 * devuelve todos lo entities relacionados con una super entidad
	 * @param superEntity
	 * @return
	 */
	public List<PilaEntity>findAllEntityBySuperEntity(SuperEntity superEntity);
	
	
}
