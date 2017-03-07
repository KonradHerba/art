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
					<h1>Reports</h1>
					<p>List of all Amartus time reports</p>
                </div>
            </div>

      </section>
      <section class="container">
          <h3>Reports' list:</h3>
            <table width="100%">
              <tr>
                <th width="20%" style="text-align:center">Name</th>
                <th width="20%" style="text-align:center">Lastname</th>
                <th width="20%" style="text-align:center">Date</th>
                <th width="20%" style="text-align:center">Project</th>
                <th width="20%" style="text-align:center">Hours</th>
              </tr> 
            <c:forEach items="${reports}" var="report">
                  <tr>                                                  
                    <td><p style="text-align:center">${report.employee.name}</p></td>
                    <td><p style="text-align:center">${report.employee.lastname}</p></td>
                    <td><p style="text-align:center">${report.date}</p></td>
                    <td><p style="text-align:center">${report.projectName}</p></td>
                    <td><p style="text-align:center">${report.reportedTime}</p></td>
                  </tr>
            </c:forEach>
          </table>
      </section>
   </body>
</html>