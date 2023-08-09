package br.com.jffw.cae.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jffw.cae.models.Usuario;
import br.com.jffw.cae.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
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

	@GetMapping("/alterar/{doc}")
	public ModelAndView alterar(@PathVariable("doc") Integer id) {
		try {
			Usuario usuario = usuarioRepository.getReferenceById(id);
			return new ModelAndView("usuarios/alterarUsuario", "usuario", usuario);
			
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString());
		}
	}
	
	@PostMapping("/alterar")
	public String alterar(Usuario usuario, Model model) {
		try {
			usuarioRepository.save(usuario);
			return "redirect:/usuario/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
}
