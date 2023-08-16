package br.com.jffw.cae.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jffw.cae.models.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, String> {
	
}

