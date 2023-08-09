<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuários</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.margem-botao {
	margin-top: 10px;
	margin-bottom: 10px;
}

.borda {
	margin: auto;
	max-width: 400px;
}
</style>
</head>
<body>
	<div class="container borda">
		<h2 class="text-primary text-center">Cadastro de Usuários</h2>
		<form action="/usuarios/novo" method="post">
			<div class="mb-3">
				<label class="form-label">Nome:</label> <input type="text"
					name="nome" class="form-control" />
			</div>

			<div class="mb-3">
				<label class="form-label">Email:</label> <input type="text"
					name="email" class="form-control" />
			</div>

			<div class="mb-3">
				<label class="form-label">Senha:</label> <input type="text"
					name="senha" class="form-control" />
			</div>
			
				<div class="mb-3">
				<label class="form-label">Data:</label>
				<input type="date" name="dataCadastro" class="form-control" />
			</div>	
			

			<div class="mb-3">
				<label class="form-label">Nível Acesso:</label> 
				<select class="form-control" name="nivelAcesso" id="nivelacesso">
					<option value="administrador">Administrador</option>
					<option value="funcionario">Funcionário</option>
					<option value="morador">Morador</option>
				</select>
			</div>

			<button type="submit" class="btn btn-primary">Incluir</button>
			<a href="/usuarios/lista" class="btn btn-secondary">Voltar para a lista</a>
		</form>
	</div>

</body>
</html>