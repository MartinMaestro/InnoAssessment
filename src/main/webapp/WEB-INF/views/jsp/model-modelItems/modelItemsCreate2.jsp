<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
	href="<c:url value='/static/images/vitruvio.png' />" />
<link rel="stylesheet" href="<c:url value='/static/css/estilo.css' />">
<link rel="stylesheet" href="<c:url value='/static/css/bootstrap.css' />">
<script type="text/javascript">
function setDimension(){
	alert("aqui");
	
	//ddlDimensions
}
</script>
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
     
     
      <fieldset name='model'>
                <legend>Model</legend><p />
                Model: <b>${model.name}</b> 
                - Year: <b>${model.year}</b>
                - Version: <b>${model.version}</b></br>
                Description: <b>${model.description}</b></br>
                <input type='hidden' name='model' value='model.id' />
                <a href="<c:url value='/model-select/'/>">Change Model</a>
      </fieldset>
     

	<fieldset name='modelItem_create'>
		<legend>Create</legend>
		<p />	
		
		<form:form action="create-modelItem" modelAttribute="modelItem">
			<p>
				Impact:<select name="impact" id = "ddlProductVersion" >
                <c:forEach items="${impactValuesList}" var="impact" varStatus="status">
  					<option value="${impact.name}">${impact.name}</option>
				</c:forEach> 
		</select>
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
			
			
			
			
   
      <fieldset name='dimension'>
           <legend>Dimension</legend><p />
           Select a dimension:
         <select name="dimension" id = "ddlDimensions">
                <c:forEach items="${dimensionList}" var="dimension" varStatus="status">
  					<option value="${dimension.id}">${dimension.name}</option>
				</c:forEach>     
     	</select>     		
      </fieldset>
      
    
     </br>
		<fieldset name='factor_list'>
		<legend  align="center">Factor's list</legend>
		<p/>
        <input aligh = "right" type="submit" class="btn btn-default" style = 'display: block;' value="Add Factors">
		<a href="<c:url value='/factor-select/${model.id}'/>">Select Factors</a>
		
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
				    <td><input type="checkbox" name="factorId" value="${factor.id}" ><br></td>
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