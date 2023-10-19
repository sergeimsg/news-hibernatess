<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


   <spring:message code="local.menu.menu.list" var="menu_title" />
   <spring:message code="local.menu.news.list" var="news_list" />
   <spring:message code="local.menu.news.add" var="add_news_menu" />
   <spring:message code="local.menu.admin.users" var="admin_users"/>
   
   <c:set value="${pageContext.request.contextPath}"  var="contextPath" />
   <c:set value="${pageContext.request.userPrincipal}" var="principal"></c:set>
   

<div class="menu-wrapper">
	<div class="menu-title-wrapper">
		<div class="menu-title">
		      <h3> <c:out value="${menu_title}"></c:out>  </h3>
		</div>
	</div>

	<div class="list-menu-invisible-wrapper">
		<div class="list-menu-wrapper" style="float: left;">
			
			<ul style="list-style-image: <c:url value="/resources/images/img.jpg"/>); text-align: left; ">
			
							
				<li style="padding-left: 5px;">
				
				<a href="${pageContext.request.contextPath}/news/goToBasePage"><c:out value="${news_list}"></c:out></a><br />
				           
				</li>

				User: <security:authentication property="principal.username"/>
				Role: <security:authentication property="principal.authorities"/>
				
				
				 <c:url var="addNews" value="/news/addNews"> 
									
					
					   </c:url>
				
				<security:authorize  access="hasRole('ADMIN')">
				
				                                            			
				   <li style="padding-left: 5px;">
				
				    <a href="${contextPath}/news/addNews"><c:out value="${add_news_menu}"></c:out> </a> </li>
				  
				    
                
                 	<li style="padding-left: 5px"> <a href="${contextPath}/users/goToUsersList">  <c:out value="${admin_users}"></c:out>    </a> </li>
                 
                 <br />
                 
                 
					</security:authorize>
								
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<!--  grey free space at the bottom of menu -->
	<div style="height: 25px;"></div>
</div>

