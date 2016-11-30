package co.edu.uniandes.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.uniandes.entity.ValidacionPensionPagador;
import co.edu.uniandes.entity.ValidacionPensionPensionado;
import co.edu.uniandes.entity.ValidacionPensionadoPagador;

/**
 * implementacion del dao de validacion
 * @author jorge perea
 */
public class ValidacionDAOImpl implements ValidacionDAO{
	
	/**
	 * @see co.edu.uniandes.dao.ValidacionDAO#validarPensionPensionado(java.lang.String, java.lang.String)
	 */
	@Override
	public ValidacionPensionPensionado validarPensionPensionado(String idPension, String idPensionado) {
		Query query = getEntityManager().createQuery("select vpp from ValidacionPensionPensionado vpp "
				+ "where vpp.tipoPension.codigo = :idPension and vpp.tipoPensionado.codigo = :idPensionado");
		query.setParameter("idPension", idPension);
		query.setParameter("idPensionado", idPensionado);
		
	    return query.getResultList().isEmpty() ? null : (ValidacionPensionPensionado)query.getResultList().get(0);
	}

	/**
	 * @see co.edu.uniandes.dao.ValidacionDAO#validarPensionPagador(java.lang.String, java.lang.String)
	 */
	@Override
	public ValidacionPensionPagador validarPensionPagador(String idPension, String idPagador) {
		Query query = getEntityManager().createQuery("select vpp from ValidacionPensionPagador vpp "
				+ "where vpp.tipoPension.codigo = :idPension and vpp.tipoPagador.codigo = :idPagador");
		query.setParameter("idPension", idPension);
		query.setParameter("idPagador", idPagador);
		
		return query.getResultList().isEmpty() ? null : (ValidacionPensionPagador)query.getResultList().get(0);
	}

	/**
	 * @see co.edu.uniandes.dao.ValidacionDAO#validarPensionadoPagador(java.lang.String, java.lang.String)
	 */
	@Override
	public ValidacionPensionadoPagador validarPensionadoPagador(String idPensionado, String idPagador) {
		Query query = getEntityManager().createQuery("select vpp from ValidacionPensionadoPagador vpp "
				+ "where vpp.tipoPensionado.codigo = :idPensionado and vpp.tipoPagador.codigo = :idPagador");
		query.setParameter("idPensionado", idPensionado);
		query.setParameter("idPagador", idPagador);
		
		return query.getResultList().isEmpty() ? null : (ValidacionPensionadoPagador)query.getResultList().get(0);
	}
	
	/**
	 * entity manager
	 */
	public EntityManager getEntityManager() {
		return  PersistenceManager.INSTANCE.getEntityManager();
	}
}
