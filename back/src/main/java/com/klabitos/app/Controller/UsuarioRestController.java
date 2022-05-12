package com.klabitos.app.Controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klabitos.app.DTO.UsuarioDTO;
import com.klabitos.app.Entities.UsuarioEntity;
import com.klabitos.app.Repositories.UsuariosRepositorio;


/**
 * The Class UsuarioRestController.
 */
@RestController
@RequestMapping("/v1")
public class UsuarioRestController {
	
	/** The usuarios repositorio. */
	@Autowired
	UsuariosRepositorio usuariosRepositorio;
	
	/**
	 * Check avaible nickname.
	 *
	 * @param nickname the nickname
	 * @return the boolean
	 */
	@GetMapping("/username/{nickname}")
	public Boolean checkAvaibleNickname(@PathVariable("nickname") String nickname) {
		return usuariosRepositorio.checkAvaibleNickname(nickname)==0;
	}
	
	/**
	 * Current user name.
	 *
	 * @param authentication the authentication
	 * @return the string
	 */
	@GetMapping("/username/active")
	public String currentUserName(Authentication authentication) {
		return authentication.getName();	
	}

	/**
	 * Obtener id con usuario.
	 *
	 * @param nickname the nickname
	 * @return the integer
	 */
	@GetMapping("username/getId/{nickname}")
	public Integer obtenerIdConUsuario(@PathVariable("nickname") String nickname) {
		return usuariosRepositorio.obtenerIdConUsuario(nickname);
	}
	
	
	/**
	 * Listar todos usuarios.
	 *
	 * @return the iterable
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/usuarios")
	public Iterable<UsuarioEntity> listarTodosUsuarios() throws SQLException{
		return usuariosRepositorio.findAll();
	}
	
	/**
	 * Listar usuario.
	 *
	 * @param id the id
	 * @return the usuario entity
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/usuarios/{id}")
	public UsuarioEntity listarUsuario(@PathVariable("id") Integer id) throws SQLException{
		return usuariosRepositorio.findById(id).get();
	}
	
	/**
	 * Listar usuario por nickname.
	 *
	 * @param nickname the nickname
	 * @return the usuario DTO
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/usuarios/nickname/{nickname}")
	public UsuarioDTO listarUsuarioPorNickname(@PathVariable("nickname") String nickname) throws SQLException{
		return usuariosRepositorio.obtenerInfoUsuario(nickname);
	}

	/**
	 * Insertar usuario.
	 *
	 * @param usuario the usuario
	 * @return the response entity
	 */
	@PostMapping("/usuarios")
	public ResponseEntity<String> insertarUsuario(@RequestBody UsuarioEntity usuario){
		usuariosRepositorio.save(usuario);
		return new ResponseEntity<String>("Insercción Correcta", HttpStatus.OK);
	}
	
	/**
	 * Modificar usuario.
	 *
	 * @param usuario the usuario
	 * @return the response entity
	 */
	@PutMapping("/usuarios")
	public ResponseEntity<String> modificarUsuario(@RequestBody UsuarioEntity usuario){
		usuariosRepositorio.save(usuario);
		return new ResponseEntity<String>("Actualización Correcta", HttpStatus.OK);
	}
	
	/**
	 * Borrar usuario.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<String> borrarUsuario(@PathVariable("id") Integer id){
		UsuarioEntity usuario = usuariosRepositorio.findById(id).get();
		usuariosRepositorio.delete(usuario);
		return new ResponseEntity<String>("Borrado Correcta", HttpStatus.OK);
	}

}
