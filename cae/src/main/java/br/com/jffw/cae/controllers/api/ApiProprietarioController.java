package br.com.jffw.cae.controllers.api;

import java.util.List;

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

import br.com.jffw.cae.dto.ProprietarioDTO;
import br.com.jffw.cae.dto.ProprietarioListDTO;
import br.com.jffw.cae.models.Proprietario;
import br.com.jffw.cae.services.ProprietarioService;

@RestController
@RequestMapping("/api/proprietarios")
public class ApiProprietarioController {

	@Autowired
	ProprietarioService proprietarioService;
	
	@CrossOrigin
	@GetMapping("/")
	public List<ProprietarioListDTO> listarTodosDTO() {
		return proprietarioService.listarProprietariosDTO();
	}
	
	@CrossOrigin
	@GetMapping("/{cpf}")
	public ResponseEntity<?> buscarProprietarioPorCpf(@PathVariable String cpf) {
		try {
			ProprietarioListDTO dto = proprietarioService.buscarProprietarioPorCpf(cpf);
			return ResponseEntity.ok(dto);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proprietário não encontrado");
		}
	}

	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<?> incluirProprietario(@RequestBody ProprietarioDTO dto) {
		try {
			ProprietarioListDTO proprietario = proprietarioService.incluirProprietario(dto);
			return ResponseEntity.ok(proprietario);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao incluir proprietário: " + e.getMessage());
		}
	}

	@CrossOrigin
	@PutMapping("/{cpf}")
	public ResponseEntity<?> alterarProprietario(@RequestBody ProprietarioDTO dto, @PathVariable String cpf) {
	    try {
	        ResponseEntity<?> response = proprietarioService.alterar(dto, cpf);
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Alteração realizada com sucesso");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Erro ao alterar proprietário: " + e.getMessage());
	    }
	}

	@CrossOrigin
	@DeleteMapping("/{cpf}")
	public ResponseEntity<String> deleteProprietario(@PathVariable String cpf) {
		try {
			return new ResponseEntity<String>(proprietarioService.remover(cpf), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Erro ao excluir proprietário: " + e.getMessage());
		}
	}
}