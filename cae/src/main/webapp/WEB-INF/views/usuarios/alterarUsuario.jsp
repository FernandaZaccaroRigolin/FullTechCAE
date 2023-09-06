<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Altera&ccedil;&atilde;o de Usu&aacute;rios</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="//use.fontawesome.com/releases/v5.0.7/css/all.css"
    />
    <style>
      .component-header {
        color: var(--bs-purple);
        background-color: var(--bs-gray-200);
        /* display: flex; */
        /* flex-wrap: wrap; */
        align-items: center;
        height: 100px;
      }

      .conteudo-main {
        height: 530px;
      }
      .component-footer {
        color: var(--bs-purple);
        background-color: var(--bs-gray-200);
        /* display: flex; */
        /* flex-wrap: wrap; */
        align-items: center;
        height: 100px;
      }

      .margem-botao {
        margin-top: 10px;
        margin-bottom: 10px;
      }

      .borda {
        margin: auto;
        max-width: 400px;
      }
      
       .btnColor {
        background-color: var(--bs-purple);
        color: var(--bs-white);

        /* border-color: var(--bs-purple); */
      }    
      
	   .btnColor:hover {
        color: var(--bs-purple);
        background-color: var(--bs-white);

        border: 2px solid var(--bs-purple);
      }   
      
      .strColor{
        color: var(--bs-purple);
      }
      
    </style>
  </head>
  <body>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib
    uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <header
      class="component-header d-flex p-2 bd-highlight justify-content-between px-md-5 border"
    >
      <h1 class="text-left">Cae - Solutions</h1>

      <a class="strLink" href="/">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          height="1em"
          viewBox="0 0 576 512"
        >
          <!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. -->
          <path
            d="M575.8 255.5c0 18-15 32.1-32 32.1h-32l.7 160.2c0 2.7-.2 5.4-.5 8.1V472c0 22.1-17.9 40-40 40H456c-1.1 0-2.2 0-3.3-.1c-1.4 .1-2.8 .1-4.2 .1H416 392c-22.1 0-40-17.9-40-40V448 384c0-17.7-14.3-32-32-32H256c-17.7 0-32 14.3-32 32v64 24c0 22.1-17.9 40-40 40H160 128.1c-1.5 0-3-.1-4.5-.2c-1.2 .1-2.4 .2-3.6 .2H104c-22.1 0-40-17.9-40-40V360c0-.9 0-1.9 .1-2.8V287.6H32c-18 0-32-14-32-32.1c0-9 3-17 10-24L266.4 8c7-7 15-8 22-8s15 2 21 7L564.8 231.5c8 7 12 15 11 24z"
          />
        </svg>
      </a>
    </header>

    <div class="container borda conteudo-main">
      <h2 class="strColor text-center">
        Altera&ccedil;&atilde;o de Usu&aacute;rios
      </h2>
      <form action="/usuarios/alterar" method="post">
        <input type="hidden" name="id" value="${usuario.id}" />
        <div class="mb-3">
          <label class="form-label">Nome:</label>
          <input
            type="text"
            name="nome"
            class="form-control"
            value="${usuario.nome}"
          />
        </div>

        <div class="mb-3">
          <label class="form-label">Email:</label>
          <input
            type="text"
            name="email"
            class="form-control"
            value="${usuario.email}"
          />
        </div>

        <div class="mb-3">
          <label class="form-label">N&iacute;vel Acesso:</label>
          <input
            type="text"
            name="nivelAcesso"
            class="form-control"
            value="${usuario.nivelAcesso}"
            readonly
          />
        </div>

        <button type="submit" class="btn btnColor">Alterar</button>
        <a href="/usuarios/lista" class="btn btn-secondary">
          Voltar para a lista</a
        >
      </form>
    </div>
    <footer
      class="conteudo-rodape component-footer d-flex p-2 bd-highlight justify-content-between px-md-5 border"
    >
      <div>Copyright &copy; 2023 - Todos os direitos reservados</div>
      <div>
        <div style="margin-left: 5px">J.F.F.W</div>
        <div style="font-size: 10px; margin-left: 5px">
          Jessianne Saiara de Sousa Macedo
        </div>
        <div style="font-size: 10px; margin-left: 5px">
          Fernanda Renata Zaccaro Rigolin
        </div>
        <div style="font-size: 10px; margin-left: 5px">
          Felipe Augusto da Silva Soares
        </div>
        <div style="font-size: 10px; margin-left: 5px">
          Wanderson Rodrigo Resende Mendes
        </div>
      </div>
    </footer>
  </body>
</html>
