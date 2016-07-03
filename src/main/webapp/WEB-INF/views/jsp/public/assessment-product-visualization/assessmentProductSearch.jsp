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
				<p class="lead">Assessed Products</p>
			</div>
		</div>
	<div class="row">
	<div class="col-sm-12" align="center">
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
	<div align='center'><a href="<c:url value='/modern/assessment-product-search'/>">Reload Products</a></div>
    <p class="lead">Versions</p>
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
	<div align='center'><a href="<c:url value='/modern/assessment-product-search'>
				    	<c:param name="productId" value="${param.productId}"/>
				    </c:url>">Reload Versions</a></div>
    <p class="lead">Assessments</p>
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