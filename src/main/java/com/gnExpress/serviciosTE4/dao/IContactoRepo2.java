package com.gnExpress.serviciosTE4.dao;

import java.util.ArrayList;

import com.gnExpress.serviciosTE4.model.Contacto;

public interface IContactoRepo2 {
	
	public int dameNumeroClientes();
	public ArrayList<Contacto> dameNoContactados();
}
