<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<spring:message code="local.locbutton.sign_out" text="some" var="sos" />
<spring:message code="local.header.login" var="no" />
<spring:message code="local.error.page.no.such.command" var="i18nTooltip"/>
<spring:message code="local.news.view.newsId.automatically" var="123" />
 
<c:set value="${pageContext.request.contextPath}" var="contextPath"/>
<c:set value="${pageContext.request.userPrincipal}" var="principal"/>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BORAJI.COM</title>
</head>
<body>
		<hr>
		<input type="text" name="username" placeholder="${some}">
		<hr>
		---<c:out value="{sos}"></c:out> 
		<br>
		${no}
		
		<spring:message code="local.header.login" />
		<br>
		Language : <a href="?language=en">English</a>|
		<a href="?language=ru">Chinese</a>
		
		<hr>
		
		<spring:message code="local.header.login" var="intitule"/>
     <input type="text" placeholder="${intitule}" title="${intitule}"
               path="wikiArticleTitle" required="true"/>
	          
	        <hr>
	        <hr>  
	          <spring:message code="local.error.page.no.such.command" var="i18nTooltip"/> 
        <input id="email_email" name="${i18nTooltip}" title="${i18nTooltip}" placeholder="${i18nTooltip}"  />               
	<br>
	<hr>
	*** <spring:message code="local.news.view.newsId.automatically" var="here" />
	
		${here}
			
	<hr>
	
	
	  <form action='<spring:url value="/login"/>' method="post">
        <input type="hidden" name="language" value="en">
        <button type="submit"> English ${en_button} </button>
    </form>
    
      <form action='<spring:url value="/login"/>' method="post">
        <input type="hidden" name="language" value="ru">
        <button type="submit">Russian ${ru_button}</button>
    </form>
    
    
    
    <form action="${contextPath}/news/changeLocale" method="get">
        <input type="hidden" name="language" value="ru"/>
        <button type="submit">${ru_button}</button>
    </form>
	
	
	<br>
	Current Locale : ${pageContext.response.locale}
	<br>
	ConxtPath: ${contextPath}
	<br>
	User principal:
	${principal}

	<h1>Spring MVC 5 + Spring Security 5 + Hibernate 5 example</h1>
	<h4>Login Form</h4>
	
	    What message is - ${message}
	
	<form action='<spring:url value="user/loginAction"/>' method="post">
    <table>
      <tr>
        <td>Username</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td><button type="submit">Login</button></td>
        
        
        
      </tr>
    </table>
  </form>
  <br/>
</body>
</html>