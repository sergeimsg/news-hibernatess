<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


	
	
	
	<spring:message code="local.newsList.no.news" var="no_news" /> 
  
	

	<c:if test="${requestScope.news2 eq 'latestNews'}">
	
	<c:forEach var="news" items="${requestScope.news}">
	
	<c:if test="${news.status eq 1}">
	
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
				<h3> <c:out value="${news.title}" /> </h3>	
				</div>
				<div class="news-date">
				
			<c:set var = "dateScope" value = "${news.newsDate}" />	
			
			<fmt:parseDate value = "${dateScope}" var = "parsedDate" pattern = "yyyy-MM-dd HH:mm" />
			
			<fmt:formatDate type="both" pattern = "d MMM yyyy HH:mm" dateStyle="medium" timeStyle="short" value="${parsedDate}" />
				
					
					
				</div>

				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
			</div>
		</div>
		
		</c:if>

	</c:forEach>
	
	</c:if>

	<div class="no-news">
	 	
	 	
	<c:if test="${news1 eq null}">
		
		<h2> <c:out value="${no_news}"></c:out>  </h2>  
		
		<a href="controller?command=go_to_base_page"> <c:out value="${go_to_basepage}"></c:out></a>
		
      	<br>
      
	</c:if>
	
	</div>


