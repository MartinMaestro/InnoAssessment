<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href='/innoassessment/static/images/vitruvio.png' />
<title>Innoassessment</title>
<!-- Bootstrap core CSS -->
<link href='/innoassessment/static/modernStyle/bootstrap.min.css'
	rel="stylesheet">
<link href='/innoassessment/static/css/estilo.css' rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.css'
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href='/innoassessment/static/modernStyle/justified-nav.css'
	rel="stylesheet">
<script
	src='/innoassessment/static/modernStyle/ie-emulation-modes-warning.js'></script>
</head>

<body>
	<div class="container">
		<%@ include file="../../common/header.jsp" %> 	     
		<div class="row">
			<div class="col-sm-12" align="center">
				<p class="lead">Product List</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-bordered">
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
				    <td><a href="<c:url value='/administration/search-productversion/${product.id}' />">List Product Version</a></td>       
				    <td><a href="<c:url value='/administration/create-productversion/${product.id}' />">Create Product Version</a></td>				   
				    <td><a href="<c:url value='/administration/delete-product/${product.id}' />">delete</a></td>
				    				
				</tr>
			</c:forEach>
		</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12" align="center">
				<p>
					<a class="btn btn-primary"
						href="/innoassessment/administration/create-product"
						role="button">Create Product »</a>
				</p>
			</div>
		</div>

		<%@ include file="../../common/footer.jsp" %>  
	</div>
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.js'></script>

</body>
</html>