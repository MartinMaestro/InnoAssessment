<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<!-- saved from url=(0047)http://getbootstrap.com/examples/justified-nav/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon"  href='/innoassessment/static/images/vitruvio.png'/>
    <title>Innoassessment</title>
    <!-- Bootstrap core CSS -->    
    <link href='/innoassessment/static/modernStyle/bootstrap.min.css' rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->    
    <link href='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.css' rel="stylesheet">
     <!-- Custom styles for this template -->
    <link href='/innoassessment/static/modernStyle/justified-nav.css' rel="stylesheet">
	 <script src='/innoassessment/static/modernStyle/ie-emulation-modes-warning.js' ></script>
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
        <h1>Administration</h1>
        <p class="lead">Welcome to the administration section</p>
       </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>Factors and Dimensions</h2>
          <p>Product innovation assessment is seen as a multi-dimensional factors composition. 
          where factors on each dimension could impact in the success of a software product</p>
          <table >
			<thead>
				<tr>
					<th class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-list-factor" role="button">View Factors »</a></p></th>
					<th class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-create-factor" role="button">Create Factor »</a></p></th>
				</tr>
			</thead>
			<tbody> 		
				<tr>
					<td class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-list-dimension" role="button">View Dimensions »</a></p></td>
				  	<td class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-create-dimension" role="button">Create Dimension »</a></p></td>
				</tr>  		
			</tbody>
			</table>        
        </div>
        <div class="col-lg-4">
          <h2>Models and ModelItems</h2>
          <p>A product innovation assessment model is a composition of ModelItems.</p>
          <table >
			<thead>
				<tr>
					<th class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-list-model" role="button">View Models »</a></p></th>
					<th class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-create-model" role="button">Create Model »</a></p></th>
				</tr>
			</thead>
			<tbody> 		
				<tr>
					<td class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-list-modelitem" role="button">View ModelItems »</a></p></td>
				  	<td class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-create-modelitem" role="button">Create ModelItem »</a></p>
				  	<p><a class="btn btn-primary" href="/innoassessment/administration-create-modelitems-select-model" role="button">Create ModelItems »</a></p>
				  	</td>
				</tr>  	
				<tr>
				<td class="col-lg-2"></td>
				</tr>	
			</tbody>
			</table>          
       </div>
        <div class="col-lg-4">
          <h2>Products and Questionnaires</h2>
          <p>Product innovation assessment models that can be assessed and positioned through questionnaires in the proposed tool
          that also provides automation in the assessment and positioning of innovation.</p>
         <table >
			<thead>
				<tr>
					<th class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-list-questionnaire" role="button">View Products »</a></p></th>
					<th class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-create-questionnaire-select-model" role="button">Create Product »</a></p></th>
				</tr>
			</thead>
			<tbody> 		
				<tr>
					<td class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-list-questionnaire" role="button">View Questionnaires »</a></p></td>
				  	<td class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-create-questionnaire-select-model" role="button">Create Questionnaire »</a></p>
				  	
				  	</td>
				</tr>  	
				<tr>
					<td class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-list-assessment" role="button">View Assessments »</a></p></td>
					<td class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-create-assessment-select-questionnaire" role="button">Create Assessments »</a></p></td>
				</tr>	
			</tbody>
			</table>    
         
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>© 2016 MiW, Inc.</p>
      </footer>

    </div> <!-- /container -->



    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.js' ></script>
  

</body></html>