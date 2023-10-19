<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

   
   <spring:message code="local.newsList.title" var="newsList_title" />
   <spring:message code="local.newsList.newsId" var="news_id" />
   <spring:message code="local.newsList.read.news" var="read_news" />
   <spring:message code="local.newsList.edit.news" var="edit_news" />
   <spring:message code="local.newsList.delete.news" var="delete_news" />
   <spring:message code="local.newsList.no.news" var="no_news" />
   
   <c:set value="${requestScope.news1}" var="news"/>
   <c:set value="${pageContext.request.contextPath }" var="contextPath"/>
   <c:set value="${pageContext.request.userPrincipal}" var="principal"/>
   

<div class="body-title">
	
<h1>  <c:out value="${newsList_title}"></c:out> </h1>	
	
</div>

			
		    	            

		 <c:if test="${news1.size() == 0}">		    				
    	
		
		      <h1> <c:out value="${no_news}"></c:out>  </h1>	
		
		</c:if>			
		
	
		


 <form action="${contextPath}/news/admin/doDeleteSomeNews" id="selectedNews" method="post">


<br>

			
	<c:forEach items="${news1}" var="news">
	
	
	
                

	<c:if test="${news.status eq 1}">
	
	
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news_id}"></c:out>
					<c:out value="${news.id}" />
					<h3>
						<c:out value="${news.title}" />
					</h3>
				</div>
				<div class="news-date">
				
			<c:set var = "dateScope" value = "${news.createDate}" />	
			
			<fmt:parseDate value = "${dateScope}" var = "parsedDate" pattern = "yyyy-MM-dd HH:mm" />
			
			<fmt:formatDate type="both" pattern = "EEE, d MMM yyyy HH:mm " dateStyle="medium" timeStyle="short" value="${parsedDate}" />
					
					
					
				</div>

				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
				<div class="news-link-to-wrapper">
					<div class="link-position">
				
				
				      <c:url var="editNews" value="/news/editNews"> 
									<c:param name="newsIdToEdit" value="${news.id}"></c:param>
					
					   </c:url>
						
					   <c:url var="readNews" value="/news/readNews"> 
									<c:param name="newsIdToRead" value="${news.id}"></c:param>
					
					   </c:url>
					   
					   
				
						<security:authorize access="hasRole('ROLE_ADMIN') and #principal != null">   
						
							
							
							<a href="${editNews}">${edit_news} </a>  ----------
							
													
							
						</security:authorize>	

						<security:authorize access="hasAnyRole('ADMIN', 'ROLE_USER') and #principal != null">
						
						<a href="${readNews}">${read_news} </a>		
						
						</security:authorize>
					
					
										
						<security:authorize access="hasRole('ROLE_ADMIN')">   
						
						
						
							<input formaction="selected" type="checkbox" name="news" value="${news.id}"/>
							
							
						</security:authorize>	
						
						
										
					</div>
				</div>

			</div>
		</div>
		
		</c:if>

	</c:forEach>



     
	<div class="no-news">
	
		
		
	
	</div>
	
	<security:authorize access="hasRole('ADMIN') and #principal != null">
	
	<div class="save-button">
	
	<input type="submit" value="<c:out value="${delete_news}"></c:out>">
	
	</div>
	</security:authorize>
	
	

	
	
	
</form>
