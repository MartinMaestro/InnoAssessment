<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC.RegistrationSuccess</title>
</head>

<body>
	<H1>Creación de Dimension correcta</H1>

	<h3>La dimension ${dimension.name} ha sido creada satisfactoriamente</h3>

	<p><a href="<c:url value='/dimension-list' />">Ir a Lista de Dimensiones</a></p>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>