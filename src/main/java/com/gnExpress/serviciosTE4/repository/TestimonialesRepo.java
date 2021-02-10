package com.gnExpress.serviciosTE4.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gnExpress.serviciosTE4.dao.ITestimonialesRepo2;
import com.gnExpress.serviciosTE4.model.Testimoniales;



@Repository
public class TestimonialesRepo implements ITestimonialesRepo2{
	
	@Autowired
	private EntityManager em;
	
	
	@Override
	public Testimoniales damePrimerTestimonial(){
		
		String testimoniales_hql="from Testimoniales t";
		
		Query miQuery=em.createQuery(testimoniales_hql);
		
		miQuery.setMaxResults(1);
		
		Testimoniales t=(Testimoniales) miQuery.getSingleResult();
		
		return t;
	}

	@Override
	public List<Testimoniales> dameListaTestimoniales(){
		
		String testimoniales_hql="from Testimoniales t";
		
		Query miQuery=em.createQuery(testimoniales_hql);
		
		miQuery.setFirstResult(1);
		
		List<Testimoniales> lt=miQuery.getResultList();
		
		return lt;
	}
	
	
	@Override
	public List<Testimoniales> dameListaCompletaTestimoniales(){
		
		String testimoniales_hql="from Testimoniales t order by t.id desc";
		
		Query miQuery=em.createQuery(testimoniales_hql);		
		
		List<Testimoniales> lt=miQuery.getResultList();
		
		return lt;
	}

}
