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
@Table(name = "tb_apartamentos")
public class Apartamento {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;	
    
    @Column(name = "NUMERO")
    private String numero;
    
    @Column(name = "ANDAR")
    private String andar;
    
    @Column(name = "QNDVAGAS")
    private int qndVagas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CPF")
    private Proprietario proprietario;
  
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "apartamento")
    //private List<Vaga> vagas;
    private Vaga vaga; 
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "apartamento")
    //private List<Veiculo> veiculos;
    private Veiculo veiculo;
    
    
    
    
}
