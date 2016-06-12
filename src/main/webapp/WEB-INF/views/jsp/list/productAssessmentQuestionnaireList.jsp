<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>

<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>


<script type="text/javascript">
function showQuestionnaires(modelId) {
	reloadPage('modelId='+modelId);
}

function showEvaluations(productVersionId) {
	reloadPage('productVersionId='+productVersionId);
}

function reloadPage(param){
	var url = window.location.href;    
	if (url.indexOf('?') > -1){
	   url += '&' + param
	}else{
	   url += '?' + param
	}
	window.location.href = url;
}
</script>
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
                    <td><a href="<c:url value='/search-productAssessmentQuestionnaire/${questionnaire.modelId}' />">Select</a></td>          
                	<td><input id="model" type='radio' name='model' value="${questionnaire.modelId}" onchange="showQuestionnaires(${questionnaire.modelId});" ${param.modelId==questionnaire.modelId?'checked':''}></td>			    				
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
                    <td><a href="<c:url value='/build-questionnaire/${questionnaireChoice.id}' />">Launch Questionnaire</a></td>          
                   
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