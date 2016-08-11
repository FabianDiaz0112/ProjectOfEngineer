package com.edu.udistrital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String identPersona;

	private String descripcion;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;

	private String nombrePersona;

	private String numCelular;

	//bi-directional many-to-one association to CasoAyuda
	@OneToMany(mappedBy="personaUsuario")
	private List<CasoAyuda> casoAyudas1;

	//bi-directional many-to-many association to CasoAyuda
	@ManyToMany
	@JoinTable(
		name="asignacion_caso"
		, joinColumns={
			@JoinColumn(name="Persona_identPersona")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Caso_ayuda_idCaso_ayuda")
			}
		)
	private List<CasoAyuda> casoAyudas2;

	//bi-directional one-to-one association to Usuario
	@OneToOne(mappedBy="persona")
	private Usuario usuario;

	public Persona() {
	}

	public String getIdentPersona() {
		return this.identPersona;
	}

	public void setIdentPersona(String identPersona) {
		this.identPersona = identPersona;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getNombrePersona() {
		return this.nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getNumCelular() {
		return this.numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public List<CasoAyuda> getCasoAyudas1() {
		return this.casoAyudas1;
	}

	public void setCasoAyudas1(List<CasoAyuda> casoAyudas1) {
		this.casoAyudas1 = casoAyudas1;
	}

	public CasoAyuda addCasoAyudas1(CasoAyuda casoAyudas1) {
		getCasoAyudas1().add(casoAyudas1);
		casoAyudas1.setPersonaUsuario(this);

		return casoAyudas1;
	}

	public CasoAyuda removeCasoAyudas1(CasoAyuda casoAyudas1) {
		getCasoAyudas1().remove(casoAyudas1);
		casoAyudas1.setPersonaUsuario(null);

		return casoAyudas1;
	}

	public List<CasoAyuda> getCasoAyudas2() {
		return this.casoAyudas2;
	}

	public void setCasoAyudas2(List<CasoAyuda> casoAyudas2) {
		this.casoAyudas2 = casoAyudas2;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}