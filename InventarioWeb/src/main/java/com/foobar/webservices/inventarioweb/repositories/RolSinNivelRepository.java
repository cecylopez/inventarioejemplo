package com.foobar.webservices.inventarioweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foobar.webservices.inventarioweb.entities.Rol;
import com.foobar.webservices.inventarioweb.entities.RolSinNivel;

public interface RolSinNivelRepository extends JpaRepository<RolSinNivel, Integer>{
	
}
