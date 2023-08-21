package br.com.jffw.cae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jffw.cae.models.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, String> {
	
    @Query("SELECT p FROM Proprietario p WHERE p.apartamento.id = ?1 AND p.cpf <> ?2")
    List<Proprietario> findByApartamentoAndNotCpf(int idApartamento, String cpf);
}
