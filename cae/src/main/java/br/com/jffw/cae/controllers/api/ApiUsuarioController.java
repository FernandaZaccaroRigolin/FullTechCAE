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

import br.com.jffw.cae.dto.UsuarioDTO;
import br.com.jffw.cae.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class ApiUsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin
	@GetMapping("/")
	public List<UsuarioDTO> listarTodosDTO() {
		return usuarioService.listarUsuariosDTO();
	}

	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Object> buscarUsuario(@RequestBody Map<String, String> dados) {
		try {
			return new ResponseEntity<Object>(usuarioService.loginUsuario(dados), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}		
	}
	
	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<Object> incluirUsuario(@RequestBody Map<String, String> dados) {
		try {
			return new ResponseEntity<Object>(usuarioService.incluirUsuario(dados), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<String> alterarUsuario(@RequestBody Map<String, String> dados, @PathVariable String id) {
		try {
			return new ResponseEntity<String>(usuarioService.alterarUsuario(dados, id), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}		
	
	@CrossOrigin
	@PutMapping("/alterarSenha")
	public ResponseEntity<String> alterarSenhaUsuario(@RequestBody Map<String, String> dados) {
		try {
			return new ResponseEntity<String>(usuarioService.alterarSenhaUsuario(dados), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}		
	}	
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable String id) {
		try {
			return new ResponseEntity<String>(usuarioService.removerUsuario(id), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}			
	}
}
