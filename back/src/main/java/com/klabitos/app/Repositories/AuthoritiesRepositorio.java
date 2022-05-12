package com.klabitos.app.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.klabitos.app.Entities.AuthoritiesEntity;

/**
 * The Interface AuthoritiesRepositorio.
 */
public interface AuthoritiesRepositorio extends CrudRepository<AuthoritiesEntity, Integer>{
	
	/**
	 * Obtener role por nickname.
	 *
	 * @param nickname the nickname
	 * @return the string
	 */
	@Query(value="select u.authority "
			+ "FROM  com.klabitos.app.Entities.AuthoritiesEntity u "
			+ "WHERE u.username = :nickname")
			String obtenerRolePorNickname(
					@Param("nickname")String nickname);
}
