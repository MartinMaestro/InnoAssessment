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
</head>

<body>
	<div class="container">
		<%@ include file="../../common/header.jsp" %> 	     
		<div class="row">
			<div class="col-sm-12" align="center">
				<p class="lead">Create ModelItems (massive)</p>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12" align="center">
				<form:form method="post" action="/innoassessment/administration/create-modelitems/${modelid}/dimension/${dimensionDetail.id}"
		modelAttribute="listFactor">
		<fieldset name='model'>
			<legend>Model</legend>
			<p />
			Model: <b>${model.name}</b> - Year: <b>${model.year}</b> - Version: <b>${model.version}</b><br>
			Description: <b>${model.description}</b><br> <input type='hidden'
				name='model' value='model.id' /> <a
				href="<c:url value='/administration/create-modelitems-select-model/'/>">Change Model</a>
		</fieldset>
		<c:if test="${empty param.dimensionid }">
			<fieldset name='dimension'>
				<legend>Dimension</legend>
				<p />
				Select one dimension:
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
										value='${dimension.id}' 
										onclick="getDimension();"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
		</fieldset>
		</c:if>
		
		<c:if test="${!empty param.dimensionid && param.dimensionid > 0}">
			<fieldset name='dimensionDetail'>
				<legend>Dimension</legend>
				<p/> 
				Dimension: <b>${dimensionDetail.name}</b> <input type='hidden'
					name='dimensionDetail' value='dimensionDetail.id' /><br> <a
					href="<c:url value='/administration/create-modelitems/${modelid}'/>">Change
					Dimension</a>
			</fieldset>
			<br>
			<fieldset name='factor_list'>
				<legend align="center">Factor's list</legend>
				<p />
				Select all the factors as you required, and click next:
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
									<td><input type='checkbox' name='factorList[${status.index}].radioValue' value='${factor.id}'> 
									<input type='hidden' name='factorList[${status.index}].id' value='${factor.id}' />
									<input type='hidden' name='factorList[${status.index}].name' value='${factor.name}' />
									<input type='hidden' name='factorList[${status.index}].definition' value='${factor.definition}' />
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
		</c:if>
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