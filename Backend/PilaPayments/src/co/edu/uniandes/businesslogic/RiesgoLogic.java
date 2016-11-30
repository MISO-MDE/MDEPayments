package co.edu.uniandes.businesslogic;

import co.edu.uniandes.dao.RiesgoDAO;
import co.edu.uniandes.dao.RiesgoDAOImpl;
import co.edu.uniandes.entity.Riesgo;
import co.edu.uniandes.to.RiesgoTO;

public class RiesgoLogic {

	private RiesgoDAO riesgoDAO;
	
	public RiesgoLogic(RiesgoDAO riesgoDAO) {
		this.riesgoDAO = riesgoDAO;
	}
	
	public Riesgo findByActividadEconomica(Long idActividad) {
		
		return riesgoDAO.findByActividadEconomica(idActividad);
	}
	
	public static RiesgoLogic getRiesgoLogic() {
		return new RiesgoLogic(new RiesgoDAOImpl());
	}
}
