<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main location="Login">
	<div class="container">
		<div class="row">
			<div class="col-md-6 py-4 mx-auto">
				<div class="card bg-light">
					<div class="card-body">			
						<h4 class="card-title">Crie sua conta</h4>
						<p>
							... Ou se você já tiver uma conta, <t:a href="/login"> clique aqui</t:a>
							e faça seu login.
						</p>
						<t:form action="/customers.create" method="POST">
							<t:input label="Nome:" 
								name="customer.name" 
								id="name-input" 
								error="${errors['customer.name']}"/>
							<t:input label="E-mail:" 
								name="customer.email" 
								id="email-input" 
								error="${errors['customer.email']}"/>
							<t:input label="Senha:" 
								name="customer.password" 
								id="password-input" 
								error="${errors['customer.password']}"/>
							<t:input label="Confirmação de senha:" 
								name="customer.passwordConfirmation" 
								type="password" 
								id="password-confirmation-input" 
								error="${errors['customer.passwordConfirmation']}"/>
							<button type="submit" class="btn btn-primary float-right shadow">
								Criar conta!
							</button>
						</t:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</t:main>