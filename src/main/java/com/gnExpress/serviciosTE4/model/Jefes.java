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
@Table(name="jefes")	
public class Jefes {

	
	
	@Id                                      //Esta anotación establece el ID pero en MySQL pero Hibernate no lo sabe
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Esta anotación informa a hibernate que este es el id de la tabla.
	@Column(name="id") 		
	private int id;
	@Column(name="nombre")	
	private String nombre;
	@Column(name="cargo")	
	private String cargo;
	@Column(name="watsapp")	
	private String watsapp;		
	@Column(name="facebook")	
	private String facebook;
	@Column(name="twitter")	
	private String twitter;
	@Column(name="instagram")	
	private String instagram;
	@Column(name="foto")	
	private String foto;
	@Column(name="youtube")	
	private String youtube;
	
	
	@ManyToOne(cascade= 
		{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})  //Especificamos que no se debe eliminar nada
	@JoinColumn(name="empresa_id", referencedColumnName = "id")  // Nombre de campo en la tabla de la BBDD (Campo clave foranea)
	private Empresa empresa;

	public Jefes() {
		
	}	

	public Jefes(String nombre, String cargo, String watsapp, String facebook, String twitter, String instagram,
			String foto, String youtube) {
		
		this.nombre = nombre;
		this.cargo = cargo;
		this.watsapp = watsapp;
		this.facebook = facebook;
		this.twitter = twitter;
		this.instagram = instagram;
		this.foto = foto;
		this.youtube = youtube;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getWatsapp() {
		return watsapp;
	}

	public void setWatsapp(String watsapp) {
		this.watsapp = watsapp;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
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

	public int getId() {
		return id;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}	
	
	
	
	
}
