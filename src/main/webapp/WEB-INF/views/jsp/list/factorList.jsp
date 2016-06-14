<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>
 <link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
  <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.css' />">
 
<meta charset="utf-8">
<title>Innoassessment</title>
</head>

<body>
<div class="myheader">
            Factor
            <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
     </div>
	</br>
	<fieldset name='factor_list'>
		<legend  align="center">Factor's list</legend>
		<p/>
		<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Definition</th>
				
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${factorList}" var="factor">
				<tr>
					<td>${factor.id}</td>
				    <td>${factor.name}</td>
				    <td>${factor.definition}</td>				    
				    <td><a href="<c:url value='/delete-factor/${factor.id}' />">delete</a></td>
				    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</fieldset>

	
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>