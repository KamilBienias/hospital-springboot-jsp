<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- prefix c, zeby wiedzial o tagach -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- prefix form, do formularzy -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
	integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
<title>Doctor page</title>
</head>
<body>
		
	<div>
		<h2>Logged as doctor ${doc.firstName} </h2> <a href="/"> Back to home page </a><a href="logout" class="btn btn-warning">Logout</a> <!-- wyswietla wartosc pod kluczem usr, a wlasciwie jej wlasciwosc bo usr.userName --> 
		<br>${doc}<br><!-- wyswietla dane o doktorze przekazanym w czasie logowania -->
				  				
	</div>
		  
</body>
</html>