package com.gabrielperuchi.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		List<UsuarioDTO> listaDTO = lista.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> buscaPorId(@PathVariable String id) {

		Usuario usuario = servico.buscaPorId(id);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);

		return ResponseEntity.ok().body(usuarioDTO);

	}

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO objDTO) {

		Usuario usuario = servico.fromDTO(objDTO);

		usuario = servico.inserir(usuario);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {

		servico.delete(id);

		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UsuarioDTO objDTO, @PathVariable String id) {

		Usuario usuario = servico.fromDTO(objDTO);
		usuario.setId(id);
		usuario = servico.update(usuario);

		return ResponseEntity.noContent().build();

	}

}
