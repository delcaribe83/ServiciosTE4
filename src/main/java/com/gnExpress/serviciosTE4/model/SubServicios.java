package com.gnExpress.serviciosTE4.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subservicios")
public class SubServicios {
	
	@Id                                      //Esta anotación establece el ID pero en MySQL pero Hibernate no lo sabe
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Esta anotación informa a hibernate que este es el id de la tabla.
	@Column(name="id") 	
	private int id;
	@Column(name="nombre")	
	private String nombre;
	@Column(name="foto")	
	private String foto;
	
	@ManyToOne(cascade= 
		{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})  //Especificamos que no se debe eliminar nada
	@JoinColumn(name="servicios_id", referencedColumnName = "id")  // Nombre de campo en la tabla de la BBDD (Campo clave foranea)
	private Servicios servicio;
	
	private String texto;

	public SubServicios() {
	
	}

	public SubServicios(String nombre, String foto, String texto) {
		super();
		this.nombre = nombre;
		this.foto = foto;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Servicios getServicio() {
		return servicio;
	}

	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	

}
