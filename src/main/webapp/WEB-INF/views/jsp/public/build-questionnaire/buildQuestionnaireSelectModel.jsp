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
				<p class="lead">Build Questionnaire <br> select one Model:</p>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12">
				<table class="table table-bordered text-center">
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
								<td><input id="model" type='radio' name='model'
									value="${model.id}" onchange="showQuestionnaires(${model.id});"
									${param.modelId==model.id?'checked':''}></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${!empty param.modelId && param.modelId > 0}">
					<div class="myheader2" align='center'>Questionnnaire</div>
					<table class="table table-bordered">
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
									<td><a
										href="<c:url value='/build-questionnaire-select-product/${questionnaire.id}' />">Add
											Product</a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>

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