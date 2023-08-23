package br.com.jffw.cae.dto;

public class VagaVeiculosDTO {
	private String placa;
	private String cor;
	private String modelo;
	private int Vaga;
	private String bloco;
	private String numero;

	public VagaVeiculosDTO() {
	}

	public VagaVeiculosDTO(String placa, String cor, String modelo, int vaga, String bloco, String numero) {
		this.setPlaca(placa);
		this.setCor(cor);
		this.setModelo(modelo);
		this.setVaga(vaga);
		this.setBloco(bloco);
		this.setNumero(numero);
	}

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

	public int getVaga() {
		return Vaga;
	}

	public void setVaga(int vaga) {
		Vaga = vaga;
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

}
