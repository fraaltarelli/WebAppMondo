<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Continenti</title>
</head>
<body>

	<div style="text-align: center;">


		<c:forEach items="${listaContinenti}" var="continente">
			<a href="runNazioni?continente=${continente}"> ${continente} </a>
			<br>
		</c:forEach>


	</div>

</body>
</html>