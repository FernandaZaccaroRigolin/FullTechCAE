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

import br.com.jffw.cae.dto.ApartamentoDTO;
import br.com.jffw.cae.services.ApartamentoService;

@RestController
@RequestMapping("/api/apartamentos")
public class ApiApartamentoController {
	@Autowired
	private ApartamentoService apartamentoService;

	@CrossOrigin
	@GetMapping("/")
	public List<ApartamentoDTO> listarApartamentosDTO() {
		return apartamentoService.listarApartamentosDTO();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarApartamento(@PathVariable String id) {
		try {
			return new ResponseEntity<Object>(apartamentoService.buscarApartamento(id), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}			
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> incluirApartamento(@RequestBody Map<String, String> dados) {
		try {
			return new ResponseEntity<Object>(apartamentoService.incluirApartamento(dados), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> alterarApartamento(@RequestBody Map<String, String> dados, @PathVariable String id) {
		
		try {
			return new ResponseEntity<String>(apartamentoService.alterarApartamento(dados, id), HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}			

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable String id) {
		try {
			return new ResponseEntity<String>(apartamentoService.removerApartamento(id), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}			
	}
}
