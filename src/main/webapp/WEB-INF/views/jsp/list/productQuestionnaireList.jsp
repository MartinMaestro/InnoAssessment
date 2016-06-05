<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. Asociate Product questionaire</title>
</head>

<body>
    <H1>Product questionaire</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th>Provider</th>
				<th>Version</th>
				
				<th>Select#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
				    <td>${product.name}</td>
				    <td>${product.description}</td>
				    <td>${product.provider}</td>
				    <td>${product.version}</td>
				    <td><input id="product"  type="radio" name="product" value="4"> 
				    </td>
				    <td><a href="<c:url value='/delete-product/${product.id}' />">delete</a></td>
				    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>