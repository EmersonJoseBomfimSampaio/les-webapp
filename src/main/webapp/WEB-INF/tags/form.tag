<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="action" required="true"%>
<%@ attribute name="method" required="true"%>
<%@ attribute name="classes" required="false" %>
<form action="${pageContext.request.contextPath}${action}" method="${method}" class="${classes}" novalidate>
	<input type="hidden" name="referer" value="${pageContext.request.requestURI}"/>
	<jsp:doBody/>
</form>