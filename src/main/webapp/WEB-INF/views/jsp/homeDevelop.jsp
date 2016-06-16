<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<title>Innoassessment</title>
</head>
<body>
        <div class="myheader">
            InnoAssessment
            <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
        </div><h3 style='text-align: center; font-weight: normal;'><i style='border: double; padding: 2px 10px 2px 10px; border-radius: 8px;'>Product Innovation Assessment Tool</i></h3>
<table align='center' >

<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">
    <a href="<c:url value='/assessmentLine-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Lista de Assessment -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/dimension-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Lista de Dimension -</a>
</td>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/create-dimension'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Crear una dimension -</a>
</td>
</tr>
<tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/factor-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Lista de Factores -</a>
</td>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/create-factor'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Crear Factor -</a>
</td>
</tr>
<tr>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/product-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Lista de Product -</a>
</td>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/create-product'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Crear Product -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/productversion-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Lista de Product Versions -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/model-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Lista de Models -</a>
</td>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/create-model'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Crear Models -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/modelitem-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Model Item List -</a>
</td>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/create-modelItem'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Crear Model Items -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/questionnaire-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Lista questionarios -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/productQuestionnaire-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Asociar producto questionarios -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/productAssesmentQuestionnaire-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Product innovation assessment questionnaire -</a>
</td>
</tr>

<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/assessmentlinedimension-list'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Lista de Assessment by dimension -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/assessment-product'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Select Assessment By Innovation Product -</a>
</td>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/questionnaire-product'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Select Questionnaire By Innovation Product -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/build-questionnaireDimensions/'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- BuidQuestionnaire Dimensions -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/build-questionnaireDimensions'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- TEMP  BuidQuestionnaire Dimensions -</a>
</td>
</tr>

</table>
</body>
</html>