package co.edu.uniandes.dao;

import java.util.List;

import co.edu.uniandes.entity.Novedad;
import co.edu.uniandes.staticmodel.TipoNovedad;

/**
 * Dao para la novedad
 * @author jorge perea
 */
public interface NovedadDAO extends DAOBase<Novedad>{
	
	/**
	 * retorna las novedad de una entidad
	 * @param idEntity id de la entidad
	 * @return lista con todas las novedades de entidad
	 */
	public List<Novedad> findByEntityTipo(Long idEntity, TipoNovedad tipo);

	/**
	 * retorna las novedad de una entidad
	 * @param idEntity id de la entidad
	 * @return lista con todas las novedades de entidad
	 */
	public List<Novedad> findNovedadesEntityByCedula(Long cedulaEntity);
	
	/**
	 * retorna las novedad de una super entity
	 * @param idEntity id de la super entity
	 * @return lista con todas las novedades de la super entities
	 */
	public List<Novedad> findNovedadesSuperEntity(Long idSuperEntity);
}
