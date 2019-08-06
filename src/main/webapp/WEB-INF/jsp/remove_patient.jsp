<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- prefix c, zeby wiedzial o tagach -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"	
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
	integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA"
	crossorigin="anonymous">
<title>Remove patient</title>
</head>
<body>
	<div>
		<h2> Remove a patient or <a href="/">back to home page</a></h2>
				
    	<!-- mozna samo ${show_patients} ale wyswietla w jednym ciagu, dlateo wybralem petle ponizej -->
		<c:forEach var="patient" items="${show_patients}">
				<a href = "/remove_patient/${patient.id}">Remove patient ${patient.id}</a><br>${patient} <br><br>
		</c:forEach>
  
	</div>

</body>
</html>