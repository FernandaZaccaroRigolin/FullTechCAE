package br.com.jffw.cae.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jffw.cae.dto.ProprietarioDTO;
import br.com.jffw.cae.services.ProprietarioService;

@RestController
@RequestMapping("/api/proprietarios")
public class ApiProprietarioController {

	@Autowired
	private ProprietarioService proprietarioService;

	@GetMapping("/")
	public List<ProprietarioDTO> listarTodosDTO() {
		return proprietarioService.listarProprietariosDTO();
	}
}