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
	<%@ include file="../common/header.jsp" %>    
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h2>Welcome to the administration section</h2>
       </div>

      <div class="row">
        <div class="col-lg-4">
          <h2>Factors and Dimensions</h2>
          <p>Product innovation assessment is seen as a multi-dimensional factors composition, 
          where factors on each dimension could impact in the success of a software product.<br>
          The impact of a factor could be positive, negative or both depending on the assessment model.
          </p>
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
          <p> Each model is identified by a modelIde and is described by its modelName.<br>
          A product innovation assessment model is a composition of ModelItems. All these models
          referred this two core concepts (factors and dimensions) with different impacts and weights.</p>
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
          <h2>Product and Questionnaire</h2>
          <p>Product innovation assessment models that can be assessed and positioned through questionnaires in the proposed tool
          that also provides automation in the assessment and positioning of innovation.</p>
         <table >
			<thead>
				<tr>
					<th class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-list-product" role="button">View Products »</a></p></th>
					<th class="col-lg-2"><p><a class="btn btn-primary" href="/innoassessment/administration-create-product" role="button">Create Product »</a></p></th>
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

    </div> <!-- /container -->

<%@ include file="../common/footer.jsp" %>  

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src='/innoassessment/static/modernStyle/ie10-viewport-bug-workaround.js' ></script>
  

</body></html>