<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<script language='Javascript' src="<c:url value='/static/js/FusionCharts.js' />"></script>
<script language='Javascript' src="<c:url value='/static/js/radioCharts.js' />"></script>
<title>Innoassessment</title>
</head>
<body>
    <div class="myheader">
        Assessment Result
        <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
    </div>
    <%-- <H3>${dimensionList.toString()}</H3>
    <H3>${evaluationResultList.toString()}</H3> --%>
            <div id='chartContainer' style='text-align: center; padding-top: 1%;'>The chart will load here!</div>
        <script type='text/javascript'>
    	var productName = "${evaluation.productVersion.product.name}";
    	var dimensions = ${dimensionList.toString()};
    	var lineValues = ${evaluationResultList.toString()};        	
        	
            FusionCharts.setCurrentRenderer('javascript');
            
            var myChart1 = new FusionCharts( generateRadioChartData(productName, dimensions, lineValues) );
            myChart1.render('chartContainer');
        </script>
<a href='javascript:window.close()' style='text-decoration:none;'><button class = 'mybutton' style = 'display: block;'>Close</button></a>    </body>
</body>
</html>