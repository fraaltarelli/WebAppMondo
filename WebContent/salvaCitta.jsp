<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salva Citta</title>
</head>
<body>
	<div style="text-align: center;">

		<form action="${targetServletDaSalvaCitta}">
			<table width="75%" border="1" align="center">
				<tr>
					<th width="34%">Seleziona la Nazione:</th>
					<th with="22%">Digita il nome della citta</th>
					<th with="22%">Digita il nome del distretto</th>
					<th with="22%">Digita il numero di abitanti</th>
				</tr>
			</table>

			<table width="75%" border="1" align="center">
				<tr>
					<td width="34%"><select name="nazioneselezionata">

							<c:forEach items="${allnations}" var="nazione">
								<c:choose>
									<c:when test="${nazione==cittaDaModificare.nazione}">
										<option value="${nazione}" selected>${nazione}</option>
									</c:when>
									<c:otherwise>
										<option value="${nazione}">${nazione}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>

					<td width="22%"><input name="nomecittainserito" type="text"
						value="${cittaDaModificare.nomeCitta}"></td>

					<td width="22%"><input name="nomedistrettoinserito"
						type="text" value="${cittaDaModificare.distretto}"></td>
					<td width="22%"><input name="popolazioneinserita"
						type="number" min="0" value="${cittaDaModificare.popolazione}">
					</td>

				</tr>

			</table>
			<input name="salvaCitta" type="submit" value="Salva"> <br>
			<br>

		</form>

	</div>

</body>
</html>