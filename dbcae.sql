CREATE DATABASE  IF NOT EXISTS `dbcae`;
USE `dbcae`;

CREATE TABLE `tb_usuarios` (
  `ID` 			    int  not null AUTO_INCREMENT,
  `NOME` 			varchar(100) not null,
  `EMAIL` 			varchar(50)  not null,
  `SENHA` 			varchar(50)  not null,
  `DTCADASTRO` 		datetime not null,
  `NIVELACESSO` 	varchar(20)  not null,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `tb_proprietarios`
(
	 `CPF` 			varchar(11) not null,
	 `NOME` 		varchar(100) not null,
	 `TELEFONE` 	varchar(20) not null,
	 `DTNASCIMENTO`	datetime null,
	 `EMAIL` 		varchar(50)  not null,
  	 `FOTO`         blob, 
	 `IDUSUARIO`	int null unique,
	 PRIMARY KEY (`CPF`),
	 FOREIGN KEY (`IDUSUARIO`) REFERENCES tb_usuarios (`ID`)
);

CREATE TABLE `tb_apartamentos`
(
    `ID`               int not null AUTO_INCREMENT,
	`NUMERO`     	   varchar(5) not null,
	`ANDAR`            varchar(2) not null,
	`QNDVAGAS`   	   int not null,
    `CPF`	           varchar(11),
	PRIMARY KEY (`ID`),
    FOREIGN KEY (`CPF`) REFERENCES tb_proprietarios (`CPF`)
);

CREATE TABLE `tb_vagas`
(
    `ID`               int not null AUTO_INCREMENT,
	`BLOCO`     	   varchar(5) not null,
	`NUMERO`           varchar(5) not null,
    `IDAPARTAMENTO`    int null,
	PRIMARY KEY (`ID`),
    FOREIGN KEY (`IDAPARTAMENTO`) REFERENCES tb_apartamentos (`ID`)
 );

CREATE TABLE `tb_veiculos`
(
    `PLACA`        varchar(10) not null,
	`COR`     	   varchar(10) not null,
	`MODELO`       varchar(10) not null,
	`FOTO`         blob, 
    `IDAPARTAMENTO`    int null,
    `IDVAGA`       int null,
	PRIMARY KEY (`PLACA`),
    FOREIGN KEY (`IDAPARTAMENTO`) REFERENCES tb_apartamentos (`ID`),
    FOREIGN KEY (`IDVAGA`) REFERENCES tb_vagas (`ID`)
);


  




