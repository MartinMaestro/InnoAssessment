<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>
<script type="text/javascript">
function showQuestonnaires(modelId) {
	reloadPage('modelId='+modelId);
}

function showEvaluations(questionnaireId) {
	reloadPage('questionnaireId='+questionnaireId);
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
<!-- Bootstrap core CSS -->
<link href='/innoassessment/static/modernStyle/bootstrap.min.css'
	rel="stylesheet">
<link href='/innoassessment/static/css/estilo.css' rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.css'
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href='/innoassessment/static/modernStyle/justified-nav.css'
	rel="stylesheet">
<script
	src='/innoassessment/static/modernStyle/ie-emulation-modes-warning.js'></script>
<title>Innoassessment</title>
</head>
<body>
<div class="container">
		<%@ include file="../../common/header.jsp" %> 
		<div class="row">
			<div class="col-sm-12" align="center">
				<p class="lead">Models</p>
			</div>
		</div>
	<div class="row">
	<div class="col-sm-12" align="center">
	<table border="1" align='center'>
		<thead>
			<tr align='center'>
				<th>Id</th>
				<th>Name</th>
				<th>Date</th>
				<th>Description</th>
				<th>Select</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${modelList}" var="model">
				<tr align='center'>
					<td>${model.id}</td>
				    <td>${model.name}</td>
				    <td>${model.year}</td>
				    <td>${model.description}</td>
            		<td><input id="model" type='radio' name='model' value="${model.id}" onchange="showQuestonnaires(${model.id});" ${param.modelId==model.id?'checked':''}></td>			    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${!empty param.modelId && param.modelId > 0}">
	<div align='center'><a href="<c:url value='/modern/assessment-questionnaire-search'/>">Reload Models</a></div>
    <H3 align='center'>Questionnaires</H3>
	<table border="1" align='center'>
		<thead>
			<tr align='center'>
				<th>Id</th>
				<th>Name</th>
				<th>Version</th>
				<th>Select</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${questionnaireList}" var="questionnaire">
				<tr align='center'>
					<td>${questionnaire.id}</td>
				    <td>${questionnaire.name}</td>
				    <td>${questionnaire.version}</td>
            		<td><input id="questionnaire" type='radio' name='questionnaire' value="${questionnaire.id}" onchange="showEvaluations(${questionnaire.id});" ${param.questionnaireId==questionnaire.id?'checked':''}></td>			    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${!empty param.questionnaireId && param.questionnaireId > 0}">
	<div align='center'><a href="<c:url value='/modern/assessment-questionnaire-search'>
				    	<c:param name="modelId" value="${param.modelId}"/>
				    </c:url>">Reload Questionnaires</a></div>
    <H3 align='center'>Assessments</H3>
	<table border="1" align='center'>
		<thead>
			<tr align='center'>
				<th>Id</th>
				<th>Product</th>
				<th>Creation Date</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${evaluationList}" var="evaluation">
				<tr align='center'>
					<td>${evaluation.id}</td>
				    <td>${evaluation.productVersion.product.name}</td>	
				    <td>${evaluation.creationTimeStamp}</td>	
				    <td><a href="<c:url value='/modern/assessment-product-view'>
				    	<c:param name="evaluationId" value="${evaluation.id}"/>
				    </c:url>">Show Assessment</a></td>		    				
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	</c:if>
	</c:if>
	</div>
	</div>
	<%@ include file="../../common/footer.jsp" %> 
	</div>
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.js'></script>
</body>	
</html>