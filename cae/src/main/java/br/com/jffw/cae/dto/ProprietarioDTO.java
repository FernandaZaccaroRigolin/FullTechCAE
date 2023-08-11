package br.com.jffw.cae.dto;

import java.util.Date;

public class ProprietarioDTO {

	private String cpf;
	private String nome;
	private String telefone;
	private Date dtNascimento;
	private String email;
	
	public ProprietarioDTO(String cpf, String nome, String telefone, Date dtNascimento, String email) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setDtNascimento(dtNascimento);
		this.setEmail(email);
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
