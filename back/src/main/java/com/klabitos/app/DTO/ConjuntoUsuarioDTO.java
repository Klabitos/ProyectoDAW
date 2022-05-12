package com.klabitos.app.DTO;


/**
 * The Class ConjuntoUsuarioDTO.
 */
public class ConjuntoUsuarioDTO {
	
	/** The num conjunto. */
	private Integer numConjunto;
	
	/** The id conjunto usuario. */
	private Integer idConjuntoUsuario;
	
	/** The nombre conjunto. */
	private String nombreConjunto;
	
	/** The id usuario. */
	private Integer idUsuario;
	
	/** The id prenda cabeza. */
	private Integer idPrendaCabeza;
	
	/** The id prenda torso. */
	private Integer idPrendaTorso;
	
	/** The id prenda pies. */
	private Integer idPrendaPies;
	
	/** The id prenda pierna. */
	private Integer idPrendaPierna;
	

	/**
	 * Instantiates a new conjunto usuario DTO.
	 */
	public ConjuntoUsuarioDTO() {
		super();
	}
	
	/**
	 * Instantiates a new conjunto usuario DTO.
	 *
	 * @param numConjunto the num conjunto
	 * @param idConjuntoUsuario the id conjunto usuario
	 * @param nombreConjunto the nombre conjunto
	 * @param idUsuario the id usuario
	 * @param idPrendaCabeza the id prenda cabeza
	 * @param idPrendaTorso the id prenda torso
	 * @param idPrendaPies the id prenda pies
	 * @param idPrendaPierna the id prenda pierna
	 */
	public ConjuntoUsuarioDTO(Integer numConjunto, Integer idConjuntoUsuario, String nombreConjunto, Integer idUsuario,
			Integer idPrendaCabeza, Integer idPrendaTorso, Integer idPrendaPies, Integer idPrendaPierna) {
		super();
		this.numConjunto = numConjunto;
		this.idConjuntoUsuario = idConjuntoUsuario;
		this.nombreConjunto = nombreConjunto;
		this.idUsuario = idUsuario;
		this.idPrendaCabeza = idPrendaCabeza;
		this.idPrendaTorso = idPrendaTorso;
		this.idPrendaPies = idPrendaPies;
		this.idPrendaPierna = idPrendaPierna;
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
	 * Gets the nombre conjunto.
	 *
	 * @return the nombre conjunto
	 */
	public String getNombreConjunto() {
		return nombreConjunto;
	}
	
	/**
	 * Sets the nombre conjunto.
	 *
	 * @param nombreConjunto the new nombre conjunto
	 */
	public void setNombreConjunto(String nombreConjunto) {
		this.nombreConjunto = nombreConjunto;
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
	 * Gets the id prenda cabeza.
	 *
	 * @return the id prenda cabeza
	 */
	public Integer getIdPrendaCabeza() {
		return idPrendaCabeza;
	}
	
	/**
	 * Sets the id prenda cabeza.
	 *
	 * @param idPrendaCabeza the new id prenda cabeza
	 */
	public void setIdPrendaCabeza(Integer idPrendaCabeza) {
		this.idPrendaCabeza = idPrendaCabeza;
	}
	
	/**
	 * Gets the id prenda torso.
	 *
	 * @return the id prenda torso
	 */
	public Integer getIdPrendaTorso() {
		return idPrendaTorso;
	}
	
	/**
	 * Sets the id prenda torso.
	 *
	 * @param idPrendaTorso the new id prenda torso
	 */
	public void setIdPrendaTorso(Integer idPrendaTorso) {
		this.idPrendaTorso = idPrendaTorso;
	}
	
	/**
	 * Gets the id prenda pies.
	 *
	 * @return the id prenda pies
	 */
	public Integer getIdPrendaPies() {
		return idPrendaPies;
	}
	
	/**
	 * Sets the id prenda pies.
	 *
	 * @param idPrendaPies the new id prenda pies
	 */
	public void setIdPrendaPies(Integer idPrendaPies) {
		this.idPrendaPies = idPrendaPies;
	}
	
	/**
	 * Gets the id prenda pierna.
	 *
	 * @return the id prenda pierna
	 */
	public Integer getIdPrendaPierna() {
		return idPrendaPierna;
	}
	
	/**
	 * Sets the id prenda pierna.
	 *
	 * @param idPrendaPierna the new id prenda pierna
	 */
	public void setIdPrendaPierna(Integer idPrendaPierna) {
		this.idPrendaPierna = idPrendaPierna;
	}
	
	
}
