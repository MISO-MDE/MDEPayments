package co.edu.uniandes.dao;

import java.util.List;

import javax.persistence.Query;

import co.edu.uniandes.entity.Novedad;
import co.edu.uniandes.staticmodel.EstadoNovedad;
import co.edu.uniandes.staticmodel.TipoNovedad;

/**
 * implementacion del dao de novedad
 * @author jorge perea
 */
public class NovedadDAOImpl extends DAOBaseImpl<Novedad> implements NovedadDAO {

	/**
	 * @see co.edu.uniandes.dao.NovedadDAO#findByEntity(java.lang.Long)
	 */
	@Override
	public List<Novedad> findByEntityTipo(Long idEntity, TipoNovedad tipo) {
		Query query = getEntityManager().createQuery("select no from Novedad no where no.entity.id = :idEntity "
				+ "and no.estado = :estado "
				+ "and no.tipoNovedad = :tipo");
		query.setParameter("idEntity", idEntity);
		query.setParameter("estado", EstadoNovedad.PENDIENTE);
		query.setParameter("tipo", TipoNovedad.SLN);
		
		return query.getResultList();
	}

	/**
	 * @see co.edu.uniandes.dao.NovedadDAO#findNovedadesSuperEntity(java.lang.Long)
	 */
	@Override
	public List<Novedad> findNovedadesSuperEntity(Long idSuperEntity) {
		Query query = getEntityManager().createQuery("select no from Novedad no where no.superEntity.id = :idSuperEntity");
		query.setParameter("idSuperEntity", idSuperEntity);
		
		return query.getResultList();
	}

	/**
	 * @see co.edu.uniandes.dao.NovedadDAO#findNovedadesEntityByCedula(java.lang.String)
	 */
	@Override
	public List<Novedad> findNovedadesEntityByCedula(Long cedulaEntity) {
		Query query = getEntityManager().createQuery("select no from Novedad no where no.entity.cedula = :cedulaEntity");
		query.setParameter("cedulaEntity", cedulaEntity);
		
		return query.getResultList();
	}

}
