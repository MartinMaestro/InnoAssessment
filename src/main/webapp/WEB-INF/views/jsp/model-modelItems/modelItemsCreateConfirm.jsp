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
 
	<form:form method="post" action="/innoassessment/create-modelItemsExecute" modelAttribute="listModelItem">
		<fieldset name='model'>
			<legend>Model</legend>
			<p />
			Model: <b>${model.name}</b> - Year: <b>${model.year}</b> - Version: <b>${model.version}</b></br>
			Description: <b>${model.description}</b></br> <input type='hidden'
				name='model' value='model.id' /> <a
				href="<c:url value='/model-select/'/>">Change Model</a>
		</fieldset>
		<fieldset name='dimensionDetail'>
			<legend>Dimension</legend>
			<p />
			Dimension: <b>${dimensionDetail.name}</b> <input type='hidden'
				name='dimensionDetail' value='dimensionDetail.id' /></br> <a
				href="<c:url value='/create-modelItems/${modelid}'/>">Change
				Dimension</a>
		</fieldset>

		<fieldset name='factor_list'>
			<legend align="center">Factor's list</legend>
			<p />
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
							<td><p>
							Weight:
							
							</p></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
		<fieldset name='modelItem_list'>
			<legend align="center">Model Item list</legend>
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
							
							<th>#</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listModelItem.modelItemList}" var="modelItem"
							varStatus="status">
							<tr>
								<td>${modelItem.modelId} - ${modelItem.modelName}
								<input type='hidden' name='modelItemList[${status.index}].modelId' value='${modelItem.modelId}' />
								</td>								
								<td>${modelItem.dimensionId} - ${modelItem.dimensionName}
								<input type='hidden' name='modelItemList[${status.index}].dimensionId' value='${modelItem.dimensionId}' />
								</td>
								<td>${modelItem.factorId} - - ${modelItem.factorName}
								<input type='hidden' name='modelItemList[${status.index}].factorId' value='${modelItem.factorId}' />
								</td>
								<th>
								<input value='${modelItem.impact}' name='modelItemList[${status.index}].impact'/>
								</th>
								<th>
								<input value='${modelItem.weight}' name='modelItemList[${status.index}].weight'/>
								</th>
								<td><input value='${modelItem.interpretation}' name='modelItemList[${status.index}].interpretation'/>
								</td>
								<td><input value='${modelItem.help}' name='modelItemList[${status.index}].help'/>
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