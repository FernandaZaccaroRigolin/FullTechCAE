package br.com.jffw.cae.dto;

import java.util.Date;

public class UsuarioDTO {
	
	private int id;
	private String nome;
	private String email;
//	private String senha;
	private Date dtCadastro;
	private String nivelAcesso;	
	

	public UsuarioDTO(int id, String nome, String email, Date dtCadastro, String nivelAcesso) {
		this.setId(id);
		this.setNome(nome);
		this.setEmail(email);
		this.setDtCadastro(dtCadastro);
		this.setNivelAcesso(nivelAcesso);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
}
