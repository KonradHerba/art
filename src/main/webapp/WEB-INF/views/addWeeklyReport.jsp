<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Weekly report</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Weekly report</h1>
				<p>Add report</p>
			</div>
		</div>
	</section>

	<section>
		<div class="container">
			<table>
				<tr>
  					<th>Project</th>

  					<c:forEach items="${reportForm.reportedDays}" var="day">
    					<th>
    						<fmt:parseDate value="${day}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
							<fmt:formatDate value="${parsedDate}" var="newParsedDate" type="date" pattern="yyyy-MM-dd" />
							<%-- fmt:formatDate value="${parsedDate}" var="weekDay" type="date" pattern="E" /--%>

							<p style="text-align:center">${newParsedDate}</p>
    					</th>
    				</c:forEach>
  				</tr>
  			</table>
		<form:form  modelAttribute="reportForm" class="form-horizontal">
			<%--table>
  				<tr>
  					<th>Project</th>

  					<c:forEach items="${reportForm.reportedDays}" var="reportedDay" varStatus="day">
    					<th>
    						<fmt:parseDate value="${reportedDay}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
							<fmt:formatDate value="${parsedDate}" var="newParsedDate" type="date" pattern="yyyy-MM-dd" />
							<fmt:formatDate value="${parsedDate}" var="weekDay" type="date" pattern="E" />

							<p style="text-align:center">${newParsedDate}</p>
    					</th>
    				</c:forEach>
  				</tr>
			</table--%> 
			<div class="form-group">
				<div class="col-lg-offset-0 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary" value ="Submit Report"/>
				</div>
			</div>
		</form:form>
		</div>
	</section>

</body>
</html>
