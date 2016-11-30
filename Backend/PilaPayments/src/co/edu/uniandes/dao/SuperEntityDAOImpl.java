package co.edu.uniandes.dao;

import java.util.List;

import javax.persistence.Query;

import co.edu.uniandes.entity.SuperEntity;

/**
 * implementacion del dao para super entidad
 * @author jorge perea
 */
public class SuperEntityDAOImpl extends DAOBaseImpl<SuperEntity> implements SuperEntityDAO {

	/**
	 * @see co.edu.uniandes.dao.SuperEntityDAO#findSuperEntity(java.lang.String)
	 */
	@Override
	public SuperEntity findSuperEntity(String nit) {
		Query query = getEntityManager().createQuery("select se from UserSuperEntity se where se.nit = :nit");
		query.setParameter("nit", nit);
	    
	    return query.getResultList().isEmpty() ? null : (SuperEntity)query.getResultList().get(0);
	}

	/**
	 * @see co.edu.uniandes.dao.SuperEntityDAO#findAllSuperEntity()
	 */
	@Override
	public List<SuperEntity> findAllSuperEntity() {
		Query query = getEntityManager().createQuery("from SuperEntity");
			
		return query.getResultList();
	}

	/**
	 * @see co.edu.uniandes.dao.SuperEntityDAO#findSuperEntityById(java.lang.Long)
	 */
	@Override
	public SuperEntity findSuperEntityById(Long id) {
		Query query = getEntityManager().createQuery("select se from SuperEntity se where se.id = :id");
		query.setParameter("id", id);
	    
	    return query.getResultList().isEmpty() ? null : (SuperEntity)query.getResultList().get(0);
	}
}
