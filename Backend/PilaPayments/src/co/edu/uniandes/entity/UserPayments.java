package co.edu.uniandes.entity;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entidad que representa un ususario que utiliza la aplicacion
 * @author Jorge Perea
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("RolType")
public class UserPayments implements Serializable{
	
	/**
	 * id del usuario
	 */
	private Long id;
	
	/**
	 * email del usuario 
	 */
	private String email;
	
	/**
	 * Username del usuario
	 */
	private String username;
	
	/**
	 * Password del usuario
	 */
	private String password;
	
	
	/**
	 * FireBase id
	 */
	private String userId;
	
	/**
	 * Rol del usuario
	 */
	private String rol;
	

	/**
	 * Constructor
	 */
	public UserPayments() {
		
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@Column(name="user_id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the UserId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param Firebase user Id token
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the rol
	 */
	@Transient
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
}
