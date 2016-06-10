<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<link rel="shortcut icon"
 href="<c:url value='/static/images/bulb-favicon.png' />"/>
<meta charset="utf-8">
<title>Spring MVC. Build Questionnaire</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Product innovation assessment questionnaire ${now}</h1>
	<h1>Crear producto</h1>
    <form:form action="build-questionnaire" modelAttribute="questionnaireChoice">        
        
        <p>Name:
            ${questionnaireChoice.modelName}          
        </p>
        
        <p>Description:
          
        </p>
        
        <p>Provider:
           
        </p>
        
       
        <p><input type="submit" value="Create"></p>
    </form:form>
	
	
	
	
	
	
	
	
	 <form id = 'questionnaire' >
	 <fieldset name='date_evaluation'>
                <legend>Evaluation Date</legend><p />
                Model: <b>${questionnaireChoice.modelName} </b> 
                - Questionnaire: <b>complete</b>
                Date: <input name='evaluation_date' value='${now}'/>
                Date: <input name='evaluation_date' type='date' value='${now}'/>
                Time: <input name='evaluation_time' type='time' value='12:32'/>
                <input type='hidden' name='model' value='modelBa1997u' />
                <input type='hidden' name='questionnaire' value='quest_u_1' />
    </fieldset>
	<table border="1">
	   <tr>
	       <th>Evaluation Date</th>
	  </tr>
	   <tr>
	       <th>Model</th><td>${questionnaireChoice.modelName}</td>
	   </tr>
	</table>
	<table border="1">
        <thead>
            <tr>
                <th>Questionnaire Id</th>
                <th>Questionnaire Name</th>
                <th>Questionnaire Version</th>
                <th>Questionnaire Model</th>
                
                <th>#</th>                                          
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questionnaireListChoice}" var="questionnaireChoice">
                <tr>
                    <td>${questionnaireChoice.id}</td>
                    <td>${questionnaireChoice.name}</td>
                    <td>${questionnaireChoice.version}</td>
                    <td>${questionnaireChoice.modelName}</td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>	
		
		
	</form>	
		
		
		     
      

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>