<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href='/innoassessment/static/images/vitruvio.png' />
<title>Innoassessment</title>
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
<script type="text/javascript">
function showProductVersions(productId) {
	reloadPage('productId',productId);
}

function loadBuildQuestionnaire(questionnaireId){
	var selectBox = document.getElementById("ddlProductVersion");
    var productVersionId = selectBox.options[selectBox.selectedIndex].value;
	var url = '/innoassessment/build-questionnaire/'+questionnaireId + '?productVersionId='+productVersionId;
	window.location.href = url;
}

function reloadPage(param,value){
	param = param + "=" + value;
	var url = window.location.href; 
	if (url.indexOf('?') > -1){
		if (param.substring(0,8) == "productId"){
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


</head>

<body>
	<div class="container">
		<!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
		<div class="masthead">
			<h3 class="text-muted">Product Innovation Assessment Tool</h3>

			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="<c:url value='/home'/>">Home</a></li>
					<li><a href="<c:url value='/home-administration'/>">Administration</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Services</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Downloads</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">About</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Contact</a></li>
				</ul>
			</nav>
		</div>
		<p></p>
		<p></p>
		<p></p>

		<div class="row">
			<div class="col-sm-12" align="center">
				<p class="lead">
					Build Questionnaire <br> select one Product:
				</p>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12">
				<fieldset name='date_evaluation'>
					<legend>Evaluation Date</legend>
					<p />
					Model: <b>${questionnaireDetail.modelName}</b> - Questionnaire: <b>${questionnaireDetail.name}</b>
					Date: <input name='evaluation_date' value='${fecha}' /> Time: <input
						name='evaluation_time' value='${hora}' /> <input type='hidden'
						name='model' value='questionnaireDetail.modelId' /> <input
						type='hidden' name='questionnaire' value='questionnaireDetail.id' /><br>
					<br> <a
						href="<c:url value='/build-questionnaire-select-model/'/>">Change
						Model</a>
				</fieldset>

				<c:choose>
					<c:when test="${!empty param.productId && param.productId > 0}">
						<fieldset name='product_evaluation'>
							<legend>Product</legend>
							<p />
							Name: <b>${product.name}</b> - Description: <b>${product.description}</b>
							<input type='hidden' name='product' value='product.id' /><br>
							<br> <a
								href="<c:url value='/build-questionnaire-select-product/${questionnaireDetail.id}'/>">Change
								Product</a>
						</fieldset>
						<fieldset name='product_version'>
							<legend>Product Version</legend>
							<p />
							Select a version of the product: <select name="product"
								id="ddlProductVersion">
								<c:forEach items="${productVersionList}" var="productVersion"
									varStatus="status">
									<option value="${productVersion.id}">${productVersion.name}</option>
								</c:forEach>
							</select>
						</fieldset>
						<div class="row">
							<div class="col-sm-12" align="center">
								<button id='btn_submit' class='btn btn-primary'
									style='display: block;' type="submit" value="Submit"
									onclick="loadBuildQuestionnaire(${questionnaireDetail.id});">Build
									Questionnaire</button>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="myheader2" align='center'>Product List</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Product Id</th>
									<th>Model Name</th>
									<th>Model Description</th>
									<th>Model Provider</th>
									<th>#</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${productList}" var="product">
									<tr>
										<td>${product.id}</td>
										<td>${product.name}</td>
										<td>${product.description}</td>
										<td>${product.provider}</td>
										<td><input id="product" type='radio' name='product'
											value="${product.id}"
											onchange="showProductVersions(${product.id});"
											${param.productId==product.id?'checked':''}></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<!-- Site footer -->
	<footer class="footer">
		<p>© 2016 MiW, Inc.</p>
	</footer>
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.js'></script>

</body>
</html>