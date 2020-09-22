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

import br.com.fiap.java.dto.CozinhaDTO;
import br.com.fiap.java.exception.ErroPadrao;
import br.com.fiap.java.exception.ErroPadraoBadRequest;
import br.com.fiap.java.model.Cozinha;
import br.com.fiap.java.service.CozinhaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaService cozinhaService;

	@ApiOperation(value = "Listar todas as cozinhas cadastradas.")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Cozinha.class) })
	@GetMapping()
	public ResponseEntity<List<Cozinha>> listar() {
		List<Cozinha> cozinhas = cozinhaService.findAll();
		return ResponseEntity.ok().body(cozinhas);

	}

	@ApiOperation(value = "Busca uma cozinha cadastrada.")
	@ResponseStatus(code = HttpStatus.OK, value = HttpStatus.OK)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Cozinha.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErroPadrao.class) })
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable(value = "id") Integer id) {
		Cozinha cozinha = cozinhaService.find(id);
		return ResponseEntity.ok(cozinha);

	}

	@ApiOperation(value = "Cadastra uma nova cozinha.")
	@ResponseStatus(code = HttpStatus.CREATED, value = HttpStatus.CREATED)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created") })
	@PostMapping
	public ResponseEntity<Void> cadastrar(@Validated @RequestBody CozinhaDTO cozinhaDTO) {
		Cozinha cozinha = cozinhaService.converterDTO(cozinhaDTO);
		cozinha = cozinhaService.cadastrar(cozinha);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cozinha.getId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "Atualiza uma cozinha cadastrada.")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, value = HttpStatus.NO_CONTENT)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 404, message = "Not Found", response = ErroPadrao.class) })
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizar(@Validated @RequestBody CozinhaDTO cozinha, @PathVariable Integer id) {
		Cozinha cozinhaObjeto = cozinhaService.converterDTO(cozinha);
		cozinhaObjeto.setId(id);
		cozinhaObjeto = cozinhaService.atualizar(cozinhaObjeto);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza uma cozinha cadastrada.")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, value = HttpStatus.NO_CONTENT)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErroPadraoBadRequest.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErroPadrao.class) })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		cozinhaService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
