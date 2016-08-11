package com.edu.udistrital.model;

import java.util.List;

import com.edu.udistrital.entity.Usuario;

public class PerfilModel {

	private int idPerfilUsuario;

	private String descPerfil;
	
	//private List<Usuario> usuarios;

	public PerfilModel() {
		
	}

	public int getIdPerfilUsuario() {
		return idPerfilUsuario;
	}

	public void setIdPerfilUsuario(int idPerfilUsuario) {
		this.idPerfilUsuario = idPerfilUsuario;
	}

	public String getDescPerfil() {
		return descPerfil;
	}

	public void setDescPerfil(String descPerfil) {
		this.descPerfil = descPerfil;
	}

	/*public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}*/
	
	
}
