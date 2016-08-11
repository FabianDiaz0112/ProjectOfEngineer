package com.edu.udistrital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_vehiculo database table.
 * 
 */
@Entity
@Table(name="tipo_vehiculo")
@NamedQuery(name="TipoVehiculo.findAll", query="SELECT t FROM TipoVehiculo t")
public class TipoVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTipo_vehiculo;

	private String descripcion_Tipo_veh;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="tipoVehiculo")
	private List<Vehiculo> vehiculos;

	public TipoVehiculo() {
	}

	public int getIdTipo_vehiculo() {
		return this.idTipo_vehiculo;
	}

	public void setIdTipo_vehiculo(int idTipo_vehiculo) {
		this.idTipo_vehiculo = idTipo_vehiculo;
	}

	public String getDescripcion_Tipo_veh() {
		return this.descripcion_Tipo_veh;
	}

	public void setDescripcion_Tipo_veh(String descripcion_Tipo_veh) {
		this.descripcion_Tipo_veh = descripcion_Tipo_veh;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setTipoVehiculo(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setTipoVehiculo(null);

		return vehiculo;
	}

}