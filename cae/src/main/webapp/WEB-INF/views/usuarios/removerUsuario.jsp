<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmação de exclusão</title>
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
	<div class="container">
		<h2 class="text-danger">Tem certeza que deseja remover este	usuário?</h2>
		<div class="alert alert-danger">
			<div>ID: ${usuario.id}</div>
			<div>Nome: ${usuario.nome}</div>
		</div>
		<form action="/usuarios/remover" method="post">
			<div class="mb-3">
				<input type="hidden" name="id" value="${usuario.id}" />
				<div>
					<a href="/usuarios/lista">Não, retornar para a lista</a> |
					<button type="submit" class="btn btn-danger">Sim, remover</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>