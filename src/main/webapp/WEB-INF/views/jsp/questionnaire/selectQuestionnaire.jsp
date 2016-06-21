<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"  href="<c:url value='/static/images/vitruvio.png' />"/>
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.css' />">

<title>Innoassessment</title>
</head>

<body>   
     <div class="myheader">
            Questionnaire
            <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
     </div>
   
    <div class="myheader2" align='center'>Questionnaire List</div>
   <table border="1" align='center' class="table table-bordered">
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
					<td><a href="<c:url value='/create-assessments/${questionnaire.id}'/>">Select</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>   
	<p><a href="<c:url value='/home'/>">Home</a></p>

</body>
</html>