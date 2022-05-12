package com.klabitos.app.Controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klabitos.app.Entities.AuthoritiesEntity;
import com.klabitos.app.Repositories.AuthoritiesRepositorio;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthoritiesRestController.
 */
@RestController
@RequestMapping("/v1")
public class AuthoritiesRestController {

	
	/** The authorities repositorio. */
	@Autowired
	AuthoritiesRepositorio authoritiesRepositorio;
	
	/**
	 * Listar todas ropas.
	 *
	 * @return the iterable
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/security/authority")
	public Iterable<AuthoritiesEntity> listarTodasRopas() throws SQLException{
		return authoritiesRepositorio.findAll();
	}
	
	/**
	 * Obtener rol.
	 *
	 * @param nickname the nickname
	 * @return the string
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/security/authority/isAdmin/{nickname}")
	public String obtenerRol(@PathVariable("nickname") String nickname) throws SQLException{
		return authoritiesRepositorio.obtenerRolePorNickname(nickname);
	}
	
	/**
	 * Insertar usuario security.
	 *
	 * @param usuario the usuario
	 * @return the response entity
	 */
	@PostMapping("/security/authority")
	public ResponseEntity<String> insertarUsuarioSecurity(@RequestBody AuthoritiesEntity usuario){
		authoritiesRepositorio.save(usuario);
		return new ResponseEntity<String>("Insercción Correcta", HttpStatus.OK);
	}
	
	

}
