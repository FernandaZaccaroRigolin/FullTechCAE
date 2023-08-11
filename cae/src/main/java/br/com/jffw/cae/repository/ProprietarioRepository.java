package br.com.jffw.cae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jffw.cae.dto.ProprietarioApartamentosDTO;
import br.com.jffw.cae.models.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, String> {
	
	@Query("SELECT new br.com.jffw.cae.dto.ProprietarioApartamentosDTO("
			+ " a.id, p.cpf, p.nome, a.numeroApartamento, a.blocoApartamento) "
			+ " FROM Proprietario p INNER JOIN p.apartamentos a")
	List<ProprietarioApartamentosDTO> getProprietarioApartamentosDTO();

}

