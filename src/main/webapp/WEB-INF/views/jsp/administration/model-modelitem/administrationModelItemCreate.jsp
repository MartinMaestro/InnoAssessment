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
				<p class="lead">Create ModelItem</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12" align="center">
				<form:form action="administration-create-modelitem"
					modelAttribute="modelItem">
					<p>
						Impact: <input type='radio' name='impact' id='opcion0'
							value='Both' checked='checked'> <label for='opcion0'>Both</label>
						<input type='radio' name='impact' id='opcion1' value='Positive'>
						<label for='opcion1'>Positive</label> <input type='radio'
							name='impact' id='opcion2' value='Negative'> <label
							for='opcion2'>Negative</label>
					</p>
					<p>
						Weight:
						<form:input path="weight" placeholder="Weight" required="required" />
					</p>
					<p>
						Interpretation:
						<form:input path="interpretation" placeholder="Interpretation"
							required="required" />
					</p>
					<p>
						Help:
						<form:input path="help" placeholder="Help" required="required" />
					</p>
					<fieldset name='model_list'>
						<legend>Model list</legend>

						<table class="table table-bordered">
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
										<td><input id="model" type='radio' name='modelId'
											value="${model.id}"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</fieldset>
					<fieldset name='dimension_list'>
						<legend>Dimension list</legend>
						<p />
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>#</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dimensionList}" var="dimension">
									<tr>
										<td>${dimension.id}</td>
										<td>${dimension.name}</td>
										<td><input id="dimensionId" type='radio'
											name='dimensionId' value="${dimension.id}"></td>
										<!--  form:input path="dimensionId" type='radio' name = 'dimension' value="${dimension.id}"/-->

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</fieldset>
					<fieldset name='factor_list'>
						<legend>Factor list</legend>
						<p />
						<div class="table-responsive">

							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th>Definition</th>

										<th>#</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${factorList}" var="factor">
										<tr>
											<td>${factor.id}</td>
											<td>${factor.name}</td>
											<td>${factor.definition}</td>
											<td><input id="dimensionId" type='radio' name='factorId'
												value="${factor.id}"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</fieldset>
					<p>
						<input class="btn btn-primary" type="submit" value="Create »">
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