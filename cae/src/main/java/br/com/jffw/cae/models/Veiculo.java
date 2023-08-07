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
//    
//    //private blob foto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDVAGA")
    private Vaga vaga;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDAPARTAMENTO")
    private Apartamento apartamento;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
    
    
    
}
