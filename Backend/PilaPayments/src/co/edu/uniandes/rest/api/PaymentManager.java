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
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.edu.uniandes.businesslogic.PaymentLogic;
import co.edu.uniandes.businesslogic.ValidacionLogic;

@Path("/payment")
public class PaymentManager {

	private static final Logger logger = LogManager.getLogger(EventManager.class);
	
	//Consulta pagos de la base de datos
	@GET
	@Path("{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPayments(@PathParam("cedula") String cedula) {

		logger.debug("Start getPayment");

		String response = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			response = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(PaymentLogic.getPaymentLogic().findPagosEntity(cedula));
		} catch (Exception ex) {
			response = "No se pudo encontrar el registro. \n" + ex.getMessage();
		}

		logger.debug("result: '"+response+"'");
		logger.debug("End getPayments");

		return response;	
	}
	
	//Envia pago para guardar en la base de datos
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(String thePayment) {

		logger.debug("Start postEvent");
		
		logger.debug("Object " + thePayment.toString());
		
		String response = "{\"id\":\"123443\"}"; // Debe retornar el id creado la entidad

		logger.debug("result: '"+response+"'");
        logger.debug("End postPayment");

        return Response.status(200).entity(response).build();
	}
	
	/**
	 * Valida que exista una relacion entre el tipo de pension y el tipo de pensionado
	 * @param theSuperEntity
	 * @return respuesta indicando si existe la relacion
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("/vPensionPensionado")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validarPensionPensionado(String theSuperEntity) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		
		final ObjectNode node = mapper.readValue(theSuperEntity.toString(), ObjectNode.class);
		
		String idPension = "";
		String idPensionado = "";
		if(!node.get("idPension").asText().isEmpty()) {
			idPension = node.get("idPension").asText();
		}
		
		if(!node.get("idPensionado").asText().isEmpty()) {
			idPensionado = node.get("idPensionado").asText();
		}
		
		String response = "{\"respuesta\":\"error\"}"; 
		
		if(ValidacionLogic.getValidacionLogic().validarPensionPensionado(idPension, idPensionado) != null){
			response = "{\"respuesta\":\"ok\"}";
		}
		
		return Response.status(200).entity(response).build();
	}
	
	/**
	 * Valida que exista una relacion entre el tipo de pension y el tipo de pagador
	 * @param theSuperEntity
	 * @return respuesta indicando si existe la relacion
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("/vPensionPagador")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validarPensionPagador(String theSuperEntity) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		
		final ObjectNode node = mapper.readValue(theSuperEntity.toString(), ObjectNode.class);
		
		String idPension = "";
		String idPagador = "";
		if(!node.get("idPension").asText().isEmpty()) {
			idPension = node.get("idPension").asText();
		}
		
		if(!node.get("idPagador").asText().isEmpty()) {
			idPagador = node.get("idPagador").asText();
		}
		
		String response = "{\"respuesta\":\"error\"}"; 
		
		if(ValidacionLogic.getValidacionLogic().validarPensionPagador(idPension, idPagador) != null){
			response = "{\"respuesta\":\"ok\"}";
		}
		
		return Response.status(200).entity(response).build();
		
	}
	
	/**
	 * Valida que exista una relacion entre el tipo de pensionado y el tipo de pagador
	 * @param theSuperEntity
	 * @return respuesta indicando si existe la relacion
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("/vPensionadoPagador")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validarPensionadoPagador(String theSuperEntity) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		
		final ObjectNode node = mapper.readValue(theSuperEntity.toString(), ObjectNode.class);
		
		String idPensionado = "";
		String idPagador = "";
		if(!node.get("idPensionado").asText().isEmpty()) {
			idPensionado = node.get("idPensionado").asText();
		}
		
		if(!node.get("idPagador").asText().isEmpty()) {
			idPagador = node.get("idPagador").asText();
		}
		
		String response = "{\"respuesta\":\"error\"}"; 
		
		if(ValidacionLogic.getValidacionLogic().validarPensionadoPagador(idPensionado, idPagador) != null){
			response = "{\"respuesta\":\"ok\"}";
		}
		
		return Response.status(200).entity(response).build();
		
	}
}
