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
import com.klabitos.app.Entities.RopaEntity;
import com.klabitos.app.Repositories.RopaRepositorio;

/**
 * The Class RopaRestController.
 */
@RestController
@RequestMapping("/v1")
public class RopaRestController {
	
	/** The ropa repositorio. */
	@Autowired
	RopaRepositorio ropaRepositorio;
	
	/**
	 * Listar todas ropas.
	 *
	 * @return the iterable
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/ropas")
	public Iterable<RopaEntity> listarTodasRopas() throws SQLException{
		return ropaRepositorio.findAll();
	}
	
	/**
	 * Listar ropa.
	 *
	 * @param id the id
	 * @return the ropa entity
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/ropas/{id}")
	public RopaEntity listarRopa(@PathVariable("id") Integer id) throws SQLException{
		return ropaRepositorio.findById(id).get();
	}

	/**
	 * Insertar ropa.
	 *
	 * @param ropa the ropa
	 * @return the response entity
	 */
	@PostMapping("/ropas")
	public ResponseEntity<String> insertarRopa(@RequestBody RopaEntity ropa){
		ropaRepositorio.save(ropa);
		return new ResponseEntity<String>("Insercción Correcta", HttpStatus.OK);
	}
	
	/**
	 * Modificar ropa.
	 *
	 * @param ropa the ropa
	 * @return the response entity
	 */
	@PutMapping("/ropas")
	public ResponseEntity<String> modificarRopa(@RequestBody RopaEntity ropa){
		ropaRepositorio.save(ropa);
		return new ResponseEntity<String>("Actualización Correcta", HttpStatus.OK);
	}
	
	/**
	 * Borrar ropa.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/ropas/{id}")
	public ResponseEntity<String> borrarRopa(@PathVariable("id") Integer id){
		RopaEntity ropa = ropaRepositorio.findById(id).get();
		ropaRepositorio.delete(ropa);
		return new ResponseEntity<String>("Borrado Correcta", HttpStatus.OK);
	}
}
