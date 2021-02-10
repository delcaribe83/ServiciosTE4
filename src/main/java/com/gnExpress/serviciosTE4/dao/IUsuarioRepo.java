package com.gnExpress.serviciosTE4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gnExpress.serviciosTE4.model.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNombre(String nombre);

}
