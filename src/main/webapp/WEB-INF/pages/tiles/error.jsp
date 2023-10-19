<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>

		    
		  <spring:message code="local.error.page.error.message" var="error_page" />
		  <spring:message code="local.error.page.go.to.basepage" var="go_to_basepage" />
		  <spring:message code="local.menu.news.list" var="news_list" />
		  
		  	  


<body>
	
	
 	
 	<div class="error-box" style="float: centre;">
 	
 	<c:out value="${error_page}"></c:out>
 	 
 	 <br>
 	 	 
 	  	 
 	 <security:authorize access="hasRole('ADMIN')">  
 	 
 	 <a href="${pageContext.request.contextPath}/news/goToNewsList"> <c:out value="${news_list}"></c:out></a>
 	 
 	 </security:authorize>
 	 <br>
 	 
 	 
   
 	 
 	 
 	 <a href="${pageContext.request.contextPath}/news/goToBasePage"> <c:out value="${go_to_basepage}"></c:out></a>
 	 
 
 	 
 	 
 	 
 	 
	</div>
	
	
	
	 	
 	
</body>
</html>

