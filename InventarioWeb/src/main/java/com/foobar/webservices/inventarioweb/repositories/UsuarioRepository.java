package com.foobar.webservices.inventarioweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foobar.webservices.inventarioweb.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	
}