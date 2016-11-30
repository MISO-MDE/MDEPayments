package co.edu.uniandes.dao;

/**
 * Interfaz para operaciones comunes
 * @author jorge perea
 * @param <T>
 */
public interface DAOBase<T> {
	
	/**
	 * persiste el entity especificado
	 * @param entity
	 * @return
	 */
	public T create(T entidad);
	
	/**
	 * Actualiza un entity
	 * @param entity
	 * @return
	 */
	public T update(T entity);
	
	/**
	 * elimina un entity
	 * @param id
	 */
	public void deleteEntity(T entity);
	
}
