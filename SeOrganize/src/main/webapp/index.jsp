<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>
<div col="8">	
	<ul class="nav flex-column">
	  <li class="nav-item">
	    <a class="nav-link active" aria-current="page" 
	    	href="UsuarioController.do?acao=altUsuario&id=${sessionScope.usuarioAutenticado.idUsuario}">
	    		Atualizar cadastro</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="AutenticadorController.do">Sair</a>
	  </li>
	</ul>	
	<h1>Seja bem vindo ${sessionScope.usuarioAutenticado.nome}</h1>
</div>
<div col="8">	
	<table>
		<thead>
			<tr>
				<th>ID Conta</th>
				<th>Descricao</th>
				<th>Credito</th>
				<th>Debito</th>
				<th>Dinheiro</th>
				<th>Pagar</th>
				<th>Receber</th>
			</tr>
		</thead>
		
		<c:forEach items="${requestScope.lista}" var="c">
			<tbody>
				<tr>
					<td>${c.idConta}</td>
					<td>${c.descricao}</td>
					<td>${c.saldoCredito}</td>
					<td>${c.saldoDebito}</td>
					<td>${c.saldoDinheiro}</td>
					<td>${c.totalPagar}</td>
					<td>${c.totalReceber}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</div>
</body>
</html>