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
		<input type="text" readonly="readonly" name="txtid" size="20"/> <br/>
		
		<label>Nome: </label>
		<input type="text" name="txtnome" size="20"/> <br/>
		
		<label>CPF: </label>
		<input type="text" name="txtcpf" size="20"/> <br/>
		
		<label>E-mail: </label>
		<input type="text" name="txtemail" size="20"/> <br/>
		
		<label>Login: </label>
		<input type="text" name="txtlogin" size="20"/> <br/>
		
		<label>Senha: </label>
		<input type="password" name="txtsenha" size="20"/> <br/>
		
		<input type="submit" value="Salvar"/>
	
	</form>

</body>
</html>