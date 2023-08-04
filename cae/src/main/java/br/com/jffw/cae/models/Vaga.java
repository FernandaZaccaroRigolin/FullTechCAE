package br.com.jffw.cae.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vagas")
public class Vaga {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;	
	
    @Column(name = "BLOCO")
	private String bloco;
	
    @Column(name = "NUMERO")
	private String numero;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    private Apartamento apartamento;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vaga")
    //private List<Veiculo> veiculos;
    Veiculo veiculo;
	
}
