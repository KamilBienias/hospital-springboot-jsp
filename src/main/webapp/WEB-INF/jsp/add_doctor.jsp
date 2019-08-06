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
<title>Add doctor</title>
</head>
<body>
		
	<div>
		<h2>Add new doctor or <a href="/">back to home page</a></h2> 
		<form:form method="post" modelAttribute="doctor"> <!-- obiekt doctor bedzie bindowany z tym formularzem -->
			
			<div class="form-group">
				<label>Doctor First Name</label>
				<form:input path="firstName" placeholder="First Name" type="text" class="form-control" /> <!-- path przypina nazwy pol do kontrolek -->
  				<form:errors path="firstName" style="color:red" class="form-text text-muted" />  
			</div>
		
			<div class="form-group">
				<label>Doctor Last Name</label>
				<form:input path="lastName" placeholder="Last Name" type="text" class="form-control" />
				<form:errors path="lastName" style="color:red" class="form-text text-muted" />  
			</div>
			
			<!--  
			<div class="form-group">
				<label>Date Of Birth</label>
				<form:input path="dateOfBirth" placeholder="dd-MM-yyyy" type="text" class="form-control" />
				<form:errors path="dateOfBirth" style="color:red" class="form-text text-muted" />  
			</div>
			-->
			
			<div class="form-group">
				<label>Pesel</label>
				<form:input path="pesel" placeholder="01234567890" type="text" class="form-control" />
				<form:errors path="pesel" style="color:red" class="form-text text-muted" />  
			</div>
	
			<div class="form-group">
				<label>Password</label>
				<form:input path="password" placeholder="Password" type="password" class="form-control" />
				<form:errors path="password" style="color:red" class="form-text text-muted" />
				<br/>
				<label>Confirm password</label>
				<form:input path="confirmPassword" placeholder="Confirm Password" type="password" class="form-control" />
				<form:errors path="confirmPassword" style="color:red" class="form-text text-muted" />
			</div>		
			
			<form:button type="submit" class="btn btn-success">Add new doctor</form:button>
		
		</form:form>		
	</div>
		  
</body>
</html>