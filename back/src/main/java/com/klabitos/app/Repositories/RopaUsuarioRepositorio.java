package com.klabitos.app.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.klabitos.app.DTO.RopaUsuarioDTO;
import com.klabitos.app.Entities.RopaUsuarioEntity;

/**
 * The Interface RopaUsuarioRepositorio.
 */
public interface RopaUsuarioRepositorio extends CrudRepository<RopaUsuarioEntity, Integer>{
	
	/**
	 * Listar ropa usuario por id persona.
	 *
	 * @param idusuario the idusuario
	 * @return the list
	 */
	@Query(value="select new com.klabitos.app.DTO.RopaUsuarioDTO (r.valorCalorRopa, r.usuario.idUsuario, r.idRopa, r.id) "
			+ "FROM com.klabitos.app.Entities.RopaUsuarioEntity r "
			+ "WHERE r.usuario.idUsuario = :idusuario")
			List<RopaUsuarioDTO>listarRopaUsuarioPorIdPersona(
					@Param("idusuario")Integer idusuario);
	
	/**
	 * Listar ropa usuario por nickname id ropa.
	 *
	 * @param nickname the nickname
	 * @param idRopa the id ropa
	 * @return the list
	 */
	@Query(value="select new com.klabitos.app.DTO.RopaUsuarioDTO (r.valorCalorRopa, r.usuario.idUsuario, r.idRopa, r.id) "
			+ "FROM com.klabitos.app.Entities.RopaUsuarioEntity r "
			+ "WHERE r.usuario.nickname = :nickname and r.idRopa = :idRopa")
			List<RopaUsuarioDTO>listarRopaUsuarioPorNicknameIdRopa(
					@Param("nickname")String nickname, @Param("idRopa")Integer idRopa);
	
}
