package co.edu.uniandes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.uniandes.entity.TipoPagador;

public class TipoPagadorDAOImpl extends DAOBaseImpl<TipoPagador> implements TipoPagadorDAO {

	/**
	 * entity manager
	 */
	private static final EntityManager em = PersistenceManager.INSTANCE.getEntityManager();	
	
	@Override
	public TipoPagador find(Long id) {
		Query query = em.createQuery("select tp from TipoPagador tp where tp.id = :id");
		query.setParameter("id", id);
	    
	    return query.getResultList().isEmpty() ? null : (TipoPagador)query.getSingleResult();
	}

	@Override
	public List<TipoPagador> findAll() {
		Query query = getEntityManager().createQuery("from TipoPagador");
		
		return query.getResultList();
	}

}
