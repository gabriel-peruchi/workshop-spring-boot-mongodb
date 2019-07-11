package com.gabrielperuchi.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielperuchi.workshopmongo.domain.Usuario;
import com.gabrielperuchi.workshopmongo.dto.UsuarioDTO;
import com.gabrielperuchi.workshopmongo.services.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioServico servico;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> buscaTodos() {

		List<Usuario> lista = servico.buscaTodos();
		
		// Convertendo os usuarios em usuariosDTO
		List<UsuarioDTO> listaDTO = lista.stream().map(usuario -> 
			new UsuarioDTO(usuario)).collect(Collectors.toList());   

		return ResponseEntity.ok().body(listaDTO);
	}

}
