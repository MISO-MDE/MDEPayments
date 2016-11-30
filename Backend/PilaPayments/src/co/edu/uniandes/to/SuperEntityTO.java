package co.edu.uniandes.to;

/**
 * To para la super entidad
 * @author jorge perea
 */
public class SuperEntityTO {
	
	/**
	 * id del super entity
	 */
	private String idSuperEntity;
	
	/**
	 * Nit de la super entidad
	 */
	private String NIT;
	
	/**
	 * nombre de la super entidad
	 */
	private String nombre;
	
	/**
	 * email del usuario
	 */
	private String email;
	
	/**
	 * password del usuario
	 */
	private String password;
	
	
	/**
	 * firebaseId del usuario
	 */
	private String userId;
	
	
	/**
	 * username del usuario
	 */
	private String username;
	
	/**
	 * id dle tipopagador
	 */
	private String tipoPagador;
	
	private String actividadEconomica;
	
	private String profesion;
	
	/**
	 * Constructor
	 */
	public SuperEntityTO() {
		
	}

	/**
	 * @return the nIT
	 */
	public String getNIT() {
		return NIT;
	}

	/**
	 * @param nIT the nIT to set
	 */
	public void setNIT(String nIT) {
		NIT = nIT;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return firebaseid
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param firebaseid to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @return the idSuperEntity
	 */
	public String getIdSuperEntity() {
		return idSuperEntity;
	}

	/**
	 * @param idSuperEntity the idSuperEntity to set
	 */
	public void setIdSuperEntity(String idSuperEntity) {
		this.idSuperEntity = idSuperEntity;
	}

	/**
	 * @return the profesion
	 */
	public String getProfesion() {
		return profesion;
	}

	/**
	 * @param profesion the profesion to set
	 */
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	/**
	 * @return the tipoPagador
	 */
	public String getTipoPagador() {
		return tipoPagador;
	}

	/**
	 * @param tipoPagador the tipoPagador to set
	 */
	public void setTipoPagador(String tipoPagador) {
		this.tipoPagador = tipoPagador;
	}

	/**
	 * @return the actividadEconomica
	 */
	public String getActividadEconomica() {
		return actividadEconomica;
	}

	/**
	 * @param actividadEconomica the actividadEconomica to set
	 */
	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}
}
