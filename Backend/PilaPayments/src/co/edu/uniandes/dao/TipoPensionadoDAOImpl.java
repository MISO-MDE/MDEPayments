package co.edu.uniandes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.uniandes.entity.TipoPensionado;

public class TipoPensionadoDAOImpl extends DAOBaseImpl<TipoPensionado> implements TipoPensionadoDAO{
	
	/**
	 * entity manager
	 */
	private static final EntityManager em = PersistenceManager.INSTANCE.getEntityManager();	
	
	@Override
	public TipoPensionado find(Long id) {
		Query query = em.createQuery("select tp from TipoPensionado tp where tp.id = :id");
		query.setParameter("id", id);
	    
	    return query.getResultList().isEmpty() ? null : (TipoPensionado)query.getSingleResult();
	}

	@Override
	public List<TipoPensionado> findAll() {
		Query query = getEntityManager().createQuery("from TipoPensionado");
		
		return query.getResultList();
	}

	@Override
	public List<TipoPensionado> findByTPagador(Long id) {
		Query query = em.createQuery("select tp from TipoPensionado tp, ValidacionPensionadoPagador pp where tp.id=pp.tipoPensionado.id and pp.tipoPagador.id = :id");
		System.out.println(query.toString());
		query.setParameter("id", id);
	    
	    return (List<TipoPensionado>) query.getResultList();
	}

	@Override
	public List<TipoPensionado> findByTPension(Long id) {
		Query query = em.createQuery("select tp from TipoPensionado tp, ValidacionPensionPensionado pp where tp.id=pp.tipoPensionado.id and pp.tipoPension.id = :id");
		query.setParameter("id", id);
	    
	    return (List<TipoPensionado>)query.getResultList();
	}

	
}
