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
		<input type="text" readonly="readonly" value="${requestScope.usuario.idUsuario}" name="txtid" size="20"/> <br/>
		
		<label>Nome: </label>
		<input type="text" value="${requestScope.usuario.nome}" name="txtnome" size="20"/> <br/>
		
		<label>CPF: </label>
		<input type="text" value="${requestScope.usuario.cpf}" name="txtcpf" size="20"/> <br/>
		
		<label>E-mail: </label>
		<input type="text" value="${requestScope.usuario.email}" name="txtemail" size="20"/> <br/>
		
		<label>Login: </label>
		<input type="text" value="${requestScope.usuario.login}" name="txtlogin" size="20"/> <br/>
		
		<label>Senha: </label>
		<input type="password" value="${requestScope.usuario.senha}" name="txtsenha" size="20"/> <br/>
		
		<input type="submit" value="Salvar"/>
	
	</form>
	<a href="login.html">Voltar</a>

</body>
</html>