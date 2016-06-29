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
		action="/innoassessment/create-modelItemsExecute"
		modelAttribute="listModelItem">
		<fieldset name='modelItem_list'>
			<legend >Model Item list</legend>
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
						<c:forEach items="${listModelItem.modelItemList}" var="modelItem"
							varStatus="status">
							<tr>
								<td>${modelItem.modelId}-${modelItem.modelName} <input
									type='hidden' name='modelItemList[${status.index}].modelId'
									value='${modelItem.modelId}' />
								</td>
								<td>${modelItem.dimensionId}-${modelItem.dimensionName} <input
									type='hidden' name='modelItemList[${status.index}].dimensionId'
									value='${modelItem.dimensionId}' />
								</td>
								<td>${modelItem.factorId}-- ${modelItem.factorName} <input
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
			<input type="submit" class="btn btn-default" style='display: block;'
				value="Confirm">
		</p>

	</form:form>
	<a href="<c:url value="/home"/>">Home</a>
</body>
</html>