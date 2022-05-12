package com.klabitos.app.DTO;

/**
 * The Class RopaUsuarioDTO.
 */
public class RopaUsuarioDTO {
	
	/** The valor calor ropa. */
	private Double valorCalorRopa;
	
	/** The id usuario. */
	private Integer idUsuario;
	
	/** The id ropa. */
	private Integer idRopa;
	
	/** The id. */
	private Integer id;
	
	
	
	/**
	 * Instantiates a new ropa usuario DTO.
	 */
	public RopaUsuarioDTO() {
		super();
	}
	
	/**
	 * Instantiates a new ropa usuario DTO.
	 *
	 * @param idUsuario the id usuario
	 * @param idRopa the id ropa
	 */
	public RopaUsuarioDTO(Integer idUsuario, Integer idRopa) {
		super();
		this.idUsuario = idUsuario;
		this.valorCalorRopa = 1.0; 
		this.idRopa = idRopa;
	}
	
	/**
	 * Instantiates a new ropa usuario DTO.
	 *
	 * @param valorCalorRopa the valor calor ropa
	 * @param idUsuario the id usuario
	 * @param idRopa the id ropa
	 * @param id the id
	 */
	public RopaUsuarioDTO(Double valorCalorRopa, Integer idUsuario, Integer idRopa, Integer id) {
		super();
		this.valorCalorRopa = valorCalorRopa;
		this.idUsuario = idUsuario;
		this.idRopa = idRopa;
		this.id = id;
	}
	
	/**
	 * Gets the valor calor ropa.
	 *
	 * @return the valor calor ropa
	 */
	public Double getValorCalorRopa() {
		return valorCalorRopa;
	}
	
	/**
	 * Sets the valor calor ropa.
	 *
	 * @param valorCalorRopa the new valor calor ropa
	 */
	public void setValorCalorRopa(Double valorCalorRopa) {
		this.valorCalorRopa = valorCalorRopa;
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
	 * Gets the id ropa.
	 *
	 * @return the id ropa
	 */
	public Integer getIdRopa() {
		return idRopa;
	}
	
	/**
	 * Sets the id ropa.
	 *
	 * @param idRopa the new id ropa
	 */
	public void setIdRopa(Integer idRopa) {
		this.idRopa = idRopa;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
}
