package co.edu.uniandes.businesslogic;

import java.util.List;

import co.edu.uniandes.dao.PagoDAO;
import co.edu.uniandes.dao.PagoDAOImpl;
import co.edu.uniandes.entity.Pago;
import co.edu.uniandes.to.PagoTO;

public class PaymentLogic {
	
	/**
	 * dao de pagos
	 */
	private PagoDAO pagoDAO;
	
	/**
	 * cosntructor
	 * @param pagoDAO
	 */
	public PaymentLogic(PagoDAO pagoDAO) {
		this.pagoDAO = pagoDAO;
	}
	
	/**
	 * realiza la creacion de un pago
	 * @return
	 */
	public Pago create(PagoTO pago) {
		return pagoDAO.create(null);
	}
	
	public List<Pago> findPagosEntity(String cedula) {		
		return pagoDAO.findPagosEntity(Long.parseLong(cedula));
	}
	
	public static PaymentLogic getPaymentLogic() {
		return new PaymentLogic(new PagoDAOImpl());
	}
}
