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
				<p class="lead">Create ModelItems Confirm</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<form:form method="post"
					action="/innoassessment/administration/create-modelitems-confirm"
					modelAttribute="listModelItem">
					<fieldset name='modelItem_list'>
						<legend>Model Item list</legend>
						<p />
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Model Id</th>
										<th>Dimension Id</th>
										<th>Factor Id</th>
										<th>Impact</th>
										<th>Weight</th>
										<th>Interpretation</th>
										<th>Help</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listModelItem.modelItemList}"
										var="modelItem" varStatus="status">
										<tr>
											<td>${modelItem.modelId}-${modelItem.modelName}<input
												type='hidden' name='modelItemList[${status.index}].modelId'
												value='${modelItem.modelId}' />
											</td>
											<td>${modelItem.dimensionId}-${modelItem.dimensionName}
												<input type='hidden'
												name='modelItemList[${status.index}].dimensionId'
												value='${modelItem.dimensionId}' />
											</td>
											<td>${modelItem.factorId}--${modelItem.factorName} <input
												type='hidden' name='modelItemList[${status.index}].factorId'
												value='${modelItem.factorId}' />
											</td>
											<th><input type='radio'
												name='modelItemList[${status.index}].impact' id='opcion0'
												value='Both' checked='checked'> <label for='opcion0'>Both</label>
												<input type='radio'
												name='modelItemList[${status.index}].impact' id='opcion1'
												value='Positive'> <label for='opcion1'>Positive</label>
												<input type='radio'
												name='modelItemList[${status.index}].impact' id='opcion2'
												value='Negative'> <label for='opcion2'>Negative</label>
											</th>
											<th><input value='${modelItem.weight}'
												name='modelItemList[${status.index}].weight'
												required="required" /></th>
											<td><textarea class=estilotextarea rows="2" cols="30"
													name='modelItemList[${status.index}].interpretation'>${modelItem.interpretation}</textarea>
											</td>
											<td><textarea class=estilotextarea rows="2" cols="30"
													name='modelItemList[${status.index}].help'>${modelItem.help}</textarea>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</fieldset>
					<p>
						<input type="submit" class="btn btn-primary"
							style='display: block;' value="Confirm">
					</p>

				</form:form>
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