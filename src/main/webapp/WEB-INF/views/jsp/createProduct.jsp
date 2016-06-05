<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. CreateProduct</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear producto</h1>
	<form:form action="create-product" modelAttribute="product">
		<p>Description:
            <form:input path="description" placeholder="Description" />
            <form:errors path="description" cssClass="error" />
        </p>
		
		<p>Name:
			<form:input path="name" placeholder="Name" required="required" />
			<form:errors path="name" cssClass="error" />
		</p>
		
		<p>Provider:
            <form:input path="provider" placeholder="Provider" />
            <form:errors path="provider" cssClass="error" />
        </p>
        
        <p>Version:
            <form:input path="version" placeholder="Version" />
            <form:errors path="version" cssClass="error" />
        </p>
		<p><input type="submit" value="Create"></p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>