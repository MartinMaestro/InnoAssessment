<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon"  href="<c:url value='/static/images/bulb-favicon.png' />"/>
<script type="text/javascript">
function showQuestionnaires(modelId) {
	reloadPage('modelId',modelId);
}

function showEvaluations(productVersionId) {
	reloadPage('productVersionId',productVersionId);
}

function existParam(param){
	var url = window.location.href; 
	return url.search(param)>0;
}

function changeFunc() {
	var selectBox = document.getElementById("ddlProduct");
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    //alert("changeFunc" + selectedValue);
    reloadPage('productId',selectedValue);
   }

function reloadPage(param,value){
	param = param + "=" + value;
	var url = window.location.href; 
	//alert("reloadPage: " + url + " - param:" + param);
	if (url.indexOf('?') > -1){
		if (existParam(param)){
			alert("si existe param")
		}
		if (param.substring(0,7) == "modelId"){
			//alert("param modelId" + param.substring(0,7));
	 	var res = url.substring(0,url.indexOf('?'))
	 	url = res + '?' + param
		}
		else {
			url +=  '&' + param;
		}
	}else{
	   	url += '?' + param
	}
	//alert("reloadPage2: " + url + " - param:" + param);
	window.location.href = url;
}


</script>
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<title>Innoassessment</title>
</head>

<body>   
     <div class="myheader">
            Questionnaire Products
            <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
     </div>
   
    <div class="myheader2" align='center'>Model List</div>
    <table border="1" align='center'>
        <thead>
            <tr>
            	<th>Model Id</th>
                <th>Model Name</th>
                <th>Model Year</th>
                <th>Model Version</th>  
                <th>Model Description</th>
                <th>#</th>                                             
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${modelList}" var="model">
                <tr>
                    <td>${model.id}</td>
                    <td>${model.name}</td>
                    <td>${model.year}</td>
                    <td>${model.version}</td>                   
                    <td>${model.description}</td>                   
                	<td><input id="model" type='radio' name='model' value="${model.id}" onchange="showQuestionnaires(${model.id});" ${param.modelId==model.id?'checked':''}></td>			    				
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${!empty param.modelId && param.modelId > 0}">
    <div class="myheader2" align='center'>Questionnnaire</div>
    <table border="1" align='center'>
        <thead>
            <tr>
                <th>Questionnaire Id</th>
                <th>Questionnaire Name</th>
                <th>Questionnaire Version</th>
                <th>#</th>                                          
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questionnaireList}" var="questionnaire">
                <tr>
                    <td>${questionnaire.id}</td>
                    <td>${questionnaire.name}</td>
                    <td>${questionnaire.version}</td>
                    <td><a href="<c:url value='/build-questionnaire/${questionnaire.id}' />">Launch Questionnaire</a></td>          
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="myheader2" align='center'>Select a Product
    	<select name="product" id = "ddlProduct" onchange="changeFunc();">
                <c:forEach items="${productList}" var="product" varStatus="status">
  					<option value="${product.id}">${product.name}</option>
				</c:forEach> 
		</select>
	</div>   
     <c:if test="${!empty param.productId && param.productId > 0}">
    	<div class="myheader2" align='center'>Select a Product Version
    	<select name="productVersion" id = "ddlProductVersion" onchange="changeFunc();">
                <c:forEach items="${productVersionList}" var="productVersion" varStatus="status">
  					<option value="${productVersion.id}">${productVersion.name} - ${productVersion.name}</option>
				</c:forEach> 
		</select>
       </div>
    </c:if>   
    
    </c:if>   
    
	
	<p><a href="<c:url value='/home'/>">Home</a></p>



</body>
</html>