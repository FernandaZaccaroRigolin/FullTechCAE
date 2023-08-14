package br.com.jffw.cae.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jffw.cae.dto.ProprietarioDTO;
import br.com.jffw.cae.models.Proprietario;
import br.com.jffw.cae.repository.ApartamentoRepository;
import br.com.jffw.cae.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@Autowired
	private ApartamentoRepository apartamentoRepository;

	public List<Proprietario> listarProprietarios() {
		return proprietarioRepository.findAll();
	}
	
	public Optional<Proprietario> listarProprietariosId(String cpf){
		return proprietarioRepository.findById(cpf);
	}

	public List<ProprietarioDTO> listarProprietariosDTO() {
		List<ProprietarioDTO> proprietarios = new ArrayList<ProprietarioDTO>();

		proprietarioRepository.findAll().forEach(c -> proprietarios
				.add(new ProprietarioDTO(c.getCpf(), c.getNome(), c.getTelefone(), c.getDtNascimento(), c.getEmail())));

		return proprietarios;

	}

	public ProprietarioDTO buscarProprietario(String cpf) {
		Proprietario proprietario = proprietarioRepository.getReferenceById(cpf);
		return new ProprietarioDTO(
				proprietario.getCpf(),
				proprietario.getNome(),
				proprietario.getTelefone(),
				proprietario.getDtNascimento(),
				proprietario.getEmail());
	}

	public Proprietario incluirProprietario(Proprietario proprietario) {
		
		Optional<Proprietario> prop = proprietarioRepository.findById(proprietario.getCpf());
		if(!prop.isEmpty()) {
			throw new RuntimeException("Este proprietario já existe");
		}
		return proprietarioRepository.save(proprietario);
	}

	public Proprietario alterar(Proprietario proprietario, String cpf) {
		Proprietario propratual = proprietarioRepository.getReferenceById(cpf);
		if (propratual == null) {
			throw new EntityNotFoundException("o Proprietario a ser alterado não existe.");
		}
		propratual.setNome(proprietario.getNome());
		return proprietarioRepository.save(propratual);
	}

	public String remover(String cpf) {
		try {
		proprietarioRepository.deleteById(cpf);
		return String.format("Proprietario %s removido com sucesso!", cpf);
		}catch (Exception e) {
			return e.toString();
		}
	}
}