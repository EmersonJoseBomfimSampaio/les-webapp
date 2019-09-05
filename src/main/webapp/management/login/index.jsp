<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main location="Login">
	<div class="container">
		<div class="row">
			<div class="col-md-6 py-4 mx-auto">
				<div class="card bg-light">
					<div class="card-body">	
						<h4 class="card-title">Por favor, insira suas credenciais.</h4>
						<p>
							... Ou  cadastre-se
							<t:a classes="" href="/register"> clicando aqui</t:a>!
							Só é necessário inserir informações básicas como email e senha. É muito rápido!	
						</p>
						<hr>
						<t:form action="/customers.read" method="POST">
							<t:input label="E-mail:" 
								name="customer.email" 
								id="email-input" 
								error="${result.errors['customer.email']}"/>
							<t:input label="Senha:" 
								name="customer.password" 
								id="password-input"
								type="password"
								error="${result.errors['customer.password']}"/>
							<button type="submit" class="btn btn-primary float-right shadow">
								Entrar!
							</button>
						</t:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</t:main>