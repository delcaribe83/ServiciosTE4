package com.gnExpress.serviciosTE4.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="empresa")
public class Empresa {
	
	
	@Id                                      //Esta anotación establece el ID pero en MySQL pero Hibernate no lo sabe
	@GeneratedValue(strategy=GenerationType.IDENTITY)//Esta anotación informa a hibernate que este es el id de la tabla.
	@Column(name="id") 		
	private int id;	
	@Column(name="nombre")	
	private String nombre;		
	@Column(name="historia")	
	private String historia;
	@Column(name="direccion")	
	private String direccion;
	@Column(name="correo")	
	private String correo;
	@Column(name="tfno")	
	private String tfno;
	@Column(name="watsapp")	
	private String watsapp;
	@Column(name="facebook")	
	private String facebook;
	@Column(name="twitter")	
	private String twitter;
	@Column(name="instagram")	
	private String instagram;
	@Column(name="movil")	
	private String movil;
	@Column(name="youtube")	
	private String youtube;
	@Column(name="publicEmpresa1")	
	private String public1;
	@Column(name="publicEmpresa2")	
	private String public2;
	@Column(name="publicEmpresa3")	
	private String public3;
	@Column(name="publicServ")	
	private String publicServ;
	@Column(name="encabezadoServ")	
	private String encabezadoServ;
	
	@Column(name="encabezado_dep_tecnico")	
	private String encabezadoDepTecnico;	
	@Column(name="public_dep_tecnico")	
	private String publicDepTecnico;	
	@Column(name="encabez_clientes_testim")	
	private String encabezClientesTestim;
	@Column(name="public_clientes_testimoniales")	
	private String publicClientesTestimoniales;
	@Column(name="encabezado_blog")	
	private String encabezadoBlog;
	@Column(name="publicidad_blog")	
	private String publicidadBlog;
	
	@OneToMany(mappedBy="empresa", cascade=
		{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Servicios> servicios;

	@OneToMany(mappedBy="empresa", cascade=
		{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
private List<Jefes> jefes;
	
	
	public Empresa() {
		
	}
	
	public Empresa(int id, String nombre, String historia, String direccion, String correo, String telefono, String watsapp,
			String facebook, String twitter, String instagram, String movil, String youtuve, String public1, String public2, String public3, String publicServ, String encabezadoServ,  String encabezadoDepTecnico, String publicDepTecnico, String encabezClientesTestim, String publicClientesTestimoniales, String encabezadoBlog, String publicidadBlog) {
		
		this.id = id;
		this.nombre = nombre;
		this.historia = historia;
		this.direccion = direccion;
		this.correo = correo;
		this.tfno = telefono;
		this.watsapp = watsapp;
		this.facebook = facebook;
		this.twitter = twitter;
		this.instagram = instagram;
		this.movil = movil;
		this.youtube = youtuve;
		this.public1=public1;
		this.public2=public2;
		this.public3=public3;
		this.publicServ=publicServ;
		this.encabezadoServ=encabezadoServ;		
		this.encabezadoDepTecnico=encabezadoDepTecnico;
		this.publicDepTecnico=publicDepTecnico;
		this.encabezClientesTestim=encabezClientesTestim;
		this.publicClientesTestimoniales=publicClientesTestimoniales;
		this.encabezadoBlog=encabezadoBlog;
		this.publicidadBlog=publicidadBlog;
		
	}
	
	
	public List<Servicios> getServicios() {
		return servicios;
	}

	
	public void setServicios(Servicios servicio) {
		
		if(servicios==null) servicios= new ArrayList<Servicios>();
		
		servicio.setEmpresa(this);
		
		servicios.add(servicio);			
	}
	
	public List<Jefes> getjefes() {
		return jefes;
	}

	
	public void setjefes(Jefes jefe) {
		
		if(jefes==null) jefes= new ArrayList<Jefes>();
		
		jefe.setEmpresa(this);
		
		jefes.add(jefe);			
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

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return tfno;
	}

	public void setTelefono(String telefono) {
		this.tfno = telefono;
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

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;

}
	
	

	public String getPublic1() {
		return public1;
	}

	public void setPublic1(String public1) {
		this.public1 = public1;
	}

	public String getPublic2() {
		return public2;
	}

	public void setPublic2(String public2) {
		this.public2 = public2;
	}

	public String getPublic3() {
		return public3;
	}

	public void setPublic3(String public3) {
		this.public3 = public3;
	}
	

	public String getEncabezadoServ() {
		return encabezadoServ;
	}

	public void setEncabezadoServ(String encabezadoServ) {
		this.encabezadoServ = encabezadoServ;
	}	

	public String getPublicServ() {
		return publicServ;
	}

	public void setPublicServ(String publicServ) {
		this.publicServ = publicServ;
	}
	
	

	public String getEncabezadoDepTecnico() {
		return encabezadoDepTecnico;
	}

	public void setEncabezadoDepTecnico(String encabezadoDepTecnico) {
		this.encabezadoDepTecnico = encabezadoDepTecnico;
	}

	public String getPublicDepTecnico() {
		return publicDepTecnico;
	}

	public void setPublicDepTecnico(String publicDepTecnico) {
		this.publicDepTecnico = publicDepTecnico;
	}

	public String getEncabezClientesTestim() {
		return encabezClientesTestim;
	}

	public void setEncabezClientesTestim(String encabezClientesTestim) {
		this.encabezClientesTestim = encabezClientesTestim;
	}

	public String getPublicClientesTestimoniales() {
		return publicClientesTestimoniales;
	}

	public void setPublicClientesTestimoniales(String publicClientesTestimoniales) {
		this.publicClientesTestimoniales = publicClientesTestimoniales;
	}

	public String getEncabezadoBlog() {
		return encabezadoBlog;
	}

	public void setEncabezadoBlog(String encabezadoBlog) {
		this.encabezadoBlog = encabezadoBlog;
	}

	public String getPublicidadBlog() {
		return publicidadBlog;
	}

	public void setPublicidadBlog(String publicidadBlog) {
		this.publicidadBlog = publicidadBlog;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", historia=" + historia + ", direccion=" + direccion
				+ ", correo=" + correo + ", tfno=" + tfno + ", watsapp=" + watsapp + ", facebook=" + facebook
				+ ", twitter=" + twitter + ", instagram=" + instagram + ", movil=" + movil + ", youtube=" + youtube
				+ ", public1=" + public1 + ", public2=" + public2 + ", public3=" + public3 + "]";
	}

	
	
	
}
