package com.gnExpress.serviciosTE4.dao;

import java.util.List;

import com.gnExpress.serviciosTE4.model.SubServicios;

public interface ISubServiciosDAO {
	
	public List<SubServicios> dameSubServPorIdServicios(Integer id);

}
