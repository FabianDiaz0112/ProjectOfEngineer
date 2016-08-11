package com.edu.udistrital.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class ApplicationConfig extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> resources = new HashSet<Class<?>>();
	
	@Override
	public Set<Class<?>> getClasses(){
		
		addRestResourceClasses(resources);
		return resources;
	}
	
	@Override
	public Set<Object> getSingletons(){
		return singletons;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(com.edu.udistrital.ws.Login.class);
	}
	
}