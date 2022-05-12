package com.klabitos.app.DTO;



/**
 * The Class UsuarioDTO.
 */
public class UsuarioDTO {
	
	/** The id usuario. */
	private Integer idUsuario;
	
	/** The email. */
	private String email;
	
	/** The name. */
	private String name;
	
	/** The surname. */
	private String surname;
	
	/** The nickname. */
	private String nickname;
	
	/** The fecha nacimiento. */
	private String fechaNacimiento;
	
	/** The id ciudad. */
	private Integer idCiudad; 
		
	
	/**
	 * Instantiates a new usuario DTO.
	 */
	public UsuarioDTO() {
		super();
	}
	
	/**
	 * Instantiates a new usuario DTO.
	 *
	 * @param idUsuario the id usuario
	 * @param email the email
	 * @param name the name
	 * @param surname the surname
	 * @param nickname the nickname
	 * @param fechaNacimiento the fecha nacimiento
	 * @param idCiudad the id ciudad
	 */
	public UsuarioDTO(Integer idUsuario, String email, String name, String surname, String nickname, 
			String fechaNacimiento, Integer idCiudad) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.nickname = nickname;
		this.fechaNacimiento = fechaNacimiento;
		this.idCiudad = idCiudad;
	}
	
	/**
	 * Gets the id usuario.
	 *
	 * @return the id usuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	/**
	 * Sets the id usuario.
	 *
	 * @param idUsuario the new id usuario
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Sets the surname.
	 *
	 * @param surname the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * Sets the nickname.
	 *
	 * @param nickname the new nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Gets the fecha nacimiento.
	 *
	 * @return the fecha nacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param fechaNacimiento the new fecha nacimiento
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * Gets the id ciudad.
	 *
	 * @return the id ciudad
	 */
	public Integer getIdCiudad() {
		return idCiudad;
	}
	
	/**
	 * Sets the id ciudad.
	 *
	 * @param idCiudad the new id ciudad
	 */
	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	
	
}
