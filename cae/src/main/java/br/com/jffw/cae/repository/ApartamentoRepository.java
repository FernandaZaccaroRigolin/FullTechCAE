package br.com.jffw.cae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jffw.cae.models.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Integer>  {

	Apartamento findByNumeroAndBloco(String numero, String Bloco);

}
