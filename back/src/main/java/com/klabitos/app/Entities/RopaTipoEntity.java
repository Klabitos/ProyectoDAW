package com.klabitos.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class RopaTipoEntity.
 */
@Entity
@Table(name="ropatipo")
public class RopaTipoEntity {

	/** The tipo ropa. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tiporopa")
	private Integer tipoRopa;
  
	/** The zona cuerpo. */
	@Column(name="zonacuerpo")
	private String zonaCuerpo;
	
	

	/**
	 * Instantiates a new ropa tipo entity.
	 */
	public RopaTipoEntity() {
		super();
	}

	/**
	 * Instantiates a new ropa tipo entity.
	 *
	 * @param tipoRopa the tipo ropa
	 * @param zonaCuerpo the zona cuerpo
	 */
	public RopaTipoEntity(Integer tipoRopa, String zonaCuerpo) {
		super();
		this.tipoRopa = tipoRopa;
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
	
	
	
}
