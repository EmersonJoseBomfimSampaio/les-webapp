<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ attribute name="title" required="true" %>
<%@ attribute name="javascripts" required="false" fragment="true" %>
<%@ attribute name="stylesheets" required="false" fragment="true" %>

<!DOCTYPE html>
<html>
<head>
	<title>
		${title}
	</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<t:stylesheet src="/css/app.css"></t:stylesheet>
	<jsp:invoke fragment="stylesheets"/>
	<t:javascript src="/js/app.js"></t:javascript>
	<jsp:invoke fragment="javascripts"/>
</head>
<body>
	<jsp:doBody/>
</body>
</html>
