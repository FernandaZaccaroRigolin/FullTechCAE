package br.com.jffw.cae.controllers.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jffw.cae.dto.VagaDTO;
import br.com.jffw.cae.services.VagaService;

@RestController @RequestMapping("/api/vagas")
public class ApiVagaController {
	
	@Autowired
	private VagaService vagaService;
	
	@CrossOrigin 
	@GetMapping("/")
	public List<VagaDTO> listarVagasDTO() {
		return vagaService.listarVagasDTO();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarVagaPorId(@PathVariable String id) {
		try {
			VagaDTO dto = vagaService.buscarVaga(id);
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<?> incluirVaga(@RequestBody Map<String, String> dados) {
	    try {
	        VagaDTO vaga = vagaService.incluirVaga(dados);
	        return ResponseEntity.ok(vaga);
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(e.getMessage()); // Resposta 400 Bad Request
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); // Resposta 500 Internal Server Error
	    }
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<String> alterarVaga(@RequestBody Map<String, String> dados, @PathVariable String id) {
		try {
			return new ResponseEntity<String>(vagaService.alterarVaga(dados, id), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}	
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerVaga(@PathVariable String id){
		try {
			return new ResponseEntity<String>(vagaService.remover(id), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}
}
