<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
	integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
<title>Login doctor</title>
</head>
<body>
	<div style="margin: auto; width: 500px; padding-top: 50px">
	<h2>Login as a doctors or <a href="/">back to home page</a></h2> 
	
		<form:form method="post" modelAttribute="doctor">

			<div class="form-group">
				<label>Doctor nickname (lower case: the first 3 letters of name and surname and last digit of pesel)</label>
				<form:input path="nickname" placeholder="Nickname" type="text" class="form-control" />
				<form:errors path="nickname" style="color:red" class="form-text text-muted" />
			</div>

			<div class="form-group">
				<label>Password</label>
				<form:input path="password" placeholder="Password" type="password" class="form-control" />
				<form:errors path="password" style="color:red" class="form-text text-muted" />
			</div>
			<form:button type="submit" class="btn btn-primary">Login</form:button>
		</form:form>
	</div>
</body>
</html>
