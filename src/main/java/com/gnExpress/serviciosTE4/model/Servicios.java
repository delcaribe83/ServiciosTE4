package com.gnExpress.serviciosTE4.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicios{
	
	@Id                                      //Esta anotación establece el ID pero en MySQL pero Hibernate no lo sabe
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Esta anotación informa a hibernate que este es el id de la tabla.
	@Column(name="id") 		
	private int id;
	@Column(name="nombre")	
	private String nombre;
	@Column(name="descripcion")	
	private String descripcion;
	@Column(name="foto")	
	private String foto;	
	
	@ManyToOne(cascade= 
		{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})  //Especificamos que no se debe eliminar nada
	@JoinColumn(name="empresa_id", referencedColumnName = "id")  // Nombre de campo en la tabla de la BBDD (Campo clave foranea)
	private Empresa empresa;
	
	@Column(name="encabezado")	
	private String encabezado;
	
	
	@OneToMany(mappedBy="servicio", cascade=
		{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<SubServicios> sub_servicios;
	
	
	
	public Servicios() {


	}


	public Servicios(String nombre, String descripcion, String foto, String encabezado) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.foto = foto;
		this.encabezado = encabezado;
	}
	
	


	public List<SubServicios> getSub_servicios() {
		return sub_servicios;
	}


	public void setSub_servicios(SubServicios sub_servicio) {
		
		if (sub_servicios==null){			
			sub_servicios=new ArrayList<SubServicios>();
			sub_servicio.setServicio(this);			
			sub_servicios.add(sub_servicio);
			
		}
		
	}


	public int getId() {
		return id;
	}	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public String getEncabezado() {
		return encabezado;
	}


	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}		
	
}
