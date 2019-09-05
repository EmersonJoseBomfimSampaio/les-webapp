<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:main location="Carrinho">
	<div class="container">
		<div class="row">
			<div class="col-lg-9 py-4">
				<div class="card bg-light">
					<div class="card-body">
						<table class="table table-hover border bg-white">
							<thead class="border-0">
								<tr>
									<th colspan="5" class="p-3 text-center">
										<h3> Itens do carrinho </h3>
									</th>
								</tr>
								<tr class="bg-light">
									<th> Nome </th>
									<th> Descrição </th>
									<th> Quantidade </th>
									<th> Preço </th>
									<th> </th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="i" begin="1" end="10">
									<tr>
										<td>
											<t:img src="/img/default.png"  classes="rounded shadow" width="60px"/>
										</td>
										<td>
											<t:a href="#"> 
												<strong> Descrição do produto aqui </strong>
											</t:a>
											<br>
											<small class="text-muted">
												Observações sobre o produto e informações adicionais aqui.
											 </small>
										</td>
										<td>
											<input type="number" class="form-control shadow" value="1" step="1" min="1" tabindex="${ i } "/>
										</td>
										<td>
											<t:currency value="99.99"/>
										</td>
										<td>
											<button class="btn btn-link" type="submit">
												<i class="fas fa-trash"> </i>
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
						<t:a classes="btn btn-primary w-100 shadow" href="/customer/checkout">
						<small>
							<i class=" fas fa-shopping-cart"></i>
						</small>
							Ir para o checkout
						</t:a>
					</div>
				</div>
			</div>
		</div>
	</div>
</t:main>