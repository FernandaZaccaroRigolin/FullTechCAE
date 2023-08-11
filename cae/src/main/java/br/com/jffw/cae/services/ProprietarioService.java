package br.com.jffw.cae.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jffw.cae.dto.ProprietarioDTO;
import br.com.jffw.cae.models.Proprietario;
import br.com.jffw.cae.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	public List<Proprietario> listarProprietarios() {
		return proprietarioRepository.findAll();
	}

	public List<ProprietarioDTO> listarProprietariosDTO() {
		List<ProprietarioDTO> proprietarios = new ArrayList<ProprietarioDTO>();
		
		proprietarioRepository.findAll().forEach(c->
		proprietarios.add(new ProprietarioDTO(c.getCpf(), c.getNome(), c.getTelefone(), c.getDtNascimento(), c.getEmail())));
		
		return proprietarios;
	}
}
