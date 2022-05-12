package com.klabitos.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class RopaUsuarioEntity.
 */
@Entity
@Table(name="ropausuario")
public class RopaUsuarioEntity {


	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	/** The id ropa. */
	@Column(name="idropa")
	private Integer idRopa;
	

	/** The usuario. */
	@ManyToOne 
	@JoinColumn(name="idusuario")
	private UsuarioEntity usuario;

	
	/** The valor calor ropa. */
	@Column(name="valorcalorropa")
	private Double valorCalorRopa;


	
	
	/**
	 * Instantiates a new ropa usuario entity.
	 */
	public RopaUsuarioEntity() {
		super();
	}

	/**
	 * Instantiates a new ropa usuario entity.
	 *
	 * @param id the id
	 * @param idRopa the id ropa
	 * @param usuario the usuario
	 * @param valorCalorRopa the valor calor ropa
	 */
	public RopaUsuarioEntity(Integer id, Integer idRopa, UsuarioEntity usuario, Double valorCalorRopa) {
		super();
		this.id = id;
		this.idRopa = idRopa;
		this.usuario = usuario;
		this.valorCalorRopa = valorCalorRopa;
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
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public UsuarioEntity getUsuario() {
		return usuario;
	}


	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
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
	
	
	
	
}
