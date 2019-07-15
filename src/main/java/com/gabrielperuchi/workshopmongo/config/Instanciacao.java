package com.gabrielperuchi.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gabrielperuchi.workshopmongo.domain.Postagem;
import com.gabrielperuchi.workshopmongo.domain.Usuario;
import com.gabrielperuchi.workshopmongo.repository.PostagemRepositorio;
import com.gabrielperuchi.workshopmongo.repository.UsuarioRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PostagemRepositorio postagemRepositorio;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepositorio.deleteAll();
		postagemRepositorio.deleteAll();
		
		Usuario gabriel = new Usuario(null, "Gabriel Peruchi", "gabriel@gmail.com");
		Usuario carlos = new Usuario(null, "Carlos Alberto", "carlos@gmail.com");
		Usuario maria = new Usuario(null, "Maria Julia", "maria@gmail.com");
		
		Postagem postagem1 = new Postagem(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", gabriel);
		Postagem postagem2 = new Postagem(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", gabriel);
		
		usuarioRepositorio.saveAll(Arrays.asList(gabriel, carlos, maria));
		
		postagemRepositorio.saveAll(Arrays.asList(postagem1,postagem2));
		
	}

}
