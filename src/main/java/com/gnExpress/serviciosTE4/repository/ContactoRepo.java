package com.gnExpress.serviciosTE4.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gnExpress.serviciosTE4.dao.IContactoRepo2;
import com.gnExpress.serviciosTE4.model.Contacto;

@Repository
public class ContactoRepo implements IContactoRepo2{
	
	
	
	@Autowired
	private EntityManager em;
	
	
// Esta es una clase de prueba	y metodo
	@Override
	public int dameNumeroClientes() {	
		
		
		String hql="select count(e.id) from Contacto e";
		
		
		
		int total=em.createQuery(hql).getFirstResult();	
		
		
		System.out.println(total+"imprime");
		
		return total;
		
	}
	
	
	public ArrayList<Contacto> dameNoContactados(){
		
		String hql="select c from Contacto c where c.contactado=0";
		
		Query miQuery=em.createQuery(hql);
		
		ArrayList<Contacto> noContactados=(ArrayList<Contacto>) miQuery.getResultList();
		
		return noContactados;
		
	}
	
	
}
