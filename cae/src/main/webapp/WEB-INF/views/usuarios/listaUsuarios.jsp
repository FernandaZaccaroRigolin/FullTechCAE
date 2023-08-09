<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Lista de Clientes</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <style>
      .margem-botao {
        margin-top: 10px;
        margin-bottom: 10px;
      }
    </style>
  </head>
  <body>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib
    uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <div class="container">
      <h2 class="text-primary text-center">Lista de Usu&aacute;rios</h2>

      <div class="margem-botao">
        <a href="/usuarios/novo" class="btn btn-primary"
          >Novo Usu&aacute;rio</a
        >
      </div>

      <table class="table table-striped">
        <thead>
          <tr>
            <th>NOME</th>
            <th>EMAIL</th>
            <th>DTCADASTRO</th>
            <th>NIVELACESSO</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="usu" items="${listagem_usuarios}">
            <tr>
              <td>${usu.nome}</td>
              <td>${usu.email}</td>
							<td><fmt:formatDate value="${usu.dtCadastro}" pattern="dd/MM/yyyy" />
              <td>${usu.nivelAcesso}</td>
              <td>
                <a href="/usuarios/alterar/${usu.id}">Alterar</a> |
                <a href="/usuarios/remover/${usu.id}">Remover</a> |
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
