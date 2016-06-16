<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
	href="<c:url value='/static/images/vitruvio.png' />" />
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.css' />">
<meta charset="utf-8">
<title>Innoassessment</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	 <div class="myheader">
            Model Item
            <img src="<c:url value='/static/images/syst_logo.png' />" alt="" />
     </div>

	<fieldset name='modelItem_create'>
		<legend>Create</legend>
		<p />
		<form:form action="create-modelItem" modelAttribute="modelItem">
			<p>
				Impact:
				<form:input path="impact" placeholder="Impact" required="required" />
			</p>
			<p>
				Weight:
				<form:input path="weight" placeholder="Weight" required="required" />
			</p>
			<p>
				Interpretation:
				<form:input path="interpretation" placeholder="Interpretation" required="required"  />
			</p>
			<p>
				Help:
				<form:input path="help" placeholder="Help" required="required"  />
			</p>
			
			
    <div class="myheader2" align='center'>Model List</div>
    		<table border="1" align='center' class="table table-bordered">
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
                	<td><input id="model" type='radio' name='model' value="${model.id}" ></td>			    				
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <div class="myheader2" align='center'>Dimension List</div>
     <table table border="1" align='center' class="table table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>				
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dimensionList}" var="dimension">
				<tr>
					<td>${dimension.id}</td>
				    <td>${dimension.name}</td>
                	<td><input id="dimensionId" type='radio' name='sdimension' value="${dimension.id}" ></td>			    				
				    <!--  form:input path="dimensionId" type='radio' name = 'dimension' value="${dimension.id}"/-->		
				    				
				</tr>
			</c:forEach>
		</tbody>
	</table>		
			<fieldset name='factor_list'>
		<legend  align="center">Factor's list</legend>
		<p/>
		<div class="table-responsive">
		
		<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Definition</th>
				
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${factorList}" var="factor">
				<tr>
					<td>${factor.id}</td>
				    <td>${factor.name}</td>
				    <td>${factor.definition}</td>				    
				    <td><input id="factor" type='radio' name='factor' value="${factor.id}" ></td>			
				    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</fieldset>		
			<p>
				<input type="submit" class="btn btn-default" style = 'display: block;' value="Create">
			</p>
		</form:form>
	</fieldset>

	<a href="<c:url value="/home"/>">Home</a>

</body>
</html>