package co.edu.uniandes.dao;

import java.util.List;

import javax.persistence.Query;

import co.edu.uniandes.entity.Pais;

/**
 * implementacion del dao de pais
 * @author jorge perea
 */
public class PaisDAOImpl extends DAOBaseImpl<Pais> implements PaisDAO{

	/**
	 * @see co.edu.uniandes.dao.PaisDAO#findAll()
	 */
	@Override
	public List<Pais> findAll() {
		Query query = getEntityManager().createQuery("from Pais");
	    
	    return query.getResultList();
	}

}
