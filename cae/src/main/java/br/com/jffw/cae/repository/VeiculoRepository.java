package br.com.jffw.cae.repository;

 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jffw.cae.dto.VagaVeiculosDTO;
import br.com.jffw.cae.models.Veiculo;
 

public interface VeiculoRepository  extends JpaRepository<Veiculo, String> {
    @Query("SELECT new br.com.jffw.cae.dto.VagaVeiculosDTO("
            + "vc.placa, vc.cor, vc.modelo, v.id, v.bloco, v.numero) FROM Vaga v INNER JOIN v.veiculos vc")
    List<VagaVeiculosDTO> getVagaVeiculoDTO();

    @Query("SELECT new br.com.jffw.cae.dto.VagaVeiculosDTO("
            + "vc.placa, vc.cor, vc.modelo, v.id, v.bloco, v.numero) FROM Vaga v "
            + "INNER JOIN v.veiculos vc WHERE v.id = ?1")
    List<VagaVeiculosDTO> getVagaVeiculoDTOById(String placa);

     @Query("SELECT vc FROM Veiculo vc WHERE vc.vaga.id = ?1 AND vc.placa <> ?2")
        List<Veiculo> findByVagaAndNotPlaca(int idVaga, String placa);

     Veiculo findByPlacaAndCorAndModelo(String placa, String cor, String modelo);

 

}