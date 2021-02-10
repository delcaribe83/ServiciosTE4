package com.gnExpress.serviciosTE4.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gnExpress.serviciosTE4.dao.IContactoRepo;
import com.gnExpress.serviciosTE4.dao.IContactoRepo2;
import com.gnExpress.serviciosTE4.dao.IEmpresaRepo2;
import com.gnExpress.serviciosTE4.dao.IServiciosRepo;
import com.gnExpress.serviciosTE4.dao.IUsuarioRepo;
import com.gnExpress.serviciosTE4.model.Contacto;
import com.gnExpress.serviciosTE4.model.Empresa;
import com.gnExpress.serviciosTE4.model.Servicios;
import com.gnExpress.serviciosTE4.model.Usuario;
import com.gnExpress.serviciosTE4.services.DatosPrivateService;



@Controller
@RequestMapping("/private")
public class Private_Controllers {
		
/*	
	@Autowired
	private IUsuarioRepo usuarioService;
*/
	
	@Autowired
	private IEmpresaRepo2 empR;
	@Autowired
	private IServiciosRepo servR;	
	@Autowired
	private IContactoRepo contR;
	@Autowired
	private IContactoRepo2 contR2;	
	@Autowired
	private DatosPrivateService dps;
	
	
	private  Empresa em;
	private ArrayList<Servicios> serv;
	private ArrayList<Contacto> total;
	private ArrayList<Contacto> total2;
	
	@GetMapping("/admin")
	public String admin(Authentication auth, Model modelo) {   //Creo un objeto de tipo Authentication y Htto srssion de tal manera que demos la bienvenida al usuario que entre en eta sesión.
		
		
		
		total=(ArrayList<Contacto>) contR.findAll();	
		modelo.addAttribute("total", total.size());
		modelo.addAttribute("totalcontactados", dps.dameTotalContactados(total));
		
		
		
		total2=(ArrayList<Contacto>) contR2.dameNoContactados();	
		modelo.addAttribute("total2", total2);		
		
		
		
		String username=auth.getName();  //Este nombre viene en una sessión por lo tanto utilizo el auth.getName para conseguir el nombre del usuario de la sessión
		modelo.addAttribute("name", username);		
	
		
		return "administre";		
		
	}		
	
	
	@GetMapping("/datosEmpresa")
	public String datosEmpresa(Authentication auth, Model modelo) {   //Creo un objeto de tipo Authentication y Htto srssion de tal manera que demos la bienvenida al usuario que entre en eta sesión.
		
		em=empR.dameLaPrimera();
		modelo.addAttribute("gnExpress", em);	
		
		
		String username=auth.getName();  //Este nombre viene en una sessión por lo tanto utilizo el auth.getName para conseguir el nombre del usuario de la sessión
		modelo.addAttribute("name", username);		
	
		
		return "AdministreDatosEmpresa";		
		
	}	
	
	
		

}
