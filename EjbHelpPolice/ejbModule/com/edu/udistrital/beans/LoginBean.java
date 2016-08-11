package com.edu.udistrital.beans;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.edu.udistrital.entity.Perfil;
import com.edu.udistrital.model.PerfilModel;
import com.google.gson.Gson;

@Stateless
public class LoginBean {

	@PersistenceContext
	EntityManager em;
	
	public static final Gson gson = new Gson();
	
	public LoginBean(){
		
	}
	
	public String ingresarLogin(PerfilModel perfilModel){
		Query query = em.createNamedQuery("Perfil.findAll");
		List<Perfil> list = query.getResultList();
		String json = gson.toJson(perfilModel);
		System.out.println(json);
		Perfil perfil = new Perfil();
		perfil = gson.fromJson(json, Perfil.class);
		System.out.println("perfil"+perfil.getDescPerfil());
		return ""+json;
	}
	
}
