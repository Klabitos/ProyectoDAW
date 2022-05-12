package com.klabitos.app.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klabitos.app.DTO.RopaUsuarioDTO;
import com.klabitos.app.Entities.RopaUsuarioEntity;
import com.klabitos.app.Repositories.RopaUsuarioRepositorio;


/**
 * The Class RopaUsuarioRestController.
 */
@RestController
@RequestMapping("/v1")
public class RopaUsuarioRestController {
	
	/** The ropa usuario repositorio. */
	@Autowired
	RopaUsuarioRepositorio ropaUsuarioRepositorio;
	
	/**
	 * Listar todos ropas usuarios.
	 *
	 * @return the iterable
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/ropausuarios")
	public Iterable<RopaUsuarioEntity> listarTodosRopasUsuarios() throws SQLException{
		return ropaUsuarioRepositorio.findAll();
	}
	
	/**
	 * Listar ropa usuario por id persona.
	 *
	 * @param idUsuario the id usuario
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@GetMapping(value= "/ropausuarios", params = {"idUsuario"})
	public List<RopaUsuarioDTO> listarRopaUsuarioPorIdPersona(@RequestParam(value="idUsuario", required=true) Integer idUsuario) throws SQLException{
		return ropaUsuarioRepositorio.listarRopaUsuarioPorIdPersona(idUsuario); 
	}
	
	/**
	 * Listar ropa usuario por nickname.
	 *
	 * @param nickname the nickname
	 * @param idRopa the id ropa
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/ropausuario")
	public List<RopaUsuarioDTO> listarRopaUsuarioPorNickname(@RequestParam(value="nickname", required=true) String nickname, @RequestParam(value="idRopa", required=true) Integer idRopa) throws SQLException{
		return ropaUsuarioRepositorio.listarRopaUsuarioPorNicknameIdRopa(nickname, idRopa); 
	}
	
	/**
	 * Insertar ropa usuario.
	 *
	 * @param ropaUsuario the ropa usuario
	 * @return the response entity
	 */
	@PostMapping("/ropausuarios")
	public ResponseEntity<String> insertarRopaUsuario(@RequestBody RopaUsuarioEntity ropaUsuario){
		ropaUsuarioRepositorio.save(ropaUsuario);
		return new ResponseEntity<String>("Insercción Correcta", HttpStatus.OK);
	}
	
	/**
	 * Modificar ropa usuario.
	 *
	 * @param ropaUsuario the ropa usuario
	 * @return the response entity
	 * @throws SQLException the SQL exception
	 */
	@PutMapping("/ropausuarios")
	public ResponseEntity<String> modificarRopaUsuario(@RequestBody RopaUsuarioEntity ropaUsuario) throws SQLException{
		List<RopaUsuarioDTO> ropaDelUsuario = listarRopaUsuarioPorIdPersona(ropaUsuario.getUsuario().getIdUsuario());
		ropaDelUsuario = ropaDelUsuario.stream()
			    .filter(p -> p.getIdRopa() == ropaUsuario.getIdRopa()).collect(Collectors.toList());
		ropaUsuario.setId(ropaDelUsuario.get(0).getId());
		ropaUsuario.setValorCalorRopa(ropaDelUsuario.get(0).getValorCalorRopa()+ropaUsuario.getValorCalorRopa());
		ropaUsuarioRepositorio.save(ropaUsuario);
		return new ResponseEntity<String>("Actualización Correcta", HttpStatus.OK);
	}

}
