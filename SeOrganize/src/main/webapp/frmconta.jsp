<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="ContaController.do" method="post">
		<label>ID:</label>
		<input type="text" readonly="readonly" name="txtid"/></br>
		<label>Descricao</label>
		<input type="text" name="txtdesc"/></br>
		<label>Saldo Crédito</label>
		<input type="text" name="txtsldcred"/></br>
		<label>Saldo Débito</label>
		<input type="text" name="txtslddeb"/></br>
		<label>Saldo Dinheiro</label>
		<input type="text" name="txtslddin"/></br>
		<label>Total a pagar</label>
		<input type="text" name="txttotpag"/></br>
		<label>Total a receber</label>
		<input type="text" name="txttotrec"/></br>
		
		<input type="submit" value="Salvar"/></br>
	</form>
	<a href="index.jsp">Menu inicial</a>

</body>
</html>