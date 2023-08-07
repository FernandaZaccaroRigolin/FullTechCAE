package br.com.jffw.cae.models;

import java.util.List;

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
    private List<Vaga> vagas;
//    //private Vaga vaga; 
//    
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "apartamento")
//    private List<Veiculo> veiculos;
//    //private Veiculo veiculo;
//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public int getQndVagas() {
		return qndVagas;
	}

	public void setQndVagas(int qndVagas) {
		this.qndVagas = qndVagas;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

//	public List<Vaga> getVagas() {
//		return vagas;
//	}
//
//	public void setVagas(List<Vaga> vagas) {
//		this.vagas = vagas;
//	}

//	public List<Veiculo> getVeiculos() {
//		return veiculos;
//	}
//
//	public void setVeiculos(List<Veiculo> veiculos) {
//		this.veiculos = veiculos;
//	}
}
