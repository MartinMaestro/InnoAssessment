<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
 href="<c:url value='/static/images/bulb-favicon.png' />"/>
<script type="text/javascript">
function showProductVersions(productId) {
	reloadPage('productId='+productId);
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
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<title>Innoassessment</title>
</head>
<body>
        <div class="myheader">
            Assessed Products
            <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
        </div>
	<table border="1" align='center'>
		<thead>
			<tr align='center'>
				<th>Id</th>
				<th>Name</th>
				<th>Select</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="product">
				<tr align='center'>
					<td>${product.id}</td>
				    <td>${product.name}</td>
            		<td><input id="product" type='radio' name='product' value="${product.id}" onchange="showProductVersions(${product.id});" ${param.productId==product.id?'checked':''}></td>			    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${!empty param.productId && param.productId > 0}">
	<div align='center'><a href="<c:url value='/assessment-product'/>">Reload Products</a></div>
    <H3 align='center'>Versions</H3>
	<table border="1" align='center'>
		<thead>
			<tr align='center'>
				<th>Id</th>
				<th>Name</th>
				<th>Select</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productVersionList}" var="productVersion">
				<tr align='center'>
					<td>${productVersion.id}</td>
				    <td>${productVersion.name}</td>
            		<td><input id="productVersion" type='radio' name='productVersion' value="${productVersion.id}" onchange="showEvaluations(${productVersion.id});" ${param.productVersionId==productVersion.id?'checked':''}></td>			    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${!empty param.productVersionId && param.productVersionId > 0}">
	<div align='center'><a href="<c:url value='/assessment-product'>
				    	<c:param name="productId" value="${param.productId}"/>
				    </c:url>">Reload Versions</a></div>
    <H3 align='center'>Assessments</H3>
	<table border="1" align='center'>
		<thead>
			<tr align='center'>
				<th>Id</th>
				<th>Questionnaire</th>
				<th>Creation Date</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${evaluationList}" var="evaluation">
				<tr align='center'>
					<td>${evaluation.id}</td>
				    <td>${evaluation.questionnaire.name}</td>	
				    <td>${evaluation.creationTimeStamp}</td>	
				    <td><a href="<c:url value='/show-assessment'>
				    	<c:param name="evaluationId" value="${evaluation.id}"/>
				    </c:url>">Show Assessment</a></td>		    				
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	</c:if>
	</c:if>
	<button class = 'mybutton' type='button' style = 'display: block;' onclick="location.href='/innoassessment/home'";>Go to the begining</button>
</body>	
</html>