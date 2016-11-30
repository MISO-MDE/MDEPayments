package co.edu.uniandes.staticmodel;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Estado de un pago
 * @author jorge perea
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EstadoPago {
	COTIZADO, PAGADO
}
