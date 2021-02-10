package com.gnExpress.serviciosTE4.services;


import java.util.ArrayList;



import org.springframework.stereotype.Service;


import com.gnExpress.serviciosTE4.model.Contacto;

@Service
public class DatosPrivateService {
	
	
	public int dameTotalContactados(ArrayList<Contacto> lista)  {	
		
		
		int cont=0;
		
		for (Contacto contacto : lista) {
			
			if(contacto.getContactado()) {
				
				cont++;
				
			}
			
		}	
		
		return cont;
		
		
	}
	
	

}
