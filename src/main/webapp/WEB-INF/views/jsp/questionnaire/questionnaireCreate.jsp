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
		Questionnaire <img
			src="<c:url value='/static/images/syst_logo.png' />" alt="" />
	</div>

	<form:form method="post"
		action="/innoassessment/create-questionnaire/${modelid}"
		modelAttribute="questionnaire">
		<fieldset name='model'>
			<legend>Model</legend>
			<p />
			Model: <b>${model.name}</b> - Year: <b>${model.year}</b> - Version: <b>${model.version}</b><br>
			Description: <b>${model.description}</b><br> <input type='hidden'
				name='model' value='model.id' /> <a
				href="<c:url value='/modelq-select/'/>">Change Model</a>
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
		<input type="submit" class="btn btn-default" style='display: block;'
			value="Create">
	</form:form>
	<a href="<c:url value="/home"/>">Home</a>
</body>
</html>