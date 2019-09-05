<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main location="Home">
	<div class="container">
		<div class="row">
			<div class="col-lg-9 py-4">
				<div class="col-12 bg-light border rounded p-4">
					<h4 class="card-title">Selecione o seu endereço:
					</h4>
					<div class="form-check">
						<input type="radio" class="form-check-input" name="address-input" id="address-1">
						<label for="address-1" class="input-check-label">Endereço 1</label>
					</div>
					<div class="form-check">
						<input type="radio" class="form-check-input" name="address-input" id="address-2">
						<label for="address-2" class="input-check-label">Endereço 2</label>
					</div>
					<div class="form-check">
						<input type="radio" class="form-check-input" name="address-input" id="address-3">
						<label for="address-3" class="input-check-label">Endereço 3</label>
					</div>
					<a class="btn btn-link" type="link" href="#">
						... ou adicione um endereço
						<i class="fas fa-map-marked-alt"></i>
					</a>
					<hr>
					<h4 class="card-title">Utilize um cupom de troca ou promocional: </h4>
					<t:form action="#" method="POST" classes="form">
						<div class="form-group">
							<label for="coupon-input"> Insira o cupom promocional ou cupom de troca</label>
							<input id="coupon-input" type="text" class="form-control shadow" name="coupon" placeholder="Digite o código aqui..."/>
						</div>
						<button type="submit" class="btn btn-primary shadow">
							Adicionar cupom
						</button>
					</t:form>
					<hr>
					<h4 class="card-title">Selecione a forma de pagamento: </h4>
					<div id="payment-methods-tabs" class="nav nav-tabs">
						<a href="#" class="nav-item nav-link active" data-toggle="tab" data-target="#option-1">
							<i class="fas fa-credit-card"></i>
							Cartão de crédito
						</a>
						<a href="#" class="nav-item nav-link" data-toggle="tab" data-target="#option-2">
							<i class="far fa-credit-card"></i>
							Cartão de Débito
						</a>
						<a href="#" class="nav-item nav-link" data-toggle="tab" data-target="#option-3">
							<i class="fas fa-barcode"></i>
							Boleto bancário
						</a>
					</div>
					<div id="payment-methods-content"  class="tab-content border border-top-0 bg-white">
						<div id="option-1"class="tab-pane fade show active">
							<div class="row">
								<div class="col-12 m-3">
									1
								</div>
							</div>
						</div>
						<div id="option-2" class="tab-pane fade">
							<div class="row">
								<div class="col-12 m-3">
									2
								</div>
							</div>
						</div>
						<div id="option-3" class="tab-pane fade">
							<div class="row">
								<div class="col-12 m-3">
									3
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="card my-4 bg-light">
					<div class="card-body">
						<h3 class="card-title text-center">
							Resumo do pedido
						</h3>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item text-muted">
							Subtotal:
							<t:currency value="${10 * 99.99 }"/> 
						</li>
						<li class="list-group-item text-muted">
							Frete: (?) Endereço não informado	
						</li>
						<li class="list-group-item">
							<h4>
								<strong>
									TOTAL:
									<t:currency value="${10 * 99.99 }"/>
								</strong>
							</h4>
						</li>
					</ul>
					<div class="card-body">
						<t:a classes="btn btn-primary w-100 shadow" href="/checkout">
						<small>
							<i class=" fas fa-shopping-cart"></i>
						</small>
							Finalizar compra
						</t:a>
					</div>
				</div>
			</div>
		</div>
	</div>
</t:main>