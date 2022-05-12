package com.klabitos.app.Controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klabitos.app.Entities.RopaTipoEntity;
import com.klabitos.app.Repositories.RopaTipoRepositorio;


/**
 * The Class RopaTipoRestController.
 */
@RestController
@RequestMapping("/v1")
public class RopaTipoRestController {
	
	/** The ropa tipo repositorio. */
	@Autowired
	RopaTipoRepositorio ropaTipoRepositorio;
	
	/**
	 * Listar todos tipos.
	 *
	 * @return the iterable
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/ropatipos")
	public Iterable<RopaTipoEntity> listarTodosTipos() throws SQLException{
		return ropaTipoRepositorio.findAll();
	}
	
	/**
	 * Listar ropa tipo.
	 *
	 * @param id the id
	 * @return the ropa tipo entity
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/ropatipos/{id}")
	public RopaTipoEntity listarRopaTipo(@PathVariable("id") Integer id) throws SQLException{
		return ropaTipoRepositorio.findById(id).get();
	}

	/**
	 * Insertar ropa tipo.
	 *
	 * @param ropaTipo the ropa tipo
	 * @return the response entity
	 */
	@PostMapping("/ropatipos")
	public ResponseEntity<String> insertarRopaTipo(@RequestBody RopaTipoEntity ropaTipo){ 
		ropaTipoRepositorio.save(ropaTipo);
		return new ResponseEntity<String>("Insercción Correcta", HttpStatus.OK);
	}
	
	/**
	 * Modificar ropa tipo.
	 *
	 * @param ropaTipo the ropa tipo
	 * @return the response entity
	 */
	@PutMapping("/ropatipos")
	public ResponseEntity<String> modificarRopaTipo(@RequestBody RopaTipoEntity ropaTipo){
		ropaTipoRepositorio.save(ropaTipo);
		return new ResponseEntity<String>("Actualización Correcta", HttpStatus.OK);
	}
	
	/**
	 * Borrar ropa tipo.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/ropatipos/{id}")
	public ResponseEntity<String> borrarRopaTipo(@PathVariable("id") Integer id){
		RopaTipoEntity ropaTipo = ropaTipoRepositorio.findById(id).get();
		ropaTipoRepositorio.delete(ropaTipo);
		return new ResponseEntity<String>("Borrado Correcta", HttpStatus.OK);
	}
}
