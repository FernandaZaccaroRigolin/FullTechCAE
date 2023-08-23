package br.com.jffw.cae.dto;

public class VeiculoDTO {

    private Integer idVaga;
    private String placa;    
    private String cor;
    private String modelo;

//    private String bloco;
//    private String numero; 

    public VeiculoDTO(Integer idVaga, String placa, String cor, String modelo) {
        this.setIdVaga(idVaga);
        this.setPlaca(placa);
        this.setCor(cor);
        this.setModelo(modelo);

//        this.setBloco(bloco);
//        this.setNumero(numero);/    
    }

 

    public Integer getIdVaga() {
        return idVaga;
    }

 

    public void setIdVaga(Integer idVaga) {
        this.idVaga = idVaga;
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
 

    }
//    public String getBloco() {
//        return bloco;
//    }
//    public void setBloco(String bloco) {
//        this.bloco = bloco;
//    }
//    public String getNumero() {
//        return numero;
//    }
//    public void setNumero(String numero) {
//        this.numero = numero;
//    }