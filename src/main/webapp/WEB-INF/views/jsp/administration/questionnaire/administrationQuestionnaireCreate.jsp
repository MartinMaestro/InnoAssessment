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
</head>

<body>
	<div class="container">
		<%@ include file="../../common/header.jsp" %> 	     
		<div class="row">
			<div class="col-sm-12" align="center">
				<p class="lead">Create Questionnaire</p>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12" align="center">
				<form:form method="post"
					action="/innoassessment/administration-create-questionnaire/${modelid}"
					modelAttribute="questionnaire">
					<fieldset name='model'>
						<legend>Model</legend>
						<p />
						Model: <b>${model.name}</b> <br>
						Year: <b>${model.year}</b> <br>
						Version: <b>${model.version}</b><br> 						
						Description: <b>${model.description}</b><br>
						<input type='hidden' name='model' value='model.id' /> <a
							href="<c:url value='/administration-create-questionnaire-select-model/'/>">Change Model</a>
					</fieldset>
					<fieldset name='questionnaire'>
						<legend>Fill the questionnaire details</legend>
						<p>
							Name:
							<form:input path="name" placeholder="Name" required="required" />
							<form:errors path="name" cssClass="error" />
						</p>
						<p>
							Version:
							<form:input path="version" placeholder="Version" />
							<form:errors path="version" cssClass="error" />
						</p>
					</fieldset>
					<input class="btn btn-primary" type="submit" value="Create »">
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>  
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.js'></script>

</body>
</html>