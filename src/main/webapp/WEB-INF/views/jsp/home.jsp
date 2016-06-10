<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/bulb-favicon.png' />"/>
<meta charset="utf-8" />
<title>Innoassessment</title>
</head>
<body>
<h1>- INNOASSESSMENT -</h1>
    <p><a href="<c:url value='/assessmentLine-list'/>">- Lista de Assessment</a></p>
    <p><a href="<c:url value='/dimension-list'/>">- Lista de Dimension</a></p>
    <p><a href="<c:url value='/create-dimension'/>">- Crear una dimension</a></p>
    <p><a href="<c:url value='/product-list'/>">- Lista de Product</a></p>
    <p><a href="<c:url value='/productversion-list'/>">- Lista de Product Versions</a></p>
    <p><a href="<c:url value='/create-product'/>">- Crear Product</a></p>
    <p><a href="<c:url value='/model-list'/>">- Lista de Models</a></p>
    <p><a href="<c:url value='/create-model'/>">- Crear Models</a></p>
    <p><a href="<c:url value='/questionnaire-list'/>">- Lista questionarios</a></p>
    <p><a href="<c:url value='/productQuestionnaire-list'/>">- Asociar producto questionarios</a></p>
    <p><a href="<c:url value='/productAssesmentQuestionnaire-list'/>">- Product innovation assessment questionnaire</a></p>
    

</body>
</html>