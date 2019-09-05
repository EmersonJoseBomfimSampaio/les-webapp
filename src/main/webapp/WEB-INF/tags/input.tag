<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="id" required="true"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="type" required="false" %>
<%@ attribute name="label" required="true"%>
<%@ attribute name="error" required="false" %>
<div class="form-group">
	<label for="${id}">${label}</label>
	<input id="${id}"
		type="${empty type ? 'text' : type }"
		name="${name}"
		class="form-control shadow resentful-input ${ not old['referer'].equals(pageContext.request.requestURI) ? '' : ( empty error ? 'is-valid' : 'is-invalid')}"
		value="${old[name]}"
		data-oldValue="${old[name]}">
	
	<c:if test="${not empty error}">
		<div class="invalid-feedback">
			${error}
		</div>
	</c:if>
</div>