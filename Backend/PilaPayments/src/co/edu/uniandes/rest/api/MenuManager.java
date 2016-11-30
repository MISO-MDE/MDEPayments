package co.edu.uniandes.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/forms")
public class MenuManager {

	private static final Logger logger = LogManager.getLogger(MenuManager.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMenu() {

		logger.debug("Start getMenu");
		
		
		String response = null;

		response = "{" + 
					"\"Menu\":[" +
					"\"Pensionados\"," +
					"\"Novedades\"," +
					"\"Pagos\"]" +
					"}";
        
		logger.debug("result: '"+response+"'");
        logger.debug("End getMenu");

        return response;	
	}
}
