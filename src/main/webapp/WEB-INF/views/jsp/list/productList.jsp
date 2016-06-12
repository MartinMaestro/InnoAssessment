<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/vitruvio.png' />"/>
<meta charset="utf-8">
<title>Spring MVC. product List</title>
</head>

<body>
    <H1>Product List</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th>Provider</th>
				<th>#</th>
				<th>#</th>
				<th>#</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
				    <td>${product.name}</td>
				    <td>${product.description}</td>
				    <td>${product.provider}</td>
				    <td><a href="<c:url value='/search-productversion/${product.id}' />">List Product Version</a></td>       
				    <td><a href="<c:url value='/create-productversion/${product.id}' />">Create Product Version</a></td>				   
				    <td><a href="<c:url value='/delete-product/${product.id}' />">delete</a></td>
				    				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>