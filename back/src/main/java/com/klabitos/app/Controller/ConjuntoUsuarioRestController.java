package com.klabitos.app.Controller;

import java.sql.SQLException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klabitos.app.DTO.ConjuntoUsuarioDTO;
import com.klabitos.app.Entities.ConjuntoUsuarioEntity;
import com.klabitos.app.Repositories.ConjuntoUsuarioRepositorio;


/**
 * The Class ConjuntoUsuarioRestController.
 */
@RestController
@RequestMapping("/v1")
public class ConjuntoUsuarioRestController {
	
	/** The conjunto usuario repositorio. */
	@Autowired
	ConjuntoUsuarioRepositorio conjuntoUsuarioRepositorio;
	
	/**
	 * Listar todos conjuntos.
	 *
	 * @return the iterable
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/conjuntos")
	public Iterable<ConjuntoUsuarioEntity> listarTodosConjuntos() throws SQLException{
		return conjuntoUsuarioRepositorio.findAll();
	}
	
	/**
	 * Listar conjunto.
	 *
	 * @param id the id
	 * @return the conjunto usuario entity
	 * @throws SQLException the SQL exception
	 */
	@GetMapping("/conjuntos/{id}")
	public ConjuntoUsuarioEntity listarConjunto(@PathVariable("id") Integer id) throws SQLException{
		return conjuntoUsuarioRepositorio.findById(id).get();
	}
	
	/**
	 * Listar conjuntos por persona.
	 *
	 * @param idUsuario the id usuario
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
	@GetMapping(value= "/conjuntos", params = {"idUsuario"})
	public List<ConjuntoUsuarioDTO> listarConjuntosPorPersona(@RequestParam(value="idUsuario", required=true) Integer idUsuario) throws SQLException{
		return conjuntoUsuarioRepositorio.listarConjuntoPorId(idUsuario); 
	}

	/**
	 * Insertar conjunto.
	 *
	 * @param conjunto the conjunto
	 * @return the response entity
	 */
	@PostMapping("/conjuntos")
	public ResponseEntity<String> insertarConjunto(@RequestBody ConjuntoUsuarioEntity conjunto){
		conjuntoUsuarioRepositorio.save(conjunto);
		return new ResponseEntity<String>("Insercción Correcta", HttpStatus.OK);
	}
	
	/**
	 * Modificar conjunto.
	 *
	 * @param conjunto the conjunto
	 * @return the response entity
	 */
	@PutMapping("/conjuntos")
	public ResponseEntity<String> modificarConjunto(@RequestBody ConjuntoUsuarioEntity conjunto){
		conjuntoUsuarioRepositorio.save(conjunto);
		return new ResponseEntity<String>("Actualización Correcta", HttpStatus.OK);
	}
	
	/**
	 * Borrar conjunto.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/conjuntos/{id}")
	public ResponseEntity<String> borrarConjunto(@PathVariable("id") Integer id){
		ConjuntoUsuarioEntity conjunto = conjuntoUsuarioRepositorio.findById(id).get();
		conjuntoUsuarioRepositorio.delete(conjunto);
		return new ResponseEntity<String>("Borrado Correcta", HttpStatus.OK);
	}
}
