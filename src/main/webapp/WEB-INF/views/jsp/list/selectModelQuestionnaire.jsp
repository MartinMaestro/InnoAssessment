<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"  href="<c:url value='/static/images/bulb-favicon.png' />"/>
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.css' />">

<script type="text/javascript">
function showQuestionnaires(modelId) {
	reloadPage('modelId',modelId);
}

function reloadPage(param,value){
	param = param + "=" + value;
	var url = window.location.href; 
	if (url.indexOf('?') > -1){		
		if (param.substring(0,7) == "modelId"){
			var res = url.substring(0,url.indexOf('?'))
	 		url = res + '?' + param
		}
		else {
			url +=  '&' + param;
		}
	}else{
	   	url += '?' + param
	}
	window.location.href = url;
}


</script>
<title>Innoassessment</title>
</head>

<body>   
     <div class="myheader">
            Questionnaire Products
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
                	<td><input id="model" type='radio' name='model' value="${model.id}" onchange="showQuestionnaires(${model.id});" ${param.modelId==model.id?'checked':''}></td>			    				
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${!empty param.modelId && param.modelId > 0}">
    <div class="myheader2" align='center'>Questionnnaire</div>
    <table border="1" align='center' class="table table-bordered">
        <thead>
            <tr>
                <th>Questionnaire Id</th>
                <th>Questionnaire Name</th>
                <th>Questionnaire Version</th>
                <th>#</th>                                          
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questionnaireList}" var="questionnaire">
                <tr>
                    <td>${questionnaire.id}</td>
                    <td>${questionnaire.name}</td>
                    <td>${questionnaire.version}</td>
                    <td><a href="<c:url value='/questionnaire-product/${questionnaire.id}' />">Add Product</a></td>          
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>    
    </c:if>   
	<p><a href="<c:url value='/home'/>">Home</a></p>

</body>
</html>