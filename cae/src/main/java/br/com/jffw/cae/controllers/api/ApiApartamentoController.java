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
	public List<ApartamentoDTO> listarTodosDTO() {
		return apartamentoService.listarApartamentosDTO();
	}

	@GetMapping("/{id}")
	public ApartamentoDTO buscarApartamento(@PathVariable String id) {
		return apartamentoService.buscarApartamento(id);
	}
	
	
	@PostMapping("/")
	public ApartamentoDTO incluirUsuario(@RequestBody Map<String, String> dados) {
		try {
			return apartamentoService.incluirApartamento(dados);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PutMapping("/{id}")
	public ApartamentoDTO alterarApartamento(@RequestBody Map<String, String> dados, @PathVariable String id) {
		return apartamentoService.alterar(dados, id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable String id) {
		return new ResponseEntity<String>(apartamentoService.remover(id), HttpStatus.ACCEPTED);

	}

}
