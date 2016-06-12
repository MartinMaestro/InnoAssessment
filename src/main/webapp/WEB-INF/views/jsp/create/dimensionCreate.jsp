<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>
<meta charset="utf-8">
<title>Spring MVC. CreateDimension</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear una dimension</h1>
	<form:form action="create-dimension" modelAttribute="dimension">
		
		<p>Name:
			<form:input path="name" placeholder="Name" required="required" />
			<form:errors path="name" cssClass="error" />
		</p>
		<p><input type="submit" value="Crear"></p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>