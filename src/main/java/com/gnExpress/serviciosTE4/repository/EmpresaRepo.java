package com.gnExpress.serviciosTE4.repository;



import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gnExpress.serviciosTE4.dao.IEmpresaRepo2;
import com.gnExpress.serviciosTE4.model.Empresa;


@Repository
public class EmpresaRepo implements IEmpresaRepo2{

	@Autowired
	private EntityManager em;	
	
	
	
	@Override
	public Empresa dameLaPrimera() {
		
		String hql_gnexpress="from Empresa e";		
		
		Query miQuery=(Query) em.createQuery(hql_gnexpress);	
		
		miQuery.setMaxResults(1);
		
		Empresa emp=(Empresa) miQuery.getSingleResult();
		
		return emp;
	}

}
