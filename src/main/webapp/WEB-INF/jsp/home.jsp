<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- prefix c, zeby wiedzial o tagach -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css"
	integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
<title>Hospital home page</title>
</head>
<body>
	<h1>${greeting}</h1>
	<div>
		<ol>
			<li><strong>Menu for doctors</strong>
				<ul>
					<li><a href="add_doctor">Register as a doctor to add a new doctor</a></li>
					<li><a href="login_doctor">Login as a doctor to display the doctor's details</a></li>
					<li><a href="logout">Logout as a doctor</a></li>	
				</ul>
			</li>
			<li><strong>Menu for patients</strong>
				<ul>
					<li><a href="add_patient">Register as a patient to add a new patient</a></li>
					<li><a href="login_patient">Login as a patient to display the patient's details</a></li>
					<li><a href="logout">Logout as a patient</a></li>
				</ul>
			</li>
			<li><strong>Menu for the director</strong>
				<ul>
					<li><a href="all_doctors">Show all doctors</a></li>
					<li><a href="doctor_details">Set the doctor's details</a></li>
					<li><a href="remove_doctor">Remove a doctor</a></li>
					<li><a href="all_patients">Show all patients</a></li>
					<li><a href="patient_details">Set the patient's details</a></li>
					<li><a href="assign_doctor_to_patient">Assign doctor to patient</a></li>
					<li><a href="remove_patient">Remove a patient</a></li>
				</ul>
			</li>
		</ol>
	</div>
</body>
</html>