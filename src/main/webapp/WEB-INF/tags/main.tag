<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ attribute name="location" required="true" %>
<t:app title="Loja - ${location}">
	<t:header/>
	<jsp:doBody/>
	<t:footer/>
</t:app>