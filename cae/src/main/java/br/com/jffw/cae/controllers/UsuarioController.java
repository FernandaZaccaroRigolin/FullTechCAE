package br.com.jffw.cae.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.jffw.cae.dto.UsuarioDTO;
import br.com.jffw.cae.models.Usuario;
import br.com.jffw.cae.models.UsuarioLogado;
import br.com.jffw.cae.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/novo")
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
			Usuario usu = usuarioRepository.getReferenceById(usuario.getId());
			usuario.setDtCadastro(usu.getDtCadastro());
			usuario.setSenha(usu.getSenha());
			usuarioRepository.save(usuario);
			
			return "redirect:/usuarios/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
	
	@GetMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable("id") int id) {
		try {
			Usuario usuario = usuarioRepository.getReferenceById(id);
			return new ModelAndView("usuarios/removerUsuario", "usuario", usuario);
		} catch (Exception e) {
			return new ModelAndView("erro", "msg_erro", e.getMessage());
		}
	}

	@PostMapping("/remover")
	public String remover(@RequestParam("id") int id, Model model) {
		try {
			usuarioRepository.deleteById(id);
			return "redirect:/usuarios/lista";
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
		}
	}
	
	@PostMapping("/login")
	public String iniciar(UsuarioLogado usuLogado, Model model) {
		try {
			UsuarioDTO usuDto = usuarioRepository.getUsuarioDTOByEmailSenha(usuLogado.getEmail(), usuLogado.getSenha());
			if (Optional.ofNullable(usuDto).isEmpty()){
				throw new NullPointerException("Usuário não localizado");
			}
			
			if (!"ADMINISTRADOR".equals(usuDto.getNivelAcesso())){
				throw new NullPointerException("Apenas administradores podem conectar neste módulo!");
			}
			
			Usuario usuario = new Usuario();
			usuario.setId(usuDto.getId());
			usuario.setNome(usuDto.getNome());
			usuario.setEmail(usuDto.getEmail());
			usuario.setDtCadastro(usuDto.getDtCadastro());
			usuario.setNivelAcesso(usuDto.getNivelAcesso());
			
			UsuarioLogado usLogado = new UsuarioLogado();
			usLogado.setUsuarioLogado(usuario);
			usLogado.setLogged(true);
			model.addAttribute("usuLogado", usLogado);
			return "home";			
			
			
		} catch (Exception e) {
			model.addAttribute("msg_erro", e.toString());
			return "erro";
			
		}
	}	
	
}
