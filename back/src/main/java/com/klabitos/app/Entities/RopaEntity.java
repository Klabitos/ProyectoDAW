package com.klabitos.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class RopaEntity.
 */
@Entity
@Table(name="ropa")
public class RopaEntity {
	
	/** The id ropa. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idropa")
	private Integer idRopa;

	/** The nombre ropa. */
	@Column(name="nombreropa")
	private String nombreRopa;

	/** The tipo ropa. */
	@OneToOne
	@JoinColumn(name="tiporopa")
	private RopaTipoEntity tipoRopa;
	
	/** The url relativa. */
	@Column(name="urlrelativa")
	private String urlRelativa;
	
	/** The valor calor por defecto. */
	@Column(name="valorcalorpordefecto")
	private Double valorCalorPorDefecto;
	
	/**
	 * Instantiates a new ropa entity.
	 */
	public RopaEntity() {
		super();
	}

	/**
	 * Instantiates a new ropa entity.
	 *
	 * @param idRopa the id ropa
	 * @param nombreRopa the nombre ropa
	 * @param tipoRopa the tipo ropa
	 * @param urlRelativa the url relativa
	 * @param valorCalorPorDefecto the valor calor por defecto
	 */
	public RopaEntity(Integer idRopa, String nombreRopa, RopaTipoEntity tipoRopa, String urlRelativa,
			Double valorCalorPorDefecto) {
		super();
		this.idRopa = idRopa;
		this.nombreRopa = nombreRopa;
		this.tipoRopa = tipoRopa;
		this.urlRelativa = urlRelativa;
		this.valorCalorPorDefecto = valorCalorPorDefecto;
	}

	/**
	 * Gets the url relativa.
	 *
	 * @return the url relativa
	 */
	public String getUrlRelativa() {
		return urlRelativa;
	}

	/**
	 * Sets the url relativa.
	 *
	 * @param urlRelativa the new url relativa
	 */
	public void setUrlRelativa(String urlRelativa) {
		this.urlRelativa = urlRelativa;
	}

	/**
	 * Gets the valor calor por defecto.
	 *
	 * @return the valor calor por defecto
	 */
	public Double getValorCalorPorDefecto() {
		return valorCalorPorDefecto;
	}

	/**
	 * Sets the valor calor por defecto.
	 *
	 * @param valorCalorPorDefecto the new valor calor por defecto
	 */
	public void setValorCalorPorDefecto(Double valorCalorPorDefecto) {
		this.valorCalorPorDefecto = valorCalorPorDefecto;
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
	public RopaTipoEntity getTipoRopa() {
		return tipoRopa;
	}

	/**
	 * Sets the tipo ropa.
	 *
	 * @param tipoRopa the new tipo ropa
	 */
	public void setTipoRopa(RopaTipoEntity tipoRopa) {
		this.tipoRopa = tipoRopa;
	}


	
	
}
