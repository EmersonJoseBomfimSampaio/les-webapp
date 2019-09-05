<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="src" required="true"%>
<%@ attribute name="alt" required="false"%>
<%@ attribute name="classes" required="false"%>
<%@ attribute name="width" required="false" %>
<%@ attribute name="height" required="false" %>
<img src="${pageContext.request.contextPath}${src}" alt="${alt}" class="${classes}" width="${width}" height="${height}"/>