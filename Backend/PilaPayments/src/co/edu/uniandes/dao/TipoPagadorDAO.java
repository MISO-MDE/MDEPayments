package co.edu.uniandes.dao;

import java.util.List;

import co.edu.uniandes.entity.TipoPagador;

public interface TipoPagadorDAO {
	
	public TipoPagador find(Long id);
	
	public List<TipoPagador> findAll();
}
