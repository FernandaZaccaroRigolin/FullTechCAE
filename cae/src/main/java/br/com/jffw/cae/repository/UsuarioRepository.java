package br.com.jffw.cae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jffw.cae.dto.UsuarioDTO;
import br.com.jffw.cae.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("SELECT new br.com.jffw.cae.dto.UsuarioDTO("
			+ "u.id, u.nome, u.email, u.dtCadastro, u.nivelAcesso) FROM Usuario u "
			+ "WHERE u.email = ?1 AND u.senha = ?2")
	UsuarioDTO getUsuarioDTOByEmailSenha(String email, String senha);

	Optional<Usuario> findByEmail(String email);	
	
}


