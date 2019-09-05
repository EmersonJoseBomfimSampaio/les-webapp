<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ attribute name="location" required="true" %>

<t:app title="Application - ${location}">
	<div class="container-fluid">
		<div class="row">
			<div class="position-absolute col-sm-4 col-md-3 col-lg-2">
				<div class="row">
					<div class="col-12 px-0">
						<ul class="nav nav-pills nav-fill">
							<li class="nav-item active">
								<t:a classes="nav-link active" href="/management/employees">
									<i class="fas fa-user-tie"></i>
									Employees
								</t:a>
							</li>
						</ul>
					</div>	
				</div>
			</div>
			<div class="offset-sm-4 offset-md-3 offset-lg-2 col py-4 bg-light border-left border-primary" style="min-height: 100vh;">
				<jsp:doBody/>
			</div>
		</div>
	</div>
</t:app>