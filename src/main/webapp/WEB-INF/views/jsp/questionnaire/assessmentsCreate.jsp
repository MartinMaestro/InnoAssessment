<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
	href="<c:url value='/static/images/vitruvio.png' />" />
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<link rel="stylesheet"
	href="<c:url value='/static/css/bootstrap.css' />">
<meta charset="utf-8">
<title>Innoassessment</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<div class="myheader">
		Model Item <img src="<c:url value='/static/images/syst_logo.png' />"
			alt="" />
	</div>

	<form:form method="post"
		action="/innoassessment/create-assessments/${questionnaireid}"
		modelAttribute="listModelItem">
		<fieldset name='questionnaire'>
			<legend>Questionnaire</legend>
			<p />
			Questionnaire: <b>${questionnaire.name}</b> - Version: <b>${questionnaire.version}</b></br>
			<input type='hidden' name='questionnaire' value='questionnaire' /> <a
				href="<c:url value='/questionnaire-select/'/>">Change
				Questionnaire</a>
		</fieldset>

		<fieldset name='modelItem_list'>
			<legend align="center">Model Item's list</legend>
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
			<input type="submit" class="btn btn-default" style='display: block;'
				value="Next">
		</p>
	</form:form>
	<a href="<c:url value="/home"/>">Home</a>
</body>
</html>