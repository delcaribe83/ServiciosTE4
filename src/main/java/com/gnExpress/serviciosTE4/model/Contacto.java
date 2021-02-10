package com.gnExpress.serviciosTE4.model;

	import java.time.LocalDate;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;


	import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


	
	@Entity
	@Table(name="contactos")	
	public class Contacto {
		
		@Id                                      //Esta anotación establece el ID pero en MySQL pero Hibernate no lo sabe
		@GeneratedValue(strategy=GenerationType.IDENTITY)//Esta anotación informa a hibernate que este es el id de la tabla.
		@Column(name="id") 			
		private int id;		
		
		
		@NotEmpty
		@Size(min=2, message=" Campo Requerido, Y DEBE TENER MÁS DE 2 CARACTERES")
		@Column(name="nombre")	
		private String nombre;	
		

		@Email
		@Pattern(regexp="[a-zA-Z0-9_.]+@+[a-zA-Z0-9-]+.+[a-zA-Z0-9-.]", message=" verifique que su correo cumpla con los requisitos establecidos")
		@Column(name="e_mail")		
		private String correo;	
		
		@NotEmpty		
		@Pattern(regexp="[0-9]{8,11}", message=" Solo valores numéricos, estos deben tener de 7 a 11 digitos ")		
		@Column(name="telefono")	
		private String telefono;
		
		@Column(name="msje")	
		private String msje;
				
		@Column(name="contactado", nullable = false, columnDefinition = "int default false")
		private boolean contactado;

		@Column(name="fecha")
		private LocalDate fecha;

		public Contacto() {
		}





		public Contacto(String nombre, String correo, String telefono, String msje, Boolean contactado) {
			this.nombre = nombre;		
			this.correo = correo;
			this.telefono = telefono;
			this.msje = msje;
			this.contactado=contactado;
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

		

		public String getCorreo() {
			return correo;
		}





		public void setCorreo(String correo) {
			this.correo = correo;
		}





		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getMsje() {
			return msje;
		}


		public void setMsje(String msje) {
			this.msje = msje;
		}
		
		


		public LocalDate getFecha() {
			return fecha;
		}





		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}





		public Boolean getContactado() {
			return contactado;
		}





		public void setContactado(Boolean contactado) {
			this.contactado = contactado;
		}





		@Override
		public String toString() {
			return "Contacto [id=" + id + ", nombre=" + nombre + ", correo=" + correo
					+ ", telefono=" + telefono + ", msje=" + msje + "]";
		}	



		
		
	}

	

