<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>
<meta charset="utf-8">
<title>Spring MVC. CreateModel</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear model</h1>
	<form:form action="create-model" modelAttribute="model">
		
		<p>Name:
			<form:input path="name" placeholder="Name" required="required" />
			<form:errors path="name" cssClass="error" />
		</p>
		
		<p>Year:
            <form:input path="year" placeholder="Year" />
            <form:errors path="year" cssClass="error" />
        </p>
        
        <p>Version:
            <form:input path="version" placeholder="Version" />
            <form:errors path="version" cssClass="error" />
        </p>
        
        <p>Description:
            <form:input path="description" placeholder="Description" />
            <form:errors path="description" cssClass="error" />
        </p>
		<p><input type="submit" value="Create"></p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>