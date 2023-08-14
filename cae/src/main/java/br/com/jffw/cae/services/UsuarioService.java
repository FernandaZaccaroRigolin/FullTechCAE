package br.com.jffw.cae.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

	public  UsuarioDTO loginUsuario(Map<String, String> dados) {
		String email = dados.get("email");
		String senha = dados.get("senha");
		UsuarioDTO usuario = usuarioRepository.getUsuarioDTOByEmailSenha(email, senha);
		
		if (Optional.ofNullable(usuario).isEmpty()){
			throw new RuntimeException("Email ou Senha inválidos");
		}			
		
		return usuario;
	}
	
	
	public UsuarioDTO incluirUsuario(Map<String, String> dados) {
		String nome = dados.get("nome");
		String email = dados.get("email");
		String senha = dados.get("senha");
		String nivelAcesso = dados.get("nivelacesso");
		Date dtCadastro = new Date();
		
		Optional<Usuario> usu = usuarioRepository.findByEmail(email);
		
		if(!usu.isEmpty()) {
			throw new RuntimeException("Este usuário já existe");
		}
		
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
		
		if (Optional.ofNullable(usuario).isEmpty()){
			throw new RuntimeException("Usuário não localizado.");
		}
		
		if(!senha.equals(usuario.getSenha())) {
			throw new RuntimeException("Senha inválida.");
		}
			
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setNivelAcesso(nivelAcesso);
		
		usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDtCadastro(), usuario.getNivelAcesso());

	}
	
	public String alterarSenhaUsuario(Map<String, String> dados) {
		String email = dados.get("email");
		String senhaAtual = dados.get("senhaAtual");
		String senhaNova = dados.get("senhaNova");
		
		UsuarioDTO usu = usuarioRepository.getUsuarioDTOByEmailSenha(email, senhaAtual);
		
		if (!Optional.ofNullable(usu).isEmpty()){
			throw new RuntimeException("Email ou Senha inválidos");
		}	
		
		Usuario usuario = usuarioRepository.getReferenceById(usu.getId());

		usuario.setNome(usu.getNome());
		usuario.setEmail(usu.getEmail());
		usuario.setSenha(senhaNova);
		usuario.setNivelAcesso(usu.getNivelAcesso());
		
		usuarioRepository.save(usuario);
		
		return String.format("Senha alterada com sucesso");
	}		
	
	public String remover(String idUsuario) {
		try {
			usuarioRepository.deleteById(Integer.parseInt(idUsuario));
			return String.format("Usuario removido com sucesso");
		} catch (Exception e) {
			return e.toString();
		}
	}	
}
