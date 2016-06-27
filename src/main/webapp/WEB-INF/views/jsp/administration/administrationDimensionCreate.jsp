<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<link  href='/innoassessment/static/css/estilo.css'  rel="stylesheet">

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
			<h3 class="text-muted">Product Innovation Assessment Tool </h3>
			<div class="myheader">   
            <img src="<c:url value='/innoassessment/static/images/syst_logo.png' />" alt="" />
        	</div>
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="<c:url value='/home'/>">Home</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Administration</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Services</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Downloads</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">About</a></li>
					<li><a href="http://getbootstrap.com/examples/justified-nav/#">Contact</a></li>
				</ul>
			</nav>
		</div>
		<!-- Jumbotron -->
		<div class="jumbotron">
			<p class="lead">Create Dimension</p>
			<form:form action="administration-create-dimension" modelAttribute="dimension">
				<p>Name:
				<form:input path="name" placeholder="Name" required="required" />
				<form:errors path="name" cssClass="error" />
				</p>
				<p><input class="btn btn-primary" type="submit" value="Create »"></p>
			</form:form>			
			<p> <a class="btn btn-primary" href="/innoassessment/home-administration" role="button">Go to Administration Home</a></p>
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