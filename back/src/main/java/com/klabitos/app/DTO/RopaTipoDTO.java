package com.klabitos.app.DTO;


/**
 * The Class RopaTipoDTO.
 */
public class RopaTipoDTO {
	
	/** The zona cuerpo. */
	private String zonaCuerpo;
	
	/** The tipo ropa. */
	private Integer tipoRopa;
	
	/**
	 * Instantiates a new ropa tipo DTO.
	 */
	public RopaTipoDTO() {
		super();
	}
	
	/**
	 * Instantiates a new ropa tipo DTO.
	 *
	 * @param zonaCuerpo the zona cuerpo
	 * @param tipoRopa the tipo ropa
	 */
	public RopaTipoDTO(String zonaCuerpo, Integer tipoRopa) {
		super();
		this.zonaCuerpo = zonaCuerpo;
		this.tipoRopa = tipoRopa;
	}
	
	/**
	 * Gets the zona cuerpo.
	 *
	 * @return the zona cuerpo
	 */
	public String getZonaCuerpo() {
		return zonaCuerpo;
	}
	
	/**
	 * Sets the zona cuerpo.
	 *
	 * @param zonaCuerpo the new zona cuerpo
	 */
	public void setZonaCuerpo(String zonaCuerpo) {
		this.zonaCuerpo = zonaCuerpo;
	}
	
	/**
	 * Gets the tipo ropa.
	 *
	 * @return the tipo ropa
	 */
	public Integer getTipoRopa() {
		return tipoRopa;
	}
	
	/**
	 * Sets the tipo ropa.
	 *
	 * @param tipoRopa the new tipo ropa
	 */
	public void setTipoRopa(Integer tipoRopa) {
		this.tipoRopa = tipoRopa;
	}
	
	
}
