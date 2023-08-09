package br.com.jffw.cae.controllers;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> cbf5f8ca6f5f10e360f318fd6bdf0629eeeaef58
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> cbf5f8ca6f5f10e360f318fd6bdf0629eeeaef58
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
	
<<<<<<< HEAD
	@GetMapping("/usuarios/novo")
=======
	@GetMapping("/novo")
>>>>>>> cbf5f8ca6f5f10e360f318fd6bdf0629eeeaef58
	public ModelAndView incluir() {
		try {
			return new ModelAndView("usuarios/novoUsuario");
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.toString()); 
		}
	}
	
	@PostMapping("/novo")
	public String incluir(Usuario usuario, Model model) {
		try {
			usuarioRepository.save(usuario);
			
			//System.out.println(usuario);
			return "redirect:/usuarios/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}	
	
	@GetMapping("/lista")
	public ModelAndView listar() {
		try {
			List<Usuario> usuarios = usuarioRepository.findAll();
			return new ModelAndView("usuarios/listaUsuarios", "listagem_usuarios", usuarios);
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
