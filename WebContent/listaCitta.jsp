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

		<c:if test="${eliminazioneRiuscita==true}">
			<h2>Eliminazione Riuscita</h2>
		</c:if>

		<a href="runContinenti">
			<button>ritorna ai continenti</button> <br>
		</a> <br>



		<table width="75%" border="1" align="center">
			<tr>
				<th width="28%">NomeCitta</th>
				<th width="23%">Distretto</th>
				<th width="23%">Popolazione</th>
				<th with="13%">Modifica Citta</th>
				<th with="13%">Elimina Citta</th>

			</tr>
		</table>

		<c:forEach items="${listaCitta}" var="citta">
			<table width="75%" border="1" align="center">
				<tr>
					<td width="28%">${citta.nomeCitta}</td>
					<td width="23%">${citta.distretto}</td>
					<td width="23%">${citta.popolazione}</td>
					<td width="13%"><a
						href="runAggiornamentoForm?idCitta=${citta.id}&countryCode=${citta.countryCode}"
						class="button"> Modifica</a></td>
					<td width="13%"><a href="runEliminaCitta?idCitta=${citta.id}"
						class="button"> Elimina</a></td>
				</tr>
			</table>
		</c:forEach>

	</div>


</body>
</html>