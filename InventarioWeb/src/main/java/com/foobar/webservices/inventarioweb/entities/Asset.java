package com.foobar.webservices.inventarioweb.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ASSETS")
public class Asset {
	@Id
	protected Integer id;
	protected String nombre;
	protected String ruta;
	protected Date fecha;
	protected char estado;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public Asset(Integer id, String nombre, String ruta, Date fecha, char estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ruta = ruta;
		this.fecha = fecha;
		this.estado = estado;
	}
	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
