package br.com.jffw.cae.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jffw.cae.dto.UsuarioDTO;
import br.com.jffw.cae.models.Usuario;
import br.com.jffw.cae.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDTO> listarUsuariosDTO() {
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		usuarioRepository.findAll().forEach(u -> 
			usuarios.add(new UsuarioDTO(u.getId(), u.getNome(), u.getEmail(), u.getDtCadastro(), u.getNivelAcesso())));
		
		return usuarios;
	}	

	public  List<UsuarioDTO> loginUsuario(Map<String, String> dados) {
		String email = dados.get("email");
		String senha = dados.get("senha");
		return usuarioRepository.getUsuarioDTOByEmail(email, senha);
	}
	
	
	public UsuarioDTO incluirUsuario(Map<String, String> dados) {
		
		String nome = dados.get("nome");
		String email = dados.get("email");
		String senha = dados.get("senha");
		String nivelAcesso = dados.get("nivelacesso");
		Date dtCadastro = new Date();
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setDtCadastro(dtCadastro);
		usuario.setNivelAcesso(nivelAcesso);
		
		usuarioRepository.save(usuario);
		
		return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDtCadastro(), usuario.getNivelAcesso());
	}	
	
	public UsuarioDTO alterar(Map<String, String> dados, String idUsuario) {
		String nome = dados.get("nome");
		String email = dados.get("email");
		String senha = dados.get("senha");
		String nivelAcesso = dados.get("nivelacesso");
		
		Usuario usuario = usuarioRepository.getReferenceById(Integer.parseInt(idUsuario));
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setNivelAcesso(nivelAcesso);
		
		usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDtCadastro(), usuario.getNivelAcesso());

	}	
	
	public String remover(String id) {
		try {
			usuarioRepository.deleteById(Integer.parseInt(id));
			return String.format("Usuario removido com sucesso");
		} catch (Exception e) {
			return e.toString();
		}
	}	
}
