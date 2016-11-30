package co.edu.uniandes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.uniandes.entity.PilaEntity;
import co.edu.uniandes.entity.SuperEntity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementacion del dao de entidad
 * @author jorge perea
 */
public class EntityDAOImpl extends DAOBaseImpl<PilaEntity> implements EntityDAO{
	
	
	private static final Logger logger = LogManager.getLogger(EntityDAOImpl.class);
	
	/**
	 * entity manager
	 */
	private static final EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	/**
	 * @see co.edu.uniandes.dao.EntityDAO#findAll()
	 */
	@Override
	public List<PilaEntity> findAll() {
		Query query = getEntityManager().createQuery("from PilaEntity");
			
		return query.getResultList();
	}
	
	/**
	 * @see co.edu.uniandes.dao.EntityDAO#find(int)
	 */
	@Override
	public PilaEntity find(long cedula) {
		logger.debug("Busqueda por Cedula:" + cedula);
		Query query = em.createQuery("select en from PilaEntity en where en.cedula = :cedula");
		query.setParameter("cedula", cedula);
	    
	    return query.getResultList().isEmpty() ? null : (PilaEntity)query.getSingleResult();
	}

	/**
	 * @see co.edu.uniandes.dao.EntityDAO#findAllEntityBySuperEntity(co.edu.uniandes.entity.SuperEntity)
	 */
	@Override
	public List<PilaEntity> findAllEntityBySuperEntity(SuperEntity superEntity) {
		Query query = em.createQuery("select en from PilaEntity en where en.superEntidad = :superEntidad");
		query.setParameter("superEntidad", superEntity);
		
		return query.getResultList();
	}

	@Override
	public PilaEntity findEntityById(Long id) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select en from PilaEntity en where en.id = :id");
		query.setParameter("id", id);
	    
	    return query.getResultList().isEmpty() ? null : (PilaEntity)query.getSingleResult();
	}	
}
