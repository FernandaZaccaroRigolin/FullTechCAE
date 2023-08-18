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
		if((email.isBlank()) || (senha.isBlank())) {
			throw new NullPointerException("O email e a senha devem ser informados.");
		}
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
		if((nome.isBlank()) || (email.isBlank()) ||(senha.isBlank())||(nivelAcesso.isBlank())  ) {
			throw new NullPointerException("O nome, email, senha e nivel de acesso devem ser informados.");
		}		
		
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
	
	public String alterarUsuario(Map<String, String> dados, String idUsuario) {
		String nome = dados.get("nome");
		String email = dados.get("email");
		String senha = dados.get("senha");
		String nivelAcesso = dados.get("nivelacesso");
		
		if((nome.isBlank()) || (email.isBlank()) ||(senha.isBlank())||(nivelAcesso.isBlank())  ) {
			throw new NullPointerException("O nome, email, senha e nivel de acesso devem ser informados.");
		}	
		
		Usuario usuario = usuarioRepository.findById(Integer.parseInt(idUsuario)).orElse(null);
		
		if (Optional.ofNullable(usuario).isEmpty()){
			throw new NullPointerException("Usuário não localizado.");
		}
		
		if(!senha.equals(usuario.getSenha())) {
			throw new RuntimeException("Senha inválida.");
		}
			
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setNivelAcesso(nivelAcesso);
		
		usuarioRepository.save(usuario);
		//return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDtCadastro(), usuario.getNivelAcesso());
		return "Alteração realizada com sucesso!";
	}
	
	public String alterarSenhaUsuario(Map<String, String> dados) {
		String email = dados.get("email");
		String senhaAtual = dados.get("senhaAtual");
		String senhaNova = dados.get("senhaNova");
		
		if((email.isBlank()) || (senhaAtual.isBlank()) ||(senhaNova.isBlank())){
			throw new NullPointerException("O email e senha devem ser informados.");
		}			
		
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
		return "Senha alterada com sucesso";
	}		
	
	public String removerUsuario(String idUsuario) {
		
		Usuario usuario = usuarioRepository.findById(Integer.parseInt(idUsuario)).orElse(null);
		if (Optional.ofNullable(usuario).isEmpty()){
			throw new NullPointerException("Usuário não localizado.");
		}		
		
		usuarioRepository.deleteById(Integer.parseInt(idUsuario));
		return "Usuário removido com sucesso";
	}	
}
