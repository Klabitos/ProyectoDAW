package com.klabitos.app.DTO;


/**
 * The Class RopaDTO.
 */
public class RopaDTO {
	
	/** The id ropa. */
	private Integer idRopa;
	
	/** The nombre ropa. */
	private String nombreRopa;
	
	/** The tipo ropa. */
	private Integer tipoRopa;
	
	
	/**
	 * Instantiates a new ropa DTO.
	 */
	public RopaDTO() {
		super();
	}
	
	/**
	 * Instantiates a new ropa DTO.
	 *
	 * @param idRopa the id ropa
	 * @param nombreRopa the nombre ropa
	 * @param tipoRopa the tipo ropa
	 */
	public RopaDTO(int idRopa, String nombreRopa, int tipoRopa) {
		super();
		this.idRopa = idRopa;
		this.nombreRopa = nombreRopa;
		this.tipoRopa = tipoRopa;
	}
	
	/**
	 * Gets the id ropa.
	 *
	 * @return the id ropa
	 */
	public int getIdRopa() {
		return idRopa;
	}
	
	/**
	 * Sets the id ropa.
	 *
	 * @param idRopa the new id ropa
	 */
	public void setIdRopa(int idRopa) {
		this.idRopa = idRopa;
	}
	
	/**
	 * Gets the nombre ropa.
	 *
	 * @return the nombre ropa
	 */
	public String getNombreRopa() {
		return nombreRopa;
	}
	
	/**
	 * Sets the nombre ropa.
	 *
	 * @param nombreRopa the new nombre ropa
	 */
	public void setNombreRopa(String nombreRopa) {
		this.nombreRopa = nombreRopa;
	}
	
	/**
	 * Gets the tipo ropa.
	 *
	 * @return the tipo ropa
	 */
	public int getTipoRopa() {
		return tipoRopa;
	}
	
	/**
	 * Sets the tipo ropa.
	 *
	 * @param tipoRopa the new tipo ropa
	 */
	public void setTipoRopa(int tipoRopa) {
		this.tipoRopa = tipoRopa;
	}


}
