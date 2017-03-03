<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Employees</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Employees</h1>
				<p>Add employee</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form  modelAttribute="newEmployee" class="form-horizontal">
			<fieldset>
				<legend>Add new employee</legend>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastname">Lastname</label>
					<div class="col-lg-10">
						<form:input id="lastname" path="lastname" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="email">Email</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="email" path="email" type="text" class="form:input-large"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="phoneNumber">Phone Number</label>
					<div class="col-lg-10">
						<form:input id="phoneNumber" path="phoneNumber" type="text" class="form:input-large"/>
					</div>
				</div>

				
				<div class="form-group">
					<label class="control-label col-lg-2" for="vacationDays">Available vacation days</label>
					<div class="col-lg-10">
						<form:input id="vacationDays" path="vacationDays" type="text" class="form:input-large"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>
