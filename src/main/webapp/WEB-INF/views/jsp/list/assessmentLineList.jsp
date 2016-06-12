<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>
<meta charset="utf-8">
<title>Spring MVC. assessmentLine List</title>
</head>

<body>
    <H1>assessmentLine List</H1>
	<table border="1">
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
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>