 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${action eq 'newsList' }">
	<c:import url="/WEB-INF/pages/tiles/newsList.jsp" />
</c:if>


<c:if test="${requestScope.presentation eq 'viewNews' }">
	<c:import url="/WEB-INF/pages/tiles/viewNews.jsp" />
</c:if>

<c:if test="${requestScope.edit eq 'edit'}">

	<c:import url="/WEB-INF/pages/tiles/editNews.jsp"></c:import>
</c:if>

<c:if test="${requestScope.addNews eq 'addNews'}">

	<c:import url="/WEB-INF/pages/tiles/addNews.jsp"></c:import>
</c:if>
