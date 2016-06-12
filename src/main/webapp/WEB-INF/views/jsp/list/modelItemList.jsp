<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
	href="<c:url value='/static/images/vitruvio.png' />" />
<meta charset="utf-8">
<title>Spring MVC. ModelItem List</title>
</head>

<body>
	<H1>ModelItem List</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Model Id</th>
				<th>Model Name</th>
				<th>Model Year</th>
				<th>Model Version</th>
				<th>Model Description</th>
				<th>Dimension Id</th>
				<th>Dimension Name</th>
				<th>Factor Id</th>
				<th>Factor Name</th>
				<th>Factor Definition</th>
				<th>Impact</th>
				<th>Weight</th>
				<th>Interpretation</th>
				<th>Help</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${modelItemList}" var="modelItem">
				<tr>
					<td>${modelItem.id}</td>
					<td>${modelItem.modelId}</td>
					<td>${modelItem.modelName}</td>
					<td>${modelItem.modelYear}</td>
					<td>${modelItem.modelVersion}</td>
					<td>${modelItem.modelDescription}</td>
					<td>${modelItem.dimensionId}</td>
					<td>${modelItem.dimensionName}</td>
					<td>${modelItem.factorId}</td>
					<td>${modelItem.factorName}</td>
					<td>${modelItem.factorDefinition}</td>
					<td>${modelItem.impact}</td>
					<td>${modelItem.weight}</td>
					<td>${modelItem.factorName}</td>
					<td>${modelItem.interpretation}</td>
					<td>${modelItem.help}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="<c:url value='/home'/>">Home</a>
	</p>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>