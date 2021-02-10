package com.gnExpress.serviciosTE4.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blog")
public class Blog {
	
	@Id                                      //Esta anotación establece el ID pero en MySQL pero Hibernate no lo sabe
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Esta anotación informa a hibernate que este es el id de la tabla.
	@Column(name="id") 		
	private int id;
	@Column(name="titulo")	
	private String titulo;
	@Column(name="fecha")	
	private LocalDate fecha;
	@Column(name="autor")	
	private String autor;	
	@Column(name="articulo")	
	private String articulo;
	@Column(name="foto")	
	private String foto;
	
	
	public Blog() {
		
	}


	public Blog(String titulo, LocalDate fecha, String autor, String articulo, String foto) {
		this.titulo = titulo;
		this.fecha = fecha;
		this.autor = autor;
		this.articulo = articulo;
		this.foto = foto;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getArticulo() {
		return articulo;
	}


	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}


	public int getId() {
		return id;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	

}
