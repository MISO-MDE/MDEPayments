package co.edu.uniandes.dao;

import co.edu.uniandes.entity.UserSuperEntity;

/**
 * Interfaz de superEntity
 * @author jorge perea
 */
public interface SuperEntityUserDAO extends DAOBase<UserSuperEntity>{
	
	/**
	 * retorna el usuario del super entity
	 * @param id id del super entity
	 * @return
	 */
	public UserSuperEntity getUser(String id);
}
