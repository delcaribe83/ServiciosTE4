package com.gnExpress.serviciosTE4.repository;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gnExpress.serviciosTE4.dao.IServiciosRepo2;
import com.gnExpress.serviciosTE4.model.Servicios;

@Repository
public class ServiciosRepo implements IServiciosRepo2{

	@Autowired
	private EntityManager em;
	
	
	
	@Override
	public List<Servicios> dameServ4() {

		String hqlQuery="from Servicios s ";
		
		Query miQuery=em.createQuery(hqlQuery);
		
		miQuery.setMaxResults(4);
		
		ArrayList<Servicios> listaS=(ArrayList<Servicios>) miQuery.getResultList();
		
		return listaS;
		
		
	}

}
