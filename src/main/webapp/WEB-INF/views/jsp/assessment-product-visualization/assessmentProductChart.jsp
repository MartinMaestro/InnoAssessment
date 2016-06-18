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
<title>Innoassessment</title>
</head>
<body>
    <div class="myheader">
        Assessment Result
        <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
    </div>
    <H3>${dimensionList.toString()}</H3>
            <div id='chartContainer' style='text-align: center; padding-top: 1%;'>The chart will load here!</div>
        <script type='text/javascript'><!--
            FusionCharts.setCurrentRenderer('javascript');
            var myChart1 = new FusionCharts( 'Radar','chartId1', '1000', '700', '0');
            myChart1.setXMLData("<chart caption='Test 1' bgColor='FFFFFF' bgAlpha='50' anchoralpha='50' radarborderalpha='50' radarborderthickness='2' radarfillcolor='FFFFFF' yAxisMaxValue = '100'  bordercolor='000000' captionpadding='20' showlabels='1' drawanchors='0' showlimits='1' legendborderalpha='1' ><categories><category label='Organization' /><category label='Market' /><category label='Environment' /><category label='Technology' /></categories><dataset seriesName='Optimal Upper Limit Impact' alpha='25'><set value='100' /><set value='100' /><set value='100' /><set value='100' /></dataset><dataset seriesName='Upper Limit Impact' alpha='25' ><set value='100' /><set value='100' /><set value='97.777777777778' /><set value='100' /></dataset><dataset seriesName='Optimum Achievable Impact' alpha='25'><set value='100' /><set value='100' /><set value='100' /><set value='100' /></dataset><dataset seriesName='Maximum Achievable Impact' alpha='25'><set value='100' /><set value='100' /><set value='97.777777777778' /><set value='100' /></dataset><dataset seriesName='Real Impact' alpha='40'><set value='0' /><set value='14.225941422594' /><set value='22.222222222222' /><set value='1.9337016574586' /></dataset><dataset seriesName='Minimum Achievable Impact' color = '646464' alpha='30'><set value='20' /><set value='0' /><set value='0' /><set value='0' /></dataset><dataset seriesName='Lower Limit Impact' color = '000000' ><set value='20' /><set value='0' /><set value='0' /><set value='0' /></dataset></chart>");
            myChart1.render('chartContainer');
        // -->
        </script>
<a href='javascript:window.close()' style='text-decoration:none;'><button class = 'mybutton' style = 'display: block;'>Close</button></a>    </body>
</body>
</html>