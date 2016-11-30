package co.edu.uniandes.dao;

import co.edu.uniandes.entity.UserIntermediary;

/**
 * Interfaz para el usuario del intermediario
 * @author jorge perea
 */
public interface IntermediaryUserDAO extends DAOBase<UserIntermediary>{
	
	/**
	 * retorna el usuario del super entity
	 * @param id id del super entity
	 * @return
	 */
	public UserIntermediary getUser(String id);
}
