package br.com.jffw.cae.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jffw.cae.dto.ApartamentoDTO;
import br.com.jffw.cae.dto.VagaDTO;
import br.com.jffw.cae.models.Apartamento;
import br.com.jffw.cae.models.Vaga;
import br.com.jffw.cae.repository.ApartamentoRepository;
import br.com.jffw.cae.repository.VagaRepository;

@Service
public class VagaService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired
	private ApartamentoRepository apartamentoRepository;
	
	public List<VagaDTO> listarVagasDTO() {
		List<VagaDTO> vagas = new ArrayList<VagaDTO>();
		vagaRepository.findAll().forEach(
				a -> vagas.add(new VagaDTO(a.getId(), a.getBloco(), a.getNumero(), a.getApartamento().getId())));

		return vagas;
	}
	
	public VagaDTO buscarVaga(String idVaga) {
		Vaga vaga = vagaRepository.findById(Integer.parseInt(idVaga)).orElse(null);
		
		if (Optional.ofNullable(vaga).isEmpty()){
			throw new RuntimeException("Vaga não localizada.");
		}
		
		return new VagaDTO(vaga.getId(), vaga.getBloco(), vaga.getNumero(), vaga.getApartamento().getId());
	}
	
	public VagaDTO incluirVaga(Map<String, String> dados) throws ParseException {
	    String bloco = dados.get("bloco");
	    String numero = dados.get("numero");

	    Vaga vaga = new Vaga();
	    vaga.setBloco(bloco);
	    vaga.setNumero(numero);
	    
	    Integer idApartamento;
	    try {
	    	Integer idAx = Integer.parseInt(dados.get("idAP"));
	    	idApartamento = idAx;
		} catch (Exception e) {
			throw new RuntimeException("Por favor, informe o apartamento.");
		}
	   
	    Apartamento ap = apartamentoRepository.getReferenceById(idApartamento);
		if (Optional.ofNullable(ap).isEmpty()){
			throw new RuntimeException("Por favor, informe o apartamento.");
		}
		
		boolean vagaExcedida = false;
		
		try {
			int qndVagas = ap.getQndVagas(); 
			List<Vaga> listVagas = vagaRepository.findByVaga(idApartamento); 
			int numVagas = listVagas.size(); 
			if(qndVagas <= numVagas) {
				vagaExcedida = true;	
				throw new RuntimeException();
			}
		} catch (Exception e) {
			if(vagaExcedida) {
				throw new RuntimeException("Quantidade de vagas foi excedida.");	
			} else {
				throw new RuntimeException("Apartamento não encontrado.");	
			}
		}
		
        Vaga numeroVaga = vagaRepository.findByNumero(numero);
        if (!Optional.ofNullable(numeroVaga).isEmpty()){	
			throw new RuntimeException("Este número de vaga já foi cadastrada.");
		}
        
	    if (idApartamento != null) {
	        Optional<Apartamento> optionalApartamento = apartamentoRepository.findById(idApartamento);
	        
	        if (!optionalApartamento.isPresent()) {
	            throw new IllegalArgumentException("O apartamento informado não existe.");
	        }
	    	        
	        Apartamento apartamento = optionalApartamento.get();
	        vaga.setApartamento(apartamento);
	    }

	    vagaRepository.save(vaga);
	    return new VagaDTO(vaga.getId(), vaga.getBloco(), vaga.getNumero(), vaga.getApartamento().getId());
	}
	
	public String alterarVaga(Map<String, String> dados, String idVaga) {
		String numero = dados.get("numero");
		String bloco = dados.get("bloco");
		
		Integer idApartamento = Integer.parseInt(dados.get("idAP"));
	    Apartamento ap = apartamentoRepository.getReferenceById(idApartamento);

		Vaga vaga = vagaRepository.getReferenceById(Integer.parseInt(idVaga));
		if (Optional.ofNullable(vaga).isEmpty()){
			return "Vaga não localizada.";
		}	
		
		int qndVagas = ap.getQndVagas(); 
		List<Vaga> listVagas = vagaRepository.findByVagaAlterar(idApartamento, vaga.getId()); 
		int numVagas = listVagas.size(); 
		if(qndVagas <= numVagas) {
			return "Quantidade de vagas foi excedida.";	
		}
		
		if(!numero.equals(vaga.getNumero())) {
			Vaga vg = vagaRepository.findByNumero(numero);
			
			if (!Optional.ofNullable(vg).isEmpty()){	
				return "Este número de vaga já foi cadastrada.";
			}		
		}
		
		vaga.setBloco(bloco);
	    vaga.setNumero(numero);
	    vaga.setApartamento(ap);

		vagaRepository.save(vaga);
		return "Alteração realizada com sucesso!";
	}
	
	public String remover(String id) {
		try {
			vagaRepository.deleteById(Integer.parseInt(id));
			return "Vaga removida com sucesso.";
		} catch (Exception e) {
			return "Não foi possivel remover a vaga informada.";
		}
	}
}