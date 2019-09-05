<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main location="Products">
	<div class="container-fluid">
		<div class="row">
			<div class="col-2">
				<t:product imageUrl="/img/default.png" description="Produto de muito valor" value="2199.99" discount="15"></t:product>
			</div>
		</div>
	</div>
</t:main>