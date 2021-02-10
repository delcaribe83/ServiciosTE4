package com.gnExpress.serviciosTE4.controller;


import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gnExpress.serviciosTE4.dao.IBlogRepo;
import com.gnExpress.serviciosTE4.dao.IBlogRepo2;
import com.gnExpress.serviciosTE4.dao.IContactoRepo;
import com.gnExpress.serviciosTE4.dao.IEmpresaRepo2;
import com.gnExpress.serviciosTE4.dao.IServiciosRepo;
import com.gnExpress.serviciosTE4.dao.ISubServiciosDAO;
import com.gnExpress.serviciosTE4.dao.ISubServiciosRepo;
import com.gnExpress.serviciosTE4.dao.ITestimonialesRepo;
import com.gnExpress.serviciosTE4.dao.ITestimonialesRepo2;
import com.gnExpress.serviciosTE4.model.Blog;
import com.gnExpress.serviciosTE4.model.Contacto;
import com.gnExpress.serviciosTE4.model.Empresa;
import com.gnExpress.serviciosTE4.model.Servicios;
import com.gnExpress.serviciosTE4.model.SubServicios;
import com.gnExpress.serviciosTE4.model.Testimoniales;
import com.gnExpress.serviciosTE4.model.Usuario;



@Controller
@RequestMapping("/gnExpress")
public class GnExpress_controller {	

	
	@Autowired
	private IContactoRepo cRepo;
	@Autowired
	private ITestimonialesRepo tRepo;	
	@Autowired
	private ITestimonialesRepo2 tRepo2;	
	@Autowired
	private IBlogRepo2 bRepo2;
	@Autowired
	private IBlogRepo bRepo;
	@Autowired
	private ISubServiciosRepo ssR;
	@Autowired
	private ISubServiciosDAO ssDAO;
	@Autowired
	private IEmpresaRepo2 empR;
	@Autowired
	private IServiciosRepo servR;		
	
	
	
	
	private  Empresa em;
	private Blog blog;
	private ArrayList<Blog> blogs;
	private Servicios servicio;
	private ArrayList<Servicios> serv;
	private SubServicios subServicio;
	private ArrayList<SubServicios> subServ;	
	private Testimoniales testimonial;
	private ArrayList<Testimoniales> testimoniales;
	
	
	
	
	
	@InitBinder
	public void miBinder(WebDataBinder binder) {
		
		StringTrimmerEditor recortarEspaciosBlanco=new StringTrimmerEditor(true);
		
		binder.registerCustomEditor(String.class, recortarEspaciosBlanco);		
	}	
	
	@GetMapping("/contacto")
	public String contacto(Model modelo) {	
		
		em=empR.dameLaPrimera();
		modelo.addAttribute("gnExpress", em);			
		
		serv=(ArrayList<Servicios>) servR.findAll();
		modelo.addAttribute("serv_gnExpress", serv);		
						
		Contacto contacto=new Contacto();
		modelo.addAttribute("cont", contacto);
		
		int fechaFooter=LocalDate.now().getYear();
		modelo.addAttribute("fechaFoot", fechaFooter);	
		
		return "contacto";		
	}
	
	
	@PostMapping("/crea_contacto")
	public String crear_contacto(@Valid @ModelAttribute("cont") Contacto contacto, 
			BindingResult resultadoValid, Model modelo) {				
				
		
		
		
		em=empR.dameLaPrimera();	
		serv=(ArrayList<Servicios>) servR.findAll();
		
		
		
		
		if(resultadoValid.hasErrors()) {			
			
			String mensaje=resultadoValid.getFieldError().getDefaultMessage();			
					
			modelo.addAttribute("gnExpress", em);		
			modelo.addAttribute("serv_gnExpress", serv);
			modelo.addAttribute("msge", mensaje);
			
			int fechaFooter=LocalDate.now().getYear();
			modelo.addAttribute("fechaFoot", fechaFooter);			
			
			return "contacto";
			
		}else {
				
			
				LocalDate fech= LocalDate.now();
				
				contacto.setFecha(fech);
			
				
				cRepo.save(contacto);	
				System.out.println(contacto.toString());	
				
				modelo.addAttribute("gnExpress", em);		
				modelo.addAttribute("serv_gnExpress", serv);
				
				int fechaFooter=LocalDate.now().getYear();
				modelo.addAttribute("fechaFoot", fechaFooter);
				
					
							
			Contacto contac2=new Contacto();
			modelo.addAttribute("cont", contac2);
			
			
			
		return "contacto";		
			
		}	
				
     }	
	
	
	@GetMapping("/blog_todos")
	public String blogTodos(Model modelo) {		
		
		em=empR.dameLaPrimera();
		modelo.addAttribute("gnExpress", em);			
		
		serv=(ArrayList<Servicios>) servR.findAll();
		modelo.addAttribute("serv_gnExpress", serv);
		
		blogs=(ArrayList<Blog>) bRepo2.dameListaDecrec();
		
		
		recortablog(blogs);	
		
		modelo.addAttribute("blogs", blogs);
		
		int fechaFooter=LocalDate.now().getYear();
		modelo.addAttribute("fechaFoot", fechaFooter);
		
		return "NuestroBlog";
		
	}	
	

	@GetMapping("/entradaBlog")
	public String entradaBlog(@RequestParam("id_blog") int id,Model modelo) {
		
		em=empR.dameLaPrimera();
		modelo.addAttribute("gnExpress", em);			
		
		serv=(ArrayList<Servicios>) servR.findAll();
		modelo.addAttribute("serv_gnExpress", serv);
		
			blog=bRepo.getOne(id);//Aqui me quede
			
			modelo.addAttribute("blog_gnExpress", blog);
			
			int fechaFooter=LocalDate.now().getYear();
			modelo.addAttribute("fechaFoot", fechaFooter);
		
		return "entrada-Blog";
		
	}
	
	@GetMapping("/testimoniales")
	public String testimoniales(Model modelo) {	
		
		em=empR.dameLaPrimera();
		modelo.addAttribute("gnExpress", em);			
		
		serv=(ArrayList<Servicios>) servR.findAll();
		modelo.addAttribute("serv_gnExpress", serv);		
					
		testimoniales=(ArrayList<Testimoniales>) tRepo2.dameListaCompletaTestimoniales();
		modelo.addAttribute("testimoniales", testimoniales);
		
		Testimoniales testimonial2=new Testimoniales();		
		modelo.addAttribute("testim", testimonial2);	
		
		int fechaFooter=LocalDate.now().getYear();
		modelo.addAttribute("fechaFoot", fechaFooter);
		
		
		return "Testimoniales";
		
	}
	
	
	@PostMapping("/crea_testimonial")
	public String crear_testimonial(@RequestParam ("ratingForm") int rating, @ModelAttribute("testim") Testimoniales testim, Model modelo) {			
		
		
		
		LocalDate fecha=LocalDate.now();
		
		testim.setFecha(fecha);
		
		testim.setPorcentaje(rating);			
		
		try {
			
			em=empR.dameLaPrimera();
			modelo.addAttribute("gnExpress", em);			
			
			serv=(ArrayList<Servicios>) servR.findAll();
			modelo.addAttribute("serv_gnExpress", serv);
			
			int fechaFooter=fecha.getYear();
			modelo.addAttribute("fechaFoot", fechaFooter);
			
			testimoniales=(ArrayList<Testimoniales>) tRepo2.dameListaTestimoniales();
			modelo.addAttribute("testimoniales", testimoniales);
			
			testimonial=tRepo2.damePrimerTestimonial();
			modelo.addAttribute("testimonial", testimonial);		
			
			
			tRepo.save(testim);		
			
			return "Testimoniales";
			
		}catch(Exception e) {
			e.printStackTrace();
			
			em=empR.dameLaPrimera();
			modelo.addAttribute("gnExpress", em);			
			
			serv=(ArrayList<Servicios>) servR.findAll();
			modelo.addAttribute("serv_gnExpress", serv);
			
			int fechaFooter=fecha.getYear();
			modelo.addAttribute("fechaFoot", fechaFooter);
			
			testimoniales=(ArrayList<Testimoniales>) tRepo2.dameListaTestimoniales();
			modelo.addAttribute("testimoniales", testimoniales);
			
			testimonial=tRepo2.damePrimerTestimonial();
			modelo.addAttribute("testimonial", testimonial);
			
			
			return "Testimoniales";
		}			
			
     }
	
	@GetMapping("/subservicios")
	public String servicios(@RequestParam ("id_Servicio") String id, Model modelo) {			
		
		em=empR.dameLaPrimera();
		modelo.addAttribute("gnExpress", em);			
		
		serv=(ArrayList<Servicios>) servR.findAll();
		modelo.addAttribute("serv_gnExpress", serv);
		
		
		int id2=Integer.parseInt(id);
		servicio=servR.getOne(id2);	
		subServ=(ArrayList<SubServicios>) ssDAO.dameSubServPorIdServicios(id2);			
		
		
		modelo.addAttribute("servicio", servicio);	
		modelo.addAttribute("subservicios", subServ);	
		
		return "servicios_Empresa";
		
	}
	
	@GetMapping("/subservicio")
	public String subservicio(@RequestParam ("id_Sub") Integer id, Model modelo) {			
		
		em=empR.dameLaPrimera();
		modelo.addAttribute("gnExpress", em);			
		
		serv=(ArrayList<Servicios>) servR.findAll();
		modelo.addAttribute("serv_gnExpress", serv);
		
		subServicio=ssR.getOne(id);
		
		modelo.addAttribute("subservicio",subServicio);
		
		return "entrada-Servicios";
		
	}
	
	@GetMapping("/login")
	public String login(Model modelo) {			
		
		em=empR.dameLaPrimera();
		modelo.addAttribute("gnExpress", em);			
		
		serv=(ArrayList<Servicios>) servR.findAll();
		modelo.addAttribute("serv_gnExpress", serv);
		
		Usuario usuario=new Usuario();
		modelo.addAttribute("user", usuario);
		
		return "login";
		
	}
	
	
	
private void recortablog(ArrayList<Blog> blogs2) {
		
		for (Blog blog : blogs2) {
			
			String articulo=blog.getArticulo();
			if(articulo.length()>300) {
				String newArticulo = articulo.substring(0, 300);
				blog.setArticulo(newArticulo+"...");
			}else {
				blog.setArticulo(articulo+"...");
			}
		}
		
	}


	
}
	
	

