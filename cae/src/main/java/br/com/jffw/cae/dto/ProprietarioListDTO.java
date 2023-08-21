package br.com.jffw.cae.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProprietarioListDTO {
    private String cpf;
    private String nome;
    private String telefone;
    @JsonIgnore
    private Date dtNascimento;
    private String email;
    private Integer apartamento;
    @JsonProperty("dtNascimento")
    private String dtNascimentoFormatted;
    private String numeroApartamento;
    private String blocoApartamento;
    private int qndVagasApartamento;
    
    public ProprietarioListDTO () { }
    
    public ProprietarioListDTO(String cpf, 
    		String nome, 
    		String telefone, 
    		String email, 
    		Integer apartamento, 
    		Date dtNascimento,
    		String numeroApartamento,
    		String blocoApartamento,
    		int qndVagasApartamento
    		) {
    	
    	this.setCpf(cpf);
    	this.setNome(nome);
    	this.setTelefone(telefone);
    	this.setEmail(email);
    	this.setApartamento(apartamento);
    	this.setDtNascimento(dtNascimento);
    	this.setDtNascimentoFormatted(this.getDtNascimentoFormatted());
    	this.setNumeroApartamento(numeroApartamento);
    	this.setBlocoApartamento(blocoApartamento);
    	this.setQndVagasApartamento(qndVagasApartamento);
    	   	
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

    public Integer getApartamento() {
        return apartamento;
    }

    public void setApartamento(Integer apartamento) {
        this.apartamento = apartamento;
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

    public int getQndVagasApartamento() {
        return qndVagasApartamento;
    }

    public void setQndVagasApartamento(int qndVagasApartamento) {
        this.qndVagasApartamento = qndVagasApartamento;
    }

    public String getDtNascimentoFormatted() {
        if (dtNascimento != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC")); 
            return dateFormat.format(dtNascimento);
        }
        return null;
    }


    public void setDtNascimentoFormatted(String dtNascimentoFormatted) {
        this.dtNascimentoFormatted = dtNascimentoFormatted;
    }
}
