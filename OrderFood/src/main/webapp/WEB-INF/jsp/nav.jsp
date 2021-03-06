
<nav class="navbar navbar-expand-lg navbar-dark bg-cl">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		<a class="navbar-brand text-white" href="#"><img
			style="max-width: 50px" " alt="logo"
			src="<c:url value="/resources/images/amajon.png"/>"></a>
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item active"><a class="nav-link text-white"
				href="<%=request.getContextPath() + "/"%>">Home <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link text-white" href="selectveg">Order</a>
			</li>
			<li class="nav-item"><a class="nav-link text-white" href="login"><i
					class="fas fa-id-badge"></i></a></li>
		</ul>
		<a class="nav-link text-white" href="${pageContext.request.contextPath}/cart"><i class="fas fa-cart-plus"></i></a> 
		<a class="nav-link text-white" href="${pageContext.request.contextPath}/logout"><i class="fas fa-sign-out-alt"></i></a> 
		<form class="form-inline my-2 my-lg-0">
			
			<input class="form-control mr-sm-2"
				type="search" placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>