package br.com.jffw.cae.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jffw.cae.dto.ProprietarioDTO;
import br.com.jffw.cae.models.Proprietario;
import br.com.jffw.cae.services.ProprietarioService;

@RestController
@RequestMapping("/api/proprietarios")
public class ApiProprietarioController {

	@Autowired
	ProprietarioService proprietarioService;

	@GetMapping("/lista")
	public List<Proprietario> listarTodos() {
		return proprietarioService.listarProprietarios();
	}

	@GetMapping("/{cpf}")
	public Object listarProprietariosId(@PathVariable String cpf) {
		return proprietarioService.listarProprietariosId(cpf);
	}

	@GetMapping("/")
	public List<ProprietarioDTO> listarTodosDTO() {
		return proprietarioService.listarProprietariosDTO();
	}

	@GetMapping("/buscar/{cpf}")
	public ProprietarioDTO buscarProprietario(@PathVariable String cpf) {
		return proprietarioService.buscarProprietario(cpf);

	}

	@PostMapping("/incluir")
	public ResponseEntity<Object> incluirProprietario(@RequestBody Proprietario proprietario) {
		try {
			return new ResponseEntity<Object>(proprietarioService.incluirProprietario(proprietario),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
		}
	}

	@PutMapping("/{cpf}")
	public ResponseEntity<String> alterarProprietario(@RequestBody Proprietario proprietario,
			@PathVariable String cpf) {
		Proprietario proprietarioatual = proprietarioService.alterar(proprietario, cpf);
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Alteração realizada com sucesso");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
		}
	}

	@DeleteMapping("/{cpf}")
	public ResponseEntity<String> deleteProprietario(@PathVariable String cpf) {
		try {
			return new ResponseEntity<String>(proprietarioService.remover(cpf), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.toString());
		}
	}
}