<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. Model List</title>
</head>

<body>
    <H1>Model List</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Year</th>
				<th>Version</th>
				<th>Description</th>				
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${modelList}" var="model">
				<tr>
					<td>${model.id}</td>
				    <td>${model.name}</td>
				    <td>${model.year}</td>
				    <td>${model.version}</td>
				    <td>${model.description}</td>				    
				    <td><a href="<c:url value='/delete-model/${model.id}' />">delete</a></td>
				    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>