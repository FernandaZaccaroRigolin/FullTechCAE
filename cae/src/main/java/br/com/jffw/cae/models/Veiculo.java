package br.com.jffw.cae.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculos")
public class Veiculo {

    @Id
    @Column(name = "PLACA")
    private String placa;	
    
    @Column(name = "COR")
    private String cor;
    
    @Column(name = "MODELO")
    private String modelo;
    
    //private blob foto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    private Vaga vaga;
    
}
