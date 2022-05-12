package com.klabitos.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klabitos.app.Entities.UsersSecurityEntity;
import com.klabitos.app.Repositories.UsuarioSecurityRepositorio;



/**
 * The Class UserSecurityRestController.
 */
@RestController
@RequestMapping("/v1")
public class UserSecurityRestController {

	/** The repositorio. */
	@Autowired
	UsuarioSecurityRepositorio repositorio;
	
	
	/**
	 * Insertar usuario security.
	 *
	 * @param usuario the usuario
	 * @return the response entity
	 */
	@PostMapping("/security/user")
	public ResponseEntity<String> insertarUsuarioSecurity(@RequestBody UsersSecurityEntity usuario){
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		repositorio.save(usuario);
		return new ResponseEntity<String>("Insercción Correcta", HttpStatus.OK);
	}
	
}
