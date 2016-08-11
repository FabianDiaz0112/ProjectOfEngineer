package com.edu.udistrital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_solicitud database table.
 * 
 */
@Entity
@Table(name="tipo_solicitud")
@NamedQuery(name="TipoSolicitud.findAll", query="SELECT t FROM TipoSolicitud t")
public class TipoSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTipo_solicitud;

	private String descripTipo_solicitud;

	//bi-directional many-to-one association to CasoAyuda
	@OneToMany(mappedBy="tipoSolicitud")
	private List<CasoAyuda> casoAyudas;

	public TipoSolicitud() {
	}

	public int getIdTipo_solicitud() {
		return this.idTipo_solicitud;
	}

	public void setIdTipo_solicitud(int idTipo_solicitud) {
		this.idTipo_solicitud = idTipo_solicitud;
	}

	public String getDescripTipo_solicitud() {
		return this.descripTipo_solicitud;
	}

	public void setDescripTipo_solicitud(String descripTipo_solicitud) {
		this.descripTipo_solicitud = descripTipo_solicitud;
	}

	public List<CasoAyuda> getCasoAyudas() {
		return this.casoAyudas;
	}

	public void setCasoAyudas(List<CasoAyuda> casoAyudas) {
		this.casoAyudas = casoAyudas;
	}

	public CasoAyuda addCasoAyuda(CasoAyuda casoAyuda) {
		getCasoAyudas().add(casoAyuda);
		casoAyuda.setTipoSolicitud(this);

		return casoAyuda;
	}

	public CasoAyuda removeCasoAyuda(CasoAyuda casoAyuda) {
		getCasoAyudas().remove(casoAyuda);
		casoAyuda.setTipoSolicitud(null);

		return casoAyuda;
	}

}