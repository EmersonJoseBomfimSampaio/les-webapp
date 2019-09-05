<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<header class="container">
	<div class="row bg-white text-light"> 
		<div class=" col-md-2 py-2 text-center">
			<t:img src="/img/default.png" classes="rounded" width="120px"/>
		</div>
		<div class=" col-md-6 py-3 py-md-5">
			<form action="#" method="GET">
				<div class="form-group">
					<div class="input-group">
						<input type="text" class="form-control border-primary shadow" placeholder="O que está procurando ?"/>
						<div class="input-group-append">
				 			<button type="submit" class="btn btn-primary shadow ">
								Pesquisar
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class=" col py-4 py-md-5 text-primary text-center">
			<t:a classes="btn btn-outline-primary btn-sm shadow	" href="/login">
				<i class=" fas fa-user"></i>			
					Olá! Faça seu login
			</t:a>
			<t:a classes="btn btn-link" href="/cart">
				<i class=" fas fa-shopping-cart"></i>
				Carrinho
			</t:a>
		</div>
	</div>
</header>
<nav id="nav" class="bg-light container-fluid border-bottom border-top">
	<div class="row">
		<div class="col-12 py-2 ">
			<ul class="nav justify-content-center"> 
				<li class="nav-item">
					<a href="#" class="nav-link" data-toggle="collapse"  data-target ="#strings-nav">Cordas</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link" data-toggle="collapse"  data-target="#keys-nav" >Teclas</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link" data-toggle="collapse"  data-target="#wind-nav" >Sopro</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link" data-toggle="collapse"  data-target="#percussion-nav">Percussão</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link" data-toggle="collapse"  data-target="#accessories-nav">Acessórios</a>
				</li>
			</ul>
		</div>	
	</div>
	<div id="strings-nav" class="row collapse fade" data-parent="#nav">
		<div class="col-md-6 py-4 px-3 text-primary mx-auto">
			<h4> Instrumentos de corda: </h4>
			<ul class="nav flex-column justify-content-center">
				<li class="nav-item">
					<a href="#" class="nav-link">Violões</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Guitarras</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Violas</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Contrabaixos</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Violinos</a>
				</li>
					<li class="nav-item">
					<a href="#" class="nav-link">Ukeleles</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="keys-nav" class="row collapse fade" data-parent="#nav">
		<div class="col-md-6 py-4 px-3 text-primary mx-auto">
			<h4> Instrumentos de teclas: </h4>
			<ul class="nav flex-column justify-content-center">
				<li class="nav-item">
					<a href="#" class="nav-link">Pianos</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Teclados</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Acordeões</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="wind-nav" class="row collapse fade" data-parent="#nav">
		<div class="col-md-6 py-4 px-3 text-primary mx-auto">
			<h4> Instrumentos de sopro: </h4>
			<ul class="nav flex-column justify-content-center">
				<li class="nav-item">
					<a href="#" class="nav-link">Trompetes</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Flautas</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Saxofones</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Clarinetes</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="percussion-nav" class="row collapse fade" data-parent="#nav">
		<div class="col-md-6 py-4 px-3 text-primary mx-auto">
			<h4> Instrumentos de percussão: </h4>
			<ul class="nav flex-column justify-content-center">
				<li class="nav-item">
					<a href="#" class="nav-link">Baterias</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Bongôs</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Tamborins</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="accessories-nav" class="row collapse fade" data-parent="#nav">
		<div class="col-md-6 py-4 px-3 text-primary mx-auto">
			<h4> Acessórios e eletrônicos: </h4>
			<ul class="nav flex-column justify-content-center">
				<li class="nav-item">
					<a href="#" class="nav-link">Afinadores</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">Amplificadores</a>
				</li>
			</ul>
		</div>	
	</div>
</nav>

