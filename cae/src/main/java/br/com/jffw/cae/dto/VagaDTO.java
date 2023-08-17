package br.com.jffw.cae.dto;

public class VagaDTO {

	private int id;
	private String bloco;
	private String numero;
	private Integer apartamento;
	
	public VagaDTO() { }
	
	public VagaDTO(int id, String bloco, String numero, Integer apartamento) {
		this.setId(id);
		this.setBloco(bloco);
		this.setNumero(numero);
		this.setApartamento(apartamento);
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
