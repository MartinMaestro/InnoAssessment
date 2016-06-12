<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>
<meta charset="utf-8">
<title>Spring MVC. ModelItem List</title>
</head>

<body>
    <H1>ModelItem List</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Version</th>
				<th>Model Name</th>
				<th>Model Version</th>  
				<th>Model Description</th>                             				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questionnaireList}" var="questionnaire">
				<tr>
					<td>${questionnaire.id}</td>
				    <td>${questionnaire.name}</td>
				    <td>${questionnaire.version}</td>
				    <td>${questionnaire.modelName}</td>
                    <td>${questionnaire.modelVersion}</td> 
                    <td>${questionnaire.modelDescription}</td>          
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>