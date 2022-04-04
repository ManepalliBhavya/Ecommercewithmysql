<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
<style type="text/css">
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}
</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Store</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<!-- NAVIGATION -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-white py-3 fixed-top">
	<img src="img/logo3.png" alt="">
	<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		data-bs-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span><i id="bar" class="fas fa-bars"></i></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link active" href="/">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/productlist">Shopping</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/productadd">AddProduct</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/categoryadd">AddCategory</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/supplieradd">AddSupplier</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/categorylist">Categorylist</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/supplierlist">Supplierlist</a>
			</li>
		</ul>

		<form action="search">
			<div class="input-group mb-0">
				<input type="search" placeholder="Search Here.."
					name="proName" value="${proName}" aria-describedby="button-addon5"
					class="form-control">
					
					

				<div class="input-group-append">
					<button id="button-addon5" type="submit" class="btn btn-primary"
						style="background-color: coral">
						<i class="fa fa-search"> </i>
					</button>
				</div>
			</div>
		</form>
		
		<a href="logout"><i class="fa fa-sign-out" aria-hidden="true"></i></a>
	</div>
	</nav>
	<br>
	<br>
	<br>
	<section id="featured" class="my-5 pb-5">
	<div class="container text-center mt-5 py-5">
		<h3>Products list</h3>
		<hr class="mx-auto">
		<p>Here you can check out our new products with fair price on 
		my store.</p>
	</div>

	<div class="row mx-auto container-fluid">
		<c:forEach var="product" items="${productList}">
			<div class="product text-center col-lg-3 col-md-4 col-12">
				<a
					href="${pageContext.request.contextPath }/productdetails/${product.id }"><img
					src="/uploads/${product.fileName}" width="270" height="250" /></a>
					

				<h5 class="proName">
					<c:out value="${product.proName}" />
				</h5>
			<%-- 	<h5 class="proDesc">
					<c:out value="${product.proDesc}" />
				</h5> --%>
				<h4 class="price">
					<c:out value="Rs.${product.price}" />
				</h4>
				<td>
<!-- 				<button style="background-color: #ff7f50;"> -->
						<a style="color: #ffffff; text-decoration: none;"
							href="${pageContext.request.contextPath }/productupdate/${product.id }">
							<input type="button" value="Update" style="background-color: #ff7f50; width: 25%;
    border: none;cursor:pointer;padding: 10px;color: #ffffff;" ></input>
    </a></a>
					</td>
				<td>
						<a style="color: #ffffff; text-decoration: none;"
							href="${pageContext.request.contextPath }/productdelete/${product.id }"
							onclick="return confirm('Are you sure?')">
							<input type="button" value="Delete" style="background-color: #ff7f50; width: 25%;
    border: none;cursor:pointer;padding: 10px;color: #ffffff;" ></input>
							</a>
					</td>
			</div>
		</c:forEach>
	</div>
	</section>

	<footer class="mt-5 py-5">
	<div class="row container mx-auto pt-5">
		<div class="footer-one col-lg-3 col-md-6 col-12">
			<img src="img/logo3.png" alt="">
			<p class="pt-3">Welcome To HCL Ecom Website.</p>
		</div>
		<div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
			<h5 class="pb-2">Featured</h5>
			<ul class="text-uppercase list-unstyled">
				<li><a href="#">men</a></li>
				<li><a href="#">women</a></li>
				<li><a href="#">boys</a></li>
				<li><a href="#">girls</a></li>
				<li><a href="#">new arrivals</a></li>
				<li><a href="#">shoes</a></li>
				<li><a href="#">clothes</a></li>
			</ul>
		</div>
		<div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
			<h5 class="pb-2">Contact Us</h5>
			<div>
				<h6 class="text-uppercase">Address</h6>
				<p>Gannavaram, VijayawadaS</p>
			</div>
			<div>
				<h6 class="text-uppercase">Phone</h6>
				<p>1800 456 456</p>
			</div>
			<div>
				<h6 class="text-uppercase">Email</h6>
				<p>Ecom@hcl.COM</p>
			</div>
		</div>

		<div class="footer-one col-lg-3 col-md-6 col-12">
			<h5 class="pb-2">Instagram</h5>
			<div class="row">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/1.jpg" alt="">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/2.jpg" alt="">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/3.jpg" alt="">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/4.jpg" alt="">
				<img class="img-fluid w-25 h-100 m-2" src="img/insta/5.jpg" alt="">
			</div>
		</div>
	</div>

	<div class="copyright mt-5">
		<div class="row container mx-auto">
			<div class="col-lg-3 col-md-6 col-12 mb-4">
				<img src="img/payment.png" alt="">
			</div>
			<div class="col-lg-4 col-md-6 col-12">
				<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
					class="fab fa-twitter"></i></a> <a href="#"><i
					class="fab fa-linkedin-in"></i></a>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>