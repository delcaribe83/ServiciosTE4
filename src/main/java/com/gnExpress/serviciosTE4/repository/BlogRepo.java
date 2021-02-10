package com.gnExpress.serviciosTE4.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gnExpress.serviciosTE4.dao.IBlogRepo2;
import com.gnExpress.serviciosTE4.model.Blog;



@Repository
public class BlogRepo implements IBlogRepo2{

	
		@Autowired
		private EntityManager em;		
		
		
		
		
		@Override
		public List<Blog> dameBlog3() {

			String hqlQuery="from Blog s order by s.id desc";
			
			Query miQuery=em.createQuery(hqlQuery);
			
			miQuery.setMaxResults(3);
			
			ArrayList<Blog> listaB=(ArrayList<Blog>) miQuery.getResultList();
			
			return listaB;
			
			
		}
		
		@Override
		public List<Blog> dameListaDecrec(){
			
			String hqlQuery="from Blog s order by s.id desc";
			
			Query miQuery=em.createQuery(hqlQuery);		
			
			ArrayList<Blog> listaB=(ArrayList<Blog>) miQuery.getResultList();
			
			return listaB;
			
			
		}
		
		@Override
		public List<Blog> dameListaDecrecIndex(){
			
			String hqlQuery="from Blog s ";
			
			Query miQuery=em.createQuery(hqlQuery);
			
			miQuery.setMaxResults(3);
			
			ArrayList<Blog> listaB=(ArrayList<Blog>) miQuery.getResultList();
			
			return listaB;
			
			
		}
		
		
		
		
		
		
	}


