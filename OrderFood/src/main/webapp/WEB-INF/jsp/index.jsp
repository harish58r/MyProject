<html>
<head>
<%@include file="base.jsp"%>
<style type="text/css">
	.carousel_set{
		height:450px;
	}	
</style>
</head>
<body class="menu">
	<header>
		<%@include file="nav.jsp"%>
	</header>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div id="carouselExampleIndicators" class="carousel slide "
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner ">
						<div class="carousel-item active">
							<img class="d-block w-100 img-fluid caroselset carousel_set" src="resources/images/food1.jpg" alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100 img-fluid caroselset carousel_set" src="resources/images/food2.jpg"" alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100 img-fluid caroselset carousel_set" src="resources/images/food3.jpg"" alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div><%@include file="footer.jsp" %></div>
</body>
</html>
