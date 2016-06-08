<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. CreateProduct Version</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear product Version</h1>
	<form:form action="create-productversion" modelAttribute="productVersion">		
		
		
		<table border="1">
 
            <tr>
                <th>Product Id</th>
                <th> Product Name</th>
                <th>Product Description</th>
                <th>Product Provider</th>
            </tr>
                            
                             <tr>
                <th>${productVersion.productId}</th>
                <th>${productVersion.productName}</th>
                <th>${productVersion.productDescription}</th>
                <th>${productVersion.productProvider}</th>
                            </tr>
           </table>
		
		<p>Name:
			<form:input path="name" placeholder="Name" required="required" />
			<form:errors path="name" cssClass="error" />
		</p>
		
		     
       
		<p><input type="submit" value="Create"></p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>