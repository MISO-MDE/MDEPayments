package co.edu.uniandes.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Usuario intermediario
 * @author Jorge Perea
 */
@Entity
@PrimaryKeyJoinColumn(name = "intermediary_id", referencedColumnName = "user_id")
public class UserIntermediary extends UserPayments{

	/**
	 * Constructor
	 */
	public UserIntermediary() {
		super();
	}
	
}
