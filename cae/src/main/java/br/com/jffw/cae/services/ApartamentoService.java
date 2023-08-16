package br.com.jffw.cae.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jffw.cae.dto.ApartamentoDTO;
import br.com.jffw.cae.models.Apartamento;
import br.com.jffw.cae.repository.ApartamentoRepository;

@Service
public class ApartamentoService {
	@Autowired
	private ApartamentoRepository apartamentoRepository;

	public List<ApartamentoDTO> listarApartamentosDTO() {
		List<ApartamentoDTO> apartamentos = new ArrayList<ApartamentoDTO>();
		apartamentoRepository.findAll().forEach(
				a -> apartamentos.add(new ApartamentoDTO(a.getId(), a.getNumero(), a.getBloco(), a.getQndVagas())));

		return apartamentos;
	}
	
	public ApartamentoDTO buscarApartamento(String id) {
		Apartamento apartamento = apartamentoRepository.getReferenceById(Integer.parseInt(id));
		if (Optional.ofNullable(apartamento).isEmpty()){
			throw new RuntimeException("Apartamento não localizado");
		}
		return new ApartamentoDTO(
				apartamento.getId(), 
				apartamento.getNumero(), 
				apartamento.getBloco(),
				apartamento.getQndVagas());
	}	

	public ApartamentoDTO incluirApartamento(Map<String, String> dados) {
		String numero = dados.get("numero");
		String bloco = dados.get("bloco");
		int qndVagas = Integer.parseInt(dados.get("qndvagas"));

		
		Apartamento ap = apartamentoRepository.findByNumero(numero);
		
		if (!Optional.ofNullable(ap).isEmpty()){	
			throw new RuntimeException("Este apartamento já existe");
		}		
		
		Apartamento apartamento = new Apartamento();
		apartamento.setNumero(numero);
		apartamento.setBloco(bloco);
		apartamento.setQndVagas(qndVagas);

		apartamentoRepository.save(apartamento);

		return new ApartamentoDTO(apartamento.getId(), apartamento.getNumero(), apartamento.getBloco(), apartamento.getQndVagas());
	}

	public String alterarApartamento(Map<String, String> dados, String idApartamento) {
		String numero = dados.get("numero");
		String bloco = dados.get("bloco");
		int qndVagas = Integer.parseInt(dados.get("qndvagas"));

		Apartamento apartamento = apartamentoRepository.getReferenceById(Integer.parseInt(idApartamento));
		if (Optional.ofNullable(apartamento).isEmpty()){
			throw new RuntimeException("Apartamento não localizado");
		}		
		
		if(!numero.equals(apartamento.getNumero())) {
			Apartamento ap = apartamentoRepository.findByNumero(numero);
			
			if (!Optional.ofNullable(ap).isEmpty()){	
				throw new RuntimeException("Este número de apartamento já foi cadastrado.");
			}		
		}
		
		apartamento.setNumero(numero);
		apartamento.setBloco(bloco);
		apartamento.setQndVagas(qndVagas);

		apartamentoRepository.save(apartamento);
		return "Alteração realizada com sucesso!";
		//return new ApartamentoDTO(apartamento.getId(), apartamento.getNumero(), apartamento.getBloco(), apartamento.getQndVagas());

	}

	public String removerApartamento(String idApartamento) {
		apartamentoRepository.deleteById(Integer.parseInt(idApartamento));
		return"Apartamento removido com sucesso";
	}
}
