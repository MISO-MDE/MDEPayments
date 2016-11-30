package co.edu.uniandes.businesslogic;

import java.util.List;

import co.edu.uniandes.dao.ActividadEconomicaDAO;
import co.edu.uniandes.dao.TipoPagadorDAO;
import co.edu.uniandes.dao.TipoPensionDAO;
import co.edu.uniandes.dao.TipoPensionadoDAO;
import co.edu.uniandes.entity.ActividadEconomica;
import co.edu.uniandes.entity.TipoPagador;
import co.edu.uniandes.entity.TipoPension;
import co.edu.uniandes.entity.TipoPensionado;

public class ParameterLogic {

	private TipoPensionDAO pensionDAO;
	private TipoPensionadoDAO pensionadoDAO;
	private ActividadEconomicaDAO actividadDAO;
	private TipoPagadorDAO pagadorDAO;
	
	public ParameterLogic(TipoPagadorDAO pagadorDAO, TipoPensionadoDAO pensionadoDAO, ActividadEconomicaDAO actividadDAO, 
			TipoPensionDAO pensionDAO) {
		this.pagadorDAO = pagadorDAO;
		this.pensionadoDAO = pensionadoDAO;
		this.actividadDAO = actividadDAO;
		this.pensionDAO = pensionDAO;
	}
	
	public List<TipoPensionado> findAllTipoPensionado() {
		return pensionadoDAO.findAll();
	}
	
	public List<TipoPension> findAllTipoPension() {
		return pensionDAO.findAll();
	}
	
	public List<ActividadEconomica> findAllActividadEconomica() {
		return actividadDAO.findAll();
	}
	
	public List<TipoPagador> findAllTipoPagador() {
		return pagadorDAO.findAll();
	}

	public List<TipoPensionado>  listTPensionadoByTPagador(Long id) {
		// TODO Auto-generated method stub
		return pensionadoDAO.findByTPagador(id);
		}
	public List<TipoPension>  listTPensionByTPagador(Long id) {
		// TODO Auto-generated method stub
		return pensionDAO.findByTPagador(id);
		}
	public List<TipoPensionado>  listTPensionadoByTPension(Long id) {
		// TODO Auto-generated method stub
		return pensionadoDAO.findByTPension(id);
		}
	public List<TipoPension>  listTPensionByTPensionado(Long id) {
		// TODO Auto-generated method stub
		return pensionDAO.findByTPensionado(id);
		}
	
}
