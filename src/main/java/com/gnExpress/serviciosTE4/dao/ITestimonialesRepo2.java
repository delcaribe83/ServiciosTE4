package com.gnExpress.serviciosTE4.dao;

import java.util.List;

import com.gnExpress.serviciosTE4.model.Testimoniales;

public interface ITestimonialesRepo2 {
	
	public Testimoniales damePrimerTestimonial();
	public List<Testimoniales> dameListaTestimoniales();
	public List<Testimoniales> dameListaCompletaTestimoniales();

}
