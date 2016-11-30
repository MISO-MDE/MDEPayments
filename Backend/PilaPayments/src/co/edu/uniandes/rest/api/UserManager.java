package co.edu.uniandes.rest.api;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.edu.uniandes.businesslogic.SuperEntityLogic;
import co.edu.uniandes.businesslogic.UserLogic;
import co.edu.uniandes.dao.ActividadEconomicaDAOImpl;
import co.edu.uniandes.dao.IntermediaryUserDAOImpl;
import co.edu.uniandes.dao.SuperEntityDAOImpl;
import co.edu.uniandes.dao.SuperEntityUserDAOImpl;
import co.edu.uniandes.dao.TipoPagadorDAOImpl;
import co.edu.uniandes.to.SuperEntityTO;
import co.edu.uniandes.to.PilaUserTO;

@Path("/users")
public class UserManager {
	
	private static final Logger logger = LogManager.getLogger(UserManager.class);
	
	/**
	 * logica de la super entidad
	 */
	private SuperEntityLogic logic;
	
	/**
	 * logica del usuario
	 */
	private UserLogic userLogic;
	
	/* Servicio Rest que recibe el id de usuario y devuelve el role del usuario */
	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserInfo(@PathParam("userId") String userId) throws JsonProcessingException {

		logger.debug("Obteniendo Usuario");
		logger.debug("userId: '" + userId + "'");
		
		String response = null;
		
		//Consulta con id del usuario userId y devuelve el role de la base de datos Llave primaria=userId
		//Aqui debemos llamar la capa capa de negocio que esta a su vez llama a la capa de persistencia
		
		PilaUserTO user = getUserLogic().getPilaUser(userId);
		ObjectMapper mapper = new ObjectMapper();
		
		if(user != null && user.getIdDb() != null) {
			response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		} else {
			response = "No se encontro el usuario";
		}
        
       logger.debug("resultado: '"+response+"'");
       logger.debug("End Get");
        
        return response;
	}
	
	/**
	 * Crea un usuario para la superentidad
	 * @param loggedUser
	 * @return
	 */
	@POST
	@Path("/superentity")
	@Produces(MediaType.APPLICATION_JSON)	
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(String  loggedUser)  throws JsonParseException, JsonMappingException, IOException {
		
		logger.debug("Ingreso Parametros de usuario");
		logger.debug("loggedUser: '" + loggedUser.toString() + "'");
		
		final ObjectNode node = new ObjectMapper().readValue(loggedUser.toString(), ObjectNode.class);
		
		logger.debug("Mail: '" +node.get("email").asText() + "'"); //Login Usuario
		logger.debug("Name: '" +node.get("name").asText() + "'"); // Nombre del usuario
		logger.debug("FirebaseId: '" +node.get("userId").asText() + "'"); //Codigo FirebaseId del Usuario
		logger.debug("superEntityId: '" +node.get("superEntityId").asText() + "'"); //Super entidad que administra
		
		SuperEntityTO superTO = new SuperEntityTO();
			
		superTO.setEmail(node.get("email").asText());
		superTO.setUsername(node.get("name").asText());
		superTO.setUserId(node.get("userId").asText()); //Guarda el Firebase Id para consultar luego al hacer login
		superTO.setIdSuperEntity(node.get("superEntityId").asText());
		superTO.setPassword(node.get("password").asText());
		
		
		logger.debug("FirebaseId: SuperTo:" + superTO.getUserId());
		logger.debug("SuperIdToSave: SuperTo:" + superTO.getIdSuperEntity());
		
		String resultado = getSuperEntityLogic().createSuperEntityUser(superTO);
		
		String response = "{\"resp\":\""+ resultado +"\"}";
        
        logger.debug("resultado: '"+response+"'");
        logger.debug("Fin Post");

        return Response.status(200).entity(response).build();
	}
	
	/**
	 * Metodo que retorna la logica
	 * @return
	 */
	public SuperEntityLogic getSuperEntityLogic() {
		if(logic == null){
			logic = new SuperEntityLogic(new SuperEntityDAOImpl(), new SuperEntityUserDAOImpl(), new TipoPagadorDAOImpl(),
					new ActividadEconomicaDAOImpl());
		}
		return logic;
	}
	
	/**
	 * Metodo que retorna la logica del user
	 * @return
	 */
	public UserLogic getUserLogic() {
		if(userLogic == null){
			userLogic = new UserLogic( new IntermediaryUserDAOImpl(), new SuperEntityUserDAOImpl());
		}
		return userLogic;
	}
}
