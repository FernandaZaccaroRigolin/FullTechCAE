package br.com.jffw.cae.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jffw.cae.models.Veiculo;

public interface VeiculoRepository  extends JpaRepository<Veiculo, String> {

}
