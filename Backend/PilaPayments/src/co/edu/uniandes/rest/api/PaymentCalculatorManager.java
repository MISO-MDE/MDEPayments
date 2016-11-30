package co.edu.uniandes.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.edu.uniandes.businesslogic.BusinessValidations;
import co.edu.uniandes.businesslogic.CalculationFormula;
import co.edu.uniandes.businesslogic.EntityLogic;
import co.edu.uniandes.businesslogic.ValidacionLogic;
import co.edu.uniandes.dao.EntityDAOImpl;
import co.edu.uniandes.dao.SuperEntityDAOImpl;
import co.edu.uniandes.dao.TipoPensionDAOImpl;
import co.edu.uniandes.dao.TipoPensionadoDAOImpl;
import co.edu.uniandes.dao.ValidacionDAOImpl;
import co.edu.uniandes.entity.PilaEntity;

@Path("/calculation")
public class PaymentCalculatorManager {
	
	private EntityLogic logic;
	
	private double calculo1 = 0;
	private double calculo2 = 0;
	private double calculo3 = 0;
	private double total = 0;
	
	
	private static final Logger logger = LogManager.getLogger(EventManager.class);
	//Devuelve el calculo de los pagos
	@GET
	@Path("{cedula}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCalculationPayment(@PathParam("cedula") String cedula) {
		
		Response restResponse;
		logger.debug("Start getPayment");
		logger.debug("data: '" + cedula + "'");
		String errorCondition = "";
		
		PilaEntity theEntity = EntityLogic.getEntityLogic().find(Long.valueOf(cedula));
		
		logger.debug("data:theEntity '" + theEntity.getCedula() + "'");
		
		BusinessValidations busVal = new BusinessValidations(theEntity, new ValidacionLogic(new ValidacionDAOImpl()));
		
		String validations = busVal.validations();
		
		if (validations.isEmpty()) {
 		
			CalculationFormula formulaCalculation = new CalculationFormula(theEntity);
			
			calculo1 = formulaCalculation.getFormula1();
			calculo2 = formulaCalculation.getFormula2();
			calculo3 = formulaCalculation.getFormula3();
			total = calculo1 + calculo2 + calculo3;
		}
		else {
			errorCondition = validations;
		}
				
		String response = null;
		// Si pasa todas las validaciones devuelve 
		
		response = 	"{" +  
					"\"" + "id\": " + theEntity.getId() + "," +
					"\"" + "supetrEntityId\":" + theEntity.getSuperEntidad().getId() + "," +
					"\"" + "entityId\":" + theEntity.getId() + "," +
					"\"" + "subTotal1\":" + calculo1 + "," +
					"\"" + "subTotal2\":" + calculo2 + "," +
					"\"" + "subTotal3\":" + calculo3 + "," +
					"\"" + "amount\":" + total + "" +
					errorCondition +
					"}";
					
	
      
		logger.debug("result: '"+response+"'");
		logger.debug("End getPayments");

		restResponse = Response.status(200).entity(response).build(); //puede realizar el pago retorno 200
		return restResponse; 
	}
	
	/**
	 * metodo auxiliar para obtener la logica del entity
	 * @return
	 */
	public EntityLogic getEntityLogic() {
		if(logic == null){
			logic = new EntityLogic(new EntityDAOImpl(), new SuperEntityDAOImpl(), new TipoPensionDAOImpl(), 
					new TipoPensionadoDAOImpl());	 	
		}
		return logic;
	}
}