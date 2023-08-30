package br.com.jffw.cae.dto;

public class VagaDTO {

	private int id;
	private String bloco;
	private String numero;
	private Integer apartamento;
	private String numeroApt;
	
	public VagaDTO() { }
	
	public VagaDTO(int id, String bloco, String numero, Integer apartamento, String numeroApt) {
		this.setId(id);
		this.setBloco(bloco);
		this.setNumero(numero);
		this.setApartamento(apartamento);
		this.setNumeroApt(numeroApt);
	}
	
	public String getNumeroApt() {
		return numeroApt;
	}

	public void setNumeroApt(String numeroApt) {
		this.numeroApt = numeroApt;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBloco() {
		return bloco;
	}
	
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Integer getApartamento() {
		return apartamento;
	}
	
	public void setApartamento(Integer apartamento) {
		this.apartamento = apartamento;
	}
}
