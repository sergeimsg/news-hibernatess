<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   
     
      
   <spring:message code="local.news.view.back" var="back_to_news_list" />
   <spring:message code="local.news.view.newsId" var="news_id" />
   <spring:message code="local.news.view.newsId.automatically" var="news_id_auto" />
   <spring:message code="local.news.view.news.title" var="news_title" />
   <spring:message code="local.news.view.news.date" var="news_date" />
   <spring:message code="local.news.view.news.brief" var="news_brief" />
   <spring:message code="local.news.view.news.content" var="news_content" />
   <spring:message code="local.news.view.news.image.path" var="news_image_path" />
   <spring:message code="local.news.view.news.image.current" var="news_image_current" />
   <spring:message code="local.news.view.news.status" var="news_status" />
   <spring:message code="local.news.view.news.choose.file" var="news_file_choose" />
   <spring:message code="local.news.view.news.save" var="news_save" />      



<div class="body-title">
	<!-- <a href="">News >> </a> View News   -->               
	<a href="${pageContext.request.contextPath}/news/goToBasePage"> <c:out value="${back_to_news_list}"></c:out></a>
</div>

<form:form action="${pageContext.request.contextPath}/news/saveNews" modelAttribute="newsEntity" method="POST">

			<!-- need to associate this data with customer id      -->
			<form:hidden path="id" />
			<form:hidden path="userDetailsEntity.userID" />
			
			         
					
			<table>
				<tbody>
					<tr>
						<td><label>${news_id} </label></td>
						
						<td><label > ${newsEntity.id}</label></td>
					</tr>
				
					<tr>
						<td><label>${news_title}</label></td>
						<td><label > ${newsEntity.title}</label></td>
												
					</tr>

					<tr>
						<td><label>${news_brief}</label></td>
						<td><label > ${newsEntity.briefNews}</label></td>
						
					</tr>
	
					
					
					
					<tr>
						<td><label> ${news_content}</label></td>
						<td><label ><c:out  value=" ${newsEntity.content}"></c:out> </label></td>
					
										
					
					</tr>
					
					
													
					
					<tr>
						<td><label> ${news_date} </label></td>
							<td><label> ${newsEntity.createDate} </label></td>
					
						
					
					</tr>
					
					
					<tr>
						<td><label>${news_image_path}</label></td>
					
						<td><img alt="${newsEntity.title}" src="<c:url value="${newsEntity.imagePath}"></c:url>" /> </td> 
						
		
												
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="" class="save"  /></td>
					</tr>

	
				
				</tbody>
			</table>
	
		
		</form:form>
	
      
      
      
      
      
