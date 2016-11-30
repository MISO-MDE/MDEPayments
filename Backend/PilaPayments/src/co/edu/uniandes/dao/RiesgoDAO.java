package co.edu.uniandes.dao;

import co.edu.uniandes.entity.Riesgo;

public interface RiesgoDAO extends DAOBase<Riesgo> {
	
	public Riesgo findByActividadEconomica(Long idActividad);

}
