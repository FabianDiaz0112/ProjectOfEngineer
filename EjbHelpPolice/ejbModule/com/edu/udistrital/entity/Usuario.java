package com.edu.udistrital.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	/*@Id
	private String persona_identPersona;*/

	private String contraseña;

	private String descripcion;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	private Perfil perfil;

	//bi-directional one-to-one association to Persona
	@Id
	@OneToOne
	private Persona persona;

	public Usuario() {
	}

	/*public String getPersona_identPersona() {
		return this.persona_identPersona;
	}

	public void setPersona_identPersona(String persona_identPersona) {
		this.persona_identPersona = persona_identPersona;
	}*/

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}