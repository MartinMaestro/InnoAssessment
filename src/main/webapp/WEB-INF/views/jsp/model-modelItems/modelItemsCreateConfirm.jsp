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

	<form:form method="post" action="/innoassessment/create-modelItems/${modelid}/dimension/${dimensionDetail.id}"
		modelAttribute="listFactor">
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
		<legend  align="center">Factor's list</legend>
		<p/>
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
				    <td><a href="<c:url value='/delete-factor/${factor.id}' />">delete</a></td>
				    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</fieldset>
	
		
		<fieldset name='factor_list'>
				<legend align="center">Factor's list</legend>
				<p />
				Select factors:
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
							<c:forEach items="${listFactor.factorList}" var="factor"
								varStatus="status">
								<tr>
									<td>${factor.id}</td>
									<td>${factor.name}</td>
									<td>${factor.definition}</td>
									<td><input type='checkbox'
										name='factorList[${status.index}].radioValue'
										value='${factor.id}'> <input type='hidden'
										name='factorList[${status.index}].id' value='${factor.id}' />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>
		
		<c:if test="${empty param.dimensionid }">
			<fieldset name='dimension'>
				<legend>Dimension</legend>
				<p />
				Select a dimension:
						</c:if>
		</fieldset>
		<c:if test="${!empty param.dimensionid && param.dimensionid > 0}">
			<fieldset name='dimensionDetail'>
				<legend>Dimension</legend>
				<p />
				Dimension: <b>${dimensionDetail.name}</b> <input type='hidden'
					name='dimensionDetail' value='dimensionDetail.id' /></br> <a
					href="<c:url value='/create-modelItems/${modelid}'/>">Change
					Dimension</a>
			</fieldset>
			</br>
			
			<p>
				<input type="submit" class="btn btn-default" style='display: block;'
					value="Next">
			</p>
		</c:if>
	</form:form>
	<a href="<c:url value="/home"/>">Home</a>
</body>
</html>