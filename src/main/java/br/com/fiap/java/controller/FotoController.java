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

@RestController
@RequestMapping("/fotos")
public class FotoController {

	@Autowired
	private FotoService cozinhaService;

	@GetMapping()
	public ResponseEntity<List<Foto>> listar() {

		List<Foto> fotos = cozinhaService.findAll();

		return ResponseEntity.ok().body(fotos);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Foto> buscar(@PathVariable(value = "id") Integer id) {
		Foto cozinha = cozinhaService.find(id);

		return ResponseEntity.ok(cozinha);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> cadastrar(@Validated @RequestBody FotoDTO fotoDTO) {
		Foto cozinha = cozinhaService.converterDTO(fotoDTO);
		cozinha = cozinhaService.cadastrar(cozinha);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cozinha.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@Validated @RequestBody FotoDTO fotoDTO, @PathVariable Integer id) {
		Foto cozinha = cozinhaService.converterDTO(fotoDTO);
		cozinha.setId(id);
		cozinha = cozinhaService.atualizar(cozinha);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		cozinhaService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
