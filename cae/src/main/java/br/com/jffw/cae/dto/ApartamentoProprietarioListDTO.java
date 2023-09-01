package br.com.jffw.cae.dto;

import java.util.Date;

public class ApartamentoProprietarioListDTO {
	private int idApartamento;
	private String nroApartamento;
	private String blocoApartamento;
	private int qndVagas;
	private String cpfProprietario;
	private String nomeProprietario;
	private String telProprietario;
	private String emailProprietario;
		
	public ApartamentoProprietarioListDTO(
			int idApartamento, String nroApartamento, String blocoApartamento, 
			int qndVagas, String cpfProprietario,
			String nomeProprietario, String telProprietario, String emailProprietario) {
		this.setIdApartamento(idApartamento);
		this.setNroApartamento(nroApartamento);
		this.setBlocoApartamento(blocoApartamento);
		this.setQndVagas(qndVagas);
		this.setCpfProprietario(cpfProprietario);
		this.setNomeProprietario(nomeProprietario);
		this.setTelProprietario(telProprietario);
		this.setEmailProprietario(emailProprietario);
	}
	
	
	public int getIdApartamento() {
		return idApartamento;
	}


	public void setIdApartamento(int idApartamento) {
		this.idApartamento = idApartamento;
	}


	public String getNroApartamento() {
		return nroApartamento;
	}
	public void setNroApartamento(String nroApartamento) {
		this.nroApartamento = nroApartamento;
	}
	public String getBlocoApartamento() {
		return blocoApartamento;
	}
	public void setBlocoApartamento(String blocoApartamento) {
		this.blocoApartamento = blocoApartamento;
	}
	
	
	public int getQndVagas() {
		return qndVagas;
	}
	public void setQndVagas(int qndVagas) {
		this.qndVagas = qndVagas;
	}
	public String getCpfProprietario() {
		return cpfProprietario;
	}
	public void setCpfProprietario(String cpfProprietario) {
		this.cpfProprietario = cpfProprietario;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public String getTelProprietario() {
		return telProprietario;
	}
	public void setTelProprietario(String telProprietario) {
		this.telProprietario = telProprietario;
	}
	public String getEmailProprietario() {
		return emailProprietario;
	}
	public void setEmailProprietario(String emailProprietario) {
		this.emailProprietario = emailProprietario;
	}	

}
