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
		<p></p><p></p><p></p>
		<div class="row">
			<div class="col-sm-12" align="center">
				<p class="lead">Dimension List</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-bordered text-center">
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
								<td><a
									href="<c:url value='/administration-delete-dimension/${dimension.id}' />">Delete</a></td>
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
						href="/innoassessment/administration-create-dimension"
						role="button">Create Dimension »</a>
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