package co.edu.uniandes.businesslogic;

import java.util.Arrays;
import java.util.List;

import co.edu.uniandes.dao.ActividadEconomicaDAO;
import co.edu.uniandes.dao.SuperEntityDAO;
import co.edu.uniandes.dao.SuperEntityUserDAO;
import co.edu.uniandes.dao.TipoPagadorDAO;
import co.edu.uniandes.entity.SuperEntity;
import co.edu.uniandes.entity.UserSuperEntity;
import co.edu.uniandes.staticmodel.ActividadEconomica;
import co.edu.uniandes.to.SuperEntityTO;

/**
 * Logica del super entity
 * @author jorge perea
 */
public class SuperEntityLogic {

	/**
	 * dao de super entidad
	 */
	private SuperEntityDAO superDAO;
	
	/**
	 * dao usuario de super entidad
	 */
	private SuperEntityUserDAO userDAO;
	
	/**
	 * dao de tipo pagador
	 */
	private TipoPagadorDAO pagadorDAO;
	
	/**
	 * dao de actividad economica
	 */
	private ActividadEconomicaDAO actividadDAO;
	
	/**
	 * Constructor
	 * @param dao
	 */
	public SuperEntityLogic(SuperEntityDAO superDAO, SuperEntityUserDAO userDAO, TipoPagadorDAO pagadorDAO, 
			ActividadEconomicaDAO actividadDAO) {
		this.superDAO = superDAO;
		this.userDAO = userDAO;
		this.pagadorDAO = pagadorDAO;
		this.actividadDAO = actividadDAO;
	}
	
	/**
	 * crea una super entidad
	 * @param superTO
	 */
	public String create(SuperEntityTO superTO) {
		
		// se crea la super entidad
		SuperEntity superEntity= new SuperEntity();
		superEntity.setNIT(superTO.getNIT());
		superEntity.setNombre(superTO.getNombre());
		superEntity.setActividad(actividadDAO.find(Long.parseLong(superTO.getActividadEconomica())));
		superEntity.setTipoPagador(pagadorDAO.find(Long.parseLong(superTO.getTipoPagador())));
		
		superEntity = superDAO.create(superEntity);	
		
		return superEntity.getId().toString();
	}
	
	/**
	 * crea un usuario para el intermediario
	 * @param superTO
	 * @return
	 */
	public String createSuperEntityUser(SuperEntityTO superTO) {
		
		String respuesta = "";
		
		//se crea el usuario
		UserSuperEntity user = new UserSuperEntity();
		
		SuperEntity superEntity = superDAO.findSuperEntityById(Long.parseLong(superTO.getIdSuperEntity()));
		
		user.setEmail(superTO.getEmail());
		user.setUsername(superTO.getUsername());
		user.setPassword(superTO.getPassword());
		user.setUserId(superTO.getUserId()); // Guarda el id de firebase
		user.setSuperEntity(superEntity);
		
		user = userDAO.create(user);
		
		if(user.getId() != null) {
			respuesta = "ok";
		} else {
			respuesta = "error al crear usuario";
		}
		
		return respuesta;
	}
	
	/**
	 * Actualiza la superEntidad
	 * @return super entidad actualizada
	 */
	public String update(SuperEntityTO superTO) {
		
		SuperEntity superEntity = superDAO.findSuperEntityById(Long.parseLong(superTO.getIdSuperEntity()));
		String response = "SuperEntity not updated";
		if(superEntity != null) {
			
			if(!superTO.getNombre().isEmpty()) {
				superEntity.setNombre(superTO.getNombre());
			} 
			
			if(!superTO.getNIT().isEmpty()) {
				superEntity.setNIT(superTO.getNIT());
			}
			
			if(!superTO.getActividadEconomica().isEmpty()) {
				superEntity.setActividad(actividadDAO.find(Long.valueOf(superTO.getActividadEconomica())));
			}
			
			if(superTO.getTipoPagador() != null) {
				superEntity.setTipoPagador(pagadorDAO.find(Long.valueOf(superTO.getTipoPagador())));
			}
			
			
			superDAO.update(superEntity).getId();
			response = "SuperEntity updated";
		}
		
		return response;
	}
	
	/**
	 * elimina un super entity
	 * @param id
	 */
	public void delete(Long id) {
		SuperEntity superEntity = superDAO.findSuperEntityById(id);
		superDAO.deleteEntity(superEntity);
	}
	
	/**
	 * retorna las super entidades del sistema
	 * @return
	 */
	public List<SuperEntity> getSuperEntities() {
		return superDAO.findAllSuperEntity();
	}
	
	/**
	 * retorna las super entidad por id
	 * @return
	 */
	public SuperEntity getSuperEntitiesById(long id) {
		return superDAO.findSuperEntityById(id);
	}
	
	/**
	 * Retorna las actividades economicas definidas en el sistema
	 * @return actividades economicas
	 */
	public List<ActividadEconomica> getEconActivities() {
		return Arrays.asList(ActividadEconomica.values());
	}
}
