package br.com.jffw.cae.dto;

public class ProprietarioApartamentosDTO {

	private int idApartamento;
	private String cpf;
	private String nome;
	private String numeroApartamento;
	private String blocoApartamento;
	
	public ProprietarioApartamentosDTO(int idAp, String cpf, String nome, String numeroAp, String blocoAp) {
		this.setIdApartamento(idAp);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setNumeroApartamento(numeroAp);
		this.setBlocoApartamento(blocoAp);
	}

	public int getIdApartamento() {
		return idApartamento;
	}

	public void setIdApartamento(int idApartamento) {
		this.idApartamento = idApartamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroApartamento() {
		return numeroApartamento;
	}

	public void setNumeroApartamento(String numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}

	public String getBlocoApartamento() {
		return blocoApartamento;
	}

	public void setBlocoApartamento(String blocoApartamento) {
		this.blocoApartamento = blocoApartamento;
	}
	
	
	
}
