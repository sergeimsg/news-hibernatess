<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <fmt:setLocale value="${sessionScope.local}" />
   	<fmt:setBundle basename="localization.local" var="loc" />
   
   <fmt:message bundle="${loc}" key="local.news.view.back" var="back_to_news_list" />
   <fmt:message bundle="${loc}" key="local.news.view.newsId" var="news_id" />
   <fmt:message bundle="${loc}" key="local.news.view.newsId.automatically" var="news_id_auto" />
   <fmt:message bundle="${loc}" key="local.news.view.news.title" var="news_title" />
   <fmt:message bundle="${loc}" key="local.news.view.news.date" var="news_date" />
   <fmt:message bundle="${loc}" key="local.news.view.news.brief" var="news_brief" />
   <fmt:message bundle="${loc}" key="local.news.view.news.content" var="news_content" />
   <fmt:message bundle="${loc}" key="local.news.view.news.image.path" var="news_image_path" />
   <fmt:message bundle="${loc}" key="local.news.view.news.status" var="news_status" />
   <fmt:message bundle="${loc}" key="local.news.view.news.choose.file" var="news_file_choose" />
   <fmt:message bundle="${loc}" key="local.news.view.news.save" var="news_save" />      



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
	
	
	<c:set value="${pageContext.request.contextPath}" var = "contextPath"/>
   <c:set value="${pageContext.request.userPrincipal}" var="principal"/>
   
   ${principal.name}


<div class="body-title">
	<!-- <a href="">News >> </a> View News   -->               
	<a href="${pageContext.request.contextPath}/news/goToBasePage"> <c:out value="${back_to_news_list}"></c:out></a>
</div>



<form:form action="${pageContext.request.contextPath}/news/saveNewNews" modelAttribute="newsEntity" method="POST">

			<!-- need to associate this data with customer id      -->
			
			<form:hidden path="id" />
			<form:hidden path="userDetailsEntity.userID" />
			<input type="hidden" value="${principal.name}" name="username"/>
			
								
			<table>
				<tbody>
					
				
					<tr>
						<td><label>${news_title}</label></td>
						<td><form:input path="title" /></td>
					</tr>

					<tr>
						<td><label>${news_brief}</label></td>
						<td><form:input path="briefNews" /></td>
					</tr>
	
					<tr>
						<td><label>${news_brief}</label></td>
						<td><form:input path="briefNews" /></td>
						
					</tr>
					
					
					<tr>
						<td><label> ${news_content}</label></td>
					
						<td><form:textarea rows="15" cols="50" path="content"/></td>
					
					
					
					</tr>
					
					
					<tr>
						<td><label> ${news_status}</label></td>
					
						<td><form:input path="status"/></td>
					
					
					
					</tr>
									
					
				
					
					<tr>
						<td><label>${news_image_path}</label></td>
					
						
						<td> 	<c:out value="${news_file_choose}"></c:out>
					   <form:input type="file"  accept="image/png, image/jpeg" path="imagePath" />${newsEntity.imagePath}			</td> 
		
					<tr>
						<td><label></label></td>
					
						
						<td><img alt="${newsEntity.title}" src="<c:url value="${newsEntity.imagePath}"></c:url>" />
						
						            
						</td> 
						
					</tr>

							
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="${news_save}" class="save"  /></td>
					</tr>

	
				
				</tbody>
			</table>
	
		
		</form:form>
	

<div class="body-title">
	          
	<a href="controller?command=go_to_news_list"> <c:out value="${back_to_news_list}"></c:out></a>
</div>

<c:if test="${sessionScope.role eq 'admin'}">

	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_add_news" /> 

<div class="add-table-margin">
	<table class="news_text_format">
		
		<tr>
			
			<td class="space_around_title_text"> <c:out value="${news_id}"></c:out></td>

			<td class="space_around_view_text"><div class="word-breaker">
			
			<input type="hidden" name="id" value="" /> 	
				<c:out value="${news_id_auto}"> </c:out>
				
				</div></td>
		</tr>
		
		
		<tr>
			<td class="space_around_title_text"> <c:out value="${news_title}"></c:out></td>

			<td class="space_around_view_text"><div class="word-breaker">
			
			<h3><input type="text" name="title" value="<c:out value="" /> "></h3>
			
				
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text"><c:out value="${news_date}"></c:out></td>

			<td class="space_around_view_text"><div class="word-breaker">
			<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
			<input type="text" name="date" value="<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss" value="${now}"/>" /> 
			
					
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text"><c:out value="${news_brief}"></c:out></td>
			<td class="space_around_view_text">
			<div class="word-breaker">
			
					<textarea wrap="soft" rows="4" cols="60" name="briefNews" placeholder="max 100 marks" 
					style="width:419px; heght:77px;" >
						<c:out value="" />
					</textarea>
				
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text"><c:out value="${news_content}"></c:out></td>
			<td class="space_around_view_text">
			<div class="word-breaker">
			<textarea rows="20" cols="60" name="content">
			
			<c:out value="" />
			
			</textarea>
			
					
				</div>
				</td>
		</tr>
		
		<tr>
			<td class="space_around_title_text"><c:out value="${news_image_path}"></c:out></td>
			<td >
			<div >
				<!-- <c:out value="${requestScope.news.imagePath}" /> -->	
					<p> 
					
				<!--  <input type="text" name="imgPath" value="">  -->	
					<c:out value="${news_file_choose}"></c:out>	
					<input type="file" name="imgPath"  accept="image/png, image/jpeg" value="">
					
								
				
				</div></td>
		</tr>
			
		
		<tr>
			<td class="space_around_title_text"> <c:out value="${news_status}"></c:out></td>
			<td >
			<div >
				<!-- <c:out value="${requestScope.news.imagePath}" /> -->	
					<p> 
					
					
					<input type="text" name="newsStatus" value="1">
					
							
				</div></td>
		</tr>	
			
			
			
		<tr>
			<td class="space_around_title_text">
			
			<a href="controller?command=go_to_news_list"> <c:out value="${back_to_news_list}"></c:out></a></td>
			
		</tr>
		
		

		
	</table>
		
		
			
</div>

	
		<input 	type="hidden" name="id" value="" /> <input
			type="submit" value="<c:out value="${news_save}"></c:out>" />

</form>


<!-- <div class="second-view-button">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="delete" /> <input
			type="hidden" name="id" value="${news.idNews}" /> <input
			type="submit" value="Delete" />
	</form>
</div>    -->

</c:if>
