package br.com.fiap.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.fiap.java.dto.CozinhaDTO;
import br.com.fiap.java.exception.DataIntegrityException;
import br.com.fiap.java.exception.ObjectNotFoundException;
import br.com.fiap.java.model.Cozinha;
import br.com.fiap.java.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public List<Cozinha> findAll() {
		return cozinhaRepository.findAll();
	}

	public Cozinha find(Integer id) {
		Optional<Cozinha> cozinha = cozinhaRepository.findById(id);
		return cozinha.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cozinha.class.getName()));

	}

	public Cozinha cadastrar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	public Cozinha converterDTO(CozinhaDTO cozinhaDTO) {
		return new Cozinha(null, cozinhaDTO.getNome());
	}

	public Cozinha atualizar(Cozinha cozinha) {
		Cozinha cozinhaAtualizada = this.find(cozinha.getId());
		atualizarDados(cozinhaAtualizada, cozinha);
		return cozinhaRepository.save(cozinhaAtualizada);
	}

	private void atualizarDados(Cozinha cozinhaNova, Cozinha cozinha) {
		cozinhaNova.setNome(cozinha.getNome());
	}

	public Object deletar(Integer id) {
		find(id);
		try {
			cozinhaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma cozinha que possui fotos");
		}
		return null;
	}

}
