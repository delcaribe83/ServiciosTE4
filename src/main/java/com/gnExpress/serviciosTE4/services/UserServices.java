package com.gnExpress.serviciosTE4.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gnExpress.serviciosTE4.dao.IUsuarioRepo;
import com.gnExpress.serviciosTE4.model.Usuario;


@Service
public class UserServices implements UserDetailsService{

	@Autowired
	private IUsuarioRepo uRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		
		Usuario user= uRepo.findByNombre(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		roles.add(new SimpleGrantedAuthority("USER"));
		
		UserDetails userDet=new User(user.getNombre(), user.getClave(), roles);
		
		return userDet;
	}

}
