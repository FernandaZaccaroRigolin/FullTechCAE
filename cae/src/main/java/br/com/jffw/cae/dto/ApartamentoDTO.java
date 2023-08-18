package br.com.jffw.cae.dto;

public class ApartamentoDTO {
	private int id;
	private String numero;
	private String bloco;	
	private int qndvagas;
	
	public ApartamentoDTO(int id, String numero, String bloco, int qndvagas) {
		this.setId(id);
		this.setNumero(numero);
		this.setBloco(bloco);
		this.setQndvagas(qndvagas);
	}
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
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public int getQndvagas() {
		return qndvagas;
	}
	public void setQndvagas(int qndvagas) {
		this.qndvagas = qndvagas;
	}
}
