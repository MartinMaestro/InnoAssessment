<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/bulb-favicon.png' />"/>
<meta charset="utf-8">
<title>Spring MVC. CreateProduct Version</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear product Version</h1>
		
		
		
		<table border="1">
 
            <tr>
                <th>Product Id</th>
                <th> Product Name</th>
                <th>Product Description</th>
                <th>Product Provider</th>
            </tr>
                            
                             <tr>
                <th>${product.id}</th>
                <th>${product.name}</th>
                <th>${product.description}</th>
                <th>${product.provider}</th>
                            </tr>
           </table>
		<form:form action="create-productversion" modelAttribute="productVersion">    
		<p>Name:
			<form:input path="name" placeholder="Name" required="required" />		
		</p>
		
		<p>Name:
            <form:input path="description" placeholder="Description" />       
        </p>
		<p>Product Id:
            <form:input path="productId" readonly="true"/>       
        </p>
		
		     
       
		<p><input type="submit" value="Create"></p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>