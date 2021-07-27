
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>
	<h1>Seja bem vindo ${sessionScope.usuarioAutenticado.nome}</h1>
	<a href="UsuarioController.do?acao=altUsuario&id=${sessionScope.usuarioAutenticado.idUsuario}">
		Atualizar usuário</a>
</body>
</html>