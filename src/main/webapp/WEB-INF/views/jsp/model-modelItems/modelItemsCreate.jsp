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
<script type="text/javascript">
	function getValueDimension(){
		elem = document.getElementsByName('dimensioncheck');
		for (i = 0; i < elem.length; i++)
			if (elem[i].checked) {
				valor = elem[i].value;
			}
		return valor;
	}

	function getDimension(){
		var valor = getValueDimension();
		var url = window.location.href;
		url+= "?dimensionid=" + valor;
		window.location.href = url;
	}
	
	function getDimension2() {
		var valor = getValueDimension();
		var url = window.location.href;
		var url2 = url.substring(0, url.search("create-modelItems"));			
		var modelid = url.substr(url.search("create-modelItems")+ 18,1);
		var urlIni = url.substring(0, url.search("create-modelItems") + 17) + "2/";			
		urlIni += modelid;
		url = urlIni + "/dimension/" + valor;
		//alert("url: " + url);
		window.location.href = url;
	}
</script>
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

	<form:form method="post" action="/innoassessment/create-modelItems/${modelid}/dimension/${dimensionDetail.id} }"
		modelAttribute="listFactor">
		<fieldset name='model'>
			<legend>Model</legend>
			<p />
			Model: <b>${model.name}</b> - Year: <b>${model.year}</b> - Version: <b>${model.version}</b></br>
			Description: <b>${model.description}</b></br> <input type='hidden'
				name='model' value='model.id' /> <a
				href="<c:url value='/model-select/'/>">Change Model</a>
		</fieldset>
		<c:if test="${empty param.dimensionid }">
			<fieldset name='dimension'>
				<legend>Dimension</legend>
				<p />
				Select a dimension:
				<div class="table-responsive">
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
									<td><input type='radio' name='dimensioncheck'
										value='${dimension.id}' checked='checked'
										onclick="getDimension();"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
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
			<p>
				<input type="submit" class="btn btn-default" style='display: block;'
					value="Next">
			</p>
		</c:if>
	</form:form>
	<a href="<c:url value="/home"/>">Home</a>
</body>
</html>