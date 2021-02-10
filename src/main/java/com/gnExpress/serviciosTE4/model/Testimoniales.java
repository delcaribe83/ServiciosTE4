package com.gnExpress.serviciosTE4.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="testimoniales")	
public class Testimoniales implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id                                      //Esta anotación establece el ID pero en MySQL pero Hibernate no lo sabe
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Esta anotación informa a hibernate que este es el id de la tabla.
	@Column(name="id")
	private int id;
	@Column(name="autor")
	private String autor;
	@Column(name="testimonial")
	private String testimonial;
	@Column(name="fecha")
	private LocalDate fecha;
	@Column(name="porcentaje")
	private float porcentaje;
	
	public Testimoniales() {
		
	}

	public Testimoniales(String autor, String testimonial, LocalDate fecha, float porcentaje) {
		
		this.autor = autor;
		this.testimonial = testimonial;
		this.fecha = fecha;
		this.porcentaje = porcentaje;
		
	}
	
	

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTestimonial() {
		return testimonial;
	}

	public void setTestimonial(String testimonial) {
		this.testimonial = testimonial;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int getId() {
		return id;
	}
	

}
