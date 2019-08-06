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
<title>Doctor's details</title>
</head>
<body>
	<div>
		<h2> Set a doctor's details or <a href="/">back to home page</a></h2>
				
    	<!-- mozna samo ${show_doctors} ale wyswietla w jednym ciagu, dlateo wybralem petle ponizej -->
		<c:forEach var="doctor" items="${show_doctors}">
				Set salary and bonus: <br>
				<a href = "/doctor_details/${doctor.id}/2000/true"> 2000 with bonus, </a>
				<a href = "/doctor_details/${doctor.id}/2000/false"> 2000 without bonus, </a>
				<a href = "/doctor_details/${doctor.id}/3000/true"> 3000 with bonus, </a>
				<a href = "/doctor_details/${doctor.id}/3000/false"> 3000 without bonus, </a>
				<a href = "/doctor_details/${doctor.id}/4000/true"> 4000 with bonus, </a>
				<a href = "/doctor_details/${doctor.id}/4000/false"> 4000 without bonus </a><br>
				${doctor} <br><br>
		</c:forEach>
  
	</div>

</body>
</html>