<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/bulb-favicon.png' />"/>
<meta charset="utf-8">
<title>Spring MVC. Asociate Product questionaire</title>
</head>

<body>   
    
    <H1>Product questionaire</H1>
    
    <H2>Model List</H2>
    <table border="1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Version</th>
                <th>Model Name</th>
                <th>Model Year</th>
                <th>Model Version</th>  
                <th>Model Description</th>
                <th>#</th>                                          
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questionnaireList}" var="questionnaire">
                <tr>
                    <td>${questionnaire.id}</td>
                    <td>${questionnaire.name}</td>
                    <td>${questionnaire.version}</td>                   
                    <td>${questionnaire.modelName}</td>
                    <td>${questionnaire.modelYear}</td>
                    <td>${questionnaire.modelVersion}</td> 
                    <td>${questionnaire.modelDescription}</td>
                    <td><a href="<c:url value='/search-questionnaire/${questionnaire.modelId}' />">Select</a></td>          
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <H2>Questionnnaire</H2>
    <table border="1">
        <thead>
            <tr>
                <th>Questionnaire Id</th>
                <th>Questionnaire Name</th>
                <th>Questionnaire Version</th>
                <th>#</th>                                          
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questionnaireListChoice}" var="questionnaireChoice">
                <tr>
                    <td>${questionnaireChoice.id}</td>
                    <td>${questionnaireChoice.name}</td>
                    <td>${questionnaireChoice.version}</td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <%
    
    out.println("PRUEBA <b>"+request. getParameter("questionnaire.id")+"</b>!");
   
%>
	
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>