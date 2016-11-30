package co.edu.uniandes.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Usuario administrador de super entity
 * @author jorge perea
 */
@Entity
@PrimaryKeyJoinColumn(name = "super_id", referencedColumnName = "user_id")
public class UserSuperEntity extends UserPayments{
	
	/**
	 * super entidad a la cual esta asociada 
	 */
	private SuperEntity superEntity;
	
	/**
	 *constructor
	 */
	public UserSuperEntity() {
		super();
	}

	/**
	 * @return the superEntity
	 */
	@OneToOne
	@JoinColumn(name="superEntity_id")
	public SuperEntity getSuperEntity() {
		return superEntity;
	}

	/**
	 * @param superEntity the superEntity to set
	 */
	public void setSuperEntity(SuperEntity superEntity) {
		this.superEntity = superEntity;
	}
}
