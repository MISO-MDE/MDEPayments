package co.edu.uniandes.businesslogic;

import co.edu.uniandes.dao.IntermediaryUserDAO;
import co.edu.uniandes.dao.SuperEntityUserDAO;
import co.edu.uniandes.entity.UserPayments;
import co.edu.uniandes.entity.UserIntermediary;
import co.edu.uniandes.entity.UserSuperEntity;
import co.edu.uniandes.to.PilaUserTO;

/**
 * logica de negocio del usuario
 * @author jorge perea
 */
public class UserLogic {
	
	/**
	 * dao de super entidad
	 */
	private SuperEntityUserDAO superDAO;
	
	private IntermediaryUserDAO intermediaryDAO;

	
	/**
	 * Constructor
	 * @param dao
	 */
	public UserLogic(IntermediaryUserDAO intermediaryDAO, SuperEntityUserDAO superDAO) {
		this.superDAO = superDAO;
		this.intermediaryDAO = intermediaryDAO;
	}
	
	/**
	 * Retorna el user con el id especificado
	 * @param userId
	 * @return
	 */
	public PilaUserTO getPilaUser(String userId) {
		
		PilaUserTO resultado = new PilaUserTO();
		
		UserSuperEntity user = superDAO.getUser(userId);
		UserIntermediary user2 = intermediaryDAO.getUser(userId);
		
		if(user != null) {	

			resultado.setIdDb(user.getId().toString());
			resultado.setEmail(user.getEmail());
			resultado.setRoleName("SuperEntity");
			resultado.setUserId(userId);
			resultado.setSuperEntity(user.getSuperEntity());
			resultado.setPassword(user.getPassword());
			
		} else if(user2 != null) {
			
			resultado.setIdDb(user2.getId().toString());
			resultado.setEmail(user2.getEmail());
			resultado.setRoleName("Intermediary");
			resultado.setUserId(userId);
			resultado.setSuperEntity(null);
			resultado.setPassword(user2.getPassword());
		}
		
		return resultado;
	}	
}
