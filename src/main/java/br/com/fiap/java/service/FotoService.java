package br.com.fiap.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.fiap.java.dto.FotoDTO;
import br.com.fiap.java.exception.DataIntegrityException;
import br.com.fiap.java.exception.ObjectNotFoundException;
import br.com.fiap.java.model.Foto;
import br.com.fiap.java.repository.FotoRepository;

@Service
public class FotoService {

	@Autowired
	private FotoRepository fotoRepository;

	public List<Foto> findAll() {
		return fotoRepository.findAll();
	}

	public Foto find(Integer id) {
		Optional<Foto> foto = fotoRepository.findById(id);
		return foto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Foto.class.getName()));

	}

	public Foto cadastrar(Foto foto) {
		return fotoRepository.save(foto);
	}


	public Foto atualizar(Foto foto) {
		Foto fotoAtualizada = this.find(foto.getId());
		atualizarDados(fotoAtualizada, foto);
		return fotoRepository.save(fotoAtualizada);
	}

	private void atualizarDados(Foto fotoNova, Foto foto) {
		fotoNova.setBaseFoto(foto.getBaseFoto());
	}

	public Object deletar(Integer id) {
		find(id);
		try {
			fotoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma foto que possui fotos");
		}
		return null;
	}

	public Foto converterDTO(FotoDTO fotoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
