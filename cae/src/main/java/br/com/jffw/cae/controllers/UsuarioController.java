package br.com.jffw.cae.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.jffw.cae.models.Usuario;
import br.com.jffw.cae.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios/novo")
	public ModelAndView incluir() {
		try {
			return new ModelAndView("usuarios/novoUsuario");
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString()); 
		}
	}
	
	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable("id") int id) {
		try {
			Usuario usuario = usuarioRepository.getReferenceById(id);
			return new ModelAndView("clientes/removerUsuario", "usuario", usuario);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.getMessage());
		}
	}
	
	@PostMapping("/remover")
	public String remover(@RequestParam("id") int id, Model model) {
		try {
			usuarioRepository.deleteById(id);
			return "redirect:/clientes/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
}
