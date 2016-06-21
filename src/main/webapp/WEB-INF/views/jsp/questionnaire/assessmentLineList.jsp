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
		Assessment <img
			src="<c:url value='/static/images/syst_logo.png' />" alt="" />
	</div>
	<div class="myheader2" align='center'>Assessment List</div>
	<div class="table-responsive">
		<table border="1" class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>modelItemModelName</th>
					<th>modelItemDimensionName</th>
					<th>modelItemFactorName</th>
					<th>modelItemImpact</th>
					<th>modelItemWeight</th>
					<th>modelItemInterpretation</th>
					<th>modelItemHelp</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${assessmentLineList}" var="assessmentLine">
					<tr>
						<td>${assessmentLine.id}</td>
						<td>${assessmentLine.modelItemModelName}</td>
						<td>${assessmentLine.modelItemDimensionName}</td>
						<td>${assessmentLine.modelItemFactorName}</td>
						<td>${assessmentLine.modelItemImpact}</td>
						<td>${assessmentLine.modelItemWeight}</td>
						<td>${assessmentLine.modelItemInterpretation}</td>
						<td>${assessmentLine.modelItemHelp}</td>
						<td></td>
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