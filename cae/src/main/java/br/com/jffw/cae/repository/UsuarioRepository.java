package br.com.jffw.cae.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jffw.cae.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
