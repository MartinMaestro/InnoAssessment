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
    <input name='model' value='${modelid}'/>
	
	<fieldset name='factor_list'>
		<legend  align="center">Factor's list</legend>
		<p/>
<form:form method="post" action = "/innoassesment/factor-select/${modelid}" modelAttribute="listFactor">		
	   
	    <input aligh = "right" type="submit" class="btn btn-default" style = 'display: block;' value="Add Factors">
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
		<c:forEach items="${listFactor.factorList}" var="factor" varStatus = "status">
			<tr>
					<td>${factor.id}</td>
				    <td>${factor.name}</td>
				    <td>${factor.definition}</td>	
				    <td> <input type='checkbox' name='factorList[${status.index}].radioValue' value='${factor.id}'></td>				    				
					<input type='hidden' name='factorList[${status.index}].id' value='${factor.id}'/>
			</tr>
			</c:forEach>		
		</tbody>
	</table>
	</fieldset>
</form:form>     
	
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>