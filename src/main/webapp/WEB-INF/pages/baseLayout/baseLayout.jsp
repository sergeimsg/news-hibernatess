<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="<c:url value="/resources/styles/script/validation.js"/>"></script>

                          

<title>Base page layout</title>


<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/newsStyle.css" />">

 
   
   <spring:message code="local.menu.nonews.authorize" var="no_news_authorize" />
   <c:set value="${pageContext.request.contextPath}" var = "contextPath"/>
   <c:set value="${pageContext.request.userPrincipal}" var="principal"/>
   
   

</head>
<body>
		
	  <div class="page">
		<div class="header">
			
			<c:import url="/WEB-INF/pages/tiles/header.jsp" charEncoding="utf-8" />
			
					
			
		</div>
		
				
		<div class="base-layout-wrapper">
			<div class="menu">
				 
				
				
				   <c:if test="${principal  ==  null}">
				   <p class="text-red"> <c:out value="${no_news_authorize}"></c:out>  </p> 
				   </c:if>
				  
				
				<c:if test="${principal != null}">
				
					<c:import url="/WEB-INF/pages/tiles/menu.jsp" charEncoding="utf-8"/>
					
				</c:if>
		</div>

		<div class="content">
				
									
				<c:if test="${requestScope.error eq 'error' }">
				
					<c:import url="/WEB-INF/pages/tiles/error.jsp" charEncoding="utf-8"></c:import>
					               
				</c:if>

				<c:if test="${not (sessionScope.user eq 'active') && not(requestScope.userRegister eq 'register')}">
					<c:import url="/WEB-INF/pages/tiles/guestInfo.jsp" charEncoding="utf-8"/>
				</c:if>
				
				
				<c:if test="${action eq 'newsList'}">
				
					<c:import url="/WEB-INF/pages/tiles/newsList.jsp" charEncoding="utf-8"/>
					
				</c:if>
				
				<c:if test="${action eq 'editNews'}">
				
					<c:import url="/WEB-INF/pages/tiles/editNews.jsp" charEncoding="utf-8"></c:import>
					
				</c:if>
				
				
				<c:if test="${action eq 'readNews'}">
				
					<c:import url="/WEB-INF/pages/tiles/viewNews.jsp" charEncoding="utf-8" />
					
				</c:if>
				
				<c:if test="${action eq 'addNews'}">
				
					<c:import url="/WEB-INF/pages/tiles/addNews.jsp" charEncoding="utf-8"></c:import>
					
				</c:if>
				
				
												
				<c:if test="${action eq 'registrationPage'}">
					
					<c:import url="/WEB-INF/pages/tiles/registration.jsp" charEncoding="utf-8"/>
				</c:if>
				
				<c:if test="${requestScope.users_list eq 'users_list' && sessionScope.user eq 'active'}">
				                                          
				
					<c:import url="/WEB-INF/pages/tiles/usersList.jsp" charEncoding="utf-8"></c:import>
					
				</c:if>
				
				 <c:if test="${requestScope.userDetail eq 'userDetail' && sessionScope.user eq 'active'}">
				                                          
				
					<c:import url="/WEB-INF/pages/tiles/userDetail.jsp" charEncoding="utf-8"></c:import>
					
				</c:if>

			</div>
		</div>

		<hr>	
		<div class="footer">

			<c:import url="/WEB-INF/pages/tiles/footer.jsp" charEncoding="utf-8"/>
		</div>
	</div>
</body>
</html>