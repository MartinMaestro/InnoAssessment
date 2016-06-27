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
    <a href="<c:url value='/assessment-product-search'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Select Assessment By Innovation Product -</a>
</td>
<tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/assessment-questionnaire-search'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Select Assessment By Questionnaire -</a>
</td>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">  
    <a href="<c:url value='/model-questionnaire'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Select Questionnaire By Innovation Product -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">
    <a href="<c:url value='/home-develop'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Develop -</a>
</td>
</tr>
<tr>
<td style="background: url(<c:url value='/static/images/option.png' />); height: 50px; width: 584px;">
    <a href="<c:url value='/home-administration'/>" style='padding-left: 30%; color: #ddebf6; text-decoration: none;'>- Administration -</a>
</td>
</tr>
</table>
</body>
</html>