package com.klabitos.app.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.klabitos.app.DTO.ConjuntoUsuarioDTO;
import com.klabitos.app.Entities.ConjuntoUsuarioEntity;

/**
 * The Interface ConjuntoUsuarioRepositorio.
 */
public interface ConjuntoUsuarioRepositorio extends CrudRepository<ConjuntoUsuarioEntity, Integer>{
	
	/**
	 * Listar conjunto por id.
	 *
	 * @param idusuario the idusuario
	 * @return the list
	 */
	@Query(value="select new com.klabitos.app.DTO.ConjuntoUsuarioDTO (c.numConjunto, c.idConjuntoUsuario, c.nombreConjunto, c.usuario.idUsuario,\r\n"
			+ "	c.prendaCabeza.idRopa, c.prendaTorso.idRopa, c.prendaPies.idRopa,  c.prendaPierna.idRopa) "
			+ "FROM com.klabitos.app.Entities.ConjuntoUsuarioEntity c "
			+ "WHERE c.usuario.idUsuario = :idusuario")
			List<ConjuntoUsuarioDTO> listarConjuntoPorId(
					@Param("idusuario")Integer idusuario);
}
