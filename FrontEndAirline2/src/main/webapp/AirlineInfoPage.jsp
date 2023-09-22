<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Airline Information </h1>
 <table>
 	<tr>
 		<th>airlineId</th>
 		<th>airlineName</th>
 	</tr>
 	<c:forEach var="airinfo" items="${listOfAirinfo}">
 	<tr>
 		<td>${airinfo.airlineId}</td>
 		<td>${airinfo.airlineName}</td>
 	</tr>
 	</c:forEach>
 </table>
 

</body>
</html>