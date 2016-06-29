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
				<p class="lead">Create Assessment</p>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12" align="center">
				<form:form method="post"
		action="/innoassessment/administration-create-assessments/${questionnaireid}"
		modelAttribute="listModelItem">
		<fieldset name='questionnaire'>
			<legend>Questionnaire</legend>
			<p />
			Questionnaire: <b>${questionnaire.name}</b> - Version: <b>${questionnaire.version}</b><br>
			<input type='hidden' name='questionnaire' value='questionnaire' /> <a
				href="<c:url value='/administration-create-assessment-select-questionnaire/'/>">Change
				Questionnaire</a>
		</fieldset>

		<fieldset name='modelItem_list'>
			<legend >Model Item's list</legend>
			<p />
			Select all the model Items as you required, and click next:
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>Model Name</th>
							<th>Model Version</th>
							<th>Dimension Name</th>
							<th>Factor Name</th>
							<th>Impact</th>
							<th>Weight</th>
							<th>Interpretation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listModelItem.modelItemList}" var="modelItem"
							varStatus="status">
							<tr>
								<td>${modelItem.id}</td>
								<td>${modelItem.modelName}</td>
								<td>${modelItem.modelVersion}</td>
								<td>${modelItem.dimensionName}</td>
								<td>${modelItem.factorName}</td>
								<td>${modelItem.impact}</td>
								<td>${modelItem.weight}</td>
								<td>${modelItem.interpretation}</td>
								<td><input type='checkbox'
									name='modelItemList[${status.index}].radioValue'
									value='${modelItem.id}'> <input type='hidden'
									name='modelItemList[${status.index}].id'
									value='${modelItem.id}' />
									<input type='hidden'
									name='modelItemList[${status.index}].impact'
									value='${modelItem.impact}' />
									</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
		<p>
			<input class="btn btn-primary" type="submit" value="Next »">
		</p>
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