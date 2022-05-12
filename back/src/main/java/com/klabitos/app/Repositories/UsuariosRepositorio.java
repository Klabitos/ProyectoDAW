package com.klabitos.app.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.klabitos.app.DTO.UsuarioDTO;
import com.klabitos.app.Entities.UsuarioEntity; 

/**
 * The Interface UsuariosRepositorio.
 */
public interface UsuariosRepositorio extends CrudRepository<UsuarioEntity, Integer>{
	
	/**
	 * Obtener info usuario.
	 *
	 * @param nickname the nickname
	 * @return the usuario DTO
	 */
	@Query(value="select new com.klabitos.app.DTO.UsuarioDTO (u.idUsuario, u.email, u.name, u.surname, u.nickname, u.fechaNacimiento, u.idCiudad) "
			+ "FROM com.klabitos.app.Entities.UsuarioEntity u "
			+ "WHERE u.nickname = :nickname")
			UsuarioDTO obtenerInfoUsuario(
					@Param("nickname")String nickname);
	
	/**
	 * Check avaible nickname.
	 *
	 * @param nickname the nickname
	 * @return the integer
	 */
	@Query(value="select count(*) "
			+ "FROM  com.klabitos.app.Entities.UsuarioEntity u "
			+ "WHERE u.nickname = :nickname")
			Integer checkAvaibleNickname(
					@Param("nickname")String nickname);
	
	/**
	 * Obtener id con usuario.
	 *
	 * @param nickname the nickname
	 * @return the integer
	 */
	@Query(value="select u.idUsuario "
			+ "FROM  com.klabitos.app.Entities.UsuarioEntity u "
			+ "WHERE u.nickname = :nickname")
			Integer obtenerIdConUsuario(
					@Param("nickname")String nickname);
}


