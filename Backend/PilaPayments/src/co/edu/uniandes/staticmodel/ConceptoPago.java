package co.edu.uniandes.staticmodel;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Representa un concepto de pago en el sistema
 * @author jorge perea
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ConceptoPago {

	EPS, PENSION, RIESGO_LABORAL
}
