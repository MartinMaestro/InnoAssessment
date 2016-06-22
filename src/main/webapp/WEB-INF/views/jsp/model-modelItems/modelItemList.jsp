<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
	href="<c:url value='/static/images/vitruvio.png' />" />
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<link rel="stylesheet"
	href="<c:url value='/static/css/bootstrap.css' />">
<title>Innoassessment</title>
</head>

<body>
	<div class="myheader">
		Model Item <img
			src="<c:url value='/static/images/syst_logo.png' />" alt="" />
	</div>
	<div class="myheader2" align='center'>Model Item List</div>
	<div class="table-responsive">
	<table border="1" class="table table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Model Name</th>
				<th>Model Year</th>
				<th>Model Version</th>
				<th>Model Description</th>
				<th>Dimension Name</th>
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
					<td>${modelItem.modelName}</td>
					<td>${modelItem.modelYear}</td>
					<td>${modelItem.modelVersion}</td>
					<td>${modelItem.modelDescription}</td>
					<td>${modelItem.dimensionName}</td>
					<td>${modelItem.factorName}</td>
					<td>${modelItem.factorDefinition}</td>
					<td>${modelItem.impact}</td>
					<td>${modelItem.weight}</td>
					<td>${modelItem.interpretation}</td>
					<td>${modelItem.help}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	<p>
		<a href="<c:url value='/home'/>">Home</a>
	</p>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>