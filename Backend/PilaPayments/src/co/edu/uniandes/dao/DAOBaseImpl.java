package co.edu.uniandes.dao;

import javax.persistence.EntityManager;

public class DAOBaseImpl<T> implements DAOBase<T>{
	
	/**
	 * entity manager
	 */
	public EntityManager getEntityManager() {
		return  PersistenceManager.INSTANCE.getEntityManager();
	}
	/**
	 * @see co.edu.uniandes.dao.DAOBase#create(java.lang.Object)
	 */
	@Override
	public T create(T entidad) {
		EntityManager em =  getEntityManager();
		em.getTransaction().begin();
	    em.persist(entidad);
	    em.getTransaction().commit();
	    em.close();
	    return entidad;
	}

	/**
	 * @see co.edu.uniandes.dao.DAOBase#update(java.lang.Object)
	 */
	@Override
	public T update(T entity) {
		EntityManager em =  getEntityManager();
		em.getTransaction().begin();
	    em.merge(entity);
	    em.getTransaction().commit();
	    em.close();
	    return entity;
	}

	/**
	 * @see co.edu.uniandes.dao.DAOBase#deleteEntity(java.lang.Object)
	 */
	@Override
	public void deleteEntity(T entity) {
		EntityManager em =  getEntityManager();
		em.getTransaction().begin();
	    em.remove((em.contains(entity) ? entity : em.merge(entity)));
	    em.getTransaction().commit();
	    em.close();
	}
}
