package br.com.jffw.cae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.jffw.cae.dto.ApartamentoProprietariosDTO;

import br.com.jffw.cae.models.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, String> {
	
	@Query("SELECT new br.com.jffw.cae.dto.ApartamentoProprietariosDTO("
			+ " p.cpf, a.id, a.numero, a.bloco, a.qndVagas) "
			+ " FROM Apartamento a INNER JOIN a.proprietarios p")
	List<ApartamentoProprietariosDTO> getApartamentoProprietariosDTO();
	
	@Query("SELECT new br.com.jffw.cae.dto.ApartamentoProprietariosDTO("
			+ " p.cpf, a.id, a.numero, a.bloco, a.qndVagas) "
			+ " FROM Apartamento a INNER JOIN a.proprietarios p WHERE p.cpf = ?1")
	List<ApartamentoProprietariosDTO> getApartamentoProprietariosDTOByCpf(String cpf);


	

}

