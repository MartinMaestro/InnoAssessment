<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. product Version List</title>
</head>

<body>
    <H1>Product Version List</H1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Product Id</th>
                <th>Product Name</th>
				<th>Product Description</th>
				<th>Product Provider</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productVersionList}" var="productVersion">
				<tr>
					<td>${productVersion.id}</td>
				    <td>${productVersion.name}</td>
				    <td>${productVersion.productId}</td>
                    <td>${productVersion.productName}</td>
				    <td>${productVersion.productDescription}</td>
				    <td>${product.productProvider}</td>				   
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="<c:url value='/home'/>">Home</a></p>

    <p>UPM-MIW --- ${now}</p>

</body>
</html>