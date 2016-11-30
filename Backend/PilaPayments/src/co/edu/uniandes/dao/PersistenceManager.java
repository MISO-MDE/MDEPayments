package co.edu.uniandes.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Manager para la persistencia
 * @author jorge perea
 */
public enum PersistenceManager {

	INSTANCE;
	private EntityManagerFactory emFactory;
	private PersistenceManager() {

		emFactory = Persistence.createEntityManagerFactory("postgres");
	}
	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
	public void close() {
		emFactory.close();
	}
}
