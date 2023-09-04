package br.com.jffw.cae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jffw.cae.dto.ApartamentoProprietarioListDTO;
import br.com.jffw.cae.dto.VagaVeiculoListDTO;
import br.com.jffw.cae.models.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {
	@Query("SELECT new br.com.jffw.cae.models.Vaga (" + "v.bloco, v.numero) " + "FROM Apartamento ap, Vaga v WHERE "
			+ "v.apartamento.id = ap.id AND ap.id = ?1")
	List<Vaga> findByVaga(int idApartamento);

	@Query("SELECT new br.com.jffw.cae.models.Vaga (" + "v.bloco, v.numero) " + "FROM Apartamento ap, Vaga v WHERE "
			+ "v.apartamento.id = ap.id AND ap.id = ?1 AND v.id <> ?2")
	List<Vaga> findByVagaAlterar(int idApartamento, int idVaga);

	Vaga findByNumero(String numero);
	
	@Query("SELECT new br.com.jffw.cae.dto.VagaVeiculoListDTO(" +
			   "g.id as idVaga, g.numero as nroVaga, g.bloco as blocoVaga, v.placa as placaVeiculo, v.cor as corVeiculo, v.modelo as modeloVeiculo) " +
			   "FROM Vaga g LEFT JOIN g.veiculos v ON " +
			   "v.vaga.id = g.id")	
	List<VagaVeiculoListDTO> findVagaVeiculo();	
	
	@Query("SELECT new br.com.jffw.cae.dto.VagaVeiculoListDTO(" +
			   "g.id as idVaga, g.numero as nroVaga, g.bloco as blocoVaga, v.placa as placaVeiculo, v.cor as corVeiculo, v.modelo as modeloVeiculo) " +
			   "FROM Vaga g LEFT JOIN g.veiculos v ON " +
			   "v.vaga.id = g.id WHERE g.apartamento.id=?1")	
	List<VagaVeiculoListDTO> findVagaVeiculoByApt(Integer apt);		

}

//"FROM Apartamento a LEFT JOIN a.proprietarios p ON " +
//"p.apartamento.id = a.id")	

//
//select g.id as idVaga 
//   , g.numero as numeroVaga 
//   , g.bloco as blocoVaga 
//   , v.placa as placaVeiculo
//   , v.cor as corVeiculo
//   , v.modelo as modeloVeiculo
//from tb_vagas g
//left join tb_veiculos v
//on g.id = v.IDVAGA  
