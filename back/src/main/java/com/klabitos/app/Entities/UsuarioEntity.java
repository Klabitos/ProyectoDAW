package com.klabitos.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class UsuarioEntity.
 */
@Entity
@Table(name="usuario")
public class UsuarioEntity {

	/** The id usuario. */
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario") 
	private Integer idUsuario;
  
	/** The name. */
	@Column(name="name")
	private String name;

	/** The email. */
	@Column(name="email")
	private String email;
	
	/** The surname. */
	@Column(name="surname")
	private String surname;
	
	/** The nickname. */
	@Column(name="nickname")
	private String nickname;
	
	/** The id ciudad. */
	@Column(name="idciudad") //WeatherApi
	private Integer idCiudad;
	
	/** The fecha nacimiento. */
	@Column(name="fechanacimiento")
	private String fechaNacimiento;
	
	

	/**
	 * Instantiates a new usuario entity.
	 */
	public UsuarioEntity() {
		super();
	}

	/**
	 * Instantiates a new usuario entity.
	 *
	 * @param idUsuario the id usuario
	 * @param name the name
	 * @param email the email
	 * @param surname the surname
	 * @param nickname the nickname
	 * @param idCiudad the id ciudad
	 * @param fechaNacimiento the fecha nacimiento
	 */
	public UsuarioEntity(Integer idUsuario, String name, String email, String surname, String nickname, 
			Integer idCiudad, String fechaNacimiento) {
		super();
		this.idUsuario = idUsuario;
		this.name = name;
		this.email = email;
		this.surname = surname;
		this.nickname = nickname;
		this.idCiudad = idCiudad;
		this.fechaNacimiento = fechaNacimiento;
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
	
	
	
}
