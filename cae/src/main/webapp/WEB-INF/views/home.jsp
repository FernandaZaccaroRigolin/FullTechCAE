<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>CAE - Solution</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="//use.fontawesome.com/releases/v5.0.7/css/all.css"
    />
    <style>
      .component {
        color: var(--bs-gray-800);
        background-color: var(--bs-gray-100);
        border: 1px solid var(--bs-gray-200);
        border-radius: 0.25rem;
      }

      .component-header {
        color: var(--bs-purple);
        background-color: var(--bs-gray-200);
        /* display: flex; */
        /* flex-wrap: wrap; */
        align-items: center;
        height: 100px;
      }

      .component-footer {
        color: var(--bs-purple);
        background-color: var(--bs-gray-200);
        /* display: flex; */
        /* flex-wrap: wrap; */
        align-items: center;
        height: 100px;
      }

      .btnlogin {
        background-color: var(--bs-purple);
        color: var(--bs-white);

        /* border-color: var(--bs-purple); */
      }

      .strLink {
        color: var(--bs-purple);
        font-size: 20px;
      }

      .strLink:hover {
        color: red;
      }

      .strLinkInactive {
        color: var(--bs-gray-200);
        font-size: 20px;
      }

      .strColor {
        color: var(--bs-purple);
      }
      .conteudo-main {
        height: 500px;
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

      <c:choose>
        <c:when test="${usuLogado.isLogged == true}">
          <!-- <input type="text" name="nome" value="${usuLogado.nome}" /> -->
          <label>${usuLogado.nome}</label>
          <a href="/" class="btn btn-lg align-middle btnlogin p-3 w-25"
            >Logout</a
          >
        </c:when>
        <c:when test="${usuLogado.isLogged == false}">
          <h6>Ol&aacute;, fa&ccedil;a o login!</h6>
          <button
            type="button"
            class="btn btn-lg align-middle btnlogin p-3 w-25"
            data-toggle="modal"
            data-target="#meuModal"
          >
            Login
          </button>
        </c:when>
      </c:choose>
    </header>
    <div class="d-flex justify-content-between conteudo-main">
      <!-- <div class="imagem">
        <img src="${pageContext.request.contextPath}/imagens/Garoto2.jpeg" />
      </div> -->
      <div class="container text-center">
        <!-- <h2 class="font-italic"></h2> -->
        <h1 class="strColor mb-5">Controle de acesso a estacionamentos</h1>
        <div class="d-flex justify-content-between">
          <div class="border" style="width: 240px">
            <img
              src="${pageContext.request.contextPath}/imagens/usuario1.jpeg"
            />
            <c:choose>
              <c:when test="${usuLogado.isLogged == true}">
                <a class="strLink" href="/usuarios/lista">Usu&aacute;rios</a>
              </c:when>
              <c:when test="${usuLogado.isLogged == false}">
                <p class="strLinkInactive">Usu&aacute;rios</p>
              </c:when>
            </c:choose>
          </div>
          <div class="border" style="width: 240px">
            <img
              src="${pageContext.request.contextPath}/imagens/proprietario2.png"
            />
            <c:choose>
              <c:when test="${usuLogado.isLogged == true}">
                <a class="strLink" href="/manutencao">Propriet&aacute;rios</a>
              </c:when>
              <c:when test="${usuLogado.isLogged == false}">
                <p class="strLinkInactive">Propriet&aacute;rios</p>
              </c:when>
            </c:choose>
          </div>
          <div class="border" style="width: 240px">
            <img
              src="${pageContext.request.contextPath}/imagens/apartamento.png"
            />

            <c:choose>
              <c:when test="${usuLogado.isLogged == true}">
                <a class="strLink" href="/manutencao">Apartamentos</a>
              </c:when>
              <c:when test="${usuLogado.isLogged == false}">
                <p class="strLinkInactive">Apartamentos</p>
              </c:when>
            </c:choose>
          </div>
          <div class="border" style="width: 240px">
            <img src="${pageContext.request.contextPath}/imagens/vaga.png" />
            <c:choose>
              <c:when test="${usuLogado.isLogged == true}">
                <a class="strLink" href="/manutencao">Vagas</a>
              </c:when>
              <c:when test="${usuLogado.isLogged == false}">
                <p class="strLinkInactive">Vagas</p>
              </c:when>
            </c:choose>
          </div>
          <div class="border" style="width: 240px">
            <img src="${pageContext.request.contextPath}/imagens/veiculo.png" />
            <c:choose>
              <c:when test="${usuLogado.isLogged == true}">
                <a class="strLink" href="/manutencao">Ve&iacute;culos</a>
              </c:when>
              <c:when test="${usuLogado.isLogged == false}">
                <p class="strLinkInactive">Ve&iacute;culos</p>
              </c:when>
            </c:choose>
          </div>
        </div>
      </div>
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
    <div id="meuModal" class="modal fade" role="dialog">
      <div class="modal-dialog">
        <!-- Conteúdo do modal-->
        <div class="modal-content">
          <!-- Cabeçalho do modal -->
          <div class="modal-header">
            <img
              src="${pageContext.request.contextPath}/imagens/usuario3.jpeg"
            />
            <h4 class="modal-title">Login - register</h4>
            <button type="button" class="close" data-dismiss="modal">
              &times;
            </button>
          </div>

          <!-- Corpo do modal -->
          <div class="modal-body">
            <form action="/usuarios/login" method="post">
              <div class="mb-3">
                <label class="form-label">Email:</label>
                <input type="text" name="email" class="form-control" />
              </div>

              <div class="mb-3">
                <label class="form-label">Senha:</label>
                <input type="password" name="senha" class="form-control" />
              </div>
              <div>
                <button
                  type="button"
                  class="btn btn-danger"
                  data-dismiss="modal"
                >
                  Cancelar
                </button>
                <button type="submit" class="btn btn-primary">Login</button>
              </div>
            </form>
          </div>

          <!-- Rodapé do modal-->
          <!-- <div class="modal-footer"></div> -->
        </div>
      </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script
      src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
      integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
      crossorigin="anonymous"
    ></script>
    <script>
      let botao = document.getElementById('btnLogout')
      botao.addEventListener('click', function () {
        navigate('/')
      })
    </script>
  </body>
</html>
