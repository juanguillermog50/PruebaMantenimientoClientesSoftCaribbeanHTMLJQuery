package com.softcaribbean.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "thom_cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nmcliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "cdcliente")
	private String codigo;

	@Column(name = "dsnombre")
	private String nombre;

	@Column(name = "dsdireccion")
	private String direccion;

	@Column(name = "dsmail")
	private String email;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-CO", timezone = "America/Bogotá")
	@Column(name = "feregistro")
	private Date fechaRegistro;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-CO", timezone = "America/Bogotá")
	@Column(name = "febaja")
	private Date fechaBaja;

	@Column(name = "cdusuario")
	private String usuario;

	@Column(name = "snactivo")
	private String activo;

	@Column(name = "cdtelefono")
	private String telefono;

	@Column(name = "dscontacto")
	private String contacto;

	@Column(name = "dslogo")
	private String logo;

	public Cliente() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getActivo() {
		return activo;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getContacto() {
		return contacto;
	}

	public String getLogo() {
		return logo;
	}

}
