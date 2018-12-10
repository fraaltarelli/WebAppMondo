<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salvataggio Citta</title>
</head>
<body>
	<div style="text-align: center;">

		<c:if test="${salvataggioRiuscito==true}">
			<h2>Salvataggio andato a buon fine</h2>
		</c:if>

		<br> <a href="runContinenti">
			<button>ritorna ai continenti</button> <br>
		</a>

	</div>


</body>
</html>