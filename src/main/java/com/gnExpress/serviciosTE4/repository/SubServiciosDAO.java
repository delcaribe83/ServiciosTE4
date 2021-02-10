package com.gnExpress.serviciosTE4.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gnExpress.serviciosTE4.dao.ISubServiciosDAO;
import com.gnExpress.serviciosTE4.model.Servicios;
import com.gnExpress.serviciosTE4.model.SubServicios;

@Repository
public class SubServiciosDAO implements ISubServiciosDAO{
	
	@Autowired
	private EntityManager em;

	
	@Override
	public List<SubServicios> dameSubServPorIdServicios(Integer id) {
		
		String hqlQuery="from SubServicios s where s.servicio.id=?0";
		
		Query miQuery=em.createQuery(hqlQuery);
		
		miQuery.setParameter(0, id);
		
		ArrayList<SubServicios> listaSS=(ArrayList<SubServicios>) miQuery.getResultList();
		
		return listaSS;
		
	}

}
