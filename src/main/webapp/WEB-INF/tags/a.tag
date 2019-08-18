<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="href" required="true" %>
<%@ attribute name="classes" required="false" %>
<a href="${pageContext.request.contextPath}${href}" class="${classes}">
	<jsp:doBody/>
</a>