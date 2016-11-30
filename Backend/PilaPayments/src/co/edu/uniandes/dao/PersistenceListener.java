package co.edu.uniandes.dao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PersistenceListener implements ServletContextListener{
	
	private EntityManagerFactory entityManagerFactory;

    public void contextInitialized(ServletContextEvent sce){
        ServletContext context = sce.getServletContext();
        entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        entityManagerFactory.close();
    }
}
