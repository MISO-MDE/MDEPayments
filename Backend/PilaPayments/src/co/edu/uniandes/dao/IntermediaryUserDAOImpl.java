package co.edu.uniandes.dao;

import javax.persistence.Query;

import co.edu.uniandes.entity.UserIntermediary;

/**
 * dao para el usuario intermedio
 * @author jorge perea
 */
public class IntermediaryUserDAOImpl extends DAOBaseImpl<UserIntermediary> implements IntermediaryUserDAO {

	/**
	 * @see co.edu.uniandes.dao.IntermediaryUserDAO#getUser(java.lang.String)
	 */
	@Override
	public UserIntermediary getUser(String userId) {
		Query query = getEntityManager().createQuery("select us from UserIntermediary us where us.userId = :userId");
		query.setParameter("userId", userId);
	    
	    return query.getResultList().isEmpty() ? null : (UserIntermediary)query.getResultList().get(0);
	}

}
