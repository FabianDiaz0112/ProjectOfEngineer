package com.edu.udistrital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idVehiculo;

	private int año;

	private String color;

	private String marca;

	private String modelo;

	private String placa;

	//bi-directional many-to-one association to CasoAyuda
	@OneToMany(mappedBy="vehiculo")
	private List<CasoAyuda> casoAyudas;

	//bi-directional many-to-one association to TipoVehiculo
	@ManyToOne
	@JoinColumn(name="Tipo_vehiculo_idTipo_vehiculo")
	private TipoVehiculo tipoVehiculo;

	public Vehiculo() {
	}

	public int getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getAño() {
		return this.año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<CasoAyuda> getCasoAyudas() {
		return this.casoAyudas;
	}

	public void setCasoAyudas(List<CasoAyuda> casoAyudas) {
		this.casoAyudas = casoAyudas;
	}

	public CasoAyuda addCasoAyuda(CasoAyuda casoAyuda) {
		getCasoAyudas().add(casoAyuda);
		casoAyuda.setVehiculo(this);

		return casoAyuda;
	}

	public CasoAyuda removeCasoAyuda(CasoAyuda casoAyuda) {
		getCasoAyudas().remove(casoAyuda);
		casoAyuda.setVehiculo(null);

		return casoAyuda;
	}

	public TipoVehiculo getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

}