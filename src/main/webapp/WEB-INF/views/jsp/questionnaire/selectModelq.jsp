<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"  href="<c:url value='/static/images/bulb-favicon.png' />"/>
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.css' />">

<title>Innoassessment</title>
</head>

<body>   
     <div class="myheader">
            Models
            <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
     </div>
   
    <div class="myheader2" align='center'>Model List</div>
    <table border="1" align='center' class="table table-bordered">
        <thead>
            <tr>
            	<th>Model Id</th>
                <th>Model Name</th>
                <th>Model Year</th>
                <th>Model Version</th>  
                <th>Model Description</th>
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
                	<td><a href="<c:url value='/create-questionnaire/${model.id}' />">Select Model</a></td>        
               </tr>
            </c:forEach>
        </tbody>
    </table>   
	<p><a href="<c:url value='/home'/>">Home</a></p>

</body>
</html>