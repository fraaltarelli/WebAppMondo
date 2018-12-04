<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Citta</title>
</head>
<body>

	<div style="text-align: center;">


       <c:if test="${tastoIndietro == true}">
		<a href="runNazioni">
			<button>indietro</button> <br>
		</a> <br>
		</c:if>
		
		<a href="runContinenti">
			<button>ritorna ai continenti</button> <br>
		</a> <br>

		<table width="75%" border="1" align="center">
			<tr>
				<th width="30%">NomeCitta</th>
				<th width="26%">Distretto</th>
				<th width="26%">Popolazione</th>
				<th with="18%">Elimina Citta
				<th>
			</tr>
		</table>

		<c:forEach items="${listaCitta}" var="citta">
			<table width="75%" border="1" align="center">
				<tr>
					<td width="30%">${citta.nomeCitta}</td>
					<td width="26%">${citta.distretto}</td>
					<td width="26%">${citta.popolazione}</td>
					<td width="18%"><a href="runEliminaCitta?idCitta=${citta.id}"
						class="button"> Elimina</a></td>
				</tr>
			</table>
		</c:forEach>

	</div>


</body>
</html>