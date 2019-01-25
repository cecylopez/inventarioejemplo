package com.foobar.webservices.inventarioweb.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String clave;
	
	private String estado;

	@Column(name="EMPLEADO_ID")
	private String empleadoId;
	
	@Column(name="VENDEDOR_ID")
	private String vendedorId;

	private String nombre;
	
	private String usuario;

	@Column(name="SUCURSAL_ID")
	private int sucursalId;
	
	private String dui;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ULTIMO_LOGIN")
	private Date ultimoLogin;
	

	//bi-directional many-to-one association to Rol
	@ManyToOne
	private Rol rol;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getEmpleadoId() {
		return empleadoId;
	}


	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}


	public String getVendedorId() {
		return vendedorId;
	}


	public void setVendedorId(String vendedorId) {
		this.vendedorId = vendedorId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public int getSucursalId() {
		return sucursalId;
	}


	public void setSucursalId(int sucursalId) {
		this.sucursalId = sucursalId;
	}


	public String getDui() {
		return dui;
	}


	public void setDui(String dui) {
		this.dui = dui;
	}


	public Date getUltimoLogin() {
		return ultimoLogin;
	}


	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	
}
