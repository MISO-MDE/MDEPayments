package co.edu.uniandes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.uniandes.entity.ActividadEconomica;

public class ActividadEconomicaDAOImpl extends DAOBaseImpl<ActividadEconomica> implements ActividadEconomicaDAO{
	
	/**
	 * entity manager
	 */
	private static final EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	
	@Override
	public ActividadEconomica find(Long id) {
		Query query = em.createQuery("select ae from ActividadEconomica ae where ae.id = :id");
		query.setParameter("id", id);
	    
	    return query.getResultList().isEmpty() ? null : (ActividadEconomica)query.getSingleResult();
	}

	@Override
	public List<ActividadEconomica> findAll() {
		Query query = getEntityManager().createQuery("from ActividadEconomica");
		
		return query.getResultList();
	}

}
