package co.edu.uniandes.dao;

import java.util.List;

import co.edu.uniandes.entity.ActividadEconomica;

public interface ActividadEconomicaDAO {
	
	public ActividadEconomica find(Long id);
	
	public List<ActividadEconomica> findAll();
}
