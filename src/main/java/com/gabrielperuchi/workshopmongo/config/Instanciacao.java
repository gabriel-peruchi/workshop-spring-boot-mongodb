package com.gabrielperuchi.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabrielperuchi.workshopmongo.domain.Usuario;
import com.gabrielperuchi.workshopmongo.repository.UsuarioRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepositorio.deleteAll();
		
		Usuario gabriel = new Usuario(null, "Gabriel Peruchi", "gabriel@gmail.com");
		Usuario carlos = new Usuario(null, "Carlos Alberto", "carlos@gmail.com");
		Usuario maria = new Usuario(null, "Maria Julia", "maria@gmail.com");
		
		usuarioRepositorio.saveAll(Arrays.asList(gabriel, carlos, maria));
		
	}

}
