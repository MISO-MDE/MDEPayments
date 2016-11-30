package co.edu.uniandes.rest.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uniandes.businesslogic.ParameterLogic;
import co.edu.uniandes.dao.ActividadEconomicaDAOImpl;
import co.edu.uniandes.dao.TipoPagadorDAOImpl;
import co.edu.uniandes.dao.TipoPensionDAOImpl;
import co.edu.uniandes.dao.TipoPensionadoDAOImpl;
import co.edu.uniandes.entity.TipoPension;
import co.edu.uniandes.entity.TipoPensionado;
import co.edu.uniandes.entity.Validacion;

@Path("/parameters")
public class ParameterManager {
    private static final Logger logger = LogManager.getLogger(ParameterManager.class);
    private ParameterLogic logic;


	 /**
     * Retorna los TipoPagador
     * @return entidades
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tipopagador")
    public String listAllTipoPagador() {
        ObjectMapper mapper = new ObjectMapper();
        logger.debug("Start getEntities");
        String response = "";
        try {
            response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getParameterLogic().findAllTipoPagador());
        } catch (JsonProcessingException e) {
            response = "No se pudo obtener la lista " + e.getMessage();
        }
        logger.debug("end getEntities:" + response);
        return response;
    }
    
    /**
     * Retorna los TipoPagador
     *
     * @return entidades
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/actividadeconomica")
    public String listAllActividadEconomica() {
        ObjectMapper mapper = new ObjectMapper();
        logger.debug("Start getEntities");
        String response = "";
        try {
            response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getParameterLogic().findAllActividadEconomica());
        } catch (JsonProcessingException e) {
            response = "No se pudo obtener la lista " + e.getMessage();
        }
        logger.debug("end getEntities:" + response);
        return response;
    }
    
	 /**
     * Retorna los TipoPensionado para un TipoPagador
     *
     * @return entidades
	 * @throws CloneNotSupportedException 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tipopagador/{idPagador}/opciones")
    public String listTPensionadoByTPagador(@PathParam("idPagador") Long idPagador) throws CloneNotSupportedException {
        ObjectMapper mapper = new ObjectMapper();
        logger.debug("Start getEntities");
        String response = "";
        try {
        	
        	List<TipoPensionado> listPensionado = getParameterLogic().listTPensionadoByTPagador(idPagador);
        	List<TipoPension> listPension = getParameterLogic().listTPensionByTPagador(idPagador);
        	
        	Validacion validaciones= new Validacion();
        	HashMap<String, List<?>> mapPensionadoPension = new HashMap<String, List<?>>();
        	mapPensionadoPension.put("0", listPension);
        	for(int i=0; i<listPensionado.size();i++){
        		TipoPensionado pensionado = listPensionado.get(i);
        		List<?> itemsPension = getParameterLogic().listTPensionByTPensionado(pensionado.getId());
        		List<TipoPension> listTPension = new ArrayList<TipoPension>();
        		for(int j=0; j<listPension.size();j++){
        			TipoPension pension = listPension.get(j);
        			TipoPension tPension =(TipoPension) pension.clone();
        			tPension.setStatus(itemsPension.contains(pension));
        			listTPension.add(tPension);
        		}
        		mapPensionadoPension.put(pensionado.getId()+"", listTPension);        	
        	}
        	      	
        	HashMap<String, List<?>> mapPensionPensionado = new HashMap<String, List<?>>();
        	mapPensionPensionado.put("0", listPensionado);
        	for(int i=0; i<listPension.size();i++){
        		TipoPension pension = listPension.get(i);
        		List<?> itemsPensionado =  getParameterLogic().listTPensionadoByTPension(pension.getId());
        		List<TipoPensionado> listTPensionado = new ArrayList<TipoPensionado>();
        		for(int j=0; j<listPensionado.size();j++){
        			TipoPensionado pensionado = listPensionado.get(j);
        			TipoPensionado tPensionado =(TipoPensionado) pensionado.clone();
        			tPensionado.setStatus(itemsPensionado.contains(pensionado));
        			listTPensionado.add(tPensionado);
        		}
        		mapPensionPensionado.put(pension.getId()+"", listTPensionado);
        	}
        	
        	validaciones.getValues().put("pensionPensionado", mapPensionPensionado);
        	validaciones.getValues().put("pensionadoPension", mapPensionadoPension);

        	
            response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(validaciones);
        } catch (JsonProcessingException e) {
            response = "No se pudo obtener la lista " + e.getMessage();
        }
        logger.debug("end getEntities:" + response);
        return response;
    }
    /**
     * metodo auxiliar para obtener la logica del entity
     *
     * @return
     */
	private ParameterLogic getParameterLogic() {
		
	        if (logic == null) {
	            logic = new ParameterLogic(new TipoPagadorDAOImpl(), new TipoPensionadoDAOImpl(), new ActividadEconomicaDAOImpl(), new TipoPensionDAOImpl());
	         
	        }
	        return logic;
	    }
}
