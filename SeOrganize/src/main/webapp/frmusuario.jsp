<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Usuário</title>
</head>
<body>

	<form action="UsuarioController.do" method="post">
	
		<label>ID: </label>
		<input type="text" readonly="readonly" value="${sessionScope.usuarioAutenticado.idUsuario}" name="txtid" size="20"/> <br/>
		
		<label>Nome: </label>
		<input type="text" value="${sessionScope.usuarioAutenticado.nome}" name="txtnome" size="20"/> <br/>
		
		<label>CPF: </label>
		<input type="text" value="${sessionScope.usuarioAutenticado.cpf}" name="txtcpf" size="20"/> <br/>
		
		<label>E-mail: </label>
		<input type="text" value="${sessionScope.usuarioAutenticado.email}" name="txtemail" size="20"/> <br/>
		
		<label>Login: </label>
		<input type="text" value="${sessionScope.usuarioAutenticado.login}" name="txtlogin" size="20"/> <br/>
		
		<label>Senha: </label>
		<input type="password" value="${sessionScope.usuarioAutenticado.senha}" name="txtsenha" size="20"/> <br/>
		
		<input type="submit" value="Salvar"/>
	
	</form>

</body>
</html>