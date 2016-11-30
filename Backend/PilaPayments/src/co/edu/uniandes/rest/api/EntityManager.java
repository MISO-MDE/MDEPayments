package co.edu.uniandes.rest.api;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.edu.uniandes.businesslogic.EntityLogic;
import co.edu.uniandes.to.EntityTO;


@Path("/entities")
public class EntityManager {

    private static final Logger logger = LogManager.getLogger(EntityManager.class);

    private EntityLogic logic;

    /**
     * Retorna los entities definidos en el
     *
     * @return entidades
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listAll() {
        ObjectMapper mapper = new ObjectMapper();
        logger.debug("Start getEntities");
        String response = "";
        try {
            response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(EntityLogic.getEntityLogic().findAll());
        } catch (JsonProcessingException e) {
            response = "No se pudo obtener la lista " + e.getMessage();
        }
        logger.debug("end getEntities:" + response);
        return response;
    }

    //Consulta por Id de entidad
    @GET
    @Path("/entity")
    @Produces(MediaType.APPLICATION_JSON)
    public String find(@QueryParam("id") String id) {
        logger.debug("Start find");
        logger.debug("id: '" + id + "'");
        ObjectMapper mapper = new ObjectMapper();
        String response = "";
        try {
            response = mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(EntityLogic.getEntityLogic().find(Long.valueOf(id)));
        } catch (Exception ex) {
            response = "No se pudo encontrar el registro. \n" + ex.getMessage();
        }
        logger.debug("result: '" + response + "'");
        return response;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String theEntity) throws JsonParseException, JsonMappingException, IOException {
        EntityTO entityTO = mapObjectEntity2PilaEntityTO(theEntity);
        String id = EntityLogic.getEntityLogic().create(entityTO);
        String response = "{\"id\":\"" + id + "\"}";
        logger.debug("result: '" + response + "'");
        return Response.status(200).entity(response).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(String theEntity) throws JsonParseException, JsonMappingException, IOException {
        logger.debug("Start update");
        EntityTO entityTO = this.mapObjectEntity2PilaEntityTO(theEntity);
        String id = EntityLogic.getEntityLogic().update(entityTO);

        String response = "{\"id\":\"" + id + "\"}";
        logger.debug("result: '" + response + "'");
        logger.debug("End update");
        return response;
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) throws JsonParseException, JsonMappingException, IOException {
        logger.debug("Start delete");
        String idDeleted = EntityLogic.getEntityLogic().delete(id); 
        String response = "{\"id\":\"" + idDeleted + "\"}";
        logger.debug("result: '" + response + "'");
        return Response.status(200).entity(response).build();
    }

    private EntityTO mapObjectEntity2PilaEntityTO(String theEntity) throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		
		final ObjectNode node = mapper.readValue(theEntity.toString(), ObjectNode.class);
        logger.debug("Object " + node.asText());
        EntityTO entityTO = new EntityTO();
        if(node.get("id") != null && !node.get("id").asText().isEmpty())  {        	
        	 entityTO.setId(node.get("id").asText());
        }
        entityTO.setSuperEntidad(node.get("superEntityId").asText());
        entityTO.setCedula(node.get("cedula").asText());
        entityTO.setNombre(node.get("nombre").asText());
        entityTO.setApellido(node.get("apellido").asText());
        entityTO.setSalario(node.get("salario").asText());
        entityTO.setTipoPension(node.get("tipoPension").asText());
        entityTO.setTipoPensionado(node.get("tipoPensionado").asText());
        entityTO.setPais(node.get("pais").asText());
        entityTO.setPaisGrupoFamiliar(node.get("paisGrupoFamiliar").asText());
        entityTO.setProfesion(node.get("profesion").asText());
        return entityTO;
    }
}
