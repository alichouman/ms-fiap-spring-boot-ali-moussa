package br.com.fiap.java.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.java.dto.FotoDTO;
import br.com.fiap.java.model.Foto;
import br.com.fiap.java.service.FotoService;

/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

@RestController
@RequestMapping("/fotos")
public class FotoController {

	@Autowired
	private FotoService fotoService;

	@GetMapping()
	public ResponseEntity<List<Foto>> listar() {

		List<Foto> fotos = fotoService.findAll();

		return ResponseEntity.ok().body(fotos);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Foto> buscar(@PathVariable(value = "id") Integer id) {
		Foto foto = fotoService.find(id);

		return ResponseEntity.ok(foto);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> cadastrar(@Validated @RequestBody FotoDTO fotoDTO) {
		Foto foto = fotoService.converterDTO(fotoDTO);
		foto = fotoService.cadastrar(foto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(foto.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@Validated @RequestBody FotoDTO fotoDTO, @PathVariable Integer id) {
		Foto foto = fotoService.converterDTO(fotoDTO);
		foto.setId(id);
		foto = fotoService.atualizar(foto);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		fotoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
