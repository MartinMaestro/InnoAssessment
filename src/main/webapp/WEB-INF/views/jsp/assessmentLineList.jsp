<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. assessmentLine List</title>
</head>

<body>
    <H1>assessmentLine List</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Active</th>
				
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${assessmentLineList}" var="assessmentLine">
				<tr>
					<td>${assessmentLine.Id}</td>
				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>