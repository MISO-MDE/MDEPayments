package co.edu.uniandes.dao;

import co.edu.uniandes.entity.UserPayments;

/**
 * Interfaz de DAO para user de intermediario
 * @author jorge perea
 */
public interface DAOUser extends DAOBase<UserPayments> {
	
	/**
	 * Retorna el usuario con el username dado
	 * @param username
	 */
	public UserPayments findByUsername(String username);
	
	/**
	 * Retorna el usuario con el username dado
	 * @param userId id del usuario buscado
	 * @return
	 */
	public UserPayments findByUserId(String userId);
}
