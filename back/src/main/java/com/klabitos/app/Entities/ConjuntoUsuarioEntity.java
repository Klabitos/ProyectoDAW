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
 * The Class ConjuntoUsuarioEntity.
 */
@Entity
@Table(name="conjuntousuario")
public class ConjuntoUsuarioEntity {

	/** The id conjunto usuario. */
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idconjuntousuario")
	private Integer idConjuntoUsuario;
	
	/** The usuario. */
	@OneToOne
	@JoinColumn(name="idusuario")
	private UsuarioEntity usuario;
	
	/** The prenda cabeza. */
	@OneToOne
	@JoinColumn(name="idprendacabeza")
	private RopaEntity prendaCabeza;
	
	/** The prenda torso. */
	@OneToOne
	@JoinColumn(name="idprendatorso")
	private RopaEntity prendaTorso;
	
	/** The prenda pierna. */
	@OneToOne
	@JoinColumn(name="idprendapierna")
	private RopaEntity prendaPierna;
	
	/** The prenda pies. */
	@OneToOne
	@JoinColumn(name="idprendapies")
	private RopaEntity prendaPies;
	
	/** The num conjunto. */
	@Column(name="numconjunto")
	private Integer numConjunto;
	
	/** The nombre conjunto. */
	@Column(name="nombreconjunto")
	private String nombreConjunto;
	
	

	/**
	 * Instantiates a new conjunto usuario entity.
	 */
	public ConjuntoUsuarioEntity() {
		super();
	}

	/**
	 * Instantiates a new conjunto usuario entity.
	 *
	 * @param idConjuntoUsuario the id conjunto usuario
	 * @param usuario the usuario
	 * @param prendaCabeza the prenda cabeza
	 * @param prendaTorso the prenda torso
	 * @param prendaPierna the prenda pierna
	 * @param prendaPies the prenda pies
	 * @param numConjunto the num conjunto
	 */
	public ConjuntoUsuarioEntity(Integer idConjuntoUsuario, UsuarioEntity usuario, RopaEntity prendaCabeza,
			RopaEntity prendaTorso, RopaEntity prendaPierna, RopaEntity prendaPies, Integer numConjunto) {
		super();
		this.idConjuntoUsuario = idConjuntoUsuario;
		this.usuario = usuario;
		this.prendaCabeza = prendaCabeza;
		this.prendaTorso = prendaTorso;
		this.prendaPierna = prendaPierna;
		this.prendaPies = prendaPies;
		this.numConjunto = numConjunto;
	}

	
	
	/**
	 * Instantiates a new conjunto usuario entity.
	 *
	 * @param idConjuntoUsuario the id conjunto usuario
	 * @param usuario the usuario
	 * @param prendaCabeza the prenda cabeza
	 * @param prendaTorso the prenda torso
	 * @param prendaPierna the prenda pierna
	 * @param prendaPies the prenda pies
	 * @param numConjunto the num conjunto
	 * @param nombreCOnjunto the nombre C onjunto
	 */
	public ConjuntoUsuarioEntity(Integer idConjuntoUsuario, UsuarioEntity usuario, RopaEntity prendaCabeza,
			RopaEntity prendaTorso, RopaEntity prendaPierna, RopaEntity prendaPies, Integer numConjunto,
			String nombreCOnjunto) {
		super();
		this.idConjuntoUsuario = idConjuntoUsuario;
		this.usuario = usuario;
		this.prendaCabeza = prendaCabeza;
		this.prendaTorso = prendaTorso;
		this.prendaPierna = prendaPierna;
		this.prendaPies = prendaPies;
		this.numConjunto = numConjunto;
		this.nombreConjunto = nombreCOnjunto;
	}

	/**
	 * Gets the nombre C onjunto.
	 *
	 * @return the nombre C onjunto
	 */
	public String getNombreCOnjunto() {
		return nombreConjunto;
	}

	/**
	 * Sets the nombre C onjunto.
	 *
	 * @param nombreCOnjunto the new nombre C onjunto
	 */
	public void setNombreCOnjunto(String nombreCOnjunto) {
		this.nombreConjunto = nombreCOnjunto;
	}

	/**
	 * Gets the id conjunto usuario.
	 *
	 * @return the id conjunto usuario
	 */
	public Integer getIdConjuntoUsuario() {
		return idConjuntoUsuario;
	}

	/**
	 * Sets the id conjunto usuario.
	 *
	 * @param idConjuntoUsuario the new id conjunto usuario
	 */
	public void setIdConjuntoUsuario(Integer idConjuntoUsuario) {
		this.idConjuntoUsuario = idConjuntoUsuario;
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
	 * Gets the prenda cabeza.
	 *
	 * @return the prenda cabeza
	 */
	public RopaEntity getPrendaCabeza() {
		return prendaCabeza;
	}

	/**
	 * Sets the prenda cabeza.
	 *
	 * @param prendaCabeza the new prenda cabeza
	 */
	public void setPrendaCabeza(RopaEntity prendaCabeza) {
		this.prendaCabeza = prendaCabeza;
	}

	/**
	 * Gets the prenda torso.
	 *
	 * @return the prenda torso
	 */
	public RopaEntity getPrendaTorso() {
		return prendaTorso;
	}

	/**
	 * Sets the prenda torso.
	 *
	 * @param prendaTorso the new prenda torso
	 */
	public void setPrendaTorso(RopaEntity prendaTorso) {
		this.prendaTorso = prendaTorso;
	}

	/**
	 * Gets the prenda pierna.
	 *
	 * @return the prenda pierna
	 */
	public RopaEntity getPrendaPierna() {
		return prendaPierna;
	}

	/**
	 * Sets the prenda pierna.
	 *
	 * @param prendaPierna the new prenda pierna
	 */
	public void setPrendaPierna(RopaEntity prendaPierna) {
		this.prendaPierna = prendaPierna;
	}

	/**
	 * Gets the prenda pies.
	 *
	 * @return the prenda pies
	 */
	public RopaEntity getPrendaPies() {
		return prendaPies;
	}

	/**
	 * Sets the prenda pies.
	 *
	 * @param prendaPies the new prenda pies
	 */
	public void setPrendaPies(RopaEntity prendaPies) {
		this.prendaPies = prendaPies;
	}

	/**
	 * Gets the num conjunto.
	 *
	 * @return the num conjunto
	 */
	public Integer getNumConjunto() {
		return numConjunto;
	}

	/**
	 * Sets the num conjunto.
	 *
	 * @param numConjunto the new num conjunto
	 */
	public void setNumConjunto(Integer numConjunto) {
		this.numConjunto = numConjunto;
	}
	

	
}
