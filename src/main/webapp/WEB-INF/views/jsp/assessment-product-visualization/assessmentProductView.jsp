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
    <script language='Javascript' src="<c:url value='/static/js/overlib.js' />"></script>
    <script language='Javascript' src="<c:url value='/static/js/tabs.js' />"></script>
<title>Innoassessment</title>
</head>
<body>    
	<div class="myheader">
        Product innovation assessment questionnaire results
        <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
    </div>
    <fieldset name='date_evaluation'>
        <legend>Evaluation Datse</legend><p />
        Model: <b>${evaluation.questionnaire.model.name}                </b> - Questionnaire: <b>${evaluation.questionnaire.name}</b>
        Time Stamp: <b>${evaluation.creationTimeStamp}</b>
    </fieldset>
    <fieldset name='product_information'>
        <legend>Product details</legend><p />
        <table>
            <tr>
            <td align='right'>Name:</td>
            <td><b>${evaluation.productVersion.product.name}</b></td>
            </tr>
            <tr>
            <td align='right'>Version:</td>
            <td><b>${evaluation.productVersion.name}</b></td>
            </tr>
            <tr>
            <td align='right'>Provider:</td>
            <td><b>${evaluation.productVersion.product.provider}</b></td>
            </tr>
            <tr>
            <td align='right'>Description:</td>
            <td><b>${evaluation.productVersion.description}</b></td>
            </tr>
        </table>
    </fieldset>
    <div id='pestanas'>
    	<c:forEach items="${dimensionList}" var="dimension" varStatus="status">
    		<input id='btn${status.index}' type='button' class='tab' style='border: none;' onClick="changeTabs2('pesta', ${dimensionList.size()},${status.index}, 'btn');/*changeTabs2('pestaEdit', 4,${status.index}, 'btnEdit');*/" value='${dimension.name}'>
    	</c:forEach>
		<div id='cont' style='border: 1px solid #4682B4;border-radius: 8px;padding: 1%;margin-top: -0.9%;'>		
    	<c:forEach items="${dimensionList}" var="dimension" varStatus="status">
			<div id='pesta${status.index}' style='display:none;'>
                  <table style='width: 100%;'>
                          <tr>
                              <td rowspan='2' style='padding-left: 7%; width:40%;'>
                                  <table border='3' cellpadding='10' style='text-align: center; border-color: #4682B4; width: 50%;'>
                                      <tr>
                                          <th rowspan = '2'>Factor</th>
                                          <th rowspan = '2'>Value</th>
                                          <th rowspan = '2'>Impact</th>
                                          <th rowspan = '2'>Weight</th>
                                          <th colspan = '2'>Sources</th>
                                      </tr>
                                      <tr>
                                          <th>URLs</th>
                                          <th>Files</th>
                                      </tr>
                                      <c:forEach items="${lineValueList}" var="lineValue">
                                      	<c:if test="${lineValue.evaluationResult.dimension.name == dimension.name}">
	                                      	<tr>
	                                      		<td>${lineValue.assessmentLine.modelItem.factor.name}</td>
                                                <td>${lineValue.valueName.name}</td>
                                                <td>${lineValue.assessmentLine.modelItem.impact}</td>
                                                <td>${lineValue.assessmentLine.modelItem.weight}</td>
                                                <td>
                                                	<c:forEach items="${lineValueList.sourcesUrls}" var="sourceUrl" varStatus="sourceUrlStatus">
                                                		${sourceUrlStatus.index}.  <a href="${sourceUrl.url}">${sourceUrl.url}</a>
                                                	</c:forEach>
                                                </td>
                                                <td>
                                                	<c:forEach items="${lineValueList.sourcesFiles}" var="sourcesFile" varStatus="sourcesFileStatus">
                                                		${sourcesFileStatus.index}.  <a href="/file/${sourcesFile.id}">${sourcesFile.name}</a>
                                                	</c:forEach> 
                                                </td>                                        
	                                      	</tr>
                                      	</c:if>
                                      </c:forEach>
								</table>
			    		</td>
                         <td valign = 'top'>
                             <table border='3' cellpadding='5' style='text-align: center; border-color: #4682B4;' align='center' valign='top'>
                                 <tr><th>Resulting impact</th><th>Value</th>
                                 <script>
                                 	dimension${dimension.id} = {};
                                 </script>
                                 <c:forEach items="${evaluationResultList}" var="evaluationResult">
                                 	<c:if test="${evaluationResult.dimension.name == dimension.name}">
                                 		<tr><td style='text-align: left;'>${evaluationResult.evaluationResultType.name}</td><td>${evaluationResult.value}</td></tr>
                                 		<script>
                                 			dimension${dimension.id}['${evaluationResult.evaluationResultType}'] = ${evaluationResult.value};
                                 		</script>
                                 	</c:if>
                                 </c:forEach>
                             </table>
                             <div id='chartContainer${status.index}' style='text-align: center; padding-top: 1%;'>The chart will load here!</div>
                             <script>
                             	
                                 chartValues[${status.index}] = "<chart caption='${dimension.name}' yAxisMaxValue='"+Math.round(dimension${dimension.id}['OPTIMUM_LIMIT_IMPACT']*110)/100+"' yAxisMinValue='0' ><set label='Maximum achievable impact' value='"+dimension${dimension.id}['MAXIMUM_ACHIEVABLE_IMPACT']+"' /><set label='Optimum achievable impact' value='"+dimension${dimension.id}['OPTIMUM_ACHIEVABLE_IMPACT']+"' /><set label='Minimum achievable impact' value='"+dimension${dimension.id}['MINIMUM_ACHIEVABLE_IMPACT']+"' /><trendlines><line startValue='"+dimension${dimension.id}['UPPER_LIMIT_IMPACT']+"' color='FF0000' displayValue='Upper Limit Impact' showOnTop='1'  thickness='3'/><line startValue='"+dimension${dimension.id}['REAL_DIMENSION_IMPACT']+"' color='91C728' displayValue='Real Impact' showOnTop='1'  thickness='3'/><line startValue='"+dimension${dimension.id}['LOWER_LIMIT_IMPACT']+"' color='FF0000' displayValue='Lower Limit Impact' showOnTop='1'  thickness='3'/></trendlines></chart>";
                                 chartDivs[${status.index}] = "chartContainer${status.index}";
                             </script>
                         </td>
                         <td valign='top'>
                             <button type='button' style='color: #4682B4; font-weight: bold; font-size: 100%; height: 26px; width: 70px;padding-right: 0px;' onclick="showDiv2('editDiv')">Edit</button>
                         </td>
                     </tr>
           		</table>                        
           	</div>
	    </c:forEach>   
	    </div>
    </div>
    <table style="width:100%;">
       <tbody>
            <tr>
                <td align="right" style="width:60%;">
	    <a href="<c:url value='/assessment-product-chart'>
					<c:param name="evaluationId" value="${param.evaluationId}"/>
			    </c:url>" style="text-decoration:none;" target="_blank"><button type="button" class="mybutton" style="display: block; margin-right: 2%;">Show Assessment Result</button></a>
                </td>
               <td align="left">
                   <button type="button" class="mybutton" style="display: block; margin-left: 2%;" onclick="location.href='javascript:history.back();'" ;="">Back</button>
               </td>
           </tr>
       </tbody>
    </table>
        <script>
            window.onload = changeTabs2('pesta', 0, 0, 'btn'); 
        </script>	    
	<button class = 'mybutton' type='button' style = 'display: block;' onclick="location.href='/innoassessment/home'">Go to the beginning</button>
</body>
</html>