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
		<!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
		<div class="masthead">
			<h3 class="text-muted">Product Innovation Assessment Tool</h3>
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="<c:url value='/home'/>">Home</a></li>
					<li><a href="<c:url value='/home-administration'/>">Administration</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Services</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Downloads</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">About</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Contact</a></li>
				</ul>
			</nav>
		</div>
		<p></p><p></p><p></p>
		<div class="row">
			<div class="col-sm-12" align="center">
				<p class="lead">Assessment List</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-bordered">
					<thead>
				<tr>
					<th>Id</th>
					<th>Model</th>
					<th>Dimension</th>
					<th>Factor</th>
					<th>Impact</th>
					<th>Weight</th>
					<th>Interpretation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${assessmentLineList}" var="assessmentLine">
					<tr>
						<td>${assessmentLine.id}</td>
						<td>${assessmentLine.modelItemModelName}</td>
						<td>${assessmentLine.modelItemDimensionName}</td>
						<td>${assessmentLine.modelItemFactorName}</td>
						<td>${assessmentLine.modelItemImpact}</td>
						<td>${assessmentLine.modelItemWeight}</td>
						<td>${assessmentLine.modelItemInterpretation}</td>
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

		<!-- Site footer -->
		<footer class="footer">
			<p>© 2016 MiW, Inc.</p>
		</footer>
	</div>
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.js'></script>

</body>
</html>