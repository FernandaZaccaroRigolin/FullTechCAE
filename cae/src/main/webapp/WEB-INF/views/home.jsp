<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>E-Commerce Cap</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
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
      }

      .btnlogin {
        background-color: var(--bs-purple);
        color: var(--bs-white);

        /* border-color: var(--bs-purple); */
      }
    </style>
  </head>
  <body>
    <header
      class="component-header d-flex p-2 bd-highlight justify-content-between px-md-5 border"
    >
      <h1 class="text-left">Cae - Solutions</h1>
      <button
        type="button"
        class="btn btn-lg mt-2 ml-2 align-middle btnlogin p-3 w-25"
        data-toggle="modal"
        data-target="#meuModal"
      >
        Login
      </button>
    </header>
    <div class="d-flex justify-content-between">
      <div class="imagem">
        <img src="${pageContext.request.contextPath}/imagens/Garoto2.jpeg" />
      </div>
      <div class="container text-center">
        <!-- <h2 class="font-italic"></h2> -->
        <h1>Controle de acesso a estacionamentos</h1>
        <div class="d-flex justify-content-between">
          <div class="border" style="width: 290px">
            <img src="${pageContext.request.contextPath}/imagens/user2.png" />
            <a href="/usuarios/novo">Proprietarios</a>
          </div>
          <div class="border" style="width: 290px">
            <img
              src="${pageContext.request.contextPath}/imagens/Apartamento.png"
            />
            <a href="/usuarios/novo">Apartamentos</a>
          </div>
          <div class="border" style="width: 290px">
            <img
              src="${pageContext.request.contextPath}/imagens/Estacionamento2.png"
            />
            <a href="/usuarios/novo">Vagas</a>
          </div>
          <div class="border" style="width: 250px">
            <img src="${pageContext.request.contextPath}/imagens/veiculo.png" />
            <a href="/usuarios/novo">Veiculos</a>
          </div>
        </div>
      </div>
    </div>

    <div id="meuModal" class="modal fade" role="dialog">
      <div class="modal-dialog">
        <!-- Conteúdo do modal-->
        <div class="modal-content">
          <!-- Cabeçalho do modal -->
          <div class="modal-header">
            <img
              src="${pageContext.request.contextPath}/imagens/Garoto3.jpeg"
            />
            <h4 class="modal-title">Login - register</h4>
            <button type="button" class="close" data-dismiss="modal">
              &times;
            </button>
          </div>

          <!-- Corpo do modal -->
          <div class="modal-body">
            <form>
              <div class="mb-3">
                <label class="form-label">Email:</label>
                <input type="text" name="email" class="form-control" />
              </div>

              <div class="mb-3">
                <label class="form-label">Senha:</label>
                <input type="text" name="telefone" class="form-control" />
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
  </body>
</html>
