package co.edu.uniandes.rest.api;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

import co.edu.uniandes.businesslogic.EventLogic;
import co.edu.uniandes.dao.EntityDAOImpl;
import co.edu.uniandes.dao.NovedadDAOImpl;
import co.edu.uniandes.to.EventTO;


@Path("/event")
public class EventManager {

	private static final Logger logger = LogManager.getLogger(EventManager.class);
	
	/**
	 * logica de negocio de novedades
	 */
	private EventLogic logic;
	
	/**
	 * Retorna las novedades asociadas con una entidad
	 * @param cedula cedula a buscar
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEvent(@PathParam("id") String cedula) {

		ObjectMapper mapper = new ObjectMapper();
		String response = "";
		try {
			response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getEventLogic().getEventsByCedula(cedula));
		} catch (JsonProcessingException e) {
			response = "No se pudo obtener la lista " + e.getMessage();
		}
		return response;   

	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(String theEvent) throws ParseException {
		
		logger.debug("Start postEvent");

		EventTO to = new EventTO();
		try {
			final ObjectNode node = new ObjectMapper().readValue(theEvent.toString(), ObjectNode.class);
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			if(!node.get("cedulaEntity").asText().isEmpty()) {
				to.setCedulaEntity((node.get("cedulaEntity").asText()));
			}
			
			if(!node.get("fechaFinal").asText().isEmpty()) {	
				cal.setTime(format.parse(node.get("fechaFinal").asText()));
				to.setFechaFin(cal.getTime());
			}

			if(!node.get("fechaInicial").asText().isEmpty()) {	        	
				cal.setTime(format.parse(node.get("fechaInicial").asText()));
				to.setFechaInicio(cal.getTime());
			}

			if(!node.get("tipoNovedad").asText().isEmpty()) {
				to.setTipoNovedad(node.get("tipoNovedad").asText());
			}
			
			if(!node.get("diasHabiles").asText().isEmpty()) {
				to.setDiasHabiles((node.get("diasHabiles").asText()));
			}
			String id = EventLogic.getEventLogic().create(to);
			
			String response = "{\"id\":\""+ id +"\"}";
		} catch(IOException | ParseException e) {
			return  Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		String response = "{\"id\":\"123443\"}"; // Debe retornar el id creado la entidad

		logger.debug("result: '"+response+"'");
        logger.debug("End postEvent");

        return Response.status(200).entity(response).build();
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String udpate(String theEvent) throws JsonParseException, JsonMappingException, IOException, ParseException {
		logger.debug("Start putEvent");
		
		String response = "";
		String id = "";
		EventTO to = new EventTO();
		try {
			final ObjectNode node = new ObjectMapper().readValue(theEvent.toString(), ObjectNode.class);
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(!node.get("fechaFinal").asText().isEmpty()) {	        	
				to.setFechaFin(format.parse(node.get("fechaFinal").asText()));
			}

			if(!node.get("fechaInicial").asText().isEmpty()) {	        	
				to.setFechaInicio(format.parse(node.get("fechaInicial").asText()));
			}

			to.setFechaCreacion(new Date());

			if(!node.get("tipoNovedad").asText().isEmpty()) {
				to.setTipoNovedad(node.get("tipoNovedad").asText());
			}
			
			if(!node.get("diasHabiles").asText().isEmpty()) {
				to.setDiasHabiles(node.get("diasHabiles").asText());
			}
			id = EventLogic.getEventLogic().create(to);
			
		} catch(IOException | ParseException e) {
			response = "No se pudo actualizar la novedad " + e.getMessage();
		}
		
		response = "{\"id\":\""+ id +"\"}";

		logger.debug("result: '"+response+"'");
        logger.debug("End putEvent");

        return response;	
	}

	@DELETE
	public void deleteSuperEntity(Object theEvent) {
		
		logger.debug("Start deleteEntity");
	}
		
	/**
	 * Retorna instancia inicializada de la logica de negocio
	 * @return
	 */
	public EventLogic getEventLogic() {
		if(logic == null){
			logic = new EventLogic(new NovedadDAOImpl(), new EntityDAOImpl());					
		}
		return logic;
	}
}
