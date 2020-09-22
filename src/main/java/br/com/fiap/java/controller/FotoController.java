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
import br.com.fiap.java.exception.ErroPadrao;
import br.com.fiap.java.exception.ErroPadraoBadRequest;
import br.com.fiap.java.model.Cozinha;
import br.com.fiap.java.model.Foto;
import br.com.fiap.java.service.FotoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

@RestController
@RequestMapping("/fotos")
public class FotoController {

	@Autowired
	private FotoService fotoService;

	@ApiOperation(value = "Listar todas as fotos cadastradas.")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Foto.class) })
	@GetMapping()
	public ResponseEntity<List<Foto>> listar() {
		List<Foto> fotos = fotoService.findAll();
		return ResponseEntity.ok().body(fotos);

	}

	@ApiOperation(value = "Busca uma foto cadastrada.")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Foto.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErroPadrao.class) })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Foto> buscar(@PathVariable(value = "id") Integer id) {
		Foto foto = fotoService.find(id);
		return ResponseEntity.ok(foto);

	}

	@ApiOperation(value = "Cadastra uma nova foto.")
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created") })
	@PostMapping
	public ResponseEntity<Void> cadastrar(@Validated @RequestBody FotoDTO fotoDTO) {
		Foto foto = fotoService.converterDTO(fotoDTO);
		foto = fotoService.cadastrar(foto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(foto.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "Atualiza uma foto cadastrada.")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, value = HttpStatus.NO_CONTENT)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 404, message = "Not Found", response = ErroPadrao.class) })
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@Validated @RequestBody FotoDTO fotoDTO, @PathVariable Integer id) {
		Foto foto = fotoService.converterDTO(fotoDTO);
		foto.setId(id);
		foto = fotoService.atualizar(foto);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Deleta uma foto cadastrada.")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, value = HttpStatus.NO_CONTENT)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErroPadraoBadRequest.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErroPadrao.class) })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		fotoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
