package com.gnExpress.serviciosTE4.controller;


import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


import com.gnExpress.serviciosTE4.dao.IBlogRepo2;
import com.gnExpress.serviciosTE4.dao.IEmpresaRepo2;
import com.gnExpress.serviciosTE4.dao.IJefesRepo;

import com.gnExpress.serviciosTE4.dao.IServiciosRepo2;
import com.gnExpress.serviciosTE4.dao.ISubServiciosRepo;
import com.gnExpress.serviciosTE4.model.Blog;
import com.gnExpress.serviciosTE4.model.Empresa;
import com.gnExpress.serviciosTE4.model.Jefes;
import com.gnExpress.serviciosTE4.model.Servicios;
import com.gnExpress.serviciosTE4.model.SubServicios;
import com.gnExpress.serviciosTE4.model.Testimoniales;
import com.gnExpress.serviciosTE4.repository.TestimonialesRepo;

@Controller
public class Index_Controller {	

	@Autowired
	private IEmpresaRepo2 empR;
	@Autowired
	private IServiciosRepo2 servR;	
	@Autowired
	private ISubServiciosRepo sservR;	
	@Autowired
	private TestimonialesRepo testimRepo;
	@Autowired
	private IJefesRepo jefesRepo;	
	@Autowired
	private IBlogRepo2 blogRepo;
	
	
	private  Empresa em;
	private ArrayList<Servicios> servicios;
	private ArrayList<SubServicios> subServ;
	private ArrayList<Testimoniales> testimoniales;
	private Testimoniales testimonial;
	private ArrayList<Jefes> jefes;
	private ArrayList<Blog> blogs;
	
	
	@RequestMapping("/")
	public String paginaInicio(Model modelo) {	
		
		int fechaFooter=LocalDate.now().getYear();
		modelo.addAttribute("fechaFoot", fechaFooter);
		
		em=empR.dameLaPrimera();
		servicios=(ArrayList<Servicios>) servR.dameServ4();
		testimoniales=(ArrayList<Testimoniales>) testimRepo.dameListaTestimoniales();
		testimonial=(Testimoniales)testimRepo.damePrimerTestimonial();
		jefes=(ArrayList<Jefes>) jefesRepo.findAll();
		blogs=(ArrayList<Blog>) blogRepo.dameBlog3();
		subServ=(ArrayList<SubServicios>) sservR.findAll();
		
		recortablog(blogs);		
		
		modelo.addAttribute("blogs", blogs);
		
		modelo.addAttribute("gnExpress", em);						//mando datos de la empresa parra el index para actualizar la historia
		modelo.addAttribute("serv_gnExpress", servicios);
		modelo.addAttribute("subServ_gnExpress", subServ);
		modelo.addAttribute("jefes_gnExpress", jefes);	
		modelo.addAttribute("blogs_gnExpress", blogs);	
		modelo.addAttribute("testimoniales_gnExpress", testimoniales);	
		modelo.addAttribute("testimonial_gnExpress", testimonial);	
		
		
		return "index";
		
	}
	
	
	@RequestMapping("/posInicio")
	public String paginaInicio2(Model modelo, HttpServletRequest request, Authentication auth) {	
		
		
		HttpSession session2=request.getSession();
		
		if(session2.getAttribute("usuario")!=null) {			
			
			session2.removeAttribute("usuario");		 
				
			System.out.println(session2.getAttribute("usuario"));
			
		}
		
		em=empR.dameLaPrimera();
		servicios=(ArrayList<Servicios>) servR.dameServ4();
		testimoniales=(ArrayList<Testimoniales>) testimRepo.dameListaTestimoniales();
		testimonial=(Testimoniales)testimRepo.damePrimerTestimonial();
		jefes=(ArrayList<Jefes>) jefesRepo.findAll();
		blogs=(ArrayList<Blog>) blogRepo.dameBlog3();
		
		
		
		modelo.addAttribute("gnExpress", em);						//mando datos de la empresa parra el index para actualizar la historia
		modelo.addAttribute("serv_gnExpress", servicios);	
		modelo.addAttribute("jefes_gnExpress", jefes);	
		modelo.addAttribute("blogs_gnExpress", blogs);	
		modelo.addAttribute("testimoniales_gnExpress", testimoniales);	
		modelo.addAttribute("testimonial_gnExpress", testimonial);	
			
		int fechaFooter=LocalDate.now().getYear();
		modelo.addAttribute("fechaFoot", fechaFooter);
	
		return "index";
		
	}


	private void recortablog(ArrayList<Blog> blogs2) {		
			
			for (Blog blog : blogs2) {
				
				String articulo=blog.getArticulo();
				if(articulo.length()>400) {
					String newArticulo = articulo.substring(0, 400);
					blog.setArticulo(newArticulo+"...");
				}else {
					blog.setArticulo(articulo+"...");
				}
			}
			
		}
		
	
}
