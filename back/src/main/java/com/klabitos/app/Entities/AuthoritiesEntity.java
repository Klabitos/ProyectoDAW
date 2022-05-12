package com.klabitos.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class AuthoritiesEntity.
 */
@Entity
@Table(name="authorities")
public class AuthoritiesEntity {

	 
	/** The username. */
	@Id
	@Column(name="username")
	private String username;
	
	/** The authority. */
	@Column(name="authority")
	private String authority;
	
	
	

	/**
	 * Instantiates a new authorities entity.
	 */
	public AuthoritiesEntity() {
		super();
	}

	/**
	 * Instantiates a new authorities entity.
	 *
	 * @param username the username
	 * @param authority the authority
	 */
	public AuthoritiesEntity(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the authority.
	 *
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * Sets the authority.
	 *
	 * @param authority the new authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
}
