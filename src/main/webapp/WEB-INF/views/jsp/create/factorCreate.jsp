<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
	href="<c:url value='/static/images/vitruvio.png' />" />
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.css' />">
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
            Factor
            <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
     </div>

	<fieldset name='factor_create'>
		<legend>Create</legend>
		<p />
		<form:form action="create-factor" modelAttribute="factor">
			<p>
				Name:
				<form:input path="name" placeholder="Name" required="required" />
				<form:errors path="name" cssClass="error" />
			</p>
			<p>
				Definition:
				<form:input path="definition" placeholder="Definition" />
				<form:errors path="definition" cssClass="error" />
			</p>
			<p>
				<input type="submit" class="btn btn-default" style = 'display: block;' value="Create">
			</p>
		</form:form>
	</fieldset>

	<a href="<c:url value="/home"/>">Home</a>

</body>
</html>