package com.foobar.webservices.inventarioweb.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foobar.webservices.inventarioweb.entities.Asset;


public interface AssetsRepository extends JpaRepository<Asset, Integer> {
	Asset getAssetByFecha(Date fecha);
}
