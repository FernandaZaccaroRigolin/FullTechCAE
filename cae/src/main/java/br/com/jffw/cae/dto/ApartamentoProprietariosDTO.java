package br.com.jffw.cae.dto;

public class ApartamentoProprietariosDTO {

	private String cpf;
	private int id;
	private String numero;
	private String bloco;
	private int qndVagas;

	public ApartamentoProprietariosDTO() {
	}

	public ApartamentoProprietariosDTO(String cpf, int id, String numero, String bloco, int qndvagas) {
		this.setCpf(cpf);
		this.setId(id);
		this.setNumero(numero);
		this.setBloco(bloco);
		this.setQndVagas(qndvagas);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public int getQndVagas() {
		return qndVagas;
	}

	public void setQndVagas(int qndVagas) {
		this.qndVagas = qndVagas;
	}

}
