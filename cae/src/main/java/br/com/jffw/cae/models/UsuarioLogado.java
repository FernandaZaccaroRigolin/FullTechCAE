package br.com.jffw.cae.models;

import org.springframework.stereotype.Component;

@Component
public class UsuarioLogado {
    private Usuario usuarioLogado;
    private String email;
    private String senha;
    private boolean isLogged; 
    
    public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		this.setLogged(true);
	}
	
    public String getNome() {
	  return usuarioLogado.getNome();
	}
    
    public boolean getIsLogged() {
		return isLogged;
	}
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
	public void setLogout() {  
        this.usuarioLogado = null;  
   }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	} 
   
}
