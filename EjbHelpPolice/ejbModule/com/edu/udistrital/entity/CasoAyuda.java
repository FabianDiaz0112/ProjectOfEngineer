package com.edu.udistrital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the caso_ayuda database table.
 * 
 */
@Entity
@Table(name="caso_ayuda")
@NamedQuery(name="CasoAyuda.findAll", query="SELECT c FROM CasoAyuda c")
public class CasoAyuda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCaso_ayuda;

	private String descripCaso_ayuda;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="Persona_identPersona")
	private Persona personaUsuario;

	//bi-directional many-to-one association to TipoSolicitud
	@ManyToOne
	@JoinColumn(name="Tipo_solicitud_idTipo_solicitud")
	private TipoSolicitud tipoSolicitud;

	//bi-directional many-to-one association to Ubicacion
	@ManyToOne
	private Ubicacion ubicacion;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	private Vehiculo vehiculo;

	//bi-directional many-to-many association to Persona
	@ManyToMany(mappedBy="casoAyudas2")
	private List<Persona> personas;

	public CasoAyuda() {
	}

	public int getIdCaso_ayuda() {
		return this.idCaso_ayuda;
	}

	public void setIdCaso_ayuda(int idCaso_ayuda) {
		this.idCaso_ayuda = idCaso_ayuda;
	}

	public String getDescripCaso_ayuda() {
		return this.descripCaso_ayuda;
	}

	public void setDescripCaso_ayuda(String descripCaso_ayuda) {
		this.descripCaso_ayuda = descripCaso_ayuda;
	}

	public Persona getPersonaUsuario() {
		return this.personaUsuario;
	}

	public void setPersonaUsuario(Persona personaUsuario) {
		this.personaUsuario = personaUsuario;
	}

	public TipoSolicitud getTipoSolicitud() {
		return this.tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}