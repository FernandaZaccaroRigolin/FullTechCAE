package br.com.jffw.cae.dto;

public class VagaVeiculoListDTO {
	private int idVaga;
	private String nroVaga;
	private String blocoVaga;
	private String placaVeiculo;
	private String corVeiculo;
	private String modeloVeiculo;
	
	
	
	public VagaVeiculoListDTO(int idVaga, String nroVaga, String blocoVaga, String placaVeiculo, String corVeiculo, String modeloVeiculo) {
		this.setIdVaga(idVaga);
		this.setNroVaga(nroVaga);
		this.setBlocoVaga(blocoVaga);
		this.setPlacaVeiculo(placaVeiculo);
		this.setCorVeiculo(corVeiculo);
		this.setModeloVeiculo(modeloVeiculo);
	}
	public int getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	public String getNroVaga() {
		return nroVaga;
	}
	public void setNroVaga(String nroVaga) {
		this.nroVaga = nroVaga;
	}
	public String getBlocoVaga() {
		return blocoVaga;
	}
	public void setBlocoVaga(String blocoVaga) {
		this.blocoVaga = blocoVaga;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getCorVeiculo() {
		return corVeiculo;
	}
	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}
	public String getModeloVeiculo() {
		return modeloVeiculo;
	}
	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	
	
	
}

