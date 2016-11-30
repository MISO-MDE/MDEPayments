package co.edu.uniandes.businesslogic;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.edu.uniandes.dao.ActividadEconomicaDAO;
import co.edu.uniandes.dao.EntityDAO;
import co.edu.uniandes.dao.EntityDAOImpl;
import co.edu.uniandes.dao.SuperEntityDAO;
import co.edu.uniandes.dao.SuperEntityDAOImpl;
import co.edu.uniandes.dao.TipoPensionDAO;
import co.edu.uniandes.dao.TipoPensionDAOImpl;
import co.edu.uniandes.dao.TipoPensionadoDAO;
import co.edu.uniandes.dao.TipoPensionadoDAOImpl;
import co.edu.uniandes.entity.PilaEntity;
import co.edu.uniandes.to.EntityTO;

/**
 * Logica del super entity
 * @author Rafa
 */
public class EntityLogic {

	private EntityDAO entityDAO;
	private SuperEntityDAO superEntityDAO;
	private TipoPensionDAO pensionDAO;
	private TipoPensionadoDAO pensionadoDAO;
	
	private static final Logger logger = LogManager.getLogger(EntityLogic.class);
	
	/**
	 * Constructor
	 * @param dao
	 */
	
	public EntityLogic(EntityDAO entityDAO, SuperEntityDAO superEntityDAO, TipoPensionDAO pensionDAO, TipoPensionadoDAO pensionadoDAO){
		this.entityDAO = entityDAO;
		this.superEntityDAO = superEntityDAO;
		this.pensionDAO = pensionDAO;
		this.pensionadoDAO = pensionadoDAO;
	}
	
	/**
	 * Crear Entidad
	 * @param entityTO
	 */
	public String update(EntityTO entityTO){		
		String response = "";		
		PilaEntity entity = entityDAO.findEntityById(Long.parseLong(entityTO.getId()));
		if(entity != null) {
			if(!entityTO.getCedula().isEmpty() ) {
				entity.setCedula(Long.parseLong(entityTO.getCedula()));
			}
			
			if(!entityTO.getNombre().isEmpty()) {
				entity.setNombre(entityTO.getNombre());
			}
			
			if(!entityTO.getApellido().isEmpty()) {
				entity.setApellido(entityTO.getApellido());
			}
			
			if(!entityTO.getSalario().isEmpty()) {
				entity.setSalario(Double.parseDouble(entityTO.getSalario()));
			}
			
			if(!entityTO.getTipoPension().isEmpty()) {
				entity.setTipoPension(pensionDAO.find(Long.parseLong(entityTO.getTipoPension())));
			}
			
			if(!entityTO.getTipoPensionado().isEmpty()) {
				entity.setTipoPensionado(pensionadoDAO.find(Long.parseLong(entityTO.getTipoPensionado())));
			}
			
			if(!entityTO.getProfesion().isEmpty()) {
				entity.setProfesion(toTitle(entityTO.getProfesion()));
			}			
			
			if(!entityTO.getPais().isEmpty()) {
				entity.setPais(Long.parseLong(entityTO.getPais()));
			}
			
			if(!entityTO.getPaisGrupoFamiliar().isEmpty()) {
				entity.setPaisGrupoFamiliar(Long.parseLong(entityTO.getPaisGrupoFamiliar()));
			}
				
			entity = entityDAO.update(entity);
		}	
		
		response = entity.getId().toString();		
		return response;
	}
	
	
	/**
	 * Crear Entidad
	 * @param entityTO
	 */
	public String create(EntityTO entityTO){
		
		String response = "";
		
		PilaEntity entity = new PilaEntity();
		entity.setCedula(Long.parseLong(entityTO.getCedula()));
		entity.setNombre(entityTO.getNombre());
		entity.setApellido(entityTO.getApellido());
		entity.setSalario(Double.parseDouble(entityTO.getSalario()));
		entity.setTipoPension(pensionDAO.find(Long.parseLong(entityTO.getTipoPension())));
		entity.setTipoPensionado(pensionadoDAO.find(Long.parseLong(entityTO.getTipoPensionado())));
		entity.setSuperEntidad(superEntityDAO.findSuperEntityById(Long.parseLong(entityTO.getSuperEntidad())));
		entity.setPais(Long.parseLong(entityTO.getPais()));
		entity.setPaisGrupoFamiliar(Long.parseLong(entityTO.getPaisGrupoFamiliar()));
		entity.setProfesion(entityTO.getProfesion());
		
		entity = entityDAO.create(entity);
		
		response = entity.getId().toString();
		
		return response;
	}
	
	public String delete(Long id){		
		String response = "";		
		PilaEntity entity = entityDAO.findEntityById(id);
		if(entity != null){
			entityDAO.deleteEntity(entity);	
			response = id+"";		
		}
		return response;
	}
	
	/**
	 * retorna las entidades del sistema
	 * @return
	 */
	public List<PilaEntity> findAll() {
		return entityDAO.findAll();
	}
	
	/**
	 * retorna la entidad por id
	 * @return
	 */
	public PilaEntity find(long id) {
		return entityDAO.find(id);
	}	
	
	/**
	 * Metodo auxiliar para convertir un string en titulo
	 * @param s string a convertir
	 * @return string convertido
	 */
	public String toTitle (String s) {
	      String s1 = s.substring(0,1).toUpperCase();
	      String sTitle = s1 + s.substring(1);
	      return sTitle;
	}
	
    /**
     * metodo auxiliar para obtener la logica del entity
     * @return
     */
    public static EntityLogic getEntityLogic() {       
        return new EntityLogic(new EntityDAOImpl(), new SuperEntityDAOImpl(), new TipoPensionDAOImpl(), new TipoPensionadoDAOImpl()); 
    }
}
