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

	@PostMapping("/login")
	public UsuarioDTO buscarUsuario(@RequestBody Map<String, String> dados) {
		return usuarioService.loginUsuario(dados);
	}
	
	@PostMapping("/")
	public UsuarioDTO incluirUsuario(@RequestBody Map<String, String> dados) {
		try {
			return usuarioService.incluirUsuario(dados);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@PutMapping("/{id}")
	public UsuarioDTO alterarUsuario(@RequestBody Map<String, String> dados, @PathVariable String id) {
		return usuarioService.alterar(dados, id);
	}
	
	@PutMapping("/alterarSenha")
	public ResponseEntity<String> alterarSenhaUsuario(@RequestBody Map<String, String> dados) {
		return new ResponseEntity<String>(usuarioService.alterarSenhaUsuario(dados), HttpStatus.ACCEPTED);
	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable String id) {
		return new ResponseEntity<String>(usuarioService.remover(id), HttpStatus.ACCEPTED);

	}

}
