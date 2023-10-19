<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="wrapper">

   <spring:message  code="local.locbutton.name.ru" var="ru_button" />
   <spring:message  code="local.locbutton.name.en" var="en_button" />
   <spring:message  code="local.locbutton.registration" var="registr_button" />
   <spring:message  code="local.locbutton.sign_in" var="signIn_button" />
   <spring:message  code="local.locbutton.sign_out" var="sign_out_button" />
   <spring:message  code="local.header.login" var="login_field" />
   <spring:message  code="local.header.password" var="password_field" />
   <spring:message  code="local.header.wedsite.title" var="website_title" />
   <spring:message  code="local.error.page.no.such.command" var="error" />
      
   	
   	<c:set value="${pageContext.request.contextPath}" var = "contextPath"/>
   	<c:set value="${pageContext.request.userPrincipal}" var="principal"/>
   	
   	
   	<div class="newstitle"><c:out value="${website_title}"></c:out>
   	
   

     
   	</div>
   	
   	        	
	<div class="local-link">

		<div align="right">		
		
		
		<form action='<spring:url value="/news/changeLocale"/>' method="get">
           <input type="hidden" name="language" value="en">
           <button type="submit"> ${en_button} </button>
           
    	</form>			
			
		<form action="${contextPath}/news/changeLocale" method="get">
           <input type="hidden" name="language" value="ru">
           <button type="submit"> ${ru_button} </button>	
         
		
		</form>
					
		</div>
		

		<c:if test="${principal == null}">

			<div align="right">
			                                
				<form action="${contextPath}/user/loginAction" method="post">
					
					<c:out value="${login_field}"></c:out> <input type="text" name="username" placeholder="add ${login_field}"/><br /> 
					<c:out value="${password_field}"></c:out><input type="password" name="password" placeholder="add ${password_field}"/><br />
					
					<c:if test="${param.error !=  null}">
					
					                                
						<font color="red"> 
						   <c:out value="${error}" />
						   
						</font> 
					</c:if>
					
					<a href="${contextPath}/user/goToRegistrationPage"><c:out value="${registr_button}"></c:out></a> 
					
					<input type="submit" value="${signIn_button}" /><br />
					
				<input type="hidden"
							   name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
						
				
					
				</form>
				
				
			</div>

		</c:if>
		
		<c:if test="${principal != null}">
				                             

			<div align="right">
				
					<a href="${contextPath}/logout">
					<button> ${sign_out_button}" </button>
					</a>
					
				
			</div>

		</c:if>
	</div>

</div>
