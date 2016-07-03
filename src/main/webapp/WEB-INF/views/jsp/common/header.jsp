<!-- The justified navigation menu is meant for single line per list item.
     Multiple lines will require custom code not provided by Bootstrap. -->
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="masthead">
<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/innoassessment/home-modern"}'>
<c:set var="tab" scope="session" value="home"/>
</c:if>
<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/innoassessment/administration/home"}'>
<c:set var="tab" scope="session" value="admin"/>
</c:if>
<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/innoassessment/build-questionnaire-select-model"}'>
<c:set var="tab" scope="session" value="build-questionnaire"/>
</c:if>
<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/innoassessment/modern/assessment-product-search"}'>
<c:set var="tab" scope="session" value="assessment-product"/>
</c:if>
<c:if test='${requestScope["javax.servlet.forward.request_uri"] == "/innoassessment/modern/assessment-questionnaire-search"}'>
<c:set var="tab" scope="session" value="assessment-questionnaire"/>
</c:if>
	<h3 class="text-muted">Product Innovation Assessment Tool</h3>
	<nav>
		<ul class="nav nav-justified">
			<li class='${sessionScope.tab == "home"? "active" : ""}'><a href="<c:url value='/home'/>">Home</a></li>
			<li class='${sessionScope.tab == "admin"? "active" : ""}'><a href="/innoassessment/administration/home">Administration</a></li>
			<li class='${sessionScope.tab == "build-questionnaire"? "active" : ""}'><a href="/innoassessment/build-questionnaire-select-model">Build Questionnaire</a></li>
			<li class='${sessionScope.tab == "assessment-product"? "active" : ""}'><a href="/innoassessment/modern/assessment-product-search">Assessment by Product</a></li>
			<li class='${sessionScope.tab == "assessment-questionnaire"? "active" : ""}'><a href="/innoassessment/modern/assessment-questionnaire-search">Assessment by Questionnaire</a></li>
		</ul>
	</nav>
</div>
<br>
<br>

