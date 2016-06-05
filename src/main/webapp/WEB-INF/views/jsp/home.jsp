<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8" />
<title>Innoassessment</title>
</head>
<body>
<h1>Este es nuestro primer Home - INNOASSESSMENT</h1>
    <p><a href="<c:url value='/assessmentLine-list'/>">- Lista de Assessment</a></p>
    <p><a href="<c:url value='/dimension-list'/>">- Lista de Dimension</a></p>
    <p><a href="<c:url value='/create-dimension'/>">- Crear una dimension</a></p>
     <p><a href="<c:url value='/product-list'/>">- Lista de Product</a></p>
    <p><a href="<c:url value='/create-product'/>">- Crear Product</a></p>
    

</body>
</html>