package br.com.jffw.cae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jffw.cae.dto.ApartamentoProprietarioListDTO;
import br.com.jffw.cae.models.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Integer>  {

	Apartamento findByNumeroAndBloco(String numero, String Bloco);
	
	@Query("SELECT new br.com.jffw.cae.dto.ApartamentoProprietarioListDTO(" +
			   "a.id as idApartamento, a.numero as nroApartamento, a.bloco as blocoApartamento, a.qndVagas, p.cpf as cpfProprietario," +
			   "p.nome as nomeProprietario, p.telefone as telProprietario, p.email as emailProprietario) " +
			   "FROM Apartamento a LEFT JOIN a.proprietarios p ON " +
			   "p.apartamento.id = a.id")	
	List<ApartamentoProprietarioListDTO> findApartamentoProprietario();
	
//    @Query("SELECT new br.com.jffw.cae.dto.VagaVeiculosDTO("
//            + "vc.placa, vc.cor, vc.modelo, v.id, v.bloco, v.numero) FROM Vaga v "
//            + "INNER JOIN v.veiculos vc WHERE v.id = ?1")
//    List<VagaVeiculosDTO> getVagaVeiculoDTOById(String placa);	

}
