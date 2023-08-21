package br.com.jffw.cae.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.jffw.cae.dto.ProprietarioDTO;
import br.com.jffw.cae.dto.ProprietarioListDTO;
import br.com.jffw.cae.models.Apartamento;
import br.com.jffw.cae.models.Proprietario;
import br.com.jffw.cae.repository.ApartamentoRepository;
import br.com.jffw.cae.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@Autowired
	private ApartamentoRepository apartamentoRepository;

	public ProprietarioListDTO buscarProprietarioPorCpf(String cpf) {
		Proprietario proprietario = proprietarioRepository.findById(cpf)
				.orElseThrow(() -> new IllegalArgumentException("Proprietário não encontrado"));

		ProprietarioListDTO dto = new ProprietarioListDTO();
		dto.setCpf(proprietario.getCpf());
		dto.setNome(proprietario.getNome());
		dto.setTelefone(proprietario.getTelefone());
		dto.setDtNascimento(proprietario.getDtNascimento());
		dto.setEmail(proprietario.getEmail());

		Apartamento apartamento = proprietario.getApartamento();
		if (apartamento != null) {
			dto.setApartamento(apartamento.getId());
			dto.setNumeroApartamento(apartamento.getNumero());
			dto.setBlocoApartamento(apartamento.getBloco());
			dto.setQndVagasApartamento(apartamento.getQndVagas());
		}

		dto.setDtNascimentoFormatted(dto.getDtNascimentoFormatted());

		return dto;
	}

	public List<ProprietarioListDTO> listarProprietariosDTO() {
		List<Proprietario> proprietarios = proprietarioRepository.findAll();
		List<ProprietarioListDTO> dtos = new ArrayList<>();

		for (Proprietario proprietario : proprietarios) {
			ProprietarioListDTO dto = new ProprietarioListDTO();
			dto.setCpf(proprietario.getCpf());
			dto.setNome(proprietario.getNome());
			dto.setTelefone(proprietario.getTelefone());
			dto.setDtNascimento(proprietario.getDtNascimento());
			dto.setEmail(proprietario.getEmail());

			Apartamento apartamento = proprietario.getApartamento();
			if (apartamento != null) {
				dto.setApartamento(apartamento.getId());
				dto.setNumeroApartamento(apartamento.getNumero());
				dto.setBlocoApartamento(apartamento.getBloco());
				dto.setQndVagasApartamento(apartamento.getQndVagas());
			}

			dto.setDtNascimentoFormatted(dto.getDtNascimentoFormatted());

			dtos.add(dto);
		}

		return dtos;
	}

	public ProprietarioListDTO incluirProprietario(ProprietarioDTO dto) throws ParseException {
	    String cpf = dto.getCpf();
	    Proprietario existingProprietario = proprietarioRepository.findById(cpf).orElse(null);
	    if (existingProprietario != null) {
	        throw new IllegalArgumentException("O proprietário já está cadastrado.");
	    }

	    Proprietario proprietario = new Proprietario();
	    proprietario.setCpf(cpf);
	    proprietario.setNome(dto.getNome());
	    proprietario.setTelefone(dto.getTelefone());
	    proprietario.setDtNascimento(dto.getDtNascimento());
	    proprietario.setEmail(dto.getEmail());

	    Integer idApartamento = dto.getApartamento();
	    if (idApartamento != null) {
	        Apartamento apartamento = apartamentoRepository.findById(idApartamento).orElse(null);
	        if (apartamento == null) {
	            throw new IllegalArgumentException("O ID do apartamento é obrigatório.");
	        }

	        List<Proprietario> proprietariosDoApartamento = apartamento.getProprietarios();
	        if (!proprietariosDoApartamento.isEmpty()) {
	            throw new IllegalArgumentException("O apartamento já está vinculado a outro proprietário.");
	        }

	        proprietario.setApartamento(apartamento);
	    } else {
	        throw new IllegalArgumentException("O ID do apartamento é obrigatório.");
	    }

	    proprietarioRepository.save(proprietario);
	    return new ProprietarioListDTO(
	    			proprietario.getCpf(),
	    			proprietario.getNome(),
	    			proprietario.getTelefone(),
	    			proprietario.getEmail(),
	    			proprietario.getApartamento().getId(),
	    			proprietario.getDtNascimento(),
	    			proprietario.getApartamento().getNumero(),
	    			proprietario.getApartamento().getBloco(),
	    			proprietario.getApartamento().getQndVagas()
	    		);
	}


	public ResponseEntity<?> alterar(ProprietarioDTO dto, String cpf) {
        Proprietario propratual = proprietarioRepository.findById(cpf)
                .orElseThrow(() -> new EntityNotFoundException("O Proprietário a ser alterado não existe."));

 

        propratual.setNome(dto.getNome());
        propratual.setTelefone(dto.getTelefone());
        propratual.setDtNascimento(dto.getDtNascimento());
        propratual.setEmail(dto.getEmail());

 

        Integer idApartamento = dto.getApartamento();
        if (idApartamento != null) {
            Apartamento apartamento = apartamentoRepository.findById(idApartamento)
                    .orElseThrow(() -> new IllegalArgumentException("O ID do apartamento não existe."));

 

            List<Proprietario> proprietariosVinculados = proprietarioRepository
                    .findByApartamentoAndNotCpf(idApartamento, cpf);
            if (!proprietariosVinculados.isEmpty()) {
                throw new IllegalArgumentException("O apartamento já está vinculado a outro proprietário.");
            }

 

            propratual.setApartamento(apartamento);
            proprietarioRepository.save(propratual);

 

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Alteração realizada com sucesso");
        }

 

        throw new IllegalArgumentException("O ID do apartamento é obrigatório para a alteração.");
    }

	public String remover(String cpf) {
		try {
			proprietarioRepository.deleteById(cpf);
			return String.format("Proprietario %s removido com sucesso!", cpf);
		} catch (Exception e) {
			throw new RuntimeException("Proprietario informado não existe.");
		}
	}
//	try {
//        vagaRepository.deleteById(Integer.parseInt(id));
//        return "Vaga deletada com sucesso.";
//    } catch (Exception e) {
//        throw new RuntimeException("Não possivel deletar a vaga informada.");
//    }
}