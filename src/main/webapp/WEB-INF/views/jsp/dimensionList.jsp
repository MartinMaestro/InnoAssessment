<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. dimension List</title>
</head>

<body>
    <H1>dimension List</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dimensionList}" var="dimension">
				<tr>
					<td>${dimension.Id}</td>
				    <td>${dimension.name}</td>
				    <td><a href="<c:url value='/delete-dimension/${dimension.Id}' />">delete</a></td>
				    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>