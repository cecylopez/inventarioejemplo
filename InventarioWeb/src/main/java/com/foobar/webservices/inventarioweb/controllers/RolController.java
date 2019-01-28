package com.foobar.webservices.inventarioweb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foobar.webservices.inventarioweb.entities.Rol;
import com.foobar.webservices.inventarioweb.entities.RolSinNivel;
import com.foobar.webservices.inventarioweb.entities.Usuario;
import com.foobar.webservices.inventarioweb.repositories.RolRepository;
import com.foobar.webservices.inventarioweb.repositories.RolSinNivelRepository;

@RestController 
@RequestMapping("/roles")
public class RolController {
	
	@Autowired
	protected RolRepository rolRepository;
	
	@Autowired
	protected RolSinNivelRepository rolSinNivelRepository;
	
	@GetMapping(path="/")
	public ResponseEntity<List<Rol>>list(@RequestParam(name="nombre", required=false) String nombre, @RequestParam(name="sector", required=false) String sector){
		
		if (nombre != null && nombre.trim().length() > 0) {
			System.out.println("Query para filtrar por nombre");
			return ResponseEntity.ok().build();
		}
		
		if (sector != null && sector.trim().length() > 0) {
			System.out.println("Query para filtrar por sector");
			return ResponseEntity.ok().build();
		}
		
		List<Rol> lista= rolRepository.findAll();
		return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(path="/sinnivel/")
	public ResponseEntity<List<RolSinNivel>>list(){
		List<RolSinNivel> lista= rolSinNivelRepository.findAll();
		return new ResponseEntity<List<RolSinNivel>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Rol> getRolById(@PathVariable("id") Integer id){
		Optional<Rol> rolById= rolRepository.findById(id);
		if (rolById.isPresent()) {
			return new ResponseEntity<Rol>(rolById.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/{id}/usuarios")
	public ResponseEntity<List<Usuario>> getUsuariosByRol(@PathVariable("id") long id) {
		
		return null;
	}
	
	@GetMapping(path="/{id}//usuarios/{idUsuario}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") long id, @PathVariable("idUsuario") long idUsuario) {
		
		return null;
	}

}
