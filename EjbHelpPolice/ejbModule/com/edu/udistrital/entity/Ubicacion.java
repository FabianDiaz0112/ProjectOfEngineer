package com.edu.udistrital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ubicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Ubicacion.findAll", query="SELECT u FROM Ubicacion u")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUbicacion;

	private String descripUbicacion;

	//bi-directional many-to-one association to CasoAyuda
	@OneToMany(mappedBy="ubicacion")
	private List<CasoAyuda> casoAyudas;

	public Ubicacion() {
	}

	public int getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getDescripUbicacion() {
		return this.descripUbicacion;
	}

	public void setDescripUbicacion(String descripUbicacion) {
		this.descripUbicacion = descripUbicacion;
	}

	public List<CasoAyuda> getCasoAyudas() {
		return this.casoAyudas;
	}

	public void setCasoAyudas(List<CasoAyuda> casoAyudas) {
		this.casoAyudas = casoAyudas;
	}

	public CasoAyuda addCasoAyuda(CasoAyuda casoAyuda) {
		getCasoAyudas().add(casoAyuda);
		casoAyuda.setUbicacion(this);

		return casoAyuda;
	}

	public CasoAyuda removeCasoAyuda(CasoAyuda casoAyuda) {
		getCasoAyudas().remove(casoAyuda);
		casoAyuda.setUbicacion(null);

		return casoAyuda;
	}

}