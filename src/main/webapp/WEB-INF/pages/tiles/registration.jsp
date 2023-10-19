<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
	

	<spring:message code="local.registration.page.registration" var="registr_page" /> 
	<spring:message code="local.error.page.go.to.basepage" var="go_to_basepage" />
	<spring:message code="local.registration.page.name" var="registr_page_name" />
	<spring:message code="local.registration.page.surname" var="registr_page_surname" />
	<spring:message code="local.registration.page.login" var="registr_page_login" />
	<spring:message code="local.registration.page.password" var="registr_page_password" />
	<spring:message code="local.registration.page.email" var="registr_page_email" />
	<spring:message code="local.registration.page.secret.word" var="registr_page_secret_word" />
	<spring:message code="local.registration.page.english.level" var="registr_page_english_level" />
	<spring:message code="local.registration.page.english.level.beginner" var="registr_page_english_level_beginner" />
	<spring:message code="local.registration.page.english.level.intermediate" var="registr_page_english_level_intermediate" />
	<spring:message code="local.registration.page.english.level.upperintermediate" var="registr_page_english_level_upperintermediate" />
	<spring:message code="local.registration.page.english.level.advanced" var="registr_page_english_level_advanced" />
	<spring:message code="local.registration.page.way.to.work" var="registr_page_way_to_work" />
	<spring:message code="local.registration.page.way.to.work.public" var="registr_page_way_to_work_public" />
	<spring:message code="local.registration.page.way.to.work.car" var="registr_page_way_to_work_car" />
	<spring:message code="local.registration.page.way.to.work.foot" var="registr_page_way_to_work_foot" />
	<spring:message code="local.registration.page.way.to.work.bike" var="registr_page_way_to_work_bike" />
	<spring:message code="local.registration.page.way.to.work.moto" var="registr_page_way_to_work_moto" />
	<spring:message code="local.registration.page.send.form" var="registr_page_send_form" />
	<spring:message code="local.registration.page.form.completed" var="registr_form_completed" />
	
	
	<c:set value="${pageContext.request.contextPath }" var="contextPath"/>


<html>

<body>
	
	 <h3> <c:out value="${registr_page }"></c:out> </h3>	
	 
		 
 
 	<div class="list-menu-wrapper" style="float: centre;">
  	
 	
 	
 	<form:form modelAttribute="userDetails" action="${contextPath}/user/doRegistrationUser" method="post" >  
		
		<form:hidden path="userID" />
			

				
		<label for="name">${registr_page_name}</label>
        <form:input path="name" id="name"/>
        <form:errors path="name" ></form:errors>
        <br>
        <br>
        <label for="surname">${registr_page_surname}</label>
        <form:input path="surname" id="surname"/>
        <form:errors path="surname" ></form:errors>
        <br>
        <br>
        <label for="login">${registr_page_login}</label>
        <form:input path="user.username" id="login"/>
        <br>
		
		  <br>
        
        <label for="password">${registr_page_password}</label>
        <form:input path="user.password" id="password"/>
        <br>
		<br>
		
		<form:hidden path="user.enabled"/>
        
        <label for="email">${registr_page_email}</label>
        <form:input path="email" id="email"/>
        <form:errors path="email" ></form:errors>
        <br>
        <br>
		
				
		<button type="submit">${registr_page_send_form}</button>
		
		</form:form>
 	
	
 		
 	 	
 	</div>
 
 	<a href="javascript:history.back()" class="back-button">${go_to_basepage}</a>
 	
 	<br>
 			 
 		 <a href="${contextPath}/news/goToBasePage"> <c:out value="${go_to_basepage}"></c:out></a>
 		 
		
 		<c:if test="${registered eq 'registered'}">
 													

			<div align="left">
			
			 			 	
			 	 <h1>	<a href="controller?command=go_to_base_page">  <c:out value="${registr_form_completed}"></c:out> </a></h1>
			 		
			 		<br>
			 		
			 		<a href="${contextPath}/news/goToBasePage"> <c:out value="${go_to_basepage}"></c:out></a>
			 	
			</div> 	

		</c:if>
 	
 	
</body>
</html>