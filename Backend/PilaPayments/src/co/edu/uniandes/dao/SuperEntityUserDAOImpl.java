package co.edu.uniandes.dao;

import javax.persistence.Query;

import co.edu.uniandes.entity.UserSuperEntity;

/**
 * Implementacion del dao
 * @author jorge perea
 */
public class SuperEntityUserDAOImpl extends DAOBaseImpl<UserSuperEntity> implements SuperEntityUserDAO {

	@Override
	public UserSuperEntity getUser(String userId) {
		Query query = getEntityManager().createQuery("select us from UserSuperEntity us where us.userId = :userId");
		query.setParameter("userId", userId);
	    
	    return query.getResultList().isEmpty() ? null : (UserSuperEntity)query.getResultList().get(0);
	}
	
}
