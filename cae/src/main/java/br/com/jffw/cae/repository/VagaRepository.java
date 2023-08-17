package br.com.jffw.cae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jffw.cae.models.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {
		@Query("SELECT new br.com.jffw.cae.models.Vaga (" +
			   "v.bloco, v.numero) " +
			   "FROM Apartamento ap, Vaga v WHERE " +
			   "v.apartamento.id = ap.id AND ap.id = ?1")
		List<Vaga> findByVaga(int idApartamento);
		
		@Query("SELECT new br.com.jffw.cae.models.Vaga (" +
				   "v.bloco, v.numero) " +
				   "FROM Apartamento ap, Vaga v WHERE " +
				   "v.apartamento.id = ap.id AND ap.id = ?1 AND v.id <> ?2")
			List<Vaga> findByVagaAlterar(int idApartamento, int idVaga);
	
	Vaga findByNumero(String numero);
}
