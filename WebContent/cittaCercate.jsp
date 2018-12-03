<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Citta Cercate</title>
</head>
<body>

	<a href="${targetServletBottone}">
		<button>indietro</button> <br>
	</a>

	<br>



	<table width="75%" border="1" align="center">
		<tr>
			<th width="35%">NomeCitta</th>
			<th width="33%">Distretto</th>
			<th width="32%">Popolazione</th>
		</tr>
	</table>

	<c:forEach items="${cittaCercate}" var="citta">
		<table width="75%" border="1" align="center">
			<tr>
				<td width="35%">${citta.nomeCitta}</td>
				<td width="33%">${citta.distretto}</td>
				<td width="32%">${citta.popolazione}</td>
			</tr>
		</table>
	</c:forEach>

</body>
</html>