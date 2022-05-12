package com.klabitos.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class UsersSecurityEntity.
 */
@Entity
@Table(name="users")
public class UsersSecurityEntity {

	/** The username. */
	@Id
	@Column(name="username")
	private String username;
	
	/** The password. */
	@Column(name="password")
	private String password;
	
	/** The enabled. */
	@Column(name="enabled")
	private Integer enabled;
	
	

	/**
	 * Instantiates a new users security entity.
	 */
	public UsersSecurityEntity() {
		super();
	}

	/**
	 * Instantiates a new users security entity.
	 *
	 * @param username the username
	 * @param password the password
	 * @param enabled the enabled
	 */
	public UsersSecurityEntity(String username, String password, Integer enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the enabled.
	 *
	 * @return the enabled
	 */
	public Integer getEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	
	
	
}
