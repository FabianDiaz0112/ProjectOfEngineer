package com.edu.udistrital.ws;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.edu.udistrital.beans.LoginBean;
import com.edu.udistrital.model.PerfilModel;

@Path("/login")
public class Login {
	
	@EJB
	LoginBean prueba;
	//PruebaEJB prueba;
	
	public Login() {
	    try {
	        //String lookupName = "java:global/FirstRestWebService/PruebaEJB!com.edu.udistrital.ejb.PruebaEJB";
	        String lookupName = "java:global/WSHelpPolice/LoginBean!com.edu.udistrital.beans.LoginBean";
	        //prueba = (PruebaEJB) InitialContext.doLookup(lookupName);
	        prueba = (LoginBean) InitialContext.doLookup(lookupName);
	    } catch (NamingException e) {
	        e.printStackTrace();
	    }
	  }

	@GET
	@Path("/getLogin")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(){
		String temp = "";
		PerfilModel perfilModel = new PerfilModel();
		perfilModel.setDescPerfil("Policia");
		perfilModel.setIdPerfilUsuario(3);
		return "Hello world "+prueba.ingresarLogin(perfilModel);
	}
}
