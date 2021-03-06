<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Employees</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Employees</h1>
					<p>List of all Amartus employees</p>
                </div>
            </div>

      </section>
      <section class="container">
         <div class="row">
            <c:forEach items="${employees}" var="employee">
               <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                  <div class="thumbnail">
                     <div class="caption">
                        <h3>Dane pracownika:</h3>
                        <p>Imie: ${employee.name}</p>
                        <p>Nazwisko: ${employee.lastname}</p>
                        <p>Email: ${employee.email}</p>
                        <p>Dostępne dni urlopowe: ${employee.vacationDays}</p>
                     </div>
                  </div>
               </div>
            </c:forEach>
         </div>
      </section>
   </body>
</html>