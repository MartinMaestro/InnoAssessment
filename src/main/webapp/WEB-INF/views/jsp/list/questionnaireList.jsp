<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. Questionnaire List List</title>
</head>

<body>
    <H1>Questionnaire List</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Version</th>
				<th>Model</th>				
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questionnaireList}" var="questionnaire">
				<tr>
					<td>${questionnaire.id}</td>
				    <td>${questionnaire.name}</td>
				    <td>${questionnaire.version}</td>
				    <td>${questionnaire.modelId}</td>				    
				    <td><a href="<c:url value='/delete-questionnaire/${questionnaire.id}' />">delete</a></td>
				    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>